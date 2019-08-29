package org.siy.shop.user.service;

import org.siy.common.service.IService;
import org.siy.shop.user.dto.GoodsFootprintDTO;
import org.siy.shop.user.po.Footprint;

import java.util.List;

/**
 * @author Ryan
 */
public interface FootprintService extends IService<Footprint> {

    List<GoodsFootprintDTO> queryGoodsFootprintByUserId(Integer userId);

}
