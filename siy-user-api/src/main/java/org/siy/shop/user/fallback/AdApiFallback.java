package org.siy.shop.user.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.fallback.ApiFallback;
import org.siy.shop.user.api.AdApi;
import org.siy.shop.user.po.Ad;

@Component
public class AdApiFallback extends ApiFallback<Ad> implements AdApi {
}
