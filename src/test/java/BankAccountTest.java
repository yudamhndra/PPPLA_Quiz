import org.example.BankAccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private BankAccount account1;
    private BankAccount account2;

    @BeforeEach
    public void setUp() {
        account1 = new BankAccount("918647", 1000);
        account2 = new BankAccount("936194", 500);
    }

    @Test
    public void testInitialBalance() {
        assertEquals(1000, account1.getBalance());
        assertEquals(500, account2.getBalance());
    }

    @Test
    public void testDeposit() {
        account1.deposit(500);
        assertEquals(1500, account1.getBalance());
    }

    @Test
    public void testNegativeDeposit() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account1.deposit(-500);
        });

        assertEquals("Deposit amount cannot be negative.", exception.getMessage());
    }

    @Test
    public void testWithdraw() {
        account1.withdraw(500);
        assertEquals(500, account1.getBalance());
    }

    @Test
    public void testInsufficientFundsWithdraw() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account2.withdraw(1000);
        });

        assertEquals("Insufficient funds for withdraw", exception.getMessage());
    }

    @Test
    public void testTransferFunds() {
        account1.transferFunds(account2, 500);
        assertEquals(500, account1.getBalance());
        assertEquals(1000, account2.getBalance());
    }

    @Test
    public void testInsufficientFundsTransfer() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account1.transferFunds(account2, 2000);
        });

        assertEquals("Insufficient funds for transfer.", exception.getMessage());
    }

    @Test
    public void testAccountNumberEquality() {
        assertNotEquals(account1.getAccountNumber(), account2.getAccountNumber());
    }

    @Test
    public void testAccountNumberValidity() {
        assertTrue(account1.getAccountNumber().matches("^\\d{6}$"));
        assertTrue(account2.getAccountNumber().matches("^\\d{6}$"));
    }
}
