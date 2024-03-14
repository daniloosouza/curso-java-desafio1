package application.menus;

import java.util.Scanner;

public class BankDepositMenu {
    int number;
    int agency;

    Double depositValue;

    public BankDepositMenu() {
    }

    public int getNumber() {
        return number;
    }

    public int getAgency() {
        return agency;
    }

    public Double getDepositValue() {
        return depositValue;
    }

    public void show(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o número da conta bancária que deseja realizar o depósito");
        number = sc.nextInt();

        System.out.println("Informe a agência da conta bancária que deseja realizar o depósito");
        agency = sc.nextInt();

        System.out.println("Informe o valor do depósito");
        depositValue = sc.nextDouble();

    }



}
