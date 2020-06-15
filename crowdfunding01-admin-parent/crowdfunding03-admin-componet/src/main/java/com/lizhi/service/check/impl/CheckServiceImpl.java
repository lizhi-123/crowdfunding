package com.lizhi.service.check.impl;

import com.lizhi.dao.check.CheckMapper;
import com.lizhi.domain.check.Check;
import com.lizhi.service.check.CheckService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckServiceImpl implements CheckService {

    Logger logger = Logger.getLogger(CheckServiceImpl.class);

    @Autowired
    CheckMapper checkMapper;


    public Check getCheckById(Integer id) {
        Check check = checkMapper.selectByPrimaryKey(id);
        logger.info("查询的数据===>"+check);
        return  check ;
    }

    /**
     * 事务测试
     *
     * @return
     */
    @Override
    public int insertChecks(List<Check> checks) {
        int result =-1;

        try {
            for (int i = 0; i < checks.size(); i++) {
                if (i < 1) {
                    result = checkMapper.insertSelective(checks.get(i));
                } else {
                    int err = 1 / 0;
                }
            }
            return result;
        }catch (Exception e){
            logger.error("插入数据出错，事务回滚："+e.getMessage());
            throw new RuntimeException(e);
        }

    }


}
