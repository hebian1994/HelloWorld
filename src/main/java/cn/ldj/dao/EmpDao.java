package cn.ldj.dao;

import cn.ldj.vo.Emp;

import java.util.List;
import java.util.Map;

public interface EmpDao {

    /**
     * 查询
     */

    public List<Map<String, Object>> findAll() throws Exception ;

    /**
     * 实现数据增加操作
     */
    public void doCreate(Emp emp) throws Exception;
}
