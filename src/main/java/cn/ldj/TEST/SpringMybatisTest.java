package cn.ldj.TEST;

import cn.ldj.dao.daoImpl.EmpDaoImpl;
import cn.ldj.vo.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SpringMybatisTest {
    @Test
    public void test() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        EmpDaoImpl empdaoimpl = (EmpDaoImpl) context.getBean("empDaoimpl");
        List<Map<String, Object>> emps= empdaoimpl.findAll();
        for(int i=0;i<emps.size();i++){
            Emp emp= (Emp) emps.get(i);
            System.out.println(emp.getEname()+emp.getJob());
        }
    }
    @Test
    public void testdoCreate() throws Exception {
        Emp emp=new Emp();
        emp.setEname("笑笑xiao3");
        emp.setJob("副总经理");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        EmpDaoImpl empdaoimpl = (EmpDaoImpl) context.getBean("empDaoimpl");
        try {
            empdaoimpl.doCreate(emp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Map<String, Object>> emps= empdaoimpl.findAll();
        for(int i=0;i<emps.size();i++){
            Emp emp2= (Emp) emps.get(i);
            System.out.println(emp2.getEname()+emp2.getJob());
        }

    }
}
