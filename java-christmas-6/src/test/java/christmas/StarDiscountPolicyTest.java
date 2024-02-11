package christmas;

import christmas.domain.Visitor;
import christmas.domain.constant.Food;
import christmas.domain.policy.discountPolicy.DiscountPolicy;
import christmas.domain.policy.discountPolicy.StarDiscountPolicy;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StarDiscountPolicyTest {

    @Test
    @DisplayName("구매금액 부족 테스트")
    public void lowPriceTest(){
        List<Visitor> input = new ArrayList<>();
        input.add(new Visitor(List.of(Food.ICE_CREAM), 15));
        input.add(new Visitor(List.of(Food.ZERO_COKE), 20));
        List<Integer> output = new ArrayList<>(List.of(0, 0));
        DiscountPolicy discountPolicy = new StarDiscountPolicy();

        Assertions.assertThat(
                input.stream().map(discountPolicy::getDiscount)
        ).isEqualTo(output);
    }

    @Test
    @DisplayName("SpecialDay 테스트")
    public void specialDayTest(){
        List<Visitor> input = new ArrayList<>();
        input.add(new Visitor(List.of(Food.BBQ_LIB), 3));
        input.add(new Visitor(List.of(Food.BBQ_LIB), 10));
        input.add(new Visitor(List.of(Food.BBQ_LIB), 11));
        List<Integer> output = new ArrayList<>(List.of(1000, 1000, 0));
        DiscountPolicy discountPolicy = new StarDiscountPolicy();

        Assertions.assertThat(
                input.stream().map(discountPolicy::getDiscount)
        ).isEqualTo(output);
    }
}
