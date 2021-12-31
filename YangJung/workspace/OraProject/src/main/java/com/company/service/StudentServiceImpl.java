package com.company.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.company.dao.StudentDAO;
import com.company.vo.StudentVO;
@Service
public class StudentServiceImpl implements StudentService {
@Inject
private StudentDAO dao;
// 글 작성
@Override
public void insert(StudentVO studentVO) throws Exception {
dao.insert(studentVO);
}
}