package com.max.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.max.pojo.Result;
import com.max.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
//创建拦截器，方法重写
public class LoginInterceptor implements HandlerInterceptor {

    //运行前运行，true->放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.获取请求的URL
        String url = request.getRequestURL().toString();
        log.info("@^@^@请求的url：{}" , url);

        //2.判断请求url中是否包含login，如果包含，放行
        if(url.contains("login")){
            log.info("@^@^@登录操作，放行，无需执行下面的代码");
            return true;
        }

        //3.获取JWT令牌
        String jwt = request.getHeader("token");

        //4.判断JWT是否为空，如果不为空，就进行解析，否则拦截
        if(!StringUtils.hasLength(jwt)){
            log.info("@^@^@请求头为空，未返回登录信息");
            Result error = Result.error("NOT_LOGIN");
            //手动转换 对象 -> json  (Jackson)
            ObjectMapper mapper = new ObjectMapper();
            String  notLogin = mapper.writeValueAsString(error);
            //返回
            response.getWriter().write(notLogin);
            return false;
        }

        //5.解析令牌的时候报错，也不能放行
        try {
            JwtUtils.parseJWT(jwt);
        }catch (Exception e){
            e.printStackTrace();
            log.info("@^@^@令牌解析失败，未登录");
            Result error = Result.error("NOT_LOGIN");
            //手动转换 对象 -> json  (Jackson)
            ObjectMapper mapper = new ObjectMapper();
            String  notLogin = mapper.writeValueAsString(error);
            //返回
            response.getWriter().write(notLogin);
            return false;
        }

        //6.放行
        return true;

    }


    //运行资源方法时运行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");
    }

    //视图渲染完成之后运行，最后运行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }
}
