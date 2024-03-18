package model.services.menus;

import java.util.Scanner;

public class BankWireMenu {
    int numberAccountOrigin;
    int agencyAccountOrigin;
    int numberAccountDestiny;
    int agencyAccountDestiny;

    Double wireValue;

    public BankWireMenu() {
    }

    public int getNumberAccountOrigin() {
        return numberAccountOrigin;
    }

    public int getAgencyAccountOrigin() {
        return agencyAccountOrigin;
    }

    public int getNumberAccountDestiny() {
        return numberAccountDestiny;
    }

    public int getAgencyAccountDestiny() {
        return agencyAccountDestiny;
    }

    public Double getWireValue() {
        return wireValue;
    }

    public void show(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o número da conta bancária de origem para a transferência");
        numberAccountOrigin = sc.nextInt();

        System.out.println("Informe a agência da conta bancária de origem para a transferência");
        agencyAccountOrigin = sc.nextInt();

        System.out.println("Informe o número da conta bancária de destino para a transferência");
        numberAccountDestiny = sc.nextInt();

        System.out.println("Informe a agência da conta bancária de destino para a transferência");
        agencyAccountDestiny = sc.nextInt();

        System.out.println("Informe o valor da transferência");
        wireValue = sc.nextDouble();

    }
}
