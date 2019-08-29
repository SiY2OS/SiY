package org.siy.shop.user.mapper;

import org.siy.common.utils.MyMapper;
import org.siy.shop.user.po.Region;

public interface RegionMapper extends MyMapper<Region> {

    String selectNameById(Short id);
}
