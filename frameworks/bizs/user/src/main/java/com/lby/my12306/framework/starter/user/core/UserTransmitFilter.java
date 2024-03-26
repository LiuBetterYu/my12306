package com.lby.my12306.framework.starter.user.core;

import com.lby.my12306.framework.starter.bases.constant.UserConstant;
import com.lby.my12306.framework.starter.user.toolkit.JWTUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * 用户信息传输过滤器
 * @author lby
 */
public class UserTransmitFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String token = httpServletRequest.getHeader("Authorization");
        UserInfoDTO userInfoDTO = JWTUtil.parseJwtToken(token);
        UserContext.setUser(userInfoDTO);

//        String userId = httpServletRequest.getHeader(UserConstant.USER_ID_KEY);
//        if (StringUtils.hasText(userId)) {
//            String userName = httpServletRequest.getHeader(UserConstant.USER_NAME_KEY);
//            String realName = httpServletRequest.getHeader(UserConstant.REAL_NAME_KEY);
//            if (StringUtils.hasText(userName)) {
//                userName = URLDecoder.decode(userName, StandardCharsets.UTF_8);
//            }
//            if (StringUtils.hasText(realName)) {
//                realName = URLDecoder.decode(realName, StandardCharsets.UTF_8);
//            }
//            String token = httpServletRequest.getHeader(UserConstant.USER_TOKEN_KEY);
//            UserInfoDTO userInfoDTO = UserInfoDTO.builder()
//                    .userId(userId)
//                    .username(userName)
//                    .realName(realName)
//                    .token(token)
//                    .build();
//            UserContext.setUser(userInfoDTO);
//        }
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            UserContext.removeUser();
        }
    }
}
