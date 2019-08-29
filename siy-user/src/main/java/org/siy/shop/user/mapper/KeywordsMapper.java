package org.siy.shop.user.mapper;


import org.siy.common.utils.MyMapper;
import org.siy.shop.user.po.Keywords;

import java.util.List;

public interface KeywordsMapper extends MyMapper<Keywords> {

    List<String> selectByKeywordLike(String keyword);
}
