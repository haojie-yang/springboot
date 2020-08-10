package com.jie.Service;

import com.jie.pojo.EnterpriseParam;
import entity.Result;

/**
 * @description:
 * @author: yanghaojie 31648
 * @date: 2020/8/10 16:26
 */
public interface EnterpriseService {

    Result findAll();

    Result findById(String id);

    Result save(EnterpriseParam enterpriseParam);

    Result delete(String id);

    Result findSearch(EnterpriseParam enterpriseParam);

    Result findByPage(EnterpriseParam enterpriseParam);
}
