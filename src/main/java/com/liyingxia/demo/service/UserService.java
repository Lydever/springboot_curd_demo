package com.liyingxia.demo.service;

import com.liyingxia.demo.dao.UserDAO;
import com.liyingxia.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserDAO userDAO;

    public  void save(User user) {
        String now = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        user.setCreateTtime(now);
        userDAO.save(user);

    }


    public void delete(Long id){
        userDAO.deleteById(id);
    }

    public User findById(Long id){
        return userDAO.findById(id).orElse(null);

    }

    public List<User> findAll(){
        return userDAO.findAll();
    }

    public Page<User> findPage(Integer pageNum,Integer pageSize,String name){
        // 构建分页查询条件
        Sort sort = new Sort(Sort.Direction.DESC,"create_time");
        Pageable pageRequest = PageRequest.of(pageNum - 1,pageSize,sort);
        return userDAO.findByNameLike(name,pageRequest);
    }

}
