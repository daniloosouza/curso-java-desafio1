package application.features;

import entities.BankAccount;
import entities.enums.AccountType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateBankAccount {
    public static BankAccount create() throws Exception {

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

        obj = new BankAccount(number, agency, name, balance, limit, AccountType.valueOf(type));

        System.out.println(obj.toString());

            //MainMenu.show();

        //} catch (Exception e) {
            //System.out.println("Valor inválido inserido. Voltando para o Menu Principal");
            //System.out.println(e.getMessage());
            //MainMenu.show();
            //throw new RuntimeException(e);
        //}

        return obj;

    }

    private static void verifyLimit(Double balance, Double limit) throws Exception {
        if(balance > limit){
            throw new Exception("O valor de saldo não deve ser maior que o limite da conta!");
        }
    }

}
