package com.xdc.sparrowShop.config;

import com.xdc.sparrowShop.generate.Shop;
import com.xdc.sparrowShop.service.ShiroRealm;
import com.xdc.sparrowShop.service.ShopContext;
import com.xdc.sparrowShop.service.ShopService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig implements WebMvcConfigurer {
    @Autowired
    ShopService shopService;

    @Value("${sparrowShop.redis.host}")
    String redisHost;
    @Value("${sparrowShop.redis.port}")
    int redisPort;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
                String phone = (String) SecurityUtils.getSubject().getPrincipal();

                if (phone != null) {
                    Shop shop;

                    if (phone.equals("admin")) {
                        shop = new Shop();

                        shop.setPhone("admin");
                    } else {
                        shop = shopService.getShopByPhone(phone);
                    }

                    if (shop != null) {
                        ShopContext.setCurrentShop(shop);
                    }
                }

                return true;
            }

            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
                ShopContext.clearCurrentUser();
            }
        });
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager, ShiroLoginFilter shiroLoginFilter) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 设置过滤接口
        Map<String, String> pattern = new HashMap<>();

        pattern.put("/api/backstage/login", "anon");
        pattern.put("/api/backstage/register", "anon");

        pattern.put("/api/backstage/freshType", "anon");
        pattern.put("/api/backstage/area", "anon");

        // todo 要给为 鉴权模式
        pattern.put("/**", "anon");

        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("shiroLoginFilter", shiroLoginFilter);
        shiroFilterFactoryBean.setFilters(filterMap);

        shiroFilterFactoryBean.setFilterChainDefinitionMap(pattern);

        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(ShiroRealm shiroRealm, RedisCacheManager redisCacheManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        // 设置领域
        securityManager.setRealm(shiroRealm);
        // 使用内存 或 redis 作为缓存
        securityManager.setCacheManager(redisCacheManager);
        // 将session设置到cookie
        securityManager.setSessionManager(new DefaultWebSessionManager());
        SecurityUtils.setSecurityManager(securityManager);

        return securityManager;
    }

    @Bean
    public RedisCacheManager redisCacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        RedisManager redisManager = new RedisManager();

        redisManager.setHost(redisHost + ":" + redisPort);
        redisCacheManager.setRedisManager(redisManager);

        return redisCacheManager;
    }
}
