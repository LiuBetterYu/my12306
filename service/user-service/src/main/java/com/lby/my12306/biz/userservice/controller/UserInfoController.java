package com.lby.my12306.biz.userservice.controller;

import com.lby.my12306.biz.userservice.dto.req.UserDeletionReqDTO;
import com.lby.my12306.biz.userservice.dto.req.UserRegisterReqDTO;
import com.lby.my12306.biz.userservice.dto.req.UserUpdateReqDTO;
import com.lby.my12306.biz.userservice.dto.resp.UserQueryActualRespDTO;
import com.lby.my12306.biz.userservice.dto.resp.UserQueryRespDTO;
import com.lby.my12306.biz.userservice.dto.resp.UserRegisterRespDTO;
import com.lby.my12306.biz.userservice.service.UserLoginService;
import com.lby.my12306.biz.userservice.service.UserService;
import com.lby.my12306.framework.starter.convention.result.Result;
import com.lby.my12306.framework.starter.web.Results;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制层
 * @author lby
 */
@RestController
@RequiredArgsConstructor
public class UserInfoController {

    private final UserLoginService userLoginService;
    private final UserService userService;

    /**
     * 根据用户名查询用户信息
     */
    @GetMapping("/api/user-service/query")
    public Result<UserQueryRespDTO> queryUserByUsername(@RequestParam("username") @NotEmpty String username) {
        return Results.success(userService.queryUserByUsername(username));
    }

    /**
     * 根据用户名查询用户无脱敏信息
     */
    @GetMapping("/api/user-service/actual/query")
    public Result<UserQueryActualRespDTO> queryActualUserByUsername(@RequestParam("username") @NotEmpty String username) {
        return Results.success(userService.queryActualUserByUsername(username));
    }

    /**
     * 检查用户名是否已存在
     */
    @GetMapping("/api/user-service/has-username")
    public Result<Boolean> hasUsername(@RequestParam("username") @NotEmpty String username) {
        return Results.success(userLoginService.hasUsername(username));
    }
    /**
     * 注册用户
     */
    @PostMapping("/api/user-service/register")
    public Result<UserRegisterRespDTO> register(@RequestBody @Valid UserRegisterReqDTO requestParam) {
        return Results.success(userLoginService.register(requestParam));
    }

    /**
     * 修改用户
     */
    @PostMapping("/api/user-service/update")
    public Result<Void> update(@RequestBody @Valid UserUpdateReqDTO requestParam) {
        userService.update(requestParam);
        return Results.success();
    }

    /**
     * 注销用户
     */
    @PostMapping("/api/user-service/deletion")
    public Result<Void> deletion(@RequestBody @Valid UserDeletionReqDTO requestParam) {
        userLoginService.deletion(requestParam);
        return Results.success();
    }
}
