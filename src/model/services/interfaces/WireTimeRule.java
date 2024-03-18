package model.services.interfaces;

import java.time.LocalTime;

public interface WireTimeRule {

    LocalTime getInitLimit();
    LocalTime getEndLimit();
    boolean validatedWire(Double value);
}
