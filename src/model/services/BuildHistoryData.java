package model.services;

import model.entities.BankAccount;
import model.entities.HistoryAccount;
import model.exceptions.AccountManagementException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuildHistoryData {
    private static final List<HistoryAccount> historyAccounts = new ArrayList<>();
    private static final String CSV_FILE_NAME = "src/resources/files/history/actions-history.csv";

    public BuildHistoryData() {
    }

    public void addHistoryData(BankAccount bankAccount, String action, Double value) {
        HistoryAccount historyAccount =
                new HistoryAccount(action, bankAccount.getAccountNumber(), bankAccount.getAccountAgency(), bankAccount.getCustomerName(),
                                   value, bankAccount.getAccountBalance(), bankAccount.getAccountType().toString());
        historyAccounts.add(historyAccount);

    }

    public void buildFile() throws AccountManagementException {
        if (historyAccounts.isEmpty()){
            throw new AccountManagementException("Não foram realizadas ações até o momento para a geração do histórico!");
        }

        List<String[]> dataLines = new ArrayList<>();
        dataLines.add(new String[]{"Data", "Ação", "Número", "Agência", "Titular", "Valor da operação", "Saldo Total", "Tipo"});
        for (HistoryAccount hist : historyAccounts) {
            dataLines.add(hist.toStringArray());
        }

        File csvOutputFile = new File(CSV_FILE_NAME);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dataLines.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }

    private String escapeSpecialCharacters(String data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

}
