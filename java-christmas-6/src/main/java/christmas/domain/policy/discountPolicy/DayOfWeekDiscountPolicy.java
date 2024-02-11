package christmas.domain.policy.discountPolicy;

import christmas.domain.Visitor;
import christmas.domain.constant.Category;
import christmas.domain.constant.Day;
import christmas.domain.constant.Food;
import java.util.List;

public class DayOfWeekDiscountPolicy implements DiscountPolicy{
    @Override
    public int getDiscount(Visitor visitor) {
        if(isDiscountable(visitor.getTotalPrice())){
            return discount(visitor.getVisitDay(), visitor.getOrders());
        }
        return 0;
    }

    private int discount(int day, List<Food> orders){
        if(Day.of(day).isWeekend()){
            return weekendDiscount(orders);
        }
        return weekDayDiscount(orders);
    }

    private int weekendDiscount(List<Food> orders ){
        return (int) (orders.stream()
                        .filter((order) -> order.getCategory() == Category.MAIN_DISH)
                        .count()*2023);
    }

    private int weekDayDiscount(List<Food> orders ){
        return (int) (orders.stream()
                .filter((order) -> order.getCategory() == Category.DESERT)
                .count()*2023);
    }
}
