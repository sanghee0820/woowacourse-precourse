package christmas.domain.policy.discountPolicy;

import christmas.domain.Visitor;
import java.util.ArrayList;
import java.util.List;

public class StarDiscountPolicy implements DiscountPolicy{
    private final String desc = "특별할인";
    private final List<Integer> specialDay = new ArrayList<>(List.of(3, 10, 17, 24, 25, 31));
    @Override
    public int getDiscount(Visitor visitor) {
        if(isDiscountable(visitor.getTotalPrice())){
            return discount(visitor.getVisitDay());
        }
        return 0;
    }

    private int discount(int day){
        if(isStarDay(day)){
            return 1000;
        }
        return 0;
    }

    private boolean isStarDay(int day){
        return specialDay.contains(day);
    }
}
