package christmas.service;

import christmas.domain.Visitor;
import christmas.domain.policy.Discountable;
import christmas.domain.policy.discountPolicy.DDayDiscountPolicy;
import christmas.domain.policy.discountPolicy.DayOfWeekDiscountPolicy;
import christmas.domain.policy.discountPolicy.DiscountPolicy;
import christmas.domain.policy.discountPolicy.StarDiscountPolicy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscountService {
    private final List<DiscountPolicy> policies = List.of(new DayOfWeekDiscountPolicy(), new DDayDiscountPolicy(), new StarDiscountPolicy());

    public Map<String, Integer> calcDiscount(Visitor visitor){
        Map<String, Integer> discount = new HashMap<>();
        for(DiscountPolicy discountPolicy: policies){
            discount.put(discountPolicy.getDesc(), discountPolicy.getDiscount(visitor));
        }
        return discount;
    }
}
