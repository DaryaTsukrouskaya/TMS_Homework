package paymentsystem;

import java.util.UUID;
import java.time.LocalDateTime;

public class BankAccount {
    private UUID id;
    private UUID merchantId;
    private Status status;
    private String accountNumber;
    private LocalDateTime createdAt;


    public BankAccount(UUID merchantId, Status status, String accountNumber, LocalDateTime createdAt) {
        this.id = UUID.randomUUID();
        this.merchantId = merchantId;
        this.status = status;
        this.accountNumber = accountNumber;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public UUID getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(UUID merchantId) {
        this.merchantId = merchantId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", merchantId=" + merchantId +
                ", status=" + status +
                ", accountNumber='" + accountNumber + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
