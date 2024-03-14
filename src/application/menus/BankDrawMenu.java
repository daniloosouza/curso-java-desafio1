package application.menus;

import java.util.Scanner;

public class BankDrawMenu {
    int number;
    int agency;

    Double drawValue;

    public BankDrawMenu() {
    }

    public int getNumber() {
        return number;
    }

    public int getAgency() {
        return agency;
    }

    public Double getDrawValue() {
        return drawValue;
    }

    public void show(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o número da conta bancária que deseja realizar o saque");
        number = sc.nextInt();

        System.out.println("Informe a agência da conta bancária que deseja realizar o saque");
        agency = sc.nextInt();

        System.out.println("Informe o valor do saque");
        drawValue = sc.nextDouble();

    }



}
