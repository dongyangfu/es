package com.es.student.mapper;


import com.es.student.domain.StuComplain;
import com.es.student.domain.StuNotice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 申诉 数据层
 */
public interface StuComplainMapper {
    /**
     * 查询申诉信息
     *
     * @param complainId 申诉ID
     * @return 申诉信息
     */
    public StuComplain selectcomplainById(Long complainId);

    /**
     * 查询申诉信息列表
     *
     * @param stuId 当前用户ID
     * @return 申诉信息
     */

    public List<StuComplain> selectStuComplainList(long stuId);

    /**
     * 新增申诉
     *
     * @param StuComplain 申诉信息
     * @return 结果
     */
    public int insertStuComplain(StuComplain stuComplain);

    /**
     * 修改申诉
     *
     * @param stuComplain 申诉信息
     * @return 结果
     */
    public int updateStuComplain(StuComplain stuComplain);

    /**
     * 查询用户与申诉关系
     *
     * @param stuId 申诉信息
     * @return 结果
     */
    public long[] selectIds(long stuId);

    /**
     * 新增用户与申诉关系
     *
     * @param stuId 当前用户Id
     * @param stuComplainId 申诉信息Id
     * @return 结果
     */
    public int insertStuCom(@Param("stuId")long stuId, @Param("stuComplainId")long stuComplainId);
    /**
     * 根据申诉信息查询申诉Id
     *
     * @param complainTitle 申诉标题
     * @return 结果
     */
    public long selectIdBycomplainTitle(String complainTitle);

}