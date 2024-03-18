package model.services;

import model.entities.BankAccount;
import model.exceptions.AccountManagementException;
import model.services.interfaces.WireTimeRule;

import java.util.List;

public class AccountManagement {
    public AccountManagement() {
    }

    public void createBankAccount(List<BankAccount> bankAccounts, BankAccount bankAccount) throws AccountManagementException {
        this.verifyAccount(bankAccounts, bankAccount.getAccountNumber(), bankAccount.getAccountAgency(), false);
        bankAccounts.add(bankAccount);
    }

    public void showAccountDetails(List<BankAccount> bankAccounts) throws AccountManagementException {
        if (bankAccounts.isEmpty()) {
            throw new AccountManagementException("Não existem contas cadastradas atualmente!");
        }
        System.out.println("Listagem de contas existentes");
        for (BankAccount obj : bankAccounts) {
            System.out.printf("Titular: %s, ", obj.getCustomerName());
            System.out.printf("Número: %s, ", obj.getAccountNumber());
            System.out.printf("Agência: %s, ", obj.getAccountAgency());
            System.out.printf("Tipo: %s, ", obj.getAccountType());
            System.out.printf("Saldo atual: %s, ", obj.getAccountBalance());
            System.out.printf("Limite de transferências diário: %s", obj.getAccountLimit());
            System.out.println();
        }
    }

    public void bankDeposit(List<BankAccount> bankAccounts, int number, int agency, Double depositValue) throws AccountManagementException {
        BankAccount obj = this.verifyAccount(bankAccounts, number, agency, true);
        this.valueIsValid(depositValue);
        obj.setAccountBalance(obj.getAccountBalance() + depositValue);
    }

    public void bankDraw(List<BankAccount> bankAccounts, int number, int agency, Double drawValue) throws AccountManagementException {
        BankAccount obj = this.verifyAccount(bankAccounts, number, agency, true);
        this.valueIsValid(drawValue);
        if (drawValue > obj.getAccountBalance()) {
            throw new AccountManagementException("A conta informada não possui saldo suficiente!");
        } else if (drawValue > obj.getAccountLimit()) {
            throw new AccountManagementException("O valor informado é maior que o limite de transação disponível!");
        } else {
            obj.setAccountBalance(obj.getAccountBalance() - drawValue);
            obj.setAccountLimit(obj.getAccountLimit() - drawValue);
        }

    }

    public void changeLimit(List<BankAccount> bankAccounts, int number, int agency, Double newLimitValue) throws AccountManagementException {
        BankAccount obj = this.verifyAccount(bankAccounts, number, agency, true);
        this.valueIsValid(newLimitValue);
        obj.setAccountLimit(newLimitValue);

    }

    public void bankWire(WireTimeRule wireTimeRule, List<BankAccount> bankAccounts, int numberAccountOrigin, int agencyAccountOrigin,
                         int numberAccountDestiny, int agencyAccountDestiny, Double wireValue) throws AccountManagementException {
        boolean accountOriginExists = false;
        boolean accountDestinyExists = false;
        for (BankAccount obj : bankAccounts) {
            if (obj.getAccountAgency().equals(agencyAccountOrigin) &&
                    obj.getAccountNumber().equals(numberAccountOrigin)) {
                if (obj.getAccountBalance() < wireValue) {
                    throw new AccountManagementException("Saldo insuficiente para realizar a transferência bancária!");
                } else if (obj.getAccountLimit() < wireValue) {
                    throw new AccountManagementException("Limite de transações diárias excedido!");
                }
                accountOriginExists = true;
            }
            if (obj.getAccountAgency().equals(agencyAccountDestiny) &&
                    obj.getAccountNumber().equals(numberAccountDestiny)) {
                accountDestinyExists = true;
            }
        }

        boolean validatedWire = wireTimeRule.validatedWire(wireValue);
        if (!accountOriginExists) {
            throw new AccountManagementException("A conta de origem informada não existe!");
        } else if (!accountDestinyExists) {
            throw new AccountManagementException("A conta de destino informada não existe!");
        } else if (!validatedWire) {
            throw new AccountManagementException("Limite de transações entre " + wireTimeRule.getInitLimit().toString() + "h e " +
                                                 wireTimeRule.getEndLimit().toString() + "h excedido!");
        } else {
            for (BankAccount obj : bankAccounts) {
                if (obj.getAccountAgency().equals(agencyAccountOrigin) &&
                        obj.getAccountNumber().equals(numberAccountOrigin)) {
                    obj.setAccountBalance(obj.getAccountBalance() - wireValue);
                    obj.setAccountLimit(obj.getAccountLimit() - wireValue);
                }
                if (obj.getAccountAgency().equals(agencyAccountDestiny) &&
                        obj.getAccountNumber().equals(numberAccountDestiny)) {
                    obj.setAccountBalance(obj.getAccountBalance() + wireValue);
                }
            }
        }

    }

    private BankAccount verifyAccount(List<BankAccount> bankAccounts, int number, int agency, boolean verifyIfExists) throws AccountManagementException {
        BankAccount bankAccount = new BankAccount();
        for (BankAccount obj : bankAccounts) {
            if (obj.getAccountAgency().equals(agency) && obj.getAccountNumber().equals(number)) {
                if (verifyIfExists){
                    return obj;
                }else{
                    throw new AccountManagementException("A conta informada já existe!");
                }
            }
        }
        if (verifyIfExists){
            throw new AccountManagementException("A conta informada não existe!");
        }else{
            return bankAccount;
        }
    }

    private void valueIsValid(Double value) throws AccountManagementException {
        if (value < 0){
            throw new AccountManagementException("O valor informado deve ser maior que 0!");
        }
    }

}
