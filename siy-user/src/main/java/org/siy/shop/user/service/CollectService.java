package org.siy.shop.user.service;

import org.siy.common.service.IService;
import org.siy.shop.user.dto.GoodsCollectDTO;
import org.siy.shop.user.po.Collect;

import java.util.List;

/**
 * @author Ryan
 */
public interface CollectService extends IService<Collect> {

    List<GoodsCollectDTO> queryGoodsCollectList(Integer userId);

}
