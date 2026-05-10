package com.lab.bank;

/**
 * Tài khoản ngân hàng đơn giản.
 */
public final class BankAccount {

    private final String number;
    private double balance;

    public BankAccount(String number, double initialBalance) {
        this.number = number;
        if (initialBalance < 0) {
            throw new IllegalArgumentException("So du ban dau khong hop le");
        }
        this.balance = initialBalance;
    }

    public String getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("So tien nap phai duong");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("So tien rut phai duong");
        }
        if (amount > balance) {
            throw new IllegalStateException("Khong du so du");
        }
        balance -= amount;
    }

    // Nothing is here
}
