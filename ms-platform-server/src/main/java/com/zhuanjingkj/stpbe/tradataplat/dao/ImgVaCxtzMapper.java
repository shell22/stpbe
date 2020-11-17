package com.zhuanjingkj.stpbe.tradataplat.dao;

import com.zhuanjingkj.stpbe.tradataplat.domain.ImgVaCxtz;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface ImgVaCxtzMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_img_va_cxtz
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    long countByExample(ImgVaCxtzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_img_va_cxtz
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int deleteByExample(ImgVaCxtzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_img_va_cxtz
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int deleteByPrimaryKey(Long imgVaId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_img_va_cxtz
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int insert(ImgVaCxtz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_img_va_cxtz
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int insertSelective(ImgVaCxtz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_img_va_cxtz
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    List<ImgVaCxtz> selectByExample(ImgVaCxtzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_img_va_cxtz
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    ImgVaCxtz selectByPrimaryKey(Long imgVaId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_img_va_cxtz
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int updateByExampleSelective(@Param("record") ImgVaCxtz record, @Param("example") ImgVaCxtzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_img_va_cxtz
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int updateByExample(@Param("record") ImgVaCxtz record, @Param("example") ImgVaCxtzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_img_va_cxtz
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int updateByPrimaryKeySelective(ImgVaCxtz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_img_va_cxtz
     *
     * @mbg.generated Tue Nov 17 12:09:26 CST 2020
     */
    int updateByPrimaryKey(ImgVaCxtz record);
}