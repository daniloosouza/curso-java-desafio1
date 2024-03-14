package application;

import application.features.MainMenu;

public class Program {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.show();

        /*Scanner sc = new Scanner(System.in);

        System.out.println("Seja bem-vindo! Escolha uma opção no menu abaixo");
        System.out.println("1 - Cadastro de conta bancária");
        System.out.println("0 - Sair");

        int option = sc.nextInt();

        switch (option){
            case 1:
                System.out.println("Selecionado a opção Criar conta");
                CreateBankAccount.create();
                break;
            case 0:
                System.out.println("Sair");
                break;
            default:
                System.out.println("Sair");
                break;
        }*/



    }
}