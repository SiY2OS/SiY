package org.siy.shop.user.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.fallback.ApiFallback;
import org.siy.shop.user.api.SearchHistoryApi;
import org.siy.shop.user.po.SearchHistory;

@Component
public class SearchHistoryApiFallback extends ApiFallback<SearchHistory> implements SearchHistoryApi {
}
