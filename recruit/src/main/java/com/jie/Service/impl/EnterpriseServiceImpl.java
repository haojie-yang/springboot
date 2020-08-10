package com.jie.Service.impl;

import com.jie.Service.EnterpriseService;
import com.jie.pojo.Enterprise;
import com.jie.pojo.EnterpriseParam;
import com.jie.repository.EnterpriseRepository;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: yanghaojie 31648
 * @date: 2020/8/10 16:27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Override
    public Result findAll() {
        return new Result(true, StatusCode.OK,"查询成功",enterpriseRepository.findAll());
    }

    @Override
    public Result findById(String id) {
        return new Result(true,StatusCode.OK,"查询成功",enterpriseRepository.findById(id).get());
    }

    @Override
    public Result save(EnterpriseParam enterpriseParam) {
        Enterprise label = new Enterprise();
        BeanUtils.copyProperties(enterpriseParam,label);
        enterpriseRepository.save(label);
        if (enterpriseParam.getId() != null && !enterpriseParam.getId().equals("")){
            return new Result(true,StatusCode.OK,"修改成功");
        }else {
            return new Result(true,StatusCode.OK,"添加成功");
        }
    }

    @Override
    public Result delete(String id) {
        int remove = enterpriseRepository.remove(id);
        if (remove == 1){
            return new Result(true,StatusCode.OK,"删除成功");
        }else {
            return new Result(true,StatusCode.OK,"删除失败");
        }
    }

    @Override
    public Result findSearch(EnterpriseParam enterpriseParam) {
        Specification<Enterprise> specification = new Specification<Enterprise>() {
            @Override
            public Predicate toPredicate(Root<Enterprise> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (enterpriseParam.getName() != null && !enterpriseParam.getName().equals("")){
                    Predicate predicate = criteriaBuilder.like(root.get("name").as(String.class), "%" + enterpriseParam.getName() + "%");
                    predicates.add(predicate);
                }
                if (enterpriseParam.getIshot() != null && !enterpriseParam.getIshot().equals("")){
                    Predicate predicate = criteriaBuilder.equal(root.get("ishot").as(String.class), enterpriseParam.getIshot());
                    predicates.add(predicate);
                }
                Predicate[] predicates1 = new Predicate[predicates.size()];
                predicates.toArray(predicates1);
                return criteriaBuilder.and(predicates1);
            }
        };
        return new Result(true, StatusCode.OK,"查询成功",enterpriseRepository.findAll(specification));
    }

    @Override
    public Result findByPage(EnterpriseParam enterpriseParam) {
        Pageable pageable = PageRequest.of(enterpriseParam.getPage() - 1, enterpriseParam.getSize());
        Specification<Enterprise> specification = new Specification<Enterprise>() {
            @Override
            public Predicate toPredicate(Root<Enterprise> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (enterpriseParam.getName() != null && !enterpriseParam.getName().equals("")){
                    Predicate predicate = criteriaBuilder.like(root.get("name").as(String.class), "%" + enterpriseParam.getName() + "%");
                    predicates.add(predicate);
                }
                if (enterpriseParam.getIshot() != null && !enterpriseParam.getIshot().equals("")){
                    Predicate predicate = criteriaBuilder.equal(root.get("ishot").as(String.class), enterpriseParam.getIshot());
                    predicates.add(predicate);
                }
                Predicate[] predicates1 = new Predicate[predicates.size()];
                predicates.toArray(predicates1);
                return criteriaBuilder.and(predicates1);
            }
        };
        Page<Enterprise> labels = enterpriseRepository.findAll(specification, pageable);
        return new Result(true, StatusCode.OK,"查询成功",new PageResult<Enterprise>(labels.getTotalElements(),labels.getContent()));
    }
}
