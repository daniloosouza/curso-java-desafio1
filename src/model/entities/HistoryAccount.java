package model.entities;

import java.time.LocalDateTime;

public class HistoryAccount {

    private final LocalDateTime date = LocalDateTime.now();
    private final String action;
    private final Integer accountNumber;
    private final Integer accountAgency;
    private final String customerName;
    private final Double value;
    private final Double balance;
    private final String type;

    public HistoryAccount(String action, Integer accountNumber, Integer accountAgency, String customerName, Double value, Double balance, String type) {
        this.action = action;
        this.accountNumber = accountNumber;
        this.accountAgency = accountAgency;
        this.customerName = customerName;
        this.value = value;
        this.balance = balance;
        this.type = type;
    }

    public String[] toStringArray() {
        String[] strings = new String[8];

        strings[0] = date.toString();
        strings[1] = action;
        strings[2] = accountNumber.toString();
        strings[3] = accountAgency.toString();
        strings[4] = customerName;
        strings[5] = String.valueOf(value);
        strings[6] = String.valueOf(balance);
        strings[7] = type;

        return strings;
    }
}
