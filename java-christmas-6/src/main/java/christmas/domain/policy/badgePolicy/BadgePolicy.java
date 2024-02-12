package christmas.domain.policy.badgePolicy;

import christmas.domain.constant.Badge;

public interface BadgePolicy {
    Badge getBadge(int totalDiscount);
}
