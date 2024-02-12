package christmas.domain.policy;

import christmas.domain.Visitor;
import christmas.domain.constant.Category;
import christmas.domain.constant.Food;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Order;

public interface Discountable {

    default boolean isDiscountable(Visitor visitor){
        return checkPrice(visitor.getTotalPrice()) && checkOrders(visitor.getOrders());
    }

    default boolean checkPrice(int price){
        return price >= 10000;
    }
    default boolean checkOrders(List<Food> orders){
        return !orders.stream().filter
                ((food) -> food.getCategory() != Category.BEVERAGE).collect(Collectors.toSet()).isEmpty();
    }
}
