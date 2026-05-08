package com.lab.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Dịch vụ giao dịch — log INFO cho luồng nghiệp vụ, ERROR khi ngoại lệ không mong đợi.
 */
public final class BankService {

    private static final Logger log = LoggerFactory.getLogger(BankService.class);

    public void transfer(BankAccount from, BankAccount to, double amount) {
        log.info("Bat dau chuyen {} tu {} sang {}", amount, from.getNumber(), to.getNumber());
        try {
            from.withdraw(amount);
            to.deposit(amount);
            log.info("Chuyen khoan thanh cong");
        } catch (RuntimeException ex) {
            log.error("Chuyen khoan that bai: {}", ex.getMessage(), ex);
            throw ex;
        }
    }
}
