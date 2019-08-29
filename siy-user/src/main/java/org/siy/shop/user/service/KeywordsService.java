package org.siy.shop.user.service;

import org.siy.common.service.IService;
import org.siy.shop.user.po.Keywords;

import java.util.List;

public interface KeywordsService extends IService<Keywords> {

    List<String> queryByKeyword(String keyword);
}
