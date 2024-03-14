package application.menus;

import java.util.Scanner;

public class ChangeLimitMenu {
    int number;
    int agency;

    Double newLimitValue;

    public ChangeLimitMenu() {
    }

    public int getNumber() {
        return number;
    }

    public int getAgency() {
        return agency;
    }

    public Double getNewLimitValue() {
        return newLimitValue;
    }

    public void show(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o número da conta bancária que deseja realizar o saque");
        number = sc.nextInt();

        System.out.println("Informe a agência da conta bancária que deseja realizar o saque");
        agency = sc.nextInt();

        System.out.println("Informe o valor do novo limite de transação diária");
        newLimitValue = sc.nextDouble();

    }

}
