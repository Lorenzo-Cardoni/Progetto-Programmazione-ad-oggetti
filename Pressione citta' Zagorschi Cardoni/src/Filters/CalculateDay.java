package Filters;

import java.time.LocalDate;

public class CalculateDay {

    private LocalDate today;

    public CalculateDay(){

        this.today=LocalDate.now();
    }

    public LocalDate getDate(int user_day){
        return today.minusDays(user_day);
    }
}
