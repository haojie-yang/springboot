package com.jie.controller;

import com.jie.Service.EnterpriseService;
import com.jie.pojo.EnterpriseParam;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: yanghaojie 31648
 * @date: 2020/8/10 16:01
 */

@RequestMapping("/enterprise")
@RestController
@CrossOrigin
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @RequestMapping("/findAll")
    public Result findAll(){
        return enterpriseService.findAll();
    }

    @RequestMapping("/findById")
    public Result findById(@PathVariable("id") String id){
        return enterpriseService.findById(id);
    }

    @RequestMapping("/save")
    public Result findById(@RequestBody EnterpriseParam enterpriseParam){
        return enterpriseService.save(enterpriseParam);
    }

    @RequestMapping("/findByid")
    public Result delete(@PathVariable("id") String id){
        return enterpriseService.delete(id);
    }

    @RequestMapping("/findSearch")
    public Result findSearch(@RequestBody EnterpriseParam enterpriseParam){
        return enterpriseService.findSearch(enterpriseParam);
    }

    @RequestMapping("/findByPage")
    public Result findByPage(@RequestBody EnterpriseParam enterpriseParam){
        return enterpriseService.findByPage(enterpriseParam);
    }


}
