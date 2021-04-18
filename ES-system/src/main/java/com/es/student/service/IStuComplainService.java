package com.es.student.service;



import com.es.student.domain.StuComplain;
import com.es.student.domain.StuNotice;

import java.util.List;

/**
 * 公告 服务层
 */
public interface IStuComplainService {
    /**
     * 查询申诉信息
     *
     * @param complainId 申诉ID
     * @return 公告信息
     */
    public StuComplain selectcomplainById(Long complainId);

    /**
     * 查询当前账号申诉列表
     *
     * @param stuId 当前学生Id
     * @return 申诉集合
     */
    public List<StuComplain> selectcomplainList(long stuId);

    /**
     * 新增申诉
     *
     * @param stuComplain 申诉信息
     * @return 结果
     */
    public int insertStuComplain(StuComplain stuComplain,long stuId);

    /**
     * 修改申诉
     *
     * @param stuComplain 申诉信息
     * @return 结果
     */
    public int updateStuComplain(StuComplain stuComplain);

    /**
     * 删除申诉信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStuComplainByIds(String ids);
}
