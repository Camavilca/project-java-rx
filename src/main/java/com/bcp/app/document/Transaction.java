package com.bcp.app.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bcp.app.utils.TransactionTypeEnum;

@Getter
@Setter
@Document(collection = "transaction")
public class Transaction {

    @Id
    private String transactionId;
    private String accountId;
    private String customerId;
    private TransactionTypeEnum transactionType;
    private double amount;
    private double concept;
}
