package com.jie.controller;

import com.jie.Service.LabelService;
import com.jie.pojo.Label;
import com.jie.pojo.LabelParam;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: yanghaojie 31648
 * @date: 2020/8/7 15:24
 */

@RestController
@RequestMapping("/label")
@CrossOrigin//跨域注解
public class LabelController {

    @Autowired
    private LabelService labelService;

    @RequestMapping("/findAll")
    public Result findAll(){
        return labelService.findAll();
    }

    @RequestMapping("/findById")
    public Result findById(@PathVariable("id") String id){
        return labelService.findById(id);
    }

    @RequestMapping("/save")
    public Result findById(@RequestBody LabelParam labelParam){
        return labelService.save(labelParam);
    }

    @RequestMapping("/findByid")
    public Result delete(@PathVariable("id") String id){
        return labelService.delete(id);
    }


}
