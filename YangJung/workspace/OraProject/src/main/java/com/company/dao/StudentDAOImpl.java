package com.company.dao;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.company.vo.StudentVO;
@Repository
public class StudentDAOImpl implements StudentDAO {
@Inject
private SqlSession sqlSession;
// 게시글 작성
@Override
public void insert(StudentVO studentVO) throws Exception {
sqlSession.insert("studentMapper.insert", studentVO);
}
}