package christmas.domain;

import christmas.domain.constant.Badge;
import christmas.domain.constant.Food;
import java.util.List;
import java.util.Map;

public class VisitorResult {
    private int day;
    private List<Food> orders;
    private int totalPrice;
    private Food gift;
    private Map<String, Integer> eventResult;
    private Badge badge;

    public VisitorResult(int day, List<Food> orders, int totalPrice, Food gift, Map<String, Integer> eventResult,
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

    public List<Food> getOrders() {
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
