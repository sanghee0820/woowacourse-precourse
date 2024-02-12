package christmas.domain.policy.giftPolicy;

import christmas.domain.Visitor;
import christmas.domain.policy.Discountable;

public interface GiftPolicy extends Discountable {

    int getGift(Visitor visitor);
}
