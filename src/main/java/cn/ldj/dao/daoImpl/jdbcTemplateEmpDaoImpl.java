package cn.ldj.dao.daoImpl;

import cn.ldj.dao.EmpDao;
import cn.ldj.util.DatabaseConnectionJDBCtemplate;
import cn.ldj.vo.Emp;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class jdbcTemplateEmpDaoImpl implements EmpDao {
    private DatabaseConnectionJDBCtemplate databaseConnectionJDBCtemplate;
    private JdbcTemplate jdbcTemplate;
    public jdbcTemplateEmpDaoImpl() throws Exception {//构造方法中实例化连接与实例化DAO对象
        this.databaseConnectionJDBCtemplate = new DatabaseConnectionJDBCtemplate();//连接数据库
        this.jdbcTemplate = databaseConnectionJDBCtemplate.getJdbcTemplate();
    }

    @Override
    public List<Map<String, Object>> findAll() throws Exception {

        String sql="select * from emp";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @Override
    public void doCreate(Emp emp) throws Exception {
        String ename=emp.getEname();
        String job=emp.getJob();
        String sql=" insert into emp values(#{?,?)";
        jdbcTemplate.update(sql,ename,job);
    }

    @Test
    public void test2() throws Exception {
        System.out.println(this.findAll());
    }
}
