package christmas.controller.util;

import christmas.domain.Order;
import christmas.domain.constant.Food;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private static final String isNumeric = "\\d+";

    public static int validateDay(String day){
        if(!day.matches(isNumeric)){
            throw new IllegalArgumentException("[ERROR] 날짜 형식이 숫자가 아닙니다.");
        }
        int integerDay = Integer.parseInt(day);

        if(1 <= integerDay && integerDay <= 31){
            return integerDay;
        }
        throw new IllegalArgumentException("[ERROR] 날짜 형식이 1~31일 사이가 아닙니다..");
    }

    public static List<Order> validateOrder(String stringOrder){
        String[] orderInfo = stringOrder.split(",");
        List<Order> orders = new ArrayList<>();
        for(String order : orderInfo){
            String[] data = order.split("-");
            if(!data[1].matches(isNumeric)){
                throw new IllegalArgumentException("[ERROR] Order형식이 일치하지 않습니다.");
            }
            if(!Arrays.stream(Food.values()).map(Food::getName).toList().contains(data[0])){
                throw new IllegalArgumentException("[ERROR] 주문하신 음식이 없습니다.");
            }
            orders.add(new Order(Food.getFood(data[0]), Integer.valueOf(data[1])));
        }

        return orders;
    }
}
