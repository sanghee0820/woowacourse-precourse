package christmas.domain.policy.discountPolicy;

import christmas.domain.Visitor;
import christmas.domain.policy.Discountable;

public interface DiscountPolicy extends Discountable {

    int getDiscount(Visitor visitor);

    String getDesc();
}
