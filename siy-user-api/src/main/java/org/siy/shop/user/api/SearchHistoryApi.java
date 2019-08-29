package org.siy.shop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.siy.common.api.Api;
import org.siy.shop.user.fallback.SearchHistoryApiFallback;
import org.siy.shop.user.po.SearchHistory;

@FeignClient(value = "siy-user", path = "searchHistory", fallback = SearchHistoryApiFallback.class)
public interface SearchHistoryApi extends Api<SearchHistory> {
}
