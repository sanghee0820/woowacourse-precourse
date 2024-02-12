package view;

import christmas.domain.VisitorResult;
import christmas.domain.constant.Badge;
import christmas.domain.constant.Food;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Order;

public class OutputView {
    public static final String WELCOME_MSG = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    public static final String VISIT_DATE_INPUT_DESC = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    public static final String ORDER_INPUT_DESC = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    public static final String EVENT_PREVIEW_HEADER = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    public static final String ORDER_LIST_HEADER = "\n<주문 메뉴>";
    public static final String TOTAL_PRICE_HEADER = "<할인 전 총주문 금액>";
    public static final String GIFT_HEADER = "<증정 메뉴>";
    public static final String BENEFIT_LIST_HEADER = "<혜택 내역>";
    public static final String BENEFIT_AMOUNT_HEADER = "<총혜택 금액>";
    public static final String DISCOUNTED_PRICE_HEADER = "<할인 후 예상 결제 금액>";
    public static final String EVENT_BADGE_HEADER = "<12월 이벤트 배지>";

    public static void printWelcome(){
        System.out.println(WELCOME_MSG);
    }
    public static void printVisitDayInput(){
        System.out.println(VISIT_DATE_INPUT_DESC);
    }

    public static void printOrderInput(){
        System.out.println(ORDER_INPUT_DESC);
    }

    public static void printResult(VisitorResult result){
        System.out.printf(EVENT_PREVIEW_HEADER, result.getDay());
    }

    private static void printOrderList(List<Food> orders){
        System.out.println(ORDER_LIST_HEADER);
        for(Food food : orders){
            System.out.println(food.getName());
        }
        System.out.println();
    }

    private static void printTotalPriceBeforeEvent(int totalPrice){
        System.out.println(TOTAL_PRICE_HEADER);
        System.out.println(totalPrice + "원\n");
    }
    private static void printGiftMenu(Food gift){
        System.out.println(GIFT_HEADER);
        if(gift != null){
            System.out.println(gift.getName());
            System.out.println();
            return;
        }
        System.out.println("없음");
        System.out.println();
    }
    private static void printEvent(Map<String, Integer> events){
        System.out.println(BENEFIT_LIST_HEADER);
        for(String key : events.keySet()){
            System.out.println(key + ": -" + events.get(key) + "원");
        }
    }

    private static void printTotalEventPrice(Map<String, Integer> events){
        System.out.println(BENEFIT_AMOUNT_HEADER);
        System.out.println("-" + events.values().stream().mapToInt(Integer::intValue).sum() + "원\n");
    }

    private static void printTotalPrice(int totalPrice, Food gift, Map<String, Integer> events){
        System.out.println(DISCOUNTED_PRICE_HEADER);
        if(gift == null){
            System.out.println(totalPrice - events.values().stream().mapToInt(Integer::intValue).sum() + "원\n");
            return;
        }

        System.out.println(totalPrice + gift.getPrice() - events.values().stream().mapToInt(Integer::intValue).sum() + "원\n");
    }

    private static void printBadge(Badge badge){
        System.out.println(EVENT_BADGE_HEADER);
        System.out.println(badge.getDesc());
    }
}
