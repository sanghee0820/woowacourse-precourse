package christmas.service;

import christmas.domain.Visitor;
import christmas.domain.constant.Badge;
import christmas.domain.policy.badgePolicy.BadgePolicy;
import christmas.domain.policy.badgePolicy.BadgePolicyImpl;
import java.util.Map;

public class BadgeService {
    private final BadgePolicy badgePolicy = new BadgePolicyImpl();

    public Badge getBadge(Map<String, Integer> events){
        return badgePolicy.getBadge(events.values().stream().mapToInt(Integer::intValue).sum());
    }
}
