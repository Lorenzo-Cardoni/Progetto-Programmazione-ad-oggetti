package Utils;

import java.time.LocalDate;

/**
 * Classe per trovare una data dati i giorni
 */
public class CalculateDay {

    private LocalDate today;

    /**
     * Costruttore
     */
    public CalculateDay(){

        this.today=LocalDate.now();
    }

    /**
     * Metodo per trovare la data
     * @param user_day giorni
     * @return data
     */
    public LocalDate getDate(int user_day){
        return today.minusDays(user_day);
    }
}
