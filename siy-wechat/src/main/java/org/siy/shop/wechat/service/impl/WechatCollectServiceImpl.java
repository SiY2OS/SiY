package org.siy.shop.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.siy.common.utils.Criteria;
import org.siy.shop.user.api.CollectApi;
import org.siy.shop.user.dto.GoodsCollectDTO;
import org.siy.shop.user.po.Collect;
import org.siy.shop.user.po.User;
import org.siy.shop.wechat.service.WechatCollectService;
import org.siy.shop.wechat.utils.JwtHelper;
import org.siy.shop.wechat.vo.CollectAddOrDeleteParamVO;
import org.siy.shop.wechat.vo.CollectAddOrDeleteResultVO;

import java.util.List;

@Service
public class WechatCollectServiceImpl implements WechatCollectService {

    @Autowired
    private CollectApi collectApi;

    @Override
    public CollectAddOrDeleteResultVO addOrDelete(CollectAddOrDeleteParamVO dto) {
        User userInfo = JwtHelper.getUserInfo();
        List<Collect> data = collectApi.queryByCriteria(
                Criteria.of(Collect.class).andEqualTo(Collect::getTypeId, dto.getTypeId())
                        .andEqualTo(Collect::getValueId, dto.getValueId())
                        .andEqualTo(Collect::getUserId, userInfo.getId())).getData();
        //添加收藏
        if (data.size() == 0) {
            collectApi.create(new Collect()
                    .setTypeId(dto.getTypeId())
                    .setValueId(dto.getValueId())
                    .setUserId(userInfo.getId()));
            return new CollectAddOrDeleteResultVO(true);
        } else {
            collectApi.delete(new Collect()
                    .setTypeId(dto.getTypeId())
                    .setValueId(dto.getValueId())
                    .setUserId(userInfo.getId()));
            return new CollectAddOrDeleteResultVO(false);
        }

    }

    @Override
    public List<GoodsCollectDTO> queryGoodsCollectList() {
        User userInfo = JwtHelper.getUserInfo();
        return collectApi.queryGoodsCollectList(userInfo.getId()).getData();
    }
}
