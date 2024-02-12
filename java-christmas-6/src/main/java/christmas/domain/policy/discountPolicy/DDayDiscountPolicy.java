package christmas.domain.policy.discountPolicy;

import christmas.domain.VisitDay;
import christmas.domain.Visitor;

public class DDayDiscountPolicy implements DiscountPolicy {
    private final String desc = "크리스마스 디데이 할인";
    private final Integer defaultDiscount = 1000;
    private final Integer dDayDiscount = 100;
    @Override
    public int getDiscount(Visitor visitor) {
        if(!isDiscountable(visitor.getTotalPrice())){
            return 0;
        }
        return discount(visitor.getVisitDay());
    }

    private int discount(VisitDay day){
        if(day.isAfterChristmas()){
            return 0;
        }
        return defaultDiscount + day.dDayOfChristmas() * dDayDiscount;
    }
}
