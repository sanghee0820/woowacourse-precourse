package christmas.controller;

import christmas.domain.Visitor;
import christmas.domain.VisitorResult;
import christmas.domain.constant.Badge;
import christmas.domain.constant.Food;
import christmas.service.BadgeService;
import christmas.service.DiscountService;
import christmas.service.GiftService;
import java.util.Map;
import christmas.view.OutputView;

public class EventController {
    private Visitor visitor;
    private final BadgeService badgeService = new BadgeService();
    private final DiscountService discountService = new DiscountService();
    private final GiftService giftService = new GiftService();

    public void setVisitor(Visitor visitor){
        OutputView.printWelcome();
        OutputView.printVisitDayInput();
        OutputView.printOrderInput();
        this.visitor = visitor;
    }
    public void getEventResult(){
        Map<String, Integer> discountInfo = discountService.calcDiscount(visitor);
        Food gift = giftService.getGift(visitor);
        Badge badge = badgeService.getBadge(discountInfo);
        VisitorResult visitorResult = new VisitorResult(visitor.getVisitDay().getDay(),
                visitor.getOrders(), visitor.getTotalPrice(), gift, discountInfo, badge);
        OutputView.printResult(visitorResult);
    }
}
