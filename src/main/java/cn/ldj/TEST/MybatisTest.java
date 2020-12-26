package cn.ldj.TEST;

import cn.ldj.empMapper.EmpMapper;
import cn.ldj.vo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.apache.log4j.Logger;

import java.io.Reader;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    Logger logger=Logger.getLogger(MybatisTest.class);

    static {
        try {
            reader = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    @Test
//查询所有
    public void findAll() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            logger.debug("开始");
            EmpMapper empOperation = session.getMapper(EmpMapper.class);
            List<Map<String, Object>> maps3=empOperation.findAll();
            for(int i=0;i<maps3.size();i++){
                Emp emp= (Emp) maps3.get(i);
                System.out.println(emp.getEname()+emp.getJob());
            }
            session.commit();
            logger.debug("结束");
        } finally {
            session.close();
        }
    }
}
