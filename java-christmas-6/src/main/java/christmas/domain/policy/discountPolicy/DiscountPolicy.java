package christmas.domain.policy.discountPolicy;

import christmas.domain.Visitor;

public interface DiscountPolicy {

    public int getDiscount(Visitor visitor);

    default boolean isDiscountable(int price){
        return price >= 10000;
    }
}
