package christmas.domain;

import christmas.domain.constant.Food;

public class Order {
    private Food food;
    private Integer amount;


    public Order(Food food, Integer amount) {
        this.food = food;
        this.amount = amount;
    }

    public Food getFood() {
        return food;
    }

    public Integer getAmount() {
        return amount;
    }
}
