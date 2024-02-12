package christmas.domain.policy.giftPolicy;

import christmas.domain.Visitor;
import christmas.domain.constant.Badge;
import christmas.domain.constant.Food;

public class GiftPolicyImpl implements GiftPolicy{

    public int getGift(Visitor visitor) {
        if(isDiscountable(visitor)){
            return findGift(visitor.getTotalPrice());
        }
        return 0;
    }

    private int findGift(int totalPrice){
        if(checkTotalPrice(totalPrice)){
            return 25000;
        }
        return 0;
    }

    private boolean checkTotalPrice(int totalPrice){
        return totalPrice > 120000;
    }
}
