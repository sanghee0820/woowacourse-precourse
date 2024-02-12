package christmas.domain.policy.discountPolicy;

import christmas.domain.VisitDay;
import christmas.domain.Visitor;

public class DDayDiscountPolicy implements DiscountPolicy {
    private final String DESC = "크리스마스 디데이 할인";
    private final Integer DEFAULT_DISCOUNT_PRICE = 1000;
    private final Integer D_DAY_DISCOUNT_PRICE = 100;
    @Override
    public int getDiscount(Visitor visitor) {
        if(!isDiscountable(visitor)){
            return 0;
        }
        return discount(visitor.getVisitDay());
    }

    @Override
    public String getDesc() {
        return DESC;
    }

    private int discount(VisitDay day){
        if(day.isAfterChristmas()){
            return 0;
        }
        return DEFAULT_DISCOUNT_PRICE + day.dDayOfChristmas() * D_DAY_DISCOUNT_PRICE;
    }
}
