package christmas.service;

import christmas.domain.Visitor;
import christmas.domain.constant.Food;
import christmas.domain.policy.giftPolicy.GiftPolicy;
import christmas.domain.policy.giftPolicy.GiftPolicyImpl;

public class GiftService {
    private final GiftPolicy giftPolicy = new GiftPolicyImpl();

    public Food getGift(Visitor visitor){
        return giftPolicy.getGift(visitor);
    }
}
