package org.siy.shop.user.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.fallback.ApiFallback;
import org.siy.shop.user.api.AddressApi;
import org.siy.shop.user.po.Address;

@Component
public class AddressApiFallback extends ApiFallback<Address> implements AddressApi {

}
