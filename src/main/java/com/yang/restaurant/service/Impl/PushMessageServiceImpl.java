package com.yang.restaurant.service.Impl;

import com.yang.restaurant.config.ProjectUrl;
import com.yang.restaurant.config.WechatAccountConfig;
import com.yang.restaurant.dto.OrderDTO;
import com.yang.restaurant.dto.RestInfoDTO;
import com.yang.restaurant.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName PushMessageServiceImpl
 * @Description
 * @Author yang
 * @Date 2020/5/16 22:48
 * @Version 1.0
 */
@Slf4j
@Service
public class PushMessageServiceImpl implements PushMessageService {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private ProjectUrl projectUrl;

    @Autowired
    private WechatAccountConfig accountConfig;

    @Override
    public void orderStatus(OrderDTO orderDTO, RestInfoDTO restInfoDTO) {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setTemplateId(accountConfig.getTemplateId().get("orderStatus"));
        templateMessage.setToUser(orderDTO.getBuyerOpenid());

        List<WxMpTemplateData> data = Arrays.asList(
                new WxMpTemplateData("first", "您的订单已完结，点击详情可对订单进行评价"),
                new WxMpTemplateData("keyword1", restInfoDTO.getRestName()),
                new WxMpTemplateData("keyword2", restInfoDTO.getRestPhone()),
                new WxMpTemplateData("keyword3", orderDTO.getOrderId()),
                new WxMpTemplateData("keyword4", orderDTO.getOrderStatusEnum().getMessage()),
                new WxMpTemplateData("keyword5", "￥" + orderDTO.getOrderAmount()),
                new WxMpTemplateData("remark", "欢迎再次光临")
        );
        templateMessage.setUrl(projectUrl.getWechatMpAuthorize() + "/customer/order/discuss?orderId=" + orderDTO.getOrderId());
        templateMessage.setData(data);

        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            log.error("【微信模板消息】发送失败，{}", e);
        }
    }
}
