package org.siy.shop.wechat.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.siy.shop.user.dto.GoodsCollectDTO;
import org.siy.shop.wechat.vo.CollectAddOrDeleteParamVO;
import org.siy.shop.wechat.vo.CollectAddOrDeleteResultVO;

import java.util.List;

public interface WechatCollectService {

    CollectAddOrDeleteResultVO addOrDelete(@RequestBody CollectAddOrDeleteParamVO collectAddOrDeleteParamDTO);

    List<GoodsCollectDTO> queryGoodsCollectList();

}
