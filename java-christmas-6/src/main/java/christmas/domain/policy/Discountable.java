package christmas.domain.policy;

import christmas.domain.Order;
import christmas.domain.Visitor;
import christmas.domain.constant.Category;
import christmas.domain.constant.Food;
import java.util.List;
import java.util.stream.Collectors;

public interface Discountable {

    default boolean isDiscountable(Visitor visitor){
        return checkPrice(visitor.getTotalPrice()) && checkOrders(visitor.getOrders());
    }

    default boolean checkPrice(int price){
        return price >= 10000;
    }
    default boolean checkOrders(List<Order> orders){
        return !orders.stream().filter
                ((order) -> order.getFood().getCategory() != Category.BEVERAGE).collect(Collectors.toSet()).isEmpty();
    }
}
