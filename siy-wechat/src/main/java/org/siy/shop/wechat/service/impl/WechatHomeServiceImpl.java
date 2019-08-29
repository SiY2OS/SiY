package org.siy.shop.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.siy.common.utils.Criteria;
import org.siy.shop.goods.api.BrandApi;
import org.siy.shop.goods.api.CategoryApi;
import org.siy.shop.goods.api.ChannelApi;
import org.siy.shop.goods.api.GoodsApi;
import org.siy.shop.goods.po.Brand;
import org.siy.shop.goods.po.Category;
import org.siy.shop.goods.po.Channel;
import org.siy.shop.goods.po.Goods;
import org.siy.shop.user.api.AdApi;
import org.siy.shop.user.api.TopicApi;
import org.siy.shop.user.po.Ad;
import org.siy.shop.user.po.Topic;
import org.siy.shop.wechat.service.WechatHomeService;
import org.siy.shop.wechat.vo.HomeCategoryVO;
import org.siy.shop.wechat.vo.HomeIndexVO;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WechatHomeServiceImpl implements WechatHomeService {
    @Autowired
    private AdApi adApi;

    @Autowired
    private ChannelApi channelApi;

    @Autowired
    private GoodsApi goodsApi;

    @Autowired
    private BrandApi brandApi;

    @Autowired
    private TopicApi topicApi;

    @Autowired
    private CategoryApi categoryApi;

    @Override
//    @Cacheable("index")
    public HomeIndexVO index() {

        List<Ad> bannerList = adApi.queryByCriteria(Criteria.of(Ad.class).fields(Ad::getId, Ad::getLink, Ad::getImageUrl).andEqualTo(Ad::getAdPositionId, 1)).getData();

        List<Channel> channelList = channelApi.queryByCriteria(Criteria.of(Channel.class).fields(Channel::getId, Channel::getIconUrl, Channel::getName, Channel::getUrl).sort(Channel::getSortOrder)).getData();

        List<Goods> newGoodsList = goodsApi.queryByCriteria(Criteria.of(Goods.class).fields(Goods::getId, Goods::getListPicUrl, Goods::getName, Goods::getRetailPrice).page(1, 4).andEqualTo(Goods::getNewly, true)).getData();

        List<Goods> hotGoodsList = goodsApi.queryByCriteria(Criteria.of(Goods.class).fields(Goods::getId, Goods::getListPicUrl, Goods::getName, Goods::getGoodsBrief, Goods::getRetailPrice).page(1, 4).andEqualTo(Goods::getHot, true)).getData();

        List<Brand> brandList = brandApi.queryByCriteria(Criteria.of(Brand.class).fields(Brand::getId, Brand::getNewPicUrl, Brand::getName, Brand::getFloorPrice).andEqualTo(Brand::getNewly, 1).sort(Brand::getNewSortOrder)).getData();

        List<Topic> topicList = topicApi.queryByCriteria(Criteria.of(Topic.class).fields(Topic::getId, Topic::getScenePicUrl, Topic::getTitle, Topic::getPriceInfo, Topic::getSubtitle).page(1, 10)).getData();

        List<HomeCategoryVO> categoryList = new LinkedList<>();

        categoryApi.queryByCriteria(
                Criteria.of(Category.class).fields(Category::getId, Category::getName).andEqualTo(Category::getParentId, 0)
        ).getData().forEach(c -> {

            List<Integer> categoryIdList = categoryApi.queryByCriteria(Criteria.of(Category.class).fields(Category::getId).andEqualTo(Category::getParentId, c.getId())).getData().stream()
                    .map(Category::getId)
                    .collect(Collectors.toList());

            List<Goods> goodsList = goodsApi.queryByCriteria(Criteria.of(Goods.class).fields(Goods::getId, Goods::getListPicUrl, Goods::getName, Goods::getRetailPrice).andIn(Goods::getCategoryId, categoryIdList).page(1, 3)).getData();
            categoryList.add(new HomeCategoryVO(c.getId(), c.getName(), goodsList));
        });

        return new HomeIndexVO().setBannerList(bannerList)
                .setChannelList(channelList)
                .setNewGoodsList(newGoodsList)
                .setHotGoodsList(hotGoodsList)
                .setBrandList(brandList)
                .setTopicList(topicList)
                .setCategoryList(categoryList);
    }
}
