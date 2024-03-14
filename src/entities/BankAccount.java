package entities;

import entities.enums.AccountType;

public class BankAccount {

    private Integer accountNumber;
    private Integer accountAgency;
    private String customerName;
    private Double accountBalance;
    private Double accountLimit;
    private AccountType accountType;

    public BankAccount(Integer accountNumber, Integer accountAgency, String customerName, Double accountBalance, Double accountLimit, AccountType accountType) {
        this.accountNumber = accountNumber;
        this.accountAgency = accountAgency;
        this.customerName = customerName;
        this.accountBalance = accountBalance;
        this.accountLimit = accountLimit;
        this.accountType = accountType;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getAccountAgency() {
        return accountAgency;
    }

    public void setAccountAgency(Integer accountAgency) {
        this.accountAgency = accountAgency;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Double getAccountLimit() {
        return accountLimit;
    }

    public void setAccountLimit(Double accountLimit) {
        this.accountLimit = accountLimit;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", accountAgency=" + accountAgency +
                ", customerName='" + customerName + '\'' +
                ", accountBalance=" + accountBalance +
                ", accountLimit=" + accountLimit +
                ", accountType=" + accountType +
                '}';
    }
}
