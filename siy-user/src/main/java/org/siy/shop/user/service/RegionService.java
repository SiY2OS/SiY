package org.siy.shop.user.service;

import org.siy.common.service.IService;
import org.siy.shop.user.po.Region;

/**
 * @author Ryan
 */
public interface RegionService extends IService<Region> {

    String queryNameById(Short id);

}
