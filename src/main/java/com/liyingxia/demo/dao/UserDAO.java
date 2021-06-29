package com.liyingxia.demo.dao;

import com.liyingxia.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User,Long> {

    @Query(value = "select * from users_info where name like %?1%",nativeQuery = true)
    Page<User> findByNameLike(String name, Pageable pageRequest);
}
