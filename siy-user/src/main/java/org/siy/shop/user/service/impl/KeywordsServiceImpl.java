package org.siy.shop.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.siy.common.service.BaseService;
import org.siy.shop.user.mapper.KeywordsMapper;
import org.siy.shop.user.po.Keywords;
import org.siy.shop.user.service.KeywordsService;

import java.util.List;

@Service
public class KeywordsServiceImpl extends BaseService<Keywords> implements KeywordsService {

    @Autowired
    private KeywordsMapper keywordsMapper;

    @Override
    public List<String> queryByKeyword(String keyword) {
        return keywordsMapper.selectByKeywordLike(keyword);
    }
}
