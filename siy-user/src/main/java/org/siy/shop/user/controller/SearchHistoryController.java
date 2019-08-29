package org.siy.shop.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.shop.user.api.SearchHistoryApi;
import org.siy.shop.user.po.SearchHistory;

@RestController
@RequestMapping("/searchHistory")
public class SearchHistoryController extends BaseApi<SearchHistory> implements SearchHistoryApi {
}
