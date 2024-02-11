package christmas.domain;

import christmas.domain.constant.Food;
import java.util.List;

public class Visitor {
    private final List<Food> orders;
    private final int visitDay;

    public Visitor(List<Food> orders, int visitDay){
        this.orders = orders;
        this.visitDay = visitDay;
    }
    public int getTotalPrice(){
        return orders.stream().mapToInt(Food::getPrice).sum();
    }

    public List<Food> getOrders(){
        return this.orders;
    }

    public int getVisitDay() {
        return this.visitDay;
    }
}
