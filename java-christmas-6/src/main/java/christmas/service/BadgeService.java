package christmas.service;

import christmas.domain.policy.badgePolicy.BadgePolicy;
import christmas.domain.policy.badgePolicy.BadgePolicyImpl;

public class BadgeService {
    private final BadgePolicy badgePolicy = new BadgePolicyImpl();
}
