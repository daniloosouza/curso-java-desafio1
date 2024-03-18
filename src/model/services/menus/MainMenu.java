package model.services.menus;

import model.entities.BankAccount;
import model.exceptions.AccountManagementException;
import model.services.AccountManagement;
import model.services.BuildHistoryData;
import model.services.VerifyWire;

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
            System.out.println("7 - Exportar histórico de transações");
            System.out.println("0 - Sair");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    CreateAccountMenu createAccountMenu = new CreateAccountMenu();
                    createAccountMenu.show();
                    accountManagement.createBankAccount(bankAccounts, createAccountMenu.getBankAccount());
                    System.out.println("Conta criada com sucesso!");
                    break;
                case 2:
                    accountManagement.showAccountDetails(bankAccounts);
                    break;
                case 3:
                    BankOperationsMenu bankDepositMenu = new BankOperationsMenu();
                    bankDepositMenu.show();
                    accountManagement.bankDeposit(bankAccounts, bankDepositMenu.getNumber(), bankDepositMenu.getAgency(), bankDepositMenu.getValue());
                    System.out.println("Depósito realizado com sucesso!");
                    break;
                case 4:
                    BankOperationsMenu bankDrawMenu = new BankOperationsMenu();
                    bankDrawMenu.show();
                    accountManagement.bankDraw(bankAccounts, bankDrawMenu.getNumber(), bankDrawMenu.getAgency(), bankDrawMenu.getValue());
                    System.out.println("Saque realizado com sucesso!");
                    break;
                case 5:
                    BankOperationsMenu changeLimitMenu = new BankOperationsMenu();
                    changeLimitMenu.show();
                    accountManagement.changeLimit(bankAccounts, changeLimitMenu.getNumber(), changeLimitMenu.getAgency(), changeLimitMenu.getValue());
                    System.out.println("Alteração de limite realizada com sucesso!");
                    break;
                case 6:
                    BankWireMenu bankWireMenu = new BankWireMenu();
                    bankWireMenu.show();
                    accountManagement.bankWire(new VerifyWire(), bankAccounts, bankWireMenu.getNumberAccountOrigin(), bankWireMenu.getAgencyAccountOrigin(),
                                               bankWireMenu.getNumberAccountDestiny(), bankWireMenu.getAgencyAccountDestiny(),
                                               bankWireMenu.getWireValue());
                    System.out.println("Transferência realizada com sucesso!");
                    break;
                case 7:
                    BuildHistoryData buildHistoryData = new BuildHistoryData();
                    buildHistoryData.buildFile();
                    System.out.println("Histórico gerado com sucesso!");
                    break;
                default:
                    System.out.println("Encerrando aplicação...");
                    System.exit(0);
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("O formato dos dados digitados está inconsistente!");
        } catch (AccountManagementException e){
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Ocorreu um erro inesperado durante o processamento!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            this.show();
        }

    }
}
