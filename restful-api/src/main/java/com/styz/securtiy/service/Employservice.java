package com.styz.securtiy.service;

import com.styz.api.model.Employ;

/**
 * <b>creat date(创建时间):2019-07-11 20:58</b>
 * <b>author(作者):</b>xxydliuyss</br>
 * <b>note(备注)):</b>
 * If you want to change the file header,please modify zhe File and Code Templates.
 */
public interface Employservice {
    /**
     * 查询
     *
     * @param id
     * @return 返回员工信息
     */
    Employ get(Long id);

    /**
     * 修改
     *
     * @param employ
     * @return 修改的ID
     */
    Long update(Employ employ);

    /**
     * 保存
     *
     * @param employ
     * @return 成功返回ture
     */
    Boolean save(Employ employ);

    /**
     * 删除
     *
     * @param id
     * @return 删除id
     */
    boolean delete(long id);
}