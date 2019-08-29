package org.siy.shop.wechat.service;

import org.siy.shop.user.dto.GoodsFootprintDTO;

import java.util.List;

public interface WechatFootprintService {

    List<List<GoodsFootprintDTO>> queryGoodsFootprintTimeLine();
}
