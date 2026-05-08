package com.lab;

import com.lab.bank.BankAccount;
import com.lab.bank.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private Main() {
    }

    public static void main(String[] args) {
        BankAccount a = new BankAccount("001", 1000);
        BankAccount b = new BankAccount("002", 500);
        BankService service = new BankService();
        service.transfer(a, b, 200);
        log.info("So du sau giao dich: {} -> {}, {} -> {}", a.getNumber(), a.getBalance(),
                b.getNumber(), b.getBalance());
    }
}
