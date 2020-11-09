package com.itxingrui.controller;

import com.itxingrui.bean.dto.Result;
import com.itxingrui.service.RedisService;
import com.itxingrui.service.SendMsgService;
import com.itxingrui.utils.CodeUtils;
import com.itxingrui.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msgCode")
public class MsgCodeController {

    @Autowired
    private SendMsgService sendMsgService;

    @Autowired
    private RedisService redisService;

    /**
     * 用于用户获取短信验证码
     * @param phone
     * @return
     */
    @RequestMapping(value = "/sendMsgCode", method = RequestMethod.GET)
    public Result sendMsgCode(@RequestParam("phone") String phone) {
        //1.生成随机六位验证码 -- 工具方法 utils包中，并且处理为静态方法
        String code = CodeUtils.randomCode();
        System.out.println(phone +"  :  " + code);
        //2.短信推送 -- 属于短信相关的业务逻辑  service，SendMsgService
        String s = sendMsgService.sendMsgCode(phone, code);
        if (!StringUtils.isEmpty(s)) {
            //3.将验证码存入redis，并设置超期时间 -- service，RedisService
            redisService.setString(phone,code,300);
        }
        return Result.getSuccess();
    }

    /**
     * 用于短信验证码校验
     * @param phone
     * @param code
     * @return
     */
    @RequestMapping(value = "/checkMsgCode", method = RequestMethod.POST)
    public Result checkMsgCode(@RequestParam("phone") String phone,
                               @RequestParam("code") String code) {
        String value = redisService.getStringValue(phone);
        if (!StringUtils.isEmpty(value) && value.equals(code)){
            redisService.delByKey(phone);
            return Result.getSuccess();
        }else {
            return Result.getFaild();
            // 如果value为null，请重新发送验证码
            // 如果equals返回false，手机号或严重码错误，请重新输入
        }

    }

}
