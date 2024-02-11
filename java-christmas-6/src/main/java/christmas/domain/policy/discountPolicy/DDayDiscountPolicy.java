package christmas.domain.policy.discountPolicy;

import christmas.domain.Visitor;

public class DDayDiscountPolicy implements DiscountPolicy {
    private final String desc = "크리스마스 디데이 할인";
    @Override
    public int getDiscount(Visitor visitor) {
        if(!isDiscountable(visitor.getTotalPrice())){
            return 0;
        }
        return discount(visitor.getVisitDay());
    }

    private int discount(int day){
        if(day > 25){
            return 0;
        }
        return 1000 + (day - 1) * 100;
    }
}
