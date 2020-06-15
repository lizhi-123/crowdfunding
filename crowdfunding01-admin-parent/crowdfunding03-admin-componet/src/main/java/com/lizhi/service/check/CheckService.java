package com.lizhi.service.check;

import com.lizhi.domain.check.Check;

import java.util.List;

public interface CheckService {

    Check getCheckById(Integer id);

    /**
     * 事务测试
     * @return
     */
    public int insertChecks(List<Check> checks);
}
