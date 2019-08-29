package org.siy.shop.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.shop.user.api.AdApi;
import org.siy.shop.user.po.Ad;

@RestController
@RequestMapping("/ad")
public class AdController extends BaseApi<Ad> implements AdApi {

}
