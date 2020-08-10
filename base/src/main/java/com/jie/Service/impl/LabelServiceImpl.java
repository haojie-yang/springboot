package com.jie.Service.impl;

import com.jie.Service.LabelService;
import com.jie.pojo.Label;
import com.jie.pojo.LabelParam;
import com.jie.repository.LabelRepository;
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

    @Override
    public Result findSearch(LabelParam labelParam) {
        Specification<Label> specification = new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (labelParam.getLabelName() != null && !labelParam.getLabelName().equals("")){
                    Predicate predicate = criteriaBuilder.like(root.get("labelName").as(String.class), "%" + labelParam.getLabelName() + "%");
                    predicates.add(predicate);
                }
                if (labelParam.getState() != null && !labelParam.getState().equals("")){
                    Predicate predicate = criteriaBuilder.equal(root.get("state").as(String.class), labelParam.getState());
                    predicates.add(predicate);
                }
                Predicate[] predicates1 = new Predicate[predicates.size()];
                predicates.toArray(predicates1);
                return criteriaBuilder.and(predicates1);
            }
        };
        return new Result(true, StatusCode.OK,"查询成功",labelRepository.findAll(specification));
    }

    @Override
    public Result findByPage(LabelParam labelParam) {
        Pageable pageable = PageRequest.of(labelParam.getPage() - 1, labelParam.getSize());
        Specification<Label> specification = new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (labelParam.getLabelName() != null && !labelParam.getLabelName().equals("")){
                    Predicate predicate = criteriaBuilder.like(root.get("labelName").as(String.class), "%" + labelParam.getLabelName() + "%");
                    predicates.add(predicate);
                }
                if (labelParam.getState() != null && !labelParam.getState().equals("")){
                    Predicate predicate = criteriaBuilder.equal(root.get("state").as(String.class), labelParam.getState());
                    predicates.add(predicate);
                }
                Predicate[] predicates1 = new Predicate[predicates.size()];
                predicates.toArray(predicates1);
                return criteriaBuilder.and(predicates1);
            }
        };
        Page<Label> labels = labelRepository.findAll(specification, pageable);
        return new Result(true, StatusCode.OK,"查询成功",new PageResult<Label>(labels.getTotalElements(),labels.getContent()));
    }
}

