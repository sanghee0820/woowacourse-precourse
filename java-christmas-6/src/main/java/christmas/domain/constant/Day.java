package christmas.domain.constant;

import java.time.LocalDate;

public enum Day {
    MONTHDAY, THUSDAY, WENDSDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    public static Day of(int day){
        return Day.values()[LocalDate.of(2023, 12, day).getDayOfWeek().getValue() - 1];
    }

}
