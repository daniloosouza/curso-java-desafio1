package model.services;

import model.services.interfaces.WireTimeRule;

import java.time.LocalTime;

public class VerifyWire implements WireTimeRule {
    private final double valueOvernight = 500.00;
    private final LocalTime initLimit = LocalTime.parse("06:00:00");
    private final LocalTime endLimit = LocalTime.parse("22:00:00");

    public double getValueOvernight() {
        return valueOvernight;
    }

    public LocalTime getInitLimit() {
        return initLimit;
    }

    public LocalTime getEndLimit() {
        return endLimit;
    }

    @Override
    public boolean validatedWire(Double value) {
        boolean wireLimited = this.wireLimited();

        if (!wireLimited && value > this.valueOvernight){
            return false;
        }
        return true;

    }

    private boolean wireLimited(){
        LocalTime timeNow = LocalTime.now();
        if (timeNow.isBefore(this.initLimit) || timeNow.isAfter(this.endLimit)){
            return false;
        }else{
            return true;
        }
    }
}
