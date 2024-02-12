package christmas;

import static org.assertj.core.api.Assertions.*;

import christmas.domain.Visitor;
import christmas.domain.constant.Food;
import christmas.domain.policy.discountPolicy.DDayDiscountPolicy;
import christmas.domain.policy.discountPolicy.DayOfWeekDiscountPolicy;
import christmas.domain.policy.discountPolicy.DiscountPolicy;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DayOfWeekDiscountPolicyTest {

    @Test
    @DisplayName("주중 테스트")
    void weekDayTest(){
        List<Visitor> input = new ArrayList<>();
        input.add(new Visitor(List.of(Food.BBQ_LIB, Food.CHOCOLATE_CAKE, Food.ICE_CREAM), 4));
        input.add(new Visitor(List.of(Food.BBQ_LIB, Food.ZERO_COKE, Food.ICE_CREAM), 12));
        input.add(new Visitor(List.of(Food.BBQ_LIB, Food.CHOCOLATE_CAKE, Food.CEASAR_SALAD), 20));
        List<Integer> output = new ArrayList<>(List.of(4046, 2023, 2023));

        DiscountPolicy discountPolicy = new DayOfWeekDiscountPolicy();

        assertThat(
                input.stream().map(discountPolicy::getDiscount)
        ).isEqualTo(output);
    }

    @Test
    @DisplayName("주말 테스트")
    void weekendTest(){
        List<Visitor> input = new ArrayList<>();
        input.add(new Visitor(List.of(Food.BBQ_LIB, Food.CHOCOLATE_CAKE, Food.T_BORN_STAKE), 1));
        input.add(new Visitor(List.of(Food.BBQ_LIB, Food.ZERO_COKE, Food.ICE_CREAM), 16));
        input.add(new Visitor(List.of(Food.BBQ_LIB, Food.CHOCOLATE_CAKE, Food.CEASAR_SALAD), 21));
        List<Integer> output = new ArrayList<>(List.of(4046, 2023, 2023));

        DiscountPolicy discountPolicy = new DayOfWeekDiscountPolicy();

        assertThat(
                input.stream().map(discountPolicy::getDiscount)
        ).isEqualTo(output);
    }
}
