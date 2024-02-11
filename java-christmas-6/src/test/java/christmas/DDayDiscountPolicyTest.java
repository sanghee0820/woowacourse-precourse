package christmas;

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
        List<List<Integer>> input = new ArrayList<>();
        input.add(List.of(4, 500));
        input.add(List.of(4, 300));
        List<Integer> output = new ArrayList<>(List.of(0, 0));
        DiscountPolicy discountPolicy = new DDayDiscountPolicy();

        Assertions.assertThat(
                input.stream().map((data) -> discountPolicy.getDiscount(data.get(0), data.get(1)))
            ).isEqualTo(output);
    }

    @Test
    @DisplayName("DDay 테스트")
    public void ddayTest(){
        List<List<Integer>> input = new ArrayList<>();
        input.add(List.of(4, 10000));
        input.add(List.of(25, 20000));
        input.add(List.of(26, 0));
        List<Integer> output = new ArrayList<>(List.of(1300, 3400, 0));
        DiscountPolicy discountPolicy = new DDayDiscountPolicy();

        Assertions.assertThat(
                input.stream().map((data) -> discountPolicy.getDiscount(data.get(0), data.get(1)))
        ).isEqualTo(output);
    }
}
