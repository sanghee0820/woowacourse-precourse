package christmas.domain.policy.discountPolicy;

import christmas.domain.VisitDay;
import christmas.domain.Visitor;
import java.util.ArrayList;
import java.util.List;

public class StarDiscountPolicy implements DiscountPolicy{
    private final String DESC = "특별할인";
    private final Integer DEFAULT_DISCOUNT_PRICE = 1000;
    @Override
    public int getDiscount(Visitor visitor) {
        if(isDiscountable(visitor)){
            return discount(visitor.getVisitDay());
        }
        return 0;
    }

    @Override
    public String getDesc() {
        return DESC;
    }

    private int discount(VisitDay day){
        if(day.isStarDay()){
            return DEFAULT_DISCOUNT_PRICE;
        }
        return 0;
    }
}
