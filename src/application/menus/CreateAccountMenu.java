package application.menus;

import entities.BankAccount;
import entities.enums.AccountType;

import java.util.Scanner;

public class CreateAccountMenu {

    BankAccount bankAccount = new BankAccount();

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void show(){

        Scanner sc = new Scanner(System.in);
        BankAccount obj = null;
        //try {
        System.out.println("Digite o número da conta bancária");
        int number = sc.nextInt();

        System.out.println("Digite a agência da conta bancária");
        int agency = sc.nextInt();

        System.out.println("Digite o nome do titular da conta bancária");
        String name = sc.next();

        System.out.println("Digite o valor do saldo total da conta bancária");
        Double balance = sc.nextDouble();

        System.out.println("Digite o valor de limite de transação diária da conta bancária");
        Double limit = sc.nextDouble();

        System.out.println("Digite o tipo da conta bancária usando os valores:");
        System.out.println("1 para Conta Corrente");
        System.out.println("2 para Conta Poupança");
        System.out.println("3 para Conta Salário");
        int type = sc.nextInt();

        bankAccount = new BankAccount(number, agency, name, balance, limit, AccountType.valueOf(type));
    }

}
