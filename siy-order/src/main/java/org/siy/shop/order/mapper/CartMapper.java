package org.siy.shop.order.mapper;

import org.siy.common.utils.MyMapper;
import org.siy.shop.order.po.Cart;

public interface CartMapper extends MyMapper<Cart> {

    int updateNumberById(Integer number, Integer id);

}
