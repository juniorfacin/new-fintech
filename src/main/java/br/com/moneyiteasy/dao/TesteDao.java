package br.com.moneyiteasy.dao;


import br.com.moneyiteasy.model.BankAccount;
import br.com.moneyiteasy.model.User;

import java.time.LocalDate;
import java.util.List;

public class TesteDao {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        BankAccountDao bankAccountDao = new BankAccountDao();

//        User user = new User("VINI DA GRINGA", "joaobocasacola@gmail.com", "11122233344",
//                "Jr@1234678", LocalDate.now(), 1000);

        BankAccount bankAccount = new BankAccount(0, "NUBANK",
                001, "123", "1234", "5");

//       bankAccountDao.deleteBankAccount("1234");

//        List<BankAccount> listaBancos = bankAccountDao.getAllUBankAccounts();
//
//        if (!listaBancos.isEmpty()) {
//            System.out.println("Contas bancárias encontradas:");
//
//            for (BankAccount bankAccount : listaBancos) {
//                System.out.println("ID Conta: " + bankAccount.getIdBankAccount());
//                System.out.println("ID Usuário: " + bankAccount.getIdUser());
//                System.out.println("Nome do Banco: " + bankAccount.getNameBank());
//                System.out.println("Número do Banco: " + bankAccount.getNumberBank());
//                System.out.println("Agência: " + bankAccount.getAgencyBank());
//                System.out.println("Número da Conta: " + bankAccount.getAccountNumber());
//                System.out.println("Dígito da Conta: " + bankAccount.getAccountNumberDigit());
//                System.out.println("---------------------------------");
//            }
//        } else {
//            System.out.println("Nenhuma conta bancária encontrada.");
//        }

//        userDao.addUser(user);
        bankAccountDao.addBankAccount(bankAccount);
    }
}
