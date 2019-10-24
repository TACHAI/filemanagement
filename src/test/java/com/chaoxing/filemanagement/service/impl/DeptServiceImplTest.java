package com.chaoxing.filemanagement.service.impl;

import com.chaoxing.filemanagement.dao.DeptMapper;
import com.chaoxing.filemanagement.po.Dept;
import com.chaoxing.filemanagement.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Create by tachai on 2019-10-23 16:52
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest // 指定启动类
public class DeptServiceImplTest {
    @Autowired
    private DeptMapper deptDao;

    @Test
    public void addDept() {

        Dept dept = new Dept();
        dept.setName("南昌市");
        dept.setParentId(1);

        int res = deptDao.insert(dept);
        assertEquals(1,res);
    }

    @Test
    public void deleteDeptById() {
    }

    @Test
    public void updateDept() {
    }

    @Test
    public void selectDeptById() {
    }

    @Test
    public void listDept() {
    }
}