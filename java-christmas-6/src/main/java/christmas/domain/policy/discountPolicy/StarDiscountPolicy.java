package christmas.domain.policy.discountPolicy;

import java.util.ArrayList;
import java.util.List;

public class StarDiscountPolicy implements DiscountPolicy{
    private final String desc = "특별할인";
    private final List<Integer> specialDay = new ArrayList<>(List.of(3, 10, 17, 24, 25, 31));
    @Override
    public int getDiscount(int day, int price) {
        if(isDiscountable(price)){
            return discount(day);
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
