package view;

import entities.NumberLottery;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by XTR100 on 12/11/2016.
 */
public class NumberLotteryEntityView {

    NumberLottery numberLottery;
    StringProperty date;
    StringProperty numberMorning;
    StringProperty numberNight;

    public NumberLotteryEntityView() {
    }

    public NumberLotteryEntityView(NumberLottery numberLottery) {
        this.numberLottery = numberLottery;
        date = new SimpleStringProperty(numberLottery.getDate());
        numberMorning = new SimpleStringProperty(numberLottery.getNumberMorning());
        numberNight = new SimpleStringProperty(numberLottery.getNumberNight());
    }

    public NumberLottery getNumberLottery() {
        return numberLottery;
    }

    public void setNumberLottery(NumberLottery numberLottery) {
        this.numberLottery = numberLottery;
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getNumberMorning() {
        return numberMorning.get();
    }

    public StringProperty numberMorningProperty() {
        return numberMorning;
    }

    public void setNumberMorning(String numberMorning) {
        this.numberMorning.set(numberMorning);
    }

    public String getNumberNight() {
        return numberNight.get();
    }

    public StringProperty numberNightProperty() {
        return numberNight;
    }

    public void setNumberNight(String numberNight) {
        this.numberNight.set(numberNight);
    }
}
