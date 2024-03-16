package application.menus;

import application.services.AccountManagement;
import entities.BankAccount;

import java.util.*;

public class MainMenu {

    private static final List<BankAccount> bankAccounts = new ArrayList<>();

    AccountManagement accountManagement = new AccountManagement();

    public void show() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Escolha uma opção no menu abaixo");
            System.out.println("1 - Cadastro de conta bancária");
            System.out.println("2 - Listagem de contas bancárias");
            System.out.println("3 - Depósito");
            System.out.println("4 - Saque");
            System.out.println("5 - Alterar limite de transação diária");
            System.out.println("6 - Realizar transferência");
            System.out.println("0 - Sair");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    CreateAccountMenu createAccountMenu = new CreateAccountMenu();
                    createAccountMenu.show();
                    accountManagement.createBankAccount(bankAccounts, createAccountMenu.getBankAccount());
                    System.out.println("Conta criada com sucesso!");
                    this.show();
                    break;
                case 2:
                    accountManagement.showAccountDetails(bankAccounts);
                    this.show();
                case 3:
                    BankDepositMenu bankDepositMenu = new BankDepositMenu();
                    bankDepositMenu.show();
                    accountManagement.bankDeposit(bankAccounts, bankDepositMenu.getNumber(),
                                                  bankDepositMenu.getAgency(), bankDepositMenu.getDepositValue());
                    System.out.println("Depósito realizado com sucesso!");
                    this.show();
                case 4:
                    BankDrawMenu bankDrawMenu = new BankDrawMenu();
                    bankDrawMenu.show();
                    accountManagement.bankDraw(bankAccounts, bankDrawMenu.getNumber(), bankDrawMenu.getAgency(),
                                               bankDrawMenu.getDrawValue());
                    System.out.println("Saque realizado com sucesso!");
                    this.show();
                case 5:
                    ChangeLimitMenu changeLimitMenu = new ChangeLimitMenu();
                    changeLimitMenu.show();
                    accountManagement.changeLimit(bankAccounts, changeLimitMenu.getNumber(),
                                                  changeLimitMenu.getAgency(), changeLimitMenu.getNewLimitValue());
                    System.out.println("Alteração de limite realizada com sucesso!");
                    this.show();
                case 6:
                    BankWireMenu bankWireMenu = new BankWireMenu();
                    bankWireMenu.show();
                    accountManagement.bankWire(bankAccounts, bankWireMenu.getNumberAccountOrigin(), bankWireMenu.getAgencyAccountOrigin(),
                                               bankWireMenu.getAgencyAccountDestiny(), bankWireMenu.getAgencyAccountDestiny(),
                                               bankWireMenu.getWireValue());
                case 0:
                    System.out.println("Encerrando aplicação...");
                    System.exit(0);
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("O formato dos dados digitados está inconsistente!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Operação cancelada!");
            this.show();
        }

    }
}
