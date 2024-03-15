package christmas.domain.constant;

import java.util.Arrays;

public enum Food {
    MUSHROOM_SOUP(Category.APPETIZER, 6000,"양송이수프"), TAPAS(Category.APPETIZER, 5500, "타파스"), CEASAR_SALAD(Category.APPETIZER, 8000, "시저샐러드"),
    T_BORN_STAKE(Category.MAIN_DISH, 55000,"티본스테이크"), BBQ_LIB(Category.MAIN_DISH, 54000, "바비큐립"), SEA_FOOD_PASTA(Category.MAIN_DISH, 35000, "해산물파스타"), CHRISTMAS_PASTA( Category.MAIN_DISH, 25000, "크리스마스파스타"),
    CHOCOLATE_CAKE(Category.DESERT, 15000,"초코케이크"), ICE_CREAM(Category.DESERT, 5000, "아이스크림"),
    ZERO_COKE(Category.BEVERAGE, 3000, "제로콜라"), RED_WINE(Category.BEVERAGE,60000, "레드와인"), CHAMPAGNE(Category.BEVERAGE, 25000, "샴페인");

    private final Category category;
    private final int price;
    private final String name;

    Food(Category category, int price, String name) {
        this.category = category;
        this.price = price;
        this.name = name;
    }
    public Category getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public static Food getFood(String name){
        for(Food food : Food.values()){
            if(food.getName().equals(name)){
                return food;
            }
        }
        throw new IllegalArgumentException("[ERROR] 일치하는 음식이 없습니다.");
    }
}
