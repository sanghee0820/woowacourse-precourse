package christmas.domain;

import christmas.domain.constant.Day;
import java.util.ArrayList;
import java.util.List;

public class VisitDay {
    private int day;

    private static final List<Integer> specialDay = new ArrayList<>(List.of(3, 10, 17, 24, 25, 31));

    public VisitDay(int day){
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public boolean isWeekend(){
        return Day.of(day).isWeekend();
    }

    public boolean isWeekDay(){
        return Day.of(day).isWeekDay();
    }

    public boolean isAfterChristmas(){
        return this.day > 25;
    }

    public int dDayOfChristmas(){
        return this.day - 1;
    }

    public boolean isStarDay(){
        return specialDay.contains(this.day);
    }
}
