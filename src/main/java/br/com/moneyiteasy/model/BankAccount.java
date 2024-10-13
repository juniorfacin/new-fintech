package br.com.moneyiteasy.model;

public class BankAccount {
    private String nameBank;
    private String numberBank;
    private String agencyBank;
    private String accountNumber;
    private String accountNumberDigit;

    public BankAccount() {
    }

    public BankAccount(String nameBank, String numberBank, String agencyBank, String accountNumber, String accountNumberDigit) {
        this.nameBank = nameBank;
        this.numberBank = numberBank;
        this.agencyBank = agencyBank;
        this.accountNumber = accountNumber;
        this.accountNumberDigit = accountNumberDigit;
    }

    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public String getNumberBank() {
        return numberBank;
    }

    public void setNumberBank(String numberBank) {
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

    public void displayAccount(){
        System.out.printf("Nome do Banco: %s | Numero do Banco: %s | Agencia Bancária: %s | Conta Bancária: %s | Digito da conta: %s   ", nameBank, numberBank, agencyBank, accountNumber, accountNumberDigit);
    }

}
