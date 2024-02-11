package christmas.domain.policy.discountPolicy;

public interface DiscountPolicy {

    public int getDiscount(int day, int price);

    default boolean isDiscountable(int price){
        return price >= 10000;
    }
}
