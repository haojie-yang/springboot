package com.jie.repository;

import com.jie.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;

/**
 * @description:
 * 对数据库操作
 * @author: yanghaojie 31648
 * @date: 2020/8/7 16:06
 */
public interface LabelRepository extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {

    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("update Label l set l.status = 0 where l.id=:id")
    int remove(@Param("id")String id);
}
