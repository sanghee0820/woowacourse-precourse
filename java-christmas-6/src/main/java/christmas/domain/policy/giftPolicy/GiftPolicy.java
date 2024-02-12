package christmas.domain.policy.giftPolicy;

import christmas.domain.Visitor;
import christmas.domain.constant.Food;
import christmas.domain.policy.Discountable;

public interface GiftPolicy extends Discountable {

    Food getGift(Visitor visitor);
}
