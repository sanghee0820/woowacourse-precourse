package christmas.domain.policy.discountPolicy;

import christmas.domain.VisitDay;
import christmas.domain.Visitor;
import christmas.domain.constant.Category;
import christmas.domain.constant.Day;
import christmas.domain.constant.Food;
import java.util.List;

public class DayOfWeekDiscountPolicy implements DiscountPolicy{
    private final String DESC = "크리스마스 디데이 할인";
    private final Integer DISCOUNT_PRICE = 2023;

    @Override
    public int getDiscount(Visitor visitor) {
        if(isDiscountable(visitor)){
            return discount(visitor.getVisitDay(), visitor.getOrders());
        }
        return 0;
    }

    @Override
    public String getDesc() {
        return DESC;
    }

    private int discount(VisitDay day, List<Food> orders){
        if(day.isWeekend()){
            return weekendDiscount(orders);
        }
        return weekDayDiscount(orders);
    }

    private int weekendDiscount(List<Food> orders ){
        return (int) (orders.stream()
                        .filter((order) -> order.getCategory() == Category.MAIN_DISH)
                        .count()*DISCOUNT_PRICE);
    }

    private int weekDayDiscount(List<Food> orders){
        return (int) (orders.stream()
                .filter((order) -> order.getCategory() == Category.DESERT)
                .count()*DISCOUNT_PRICE);
    }
}
