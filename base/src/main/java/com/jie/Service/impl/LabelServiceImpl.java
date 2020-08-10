package com.jie.Service.impl;

import com.jie.Service.LabelService;
import com.jie.pojo.Label;
import com.jie.pojo.LabelParam;
import com.jie.repository.LabelRepository;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @description:
 * @author: yanghaojie 31648
 * @date: 2020/8/7 16:09
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelRepository labelRepository;

    @Override
    public Result findAll() {
        return new Result(true, StatusCode.OK,"查询成功",labelRepository.findAll());
    }

    @Override
    public Result findById(String id) {
        return new Result(true,StatusCode.OK,"查询成功",labelRepository.findById(id).get());
    }

    @Override
    public Result save(LabelParam labelParam) {
        Label label = new Label();
        BeanUtils.copyProperties(labelParam,label);
        labelRepository.save(label);
        if (labelParam.getId() != null && !labelParam.getId().equals("")){
            return new Result(true,StatusCode.OK,"修改成功");
        }else {
            return new Result(true,StatusCode.OK,"添加成功");
        }
    }

    @Override
    public Result delete(String id) {
        int remove = labelRepository.remove(id);
        if (remove == 1){
            return new Result(true,StatusCode.OK,"删除成功");
        }else {
            return new Result(true,StatusCode.OK,"删除失败");
        }
    }
}

