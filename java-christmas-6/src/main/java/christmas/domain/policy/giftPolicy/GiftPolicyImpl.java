package christmas.domain.policy.giftPolicy;

import christmas.domain.Visitor;
import christmas.domain.constant.Food;

public class GiftPolicyImpl implements GiftPolicy{

    public Food getGift(Visitor visitor) {
        if(isDiscountable(visitor)){
            return findGift(visitor.getTotalPrice());
        }
        return null;
    }

    private Food findGift(int totalPrice){
        if(checkTotalPrice(totalPrice)){
            return Food.CHAMPAGNE;
        }
        return null;
    }

    private boolean checkTotalPrice(int totalPrice){
        return totalPrice > 120000;
    }
}
