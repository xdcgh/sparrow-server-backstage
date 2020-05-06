package com.xdc.sparrowShop.generate;

import com.xdc.sparrowShop.generate.FreshType;
import com.xdc.sparrowShop.generate.FreshTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FreshTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FRESH_TYPE
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    long countByExample(FreshTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FRESH_TYPE
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    int deleteByExample(FreshTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FRESH_TYPE
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FRESH_TYPE
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    int insert(FreshType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FRESH_TYPE
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    int insertSelective(FreshType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FRESH_TYPE
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    List<FreshType> selectByExample(FreshTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FRESH_TYPE
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    FreshType selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FRESH_TYPE
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    int updateByExampleSelective(@Param("record") FreshType record, @Param("example") FreshTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FRESH_TYPE
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    int updateByExample(@Param("record") FreshType record, @Param("example") FreshTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FRESH_TYPE
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    int updateByPrimaryKeySelective(FreshType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FRESH_TYPE
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    int updateByPrimaryKey(FreshType record);
}