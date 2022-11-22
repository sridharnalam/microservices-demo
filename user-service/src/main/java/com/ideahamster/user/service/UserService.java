package com.ideahamster.user.service;

import com.ideahamster.user.entity.User;
import com.ideahamster.user.repository.UserRepository;
import com.ideahamster.user.vo.Department;
import com.ideahamster.user.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user){
        log.info("Inside saveUser method of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            Department department = restTemplate.getForObject("http://localhost:9001/departments/"+user.getDepartmentId(), Department.class);
            vo.setUser(user);
            vo.setDepartment(department);
        }

        return vo;
    }
}

