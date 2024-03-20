# curso-java-desafio1

Primeiro desafio do Programa **Renew your Career (Java & Spring Boot)**.

## 📄 Diagramas
### Diagrama de sequência da aplicação
```mermaid
sequenceDiagram 
actor u as Usuario
participant p as Program
participant m as Menus
participant s as Services
autonumber
u->>p: Inicia a aplicação
p->>m: Executa a classe de Menu inicial
m->>p: Exibe o Menu inicial para o usuário
u->>p: Escolhe a opção desejada
p->>m: Executa a classe referente a opção escolhida
m-->>p: Exibe o menu (Caso exista)
u-->>p: Insere as informações
p->>s: Executa a classe de processamento
s->>s: Realiza as validações necessárias
s->>s: Executa a operação escolhida (Criação, Depósito, saque, etc.)
s->>p: Retorna a mensagem com status de sucesso ou erro
```

Diagrama de classes da aplicação
```mermaid
classDiagram
direction BT
class AccountManagement {
  + AccountManagement() 
  - verifyAccount(List~BankAccount~, int, int, boolean) BankAccount
  + createBankAccount(List~BankAccount~, BankAccount) void
  + bankDeposit(List~BankAccount~, int, int, Double) void
  - valueIsValid(Double) void
  + bankDraw(WireTimeRule, List~BankAccount~, int, int, Double) void
  + showAccountDetails(List~BankAccount~) void
  + changeLimit(List~BankAccount~, int, int, Double) void
  + bankWire(WireTimeRule, List~BankAccount~, int, int, int, int, Double) void
}
class AccountManagementException {
  + AccountManagementException(String) 
}
class AccountType {
<<enumeration>>
  CONTA_CORRENTE = 1
  CONTA_POUPANCA = 2
  CONTA_SALARIO = 3
  - AccountType(int) 
  - int value
  + values() AccountType[]
  + valueOf(int) AccountType
  + valueOf(String) AccountType
   int value
}
class BankAccount {
  + BankAccount(Integer, Integer, String, Double, Double, AccountType) 
  + BankAccount() 
  - Double accountBalance
  - Double accountLimit
  - Integer accountAgency
  - AccountType accountType
  - Integer accountNumber
  - String customerName
  + toString() String
   Double accountLimit
   Integer accountNumber
   String customerName
   Integer accountAgency
   AccountType accountType
   Double accountBalance
}
class BankOperationsMenu {
  + BankOperationsMenu() 
  - int agency
  - Double value
  - int number
  + show() void
   Double value
   int number
   int agency
}
class BankWireMenu {
  + BankWireMenu() 
  - Double wireValue
  - int numberAccountDestiny
  - int numberAccountOrigin
  - int agencyAccountOrigin
  - int agencyAccountDestiny
  + show() void
   int agencyAccountDestiny
   Double wireValue
   int numberAccountOrigin
   int numberAccountDestiny
   int agencyAccountOrigin
}
class BuildHistoryData {
  - List historyAccounts  
  + BuildHistoryData() 
  - escapeSpecialCharacters(String) String
  + addHistoryData(BankAccount, String, Double) void
  + buildFile() void
  - convertToCSV(String[]) String
}
class CreateAccountMenu {
  + CreateAccountMenu() 
  - BankAccount bankAccount
  + show() void
   BankAccount bankAccount
}
class HistoryAccount {
  - LocalDateTime date
  - String action
  - Integer accountNumber
  - Integer accountAgency
  - String customerName
  - Double value
  - Double balance
  - String type  
  + HistoryAccount(String, Integer, Integer, String, Double, Double, String) 
  + toStringArray() String[]
}
class MainMenu {
  - List bankAccounts  
  + MainMenu() 
  + show() void
}
class Program {
  + Program() 
  + main(String[]) void
}
class VerifyWire {
  + VerifyWire() 
  - LocalTime initLimit
  - LocalTime endLimit
  + validatedWire(Double) boolean
  - wireLimited() boolean
   LocalTime initLimit
   LocalTime endLimit
}
class WireTimeRule {
<<Interface>>
  + validatedWire(Double) boolean
   LocalTime initLimit
   LocalTime endLimit
}

AccountManagement  ..>  AccountManagementException : «create»
AccountManagement  ..>  BankAccount : «create»
AccountManagement "1" *--> "buildHistoryData 1" BuildHistoryData 
AccountManagement  ..>  BuildHistoryData : «create»
BankAccount "1" *--> "accountType 1" AccountType 
BuildHistoryData  ..>  AccountManagementException : «create»
BuildHistoryData  ..>  HistoryAccount : «create»
BuildHistoryData "1" *--> "historyAccounts *" HistoryAccount 
CreateAccountMenu  ..>  BankAccount : «create»
CreateAccountMenu "1" *--> "bankAccount 1" BankAccount 
MainMenu  ..>  AccountManagement : «create»
MainMenu "1" *--> "accountManagement 1" AccountManagement 
MainMenu "1" *--> "bankAccounts *" BankAccount 
MainMenu  ..>  BankOperationsMenu : «create»
MainMenu  ..>  BankWireMenu : «create»
MainMenu  ..>  BuildHistoryData : «create»
MainMenu  ..>  CreateAccountMenu : «create»
MainMenu  ..>  VerifyWire : «create»
Program  ..>  MainMenu : «create»
VerifyWire  ..>  WireTimeRule 

```


## 🚀 Começando

Essas instruções permitirão que você obtenha uma cópia do projeto em sua máquina local para fins de desenvolvimento e teste.

### 📋 Pré-requisitos

- **[Git](https://git-scm.com/downloads)**
- **[Java 11 ou superior](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)**
- **IDE compatível com a linguagem JAVA**

### 🔧 Instalação

1. Realize o clone do projeto através do Github:
```
git clone https://github.com/daniloosouza/curso-java-desafio1.git
```
2. Importe o projeto na IDE de sua preferência:


## ⚙️ Execução

1. Execute a classe Program, contida em:
   ```/src/application/Program.java```
2. Será exibido um Menu Principal no Console com as opções:
```   
1 - Cadastro de conta bancária
2 - Listagem de contas bancárias
3 - Depósito
4 - Saque
5 - Alterar limite de transação diária
6 - Realizar transferência
7 - Exportar histórico de transações
0 - Sair 
```
3. Escolha a opção desejada e insira as informações necessárias
4. Como resultado da opção 7, será gerado um arquivo em 
``/src/resources/files/history`` com o nome de : **actions-history.csv** 
5. Ao final da execução de cada ação, é mostrada uma mensagem de sucesso.
6. Caso ocorra algum erro durante a execução, mensagens informativas sobre o erro serão exibidas.
7. Para encerra a aplicação, escolha a opção **0** no Menu Principal.


## ✒️ Autores
* **Danilo de Oliveira** - **[github](https://github.com/daniloosouza)**

---