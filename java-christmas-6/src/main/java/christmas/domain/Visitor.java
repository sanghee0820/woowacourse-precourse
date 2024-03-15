package christmas.domain;

import christmas.domain.constant.Food;
import java.util.List;

public class Visitor {
    private final List<Order> orders;
    private final VisitDay visitDay;

    public Visitor(List<Order> orders, int visitDay){
        this.orders = orders;
        this.visitDay = new VisitDay(visitDay);
    }
    public int getTotalPrice(){
        return orders.stream()
                .mapToInt(order ->
                        order.getFood().getPrice()*order.getAmount())
                .sum();
    }

    public List<Order> getOrders(){
        return this.orders;
    }

    public VisitDay getVisitDay() {
        return this.visitDay;
    }
}
