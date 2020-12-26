package cn.ldj.TEST;

import cn.ldj.dao.daoImpl.jdbcTemplateEmpDaoImpl;

import java.util.List;
import java.util.Map;

public class JDBCTemplateTest2 {
    public static void main(String[] args) throws Exception {
        //测试查询
        List<Map<String, Object>> maps1= new jdbcTemplateEmpDaoImpl().findAll();

        System.out.println(maps1);
    }
}
