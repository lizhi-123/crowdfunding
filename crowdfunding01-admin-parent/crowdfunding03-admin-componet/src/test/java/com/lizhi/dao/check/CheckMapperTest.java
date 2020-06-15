package com.lizhi.dao.check;

import com.lizhi.domain.check.Check;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration("classpath:applicationContext-component.xml")
public class CheckMapperTest {

    @Autowired
    CheckMapper checkMapper;
    @Test
    public void insertSelectiveTest(){
        Check check = new Check();
        check.setName("张飞");
        check.setAge(19);
        checkMapper.insertSelective(check);

    }
}
