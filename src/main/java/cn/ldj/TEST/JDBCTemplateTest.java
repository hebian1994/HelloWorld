package cn.ldj.TEST;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JDBCTemplateTest {
    public static void main(String[] args) {
        //创建数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/sqltestdb?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //创建JdbcTemplate对象，设置数据源
        JdbcTemplate template = new JdbcTemplate(dataSource);

        /*插入数据template.update("insert into emp values(?,?)","大哥","大哥");*/
        /*修改数据template.update("UPDATE emp SET ename = '修改名字' WHERE job = '大哥'");*/
        /*查询所有并返回结果*/
        //String sql="select * from emp";
        //List<Map<String, Object>> maps = template.queryForList(sql);
        //System.out.println(maps);
        //条件查询
        //String sql1="select * from emp where ename = '李总'";
        //List<Map<String, Object>> maps1 = template.queryForList(sql1);
        //System.out.println(maps1);
        //删除数据
        //template.update("DELETE from emp where ename = '修改名字'");

    }
}