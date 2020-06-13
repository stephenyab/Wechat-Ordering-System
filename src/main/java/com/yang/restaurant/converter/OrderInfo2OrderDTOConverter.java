package com.yang.restaurant.converter;

import com.yang.restaurant.dto.OrderDTO;
import com.yang.restaurant.entity.OrderDetail;
import com.yang.restaurant.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import javax.servlet.http.Cookie;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OrderInfo2OrderDTOConverter
 * @Description
 * @Author yang
 * @Date 2020/5/13 17:27
 * @Version 1.0
 */
@Slf4j
public class OrderInfo2OrderDTOConverter {

    public static OrderDTO convert(Cookie carCookie, Cookie deskCookie, UserInfo buyerInfo) {
        //设置下订单的用户信息
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(buyerInfo.getUserName());
        orderDTO.setBuyerPhone(buyerInfo.getUserPhone());
        orderDTO.setBuyerAddress(buyerInfo.getUserCountry() + "-" + buyerInfo.getUserProvince() + "-" + buyerInfo.getUserCity());
        orderDTO.setBuyerOpenid(buyerInfo.getUserOpenid());

        //将购买的商品从购物车Cookie中取出
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            String orderResult = URLDecoder.decode(carCookie.getValue(), "UTF-8");
            JSONArray jsonArray = new JSONArray(orderResult);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setProductId(jsonObject.getString("g_id"));
                orderDetail.setProductQuantity(jsonObject.getInt("num"));
                orderDetailList.add(orderDetail);
            }
        } catch (UnsupportedEncodingException e) {
            log.info("解码出现错误：{}", carCookie.getValue());
        } catch (JSONException e) {
            log.info("JSON解析出现错误");
        }

        orderDTO.setDeskNum(Integer.valueOf(deskCookie.getValue()));
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
