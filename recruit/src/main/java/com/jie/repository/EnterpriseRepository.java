package com.jie.repository;

import com.jie.pojo.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: yanghaojie 31648
 * @date: 2020/8/10 16:27
 */
public interface EnterpriseRepository extends JpaRepository<Enterprise,String>, JpaSpecificationExecutor<Enterprise> {
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("update Enterprise l set l.status = 0 where l.id=:id")
    int remove(@Param("id")String id);
}
