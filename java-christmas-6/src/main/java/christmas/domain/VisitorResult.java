package christmas.domain;

import christmas.domain.constant.Badge;
import christmas.domain.constant.Food;
import java.util.List;
import java.util.Map;

public class VisitorResult {
    private final int day;
    private final List<Order> orders;
    private final int totalPrice;
    private final Food gift;
    private final Map<String, Integer> eventResult;
    private final Badge badge;

    public VisitorResult(int day, List<Order> orders, int totalPrice, Food gift, Map<String, Integer> eventResult,
                         Badge badge) {
        this.day = day;
        this.orders = orders;
        this.totalPrice = totalPrice;
        this.gift = gift;
        this.eventResult = eventResult;
        this.badge = badge;
    }

    public int getDay() {
        return day;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public Food getGift() {
        return gift;
    }

    public Map<String, Integer> getEventResult() {
        return eventResult;
    }

    public Badge getBadge() {
        return badge;
    }

}
