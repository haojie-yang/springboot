package com.jie.Service;

import com.jie.pojo.Label;
import com.jie.pojo.LabelParam;
import entity.Result;

/**
 * @description:
 * @author: yanghaojie 31648
 * @date: 2020/8/7 16:08
 */
public interface LabelService {

    Result findAll();

    Result findById(String id);

    Result save(LabelParam labelParam);

    Result delete(String id);

    Result findSearch(LabelParam labelParam);

    Result findByPage(LabelParam labelParam);
}
