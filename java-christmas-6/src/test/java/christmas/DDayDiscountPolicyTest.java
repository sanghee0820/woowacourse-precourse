package christmas;

import christmas.domain.Visitor;
import christmas.domain.constant.Food;
import christmas.domain.policy.discountPolicy.DDayDiscountPolicy;
import christmas.domain.policy.discountPolicy.DiscountPolicy;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DDayDiscountPolicyTest {

    @Test
    @DisplayName("구매금액 부족 테스트")
    public void lowPriceTest(){
        List<Visitor> input = new ArrayList<>();
        input.add(new Visitor(List.of(Food.ICE_CREAM), 15));
        input.add(new Visitor(List.of(Food.ZERO_COKE), 20));
        List<Integer> output = new ArrayList<>(List.of(0, 0));
        DiscountPolicy discountPolicy = new DDayDiscountPolicy();

        Assertions.assertThat(
                input.stream().map(discountPolicy::getDiscount)
            ).isEqualTo(output);
    }

    @Test
    @DisplayName("DDay 테스트")
    public void ddayTest(){
        List<Visitor> input = new ArrayList<>();
        input.add(new Visitor(List.of(Food.BBQ_LIB), 4));
        input.add(new Visitor(List.of(Food.CHRISTMAS_PASTA), 25));
        input.add(new Visitor(List.of(Food.MUSHROOM_SOUP), 26));
        List<Integer> output = new ArrayList<>(List.of(1300, 3400, 0));
        DiscountPolicy discountPolicy = new DDayDiscountPolicy();

        Assertions.assertThat(
                input.stream().map(discountPolicy::getDiscount)
        ).isEqualTo(output);
    }
}
