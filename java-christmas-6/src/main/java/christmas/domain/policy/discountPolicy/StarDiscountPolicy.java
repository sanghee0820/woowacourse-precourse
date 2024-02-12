package christmas.domain.policy.discountPolicy;

import christmas.domain.VisitDay;
import christmas.domain.Visitor;
import java.util.ArrayList;
import java.util.List;

public class StarDiscountPolicy implements DiscountPolicy{
    private final String desc = "특별할인";
    @Override
    public int getDiscount(Visitor visitor) {
        if(isDiscountable(visitor)){
            return discount(visitor.getVisitDay());
        }
        return 0;
    }

    private int discount(VisitDay day){
        if(day.isStarDay()){
            return 1000;
        }
        return 0;
    }
}
