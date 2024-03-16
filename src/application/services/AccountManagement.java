package application.services;

import entities.BankAccount;

import java.util.List;

public class AccountManagement {
    public AccountManagement() {
    }

    public void createBankAccount(List<BankAccount> bankAccounts, BankAccount bankAccount) throws Exception {
        this.verifyAccount(bankAccounts, bankAccount.getAccountNumber(), bankAccount.getAccountAgency(), false);
        bankAccounts.add(bankAccount);
    }

    public void showAccountDetails(List<BankAccount> bankAccounts) throws Exception {
        if (bankAccounts.isEmpty()) {
            throw new Exception("Não existem contas cadastradas atualmente!");
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

    public void bankDeposit(List<BankAccount> bankAccounts, int number, int agency, Double depositValue) throws Exception {
        BankAccount obj = this.verifyAccount(bankAccounts, number, agency, true);
        obj.setAccountBalance(obj.getAccountBalance() + depositValue);
        //obj.setAccountLimit(obj.getAccountLimit() - depositValue);

        /*boolean accountExists = false;
        for (BankAccount obj : bankAccounts) {
            if (obj.getAccountAgency().equals(agency) && obj.getAccountNumber().equals(number)) {
                obj.setAccountBalance(obj.getAccountBalance() + depositValue);
                obj.setAccountLimit(obj.getAccountLimit() - depositValue);
                accountExists = true;
            }
        }
        if (!accountExists) {
            throw new Exception("A conta informada não existe!");
        }*/

    }

    public void bankDraw(List<BankAccount> bankAccounts, int number, int agency, Double drawValue) throws Exception {
        BankAccount obj = this.verifyAccount(bankAccounts, number, agency, true);
        if (drawValue > obj.getAccountBalance()) {
            throw new Exception("A conta informada não possui saldo suficiente!");
        } else if (drawValue > obj.getAccountLimit()) {
            throw new Exception("O valor informado é maior que o limite de transação disponível!");
        } else {
            obj.setAccountBalance(obj.getAccountBalance() - drawValue);
            obj.setAccountLimit(obj.getAccountLimit() - drawValue);
        }

        /*boolean accountExists = false;
        for (BankAccount obj : bankAccounts) {
            if (obj.getAccountAgency().equals(agency) && obj.getAccountNumber().equals(number)) {
                if (drawValue > obj.getAccountBalance()) {
                    throw new Exception("A conta informada não possui saldo suficiente!");
                } else if (drawValue > obj.getAccountLimit()) {
                    throw new Exception("O valor informado é maior que o limite de transação disponível!");
                }
                obj.setAccountBalance(obj.getAccountBalance() - drawValue);
                obj.setAccountLimit(obj.getAccountLimit() - drawValue);
                accountExists = true;
            }
        }
        if (!accountExists) {
            throw new Exception("A conta informada não existe!");
        }*/

    }

    public void changeLimit(List<BankAccount> bankAccounts, int number, int agency, Double newLimitValue) throws Exception {
        BankAccount obj = this.verifyAccount(bankAccounts, number, agency, true);
        if (newLimitValue < 0) {
            throw new Exception("O valor informado deve ser maior que 0!");
        }
        obj.setAccountLimit(newLimitValue);

        /*boolean accountExists = false;
        for (BankAccount obj : bankAccounts) {
            if (obj.getAccountAgency().equals(agency) && obj.getAccountNumber().equals(number)) {
                if (newLimitValue < 0) {
                    throw new Exception("O valor informado deve ser maior que 0!");
                }
                obj.setAccountLimit(newLimitValue);
                accountExists = true;
            }
        }
        if (!accountExists) {
            throw new Exception("A conta informada não existe!");
        }*/

    }

    public void bankWire(List<BankAccount> bankAccounts, int numberAccountOrigin, int agencyAccountOrigin,
                         int numberAccountDestiny, int agencyAccountDestiny, Double wireValue) throws Exception {
        boolean accountOriginExists = false;
        boolean accountDestinyExists = false;
        for (BankAccount obj : bankAccounts) {
            if (obj.getAccountAgency().equals(numberAccountOrigin) &&
                    obj.getAccountNumber().equals(agencyAccountOrigin)) {
                if (obj.getAccountBalance() < wireValue) {
                    throw new Exception("Saldo insuficiente para realizar a transferência bancária!");
                } else if (obj.getAccountLimit() < wireValue) {
                    throw new Exception("Limite de transações diárias excedido!");
                }
                accountOriginExists = true;
            }
            if (obj.getAccountAgency().equals(numberAccountDestiny) &&
                    obj.getAccountNumber().equals(agencyAccountDestiny)) {
                accountDestinyExists = true;
            }
        }
        if (!accountOriginExists) {
            throw new Exception("A conta de origem informada não existe!");
        } else if (!accountDestinyExists) {
            throw new Exception("A conta de destino informada não existe!");
        } else {
            for (BankAccount obj : bankAccounts) {
                if (obj.getAccountAgency().equals(numberAccountOrigin) &&
                        obj.getAccountNumber().equals(agencyAccountOrigin)) {
                    obj.setAccountBalance(obj.getAccountBalance() - wireValue);
                    obj.setAccountLimit(obj.getAccountLimit() - wireValue);
                }
                if (obj.getAccountAgency().equals(numberAccountDestiny) &&
                        obj.getAccountNumber().equals(agencyAccountDestiny)) {
                    obj.setAccountBalance(obj.getAccountBalance() + wireValue);
                }
            }
        }

    }

    private BankAccount verifyAccount(List<BankAccount> bankAccounts, int number, int agency, boolean verifyIfExists) throws Exception {
        BankAccount bankAccount = new BankAccount();
        for (BankAccount obj : bankAccounts) {
            if (obj.getAccountAgency().equals(agency) && obj.getAccountNumber().equals(number)) {
                if (verifyIfExists){
                    return obj;
                }else{
                    throw new Exception("A conta informada já existe!");
                }
            }
        }
        if (verifyIfExists){
            throw new Exception("A conta informada não existe!");
        }else{
            return bankAccount;
        }
    }

}
