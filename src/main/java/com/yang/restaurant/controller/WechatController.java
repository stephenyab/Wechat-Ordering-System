package com.yang.restaurant.controller;

import com.yang.restaurant.config.ProjectUrl;
import com.yang.restaurant.constant.CookieConstant;
import com.yang.restaurant.constant.RedisConstant;
import com.yang.restaurant.entity.UserInfo;
import com.yang.restaurant.enums.ResultEnum;
import com.yang.restaurant.enums.UserIdentityEnum;
import com.yang.restaurant.exception.UserException;
import com.yang.restaurant.service.UserService;
import com.yang.restaurant.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName WechatController
 * @Description
 * @Author yang
 * @Date 2020/5/14 10:39
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping("/wechat")
public class WechatController {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private ProjectUrl projectUrl;

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * @return java.lang.String
     * @Author yang
     * @Description 微信登录入口
     * @Date 2020/4/14 21:53
     * @Param []
     **/
    @GetMapping("/authorize")
    public String authorize() {
        String url = projectUrl.getWechatMpAuthorize() + "/wechat/userInfo";
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
        return "redirect:" + redirectUrl;
    }

    /**
     * @return java.lang.String
     * @Author yang
     * @Description 获取用户openid和信息
     * @Date 2020/4/14 21:53
     * @Param [code]
     **/
    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = null;
        WxMpUser wxMpUser = null;
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
            wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
        } catch (WxErrorException e) {
            log.error("【微信网页授权】{}", e);
            throw new UserException(ResultEnum.WECHAT_AUTHORIZE_ERROR.getCode(), "微信网页授权出现错误：" + e.getError().getErrorMsg());
        }

        String openId = wxMpOAuth2AccessToken.getOpenId();

        UserInfo userInfo = null;
        try {
            userInfo = userService.findUserByOpenid(openId);
        } catch (Exception e) {
            log.info("用户未注册");
        }

        if (userInfo == null) {
            userInfo = new UserInfo();
            userInfo.setUserOpenid(openId);
            userInfo.setUserName(wxMpUser.getNickname());
            userInfo.setUserSex(wxMpUser.getSex());
            userInfo.setUserIdentity(UserIdentityEnum.CUSTOMER.getCode());
            if (wxMpUser.getHeadImgUrl().equals("")) {
                userInfo.setUserHeadimgurl("/images/default_head_img.png");
            }else {
                userInfo.setUserHeadimgurl(wxMpUser.getHeadImgUrl());
            }
            userInfo.setUserProvince(wxMpUser.getProvince());
            userInfo.setUserCity(wxMpUser.getCity());
            userInfo.setUserCountry(wxMpUser.getCountry());
            userService.save(userInfo);
        }

        return "redirect:/wechat/login" + "?openid=" + openId;
    }

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid,
                              HttpServletResponse response,
                              Map<String, Object> map) {
        //1.username与数据库中的数据匹配
        UserInfo userInfo = userService.findUserByOpenid(openid);
        if (userInfo == null) {
            map.put("msg", ResultEnum.LOGIN_FAIL);
            return new ModelAndView("customer/common/error", map);
        }

        //2.设置token至redis中
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;

        redisTemplate.opsForValue().set(String.format(RedisConstant.USER_PREFIX, token), openid, expire, TimeUnit.SECONDS);

        //3.设置token至cookie
        CookieUtil.set(response, CookieConstant.USER, token, expire);

        return new ModelAndView("redirect:/customer/index");
    }

}
