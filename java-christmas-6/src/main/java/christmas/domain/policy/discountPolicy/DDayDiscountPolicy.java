package christmas.domain.policy.discountPolicy;

public class DDayDiscountPolicy implements DiscountPolicy {
    private final String desc = "크리스마스 디데이 할인";
    @Override
    public int getDiscount(int day, int price) {
        if(!isDiscountable(price)){
            return 0;
        }
        return discount(day);
    }

    private int discount(int day){
        if(day > 25){
            return 0;
        }
        return 1000 + (day - 1) * 100;
    }
}
