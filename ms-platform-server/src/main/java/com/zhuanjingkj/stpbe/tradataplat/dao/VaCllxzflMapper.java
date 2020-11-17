package com.zhuanjingkj.stpbe.tradataplat.dao;

import com.zhuanjingkj.stpbe.tradataplat.domain.VaCllxzfl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface VaCllxzflMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_va_cllxzfl
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    long countByExample(VaCllxzflExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_va_cllxzfl
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int deleteByExample(VaCllxzflExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_va_cllxzfl
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int deleteByPrimaryKey(Byte vaCllxzflId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_va_cllxzfl
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int insert(VaCllxzfl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_va_cllxzfl
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int insertSelective(VaCllxzfl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_va_cllxzfl
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    List<VaCllxzfl> selectByExample(VaCllxzflExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_va_cllxzfl
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    VaCllxzfl selectByPrimaryKey(Byte vaCllxzflId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_va_cllxzfl
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int updateByExampleSelective(@Param("record") VaCllxzfl record, @Param("example") VaCllxzflExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_va_cllxzfl
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int updateByExample(@Param("record") VaCllxzfl record, @Param("example") VaCllxzflExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_va_cllxzfl
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int updateByPrimaryKeySelective(VaCllxzfl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_va_cllxzfl
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int updateByPrimaryKey(VaCllxzfl record);
}