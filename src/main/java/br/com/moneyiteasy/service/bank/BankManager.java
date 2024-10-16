//package br.com.moneyiteasy.service.bank;
//
//import br.com.moneyiteasy.model.BankAccount;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class BankManager extends BankAccount {
//    private List<BankAccount> bankAccounts = new ArrayList<>();
//
//    public BankManager() {
//        super();
//    }
//
//    public void addBankAccount(Scanner scanner) {
//        BankAccount bankAccount = new BankAccount();
//        boolean success = false;
//        while (!success) {
//            try {
//                System.out.println("Cadastro da conta bancária:");
//                System.out.println("Digite o nome do banco:");
//                bankAccount.setNameBank(scanner.nextLine());
//                System.out.println("Digite o numero do banco:");
//                bankAccount.setNumberBank(scanner.nextLine());
//                System.out.println("Digite a agência bancária:");
//                bankAccount.setAgencyBank(scanner.nextLine());
//                System.out.println("Digite o numero da conta bancária (sem digito):");
//                bankAccount.setAccountNumber(scanner.nextLine());
//                System.out.println("Digite o digito da conta bancária");
//                bankAccount.setAccountNumberDigit(scanner.nextLine());
//                if (!isBankExists(bankAccount)) {
//                    bankAccounts.add(bankAccount);
//                    System.out.println("Conta Cadastrada com sucesso!");
//                    success = true;
//                } else {
//                    System.out.println("Conta ja existente");
//                }
//            } catch (IllegalArgumentException e){
//                System.out.println("Erro ao cadastrar conta" + e.getMessage());
//            }
//        }
//    }
//    public void displayBankAccounts() {
//        if (!bankAccounts.isEmpty()) {
//            for (BankAccount bankAccount : bankAccounts) {
//                bankAccount.displayAccount();
//            }
//        } else {
//            System.out.println("Nenhuma conta encontrada");
//        }
//    }
//    private boolean isBankExists(BankAccount bankAccount) {
//        return bankAccounts.stream().anyMatch(u -> u.getAccountNumber().equals(bankAccount.getAccountNumber()) && u.getAccountNumberDigit().equals(bankAccount.getAccountNumberDigit()));
//    }
//}