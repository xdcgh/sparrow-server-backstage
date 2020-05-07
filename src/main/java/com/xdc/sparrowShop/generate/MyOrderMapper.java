package com.xdc.sparrowShop.generate;

import com.xdc.sparrowShop.generate.MyOrder;
import com.xdc.sparrowShop.generate.MyOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MyOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MY_ORDER
     *
     * @mbg.generated Thu May 07 23:28:16 CST 2020
     */
    long countByExample(MyOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MY_ORDER
     *
     * @mbg.generated Thu May 07 23:28:16 CST 2020
     */
    int deleteByExample(MyOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MY_ORDER
     *
     * @mbg.generated Thu May 07 23:28:16 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MY_ORDER
     *
     * @mbg.generated Thu May 07 23:28:16 CST 2020
     */
    int insert(MyOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MY_ORDER
     *
     * @mbg.generated Thu May 07 23:28:16 CST 2020
     */
    int insertSelective(MyOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MY_ORDER
     *
     * @mbg.generated Thu May 07 23:28:16 CST 2020
     */
    List<MyOrder> selectByExample(MyOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MY_ORDER
     *
     * @mbg.generated Thu May 07 23:28:16 CST 2020
     */
    MyOrder selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MY_ORDER
     *
     * @mbg.generated Thu May 07 23:28:16 CST 2020
     */
    int updateByExampleSelective(@Param("record") MyOrder record, @Param("example") MyOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MY_ORDER
     *
     * @mbg.generated Thu May 07 23:28:16 CST 2020
     */
    int updateByExample(@Param("record") MyOrder record, @Param("example") MyOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MY_ORDER
     *
     * @mbg.generated Thu May 07 23:28:16 CST 2020
     */
    int updateByPrimaryKeySelective(MyOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MY_ORDER
     *
     * @mbg.generated Thu May 07 23:28:16 CST 2020
     */
    int updateByPrimaryKey(MyOrder record);
}