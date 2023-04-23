package paymentsystem;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;
import java.time.LocalDateTime;

public class Merchant {
    private UUID id;
    private String name;
    private List<BankAccount> bankAccounts;
    private LocalDateTime createdAt;

    public Merchant() {

    }

    public Merchant(String name, LocalDateTime createdAt) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.bankAccounts = new ArrayList<>();
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccounts.add(bankAccount);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bankAccounts=" + bankAccounts +
                ", createdAt=" + createdAt +
                '}';
    }
}
