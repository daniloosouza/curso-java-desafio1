package application.features;

import application.menus.BankDepositMenu;
import application.menus.BankDrawMenu;
import application.menus.ChangeLimitMenu;
import entities.BankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MainMenu {

    private static final List<BankAccount> bankAccounts = new ArrayList<>();

    ManagementAccount managementAccount = new ManagementAccount();

    public void show() {
        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("Escolha uma opção no menu abaixo");
            System.out.println("1 - Cadastro de conta bancária");
            System.out.println("2 - Listagem de contas bancárias");
            System.out.println("3 - Depósito");
            System.out.println("4 - Saque");
            System.out.println("5 - Alterar limite de transação diária");
            System.out.println("0 - Sair");

            int option = sc.nextInt();

            switch (option){
                case 1:
                    System.out.println("Selecionado a opção Criar conta");
                    BankAccount account = CreateBankAccount.create();
                    if(Objects.nonNull(account)){
                        // Verify if Account already exists
                        for (BankAccount obj : bankAccounts){
                            if(obj.getAccountAgency().equals(account.getAccountAgency()) && obj.getAccountNumber().equals(account.getAccountNumber())){
                                System.out.println("Ocorreu um erro! A conta informada já existe.");
                                this.show();
                                break;
                            }
                        }

                        System.out.println("Conta criada com sucesso!");
                        bankAccounts.add(account);
                    }
                    this.show();
                    break;
                case 2:
                    System.out.println("Contas existentes:");
                    System.out.println(bankAccounts.toString());
                    this.show();
                case 3:
                    BankDepositMenu bankDepositMenu = new BankDepositMenu();
                    bankDepositMenu.show();
                    managementAccount.bankDeposit(bankAccounts, bankDepositMenu.getNumber(), bankDepositMenu.getAgency(), bankDepositMenu.getDepositValue());
                    System.out.println("Depósito realizado com sucesso!");
                    this.show();
                case 4:
                    BankDrawMenu bankDrawMenu = new BankDrawMenu();
                    bankDrawMenu.show();
                    managementAccount.bankDraw(bankAccounts, bankDrawMenu.getNumber(), bankDrawMenu.getAgency(), bankDrawMenu.getDrawValue());
                    System.out.println("Saque realizado com sucesso!");
                    this.show();
                case 5:
                    ChangeLimitMenu changeLimitMenu = new ChangeLimitMenu();
                    changeLimitMenu.show();
                    managementAccount.changeLimit(bankAccounts, changeLimitMenu.getNumber(), changeLimitMenu.getAgency(), changeLimitMenu.getNewLimitValue());
                    System.out.println("Alteração de limite realizada com sucesso!");
                    this.show();
                case 0:
                    System.out.println("Sair");
                    System.exit(0);
                    break;
            }
        }
        catch (Exception e){
            System.out.println("Operação cancelada!");
            System.out.println(e.getMessage());
            this.show();
        }

    }
}
