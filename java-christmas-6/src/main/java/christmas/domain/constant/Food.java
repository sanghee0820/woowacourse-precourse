package christmas.domain.constant;

public enum Food {
    MUSHROOM_SOUP(Category.APPETIZER, 6000), TAPAS(Category.APPETIZER, 5500), CEASAR_SALAD(Category.APPETIZER, 8000),
    T_BORN_STAKE(Category.MAIN_DISH, 55000), BBQ_LIB(Category.MAIN_DISH, 54000), SEA_FOOD_PASTA(Category.MAIN_DISH, 35000), CHRISTMAS_PASTA( Category.MAIN_DISH, 25000),
    CHOCOLATE_CAKE(Category.DESERT, 15000), ICE_CREAM(Category.DESERT, 5000),
    ZERO_COKE(Category.BEVERAGE, 3000), RED_WINE(Category.BEVERAGE,60000), Champagne(Category.BEVERAGE, 25000);

    private  final Category category;
    private final int price;

    Food(Category category, int price) {
        this.category = category;
        this.price = price;
    }
    public Category getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

}
