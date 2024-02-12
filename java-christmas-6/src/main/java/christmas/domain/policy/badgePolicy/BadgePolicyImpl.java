package christmas.domain.policy.badgePolicy;

import christmas.domain.constant.Badge;

public class BadgePolicyImpl implements BadgePolicy{
    @Override
    public Badge getBadge(int totalDiscount) {
        return Badge.of(totalDiscount);
    }
}
