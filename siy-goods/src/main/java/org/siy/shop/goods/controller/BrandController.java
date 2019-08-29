package org.siy.shop.goods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.shop.goods.api.BrandApi;
import org.siy.shop.goods.po.Brand;

@RestController
@RequestMapping("/brand")
public class BrandController extends BaseApi<Brand> implements BrandApi {

}
