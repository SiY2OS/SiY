package org.siy.shop.wechat.service;

import org.siy.shop.wechat.vo.AddressVO;

import java.util.List;

public interface WechatAddressService {

    AddressVO queryDetail(Integer id);

    List<AddressVO> queryDetailList();

}
