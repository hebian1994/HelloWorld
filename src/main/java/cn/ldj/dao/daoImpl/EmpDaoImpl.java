package cn.ldj.dao.daoImpl;

import cn.ldj.dao.EmpDao;
import cn.ldj.empMapper.EmpMapper;
import cn.ldj.vo.Emp;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;
import java.util.Map;

public class EmpDaoImpl implements EmpDao {
    //原来所有操作都通过SqlSession来执行，现在都是SqlSessionTemplate
    private SqlSessionTemplate sqlSession;
    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }
    @Override
    public List<Map<String, Object>> findAll() throws Exception {
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        return mapper.findAll();
    }

    @Override
    public void doCreate(Emp emp) throws Exception {
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        mapper.doCreate(emp);
    }
}
