package christmas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.Visitor;
import christmas.domain.constant.Food;
import christmas.domain.policy.discountPolicy.DDayDiscountPolicy;
import christmas.domain.policy.discountPolicy.DiscountPolicy;
import christmas.domain.policy.giftPolicy.GiftPolicy;
import christmas.domain.policy.giftPolicy.GiftPolicyImpl;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GiftPolicyImplTest {

    @Test
    @DisplayName("증정품 제공 테스트")
    void giftTest(){
        List<Visitor> input = new ArrayList<>();
        input.add(new Visitor(List.of(Food.BBQ_LIB, Food.BBQ_LIB, Food.CHOCOLATE_CAKE, Food.ICE_CREAM), 4));
        input.add(new Visitor(List.of(Food.BBQ_LIB, Food.T_BORN_STAKE, Food.ZERO_COKE, Food.ICE_CREAM), 12));
        input.add(new Visitor(List.of(Food.ZERO_COKE, Food.ZERO_COKE, Food.CHAMPAGNE, Food.CHAMPAGNE, Food.CHAMPAGNE, Food.CHAMPAGNE, Food.CHAMPAGNE, Food.CHAMPAGNE, Food.CHAMPAGNE), 20));
        List<Food> output = new ArrayList<>();
        output.add(Food.CHAMPAGNE);
        output.add(null);
        output.add(null);
        GiftPolicy giftPolicy = new GiftPolicyImpl();

        assertEquals(
                input.stream().map(giftPolicy::getGift).toList()
        , output);
    }
}
