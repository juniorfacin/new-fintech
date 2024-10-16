package br.com.moneyiteasy.model;

public class BankAccount {
    private int idBankAccount;
    private int idUser;
    private String nameBank;
    private int numberBank;
    private String agencyBank;
    private String accountNumber;
    private String accountNumberDigit;

    public BankAccount() {
    }

    public BankAccount( int idBankAccount, int idUser, String nameBank, int numberBank,
                       String agencyBank, String accountNumber, String accountNumberDigit) {
        this.idBankAccount = idBankAccount;
        this.idUser = idUser;
        this.nameBank = nameBank;
        this.numberBank = numberBank;
        this.agencyBank = agencyBank;
        this.accountNumber = accountNumber;
        this.accountNumberDigit = accountNumberDigit;
    }

    public BankAccount( int idUser, String nameBank, int numberBank,
                       String agencyBank, String accountNumber, String accountNumberDigit) {
        this.nameBank = nameBank;
        this.numberBank = numberBank;
        this.agencyBank = agencyBank;
        this.accountNumber = accountNumber;
        this.accountNumberDigit = accountNumberDigit;
    }


    public int getIdBankAccount() {
        return idBankAccount;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getNameBank() {
        return nameBank;
    }

    public void setIdBankAccount(int idBankAccount) {
        this.idBankAccount = idBankAccount;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public int getNumberBank() {
        return numberBank;
    }

    public void setNumberBank(int numberBank) {
        this.numberBank = numberBank;
    }

    public String getAgencyBank() {
        return agencyBank;
    }

    public void setAgencyBank(String agencyBank) {
        this.agencyBank = agencyBank;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumberDigit() {
        return accountNumberDigit;
    }

    public void setAccountNumberDigit(String accountNumberDigit) {
        this.accountNumberDigit = accountNumberDigit;
    }

    public void displayAccount() {
        System.out.printf("Nome do Banco: %s | Numero do Banco: %s | Agencia Bancária: %s | Conta Bancária: %s | Digito da conta: %s   ",
                nameBank, numberBank, agencyBank, accountNumber, accountNumberDigit);
    }

}
