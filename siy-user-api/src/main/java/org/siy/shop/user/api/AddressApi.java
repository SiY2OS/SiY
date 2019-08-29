package org.siy.shop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.siy.common.api.Api;
import org.siy.shop.user.fallback.AddressApiFallback;
import org.siy.shop.user.po.Address;

@FeignClient(value = "siy-user", path = "address", fallback = AddressApiFallback.class)
public interface AddressApi extends Api<Address> {

}
