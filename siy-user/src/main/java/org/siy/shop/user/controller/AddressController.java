package org.siy.shop.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.shop.user.api.AddressApi;
import org.siy.shop.user.po.Address;

@RestController
@RequestMapping("/address")
public class AddressController extends BaseApi<Address> implements AddressApi {
}
