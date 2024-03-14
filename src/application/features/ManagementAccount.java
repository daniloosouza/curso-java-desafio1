package application.features;

import entities.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class ManagementAccount {
    private List<BankAccount> bankAccounts = new ArrayList<>();

    public ManagementAccount() {
    }

    public boolean verifyAccountExists(List<BankAccount> bankAccounts, int number, int agency) {
        for (BankAccount obj : bankAccounts){
            if(obj.getAccountAgency().equals(agency) && obj.getAccountNumber().equals(number)){
                return true;
            }
        }
        return false;
    }

    public void bankDeposit(List<BankAccount> bankAccounts, int number, int agency, Double depositValue) throws Exception {
        boolean accountExists = false;
        for (BankAccount obj : bankAccounts){
            if(obj.getAccountAgency().equals(agency) && obj.getAccountNumber().equals(number)){
                obj.setAccountBalance(obj.getAccountBalance()+ depositValue);
                obj.setAccountLimit(obj.getAccountLimit() - depositValue);
                accountExists = true;
            }
        }
        if(!accountExists){
            throw new Exception("A conta informada não existe!");
        }

    }

    public void bankDraw(List<BankAccount> bankAccounts, int number, int agency, Double drawValue) throws Exception {
        boolean accountExists = false;
        for (BankAccount obj : bankAccounts){
            if(obj.getAccountAgency().equals(agency) && obj.getAccountNumber().equals(number)){
                if(drawValue > obj.getAccountBalance()){
                    throw new Exception("A conta informada não possui saldo suficiente!");
                } else if (drawValue > obj.getAccountLimit()) {
                    throw new Exception("O valor informado é maior que o limite de transação disponível!");
                }
                obj.setAccountBalance(obj.getAccountBalance() - drawValue);
                obj.setAccountLimit(obj.getAccountLimit() - drawValue);
                accountExists = true;
            }
        }
        if(!accountExists){
            throw new Exception("A conta informada não existe!");
        }

    }

    public void changeLimit(List<BankAccount> bankAccounts, int number, int agency, Double newLimitValue) throws Exception {
        boolean accountExists = false;
        for (BankAccount obj : bankAccounts){
            if(obj.getAccountAgency().equals(agency) && obj.getAccountNumber().equals(number)){
                if(newLimitValue < 0){
                    throw new Exception("O valor informado deve ser maior que 0!");
                }
                obj.setAccountLimit(newLimitValue);
                accountExists = true;
            }
        }
        if(!accountExists){
            throw new Exception("A conta informada não existe!");
        }

    }


}
