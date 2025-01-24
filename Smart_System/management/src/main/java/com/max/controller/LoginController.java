package com.max.controller;

import com.max.pojo.Emp;
import com.max.pojo.Result;
import com.max.service.EmpService;
import com.max.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private EmpService empService;
    /**
     * 登录界面
     * @param emp
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登录：{}",emp);
        Emp e = empService.login(emp);
        //登陆成功，生成令牌，判断逻辑，是否查询到了登录者信息
        if(e != null){
            //封装到一个Hashmap中
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("username",e.getUsername());
            claims.put("phoneNumber",e.getPhoneNumber());

            log.info("生成令牌：{}",JwtUtils.generateJwt(claims));
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        //登录失败，返回错误信息
        return Result.error("用户名或密码错误");
    }
}
