package com.zhuanjingkj.stpbe.tradataplat.dao;

import com.zhuanjingkj.stpbe.tradataplat.domain.VaCsys;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface VaCsysMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_va_csys
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    long countByExample(VaCsysExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_va_csys
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int deleteByExample(VaCsysExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_va_csys
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int deleteByPrimaryKey(Integer vaCsysId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_va_csys
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int insert(VaCsys record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_va_csys
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int insertSelective(VaCsys record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_va_csys
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    List<VaCsys> selectByExample(VaCsysExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_va_csys
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    VaCsys selectByPrimaryKey(Integer vaCsysId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_va_csys
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int updateByExampleSelective(@Param("record") VaCsys record, @Param("example") VaCsysExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_va_csys
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int updateByExample(@Param("record") VaCsys record, @Param("example") VaCsysExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_va_csys
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int updateByPrimaryKeySelective(VaCsys record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_va_csys
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int updateByPrimaryKey(VaCsys record);
}