package org.siy.shop.wechat.service;

import org.siy.shop.wechat.vo.SearchIndexVO;

import java.util.List;

public interface WechatSearchService {

    List<String> helper(String keyword);

    void clearHistory();

    SearchIndexVO index();

}
