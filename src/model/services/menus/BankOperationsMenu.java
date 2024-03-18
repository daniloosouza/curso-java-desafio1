package model.services.menus;

import java.util.Scanner;

public class BankOperationsMenu {
    int number;
    int agency;

    Double value;

    public BankOperationsMenu() {
    }

    public int getNumber() {
        return number;
    }

    public int getAgency() {
        return agency;
    }

    public Double getValue() {
        return value;
    }

    public void show(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o número da conta bancária:");
        number = sc.nextInt();

        System.out.println("Informe a agência da conta bancária:");
        agency = sc.nextInt();

        System.out.println("Informe o valor:");
        value = sc.nextDouble();
    }
}
