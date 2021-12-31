package com.company.controller;

import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.company.service.StudentService;
import com.company.vo.StudentVO;
@Controller
@RequestMapping("/")
public class StudentController {
private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
@Inject
StudentService service;
@RequestMapping(value = "insertView", method = RequestMethod.GET)
public void insertView() throws Exception{
logger.info("insertView");
}
// 글 작성
@RequestMapping(value = "insert", method = RequestMethod.POST)
public String insert(StudentVO studentVO) throws Exception{
logger.info("insert");
service.insert(studentVO);
return "insertView";
}
}