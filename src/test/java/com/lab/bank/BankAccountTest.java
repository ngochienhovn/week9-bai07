package com.lab.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BankAccountTest {

    @Test
    void depositIncreasesBalance() {
        BankAccount account = new BankAccount("x", 10);
        account.deposit(5);
        assertEquals(15, account.getBalance());
    }

    @Test
    void withdrawDecreasesBalance() {
        BankAccount account = new BankAccount("y", 100);
        account.withdraw(30);
        assertEquals(70, account.getBalance());
    }

    @Test
    void withdrawMoreThanBalanceThrows() {
        BankAccount account = new BankAccount("z", 10);
        assertThrows(IllegalStateException.class, () -> account.withdraw(20));
    }
}
