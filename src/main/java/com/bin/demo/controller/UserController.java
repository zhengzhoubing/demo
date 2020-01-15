package com.bin.demo.controller;

import com.bin.demo.common.basic.ResultHelper;
import com.bin.demo.common.exception.ApplicationException;
import com.bin.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * package: com.bin.demo.controller
 * class: UserController
 * description: TODO用一句话描述该文件做什么
 * date 2020/1/15 15:44
 *
 * @author ZhengZhouBin
 **/
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping(value = "queryUser", produces = "application/json;charset=utf-8")
    public Map<String, Object> queryUser() {
        try {
            Map<String, Object> result = ResultHelper.buildSuccessMap();
            result.put("userList", userService.queryUser());
            return result;
        } catch (ApplicationException e) {
            logger.error(e.getMsg(), e);
            return ResultHelper.buildExceptionMap(e.getCode(), e.getMsg());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResultHelper.buildDefaultExceptionMap(e);
        }
    }
}
