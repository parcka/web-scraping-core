package entities;

/**
 * Created by XTR100 on 12/10/2016.
 */
public class NumberLottery {

    String date;
    String numberMorning;
    String numberNight;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumberMorning() {
        return numberMorning;
    }

    public void setNumberMorning(String numberMorning) {
        this.numberMorning = numberMorning;
    }

    public String getNumberNight() {
        return numberNight;
    }

    public void setNumberNight(String numberNight) {
        this.numberNight = numberNight;
    }

    @Override
    public String toString() {
        return "NumberLottery{" +
                "date='" + date + '\'' +
                ", numberMorning='" + numberMorning + '\'' +
                ", numberNight='" + numberNight + '\'' +
                '}';
    }
}
