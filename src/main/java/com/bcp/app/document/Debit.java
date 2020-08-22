package com.bcp.app.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bcp.app.utils.AccountTypeEnum;
import com.bcp.app.utils.DebitTypeEnum;

import java.time.LocalDate;

import javax.annotation.Generated;

@Getter
@Setter
@Document(collection = "debit")
public class Debit extends Account {

    @Id
    private String accountId;
    private DebitTypeEnum debitType;
    private double amount;
    private double interestRate;
    private LocalDate startDate;
    private LocalDate endtDate;

    public Debit() {
        setAccountType(AccountTypeEnum.DEBIT);
        setCreationDate(LocalDate.now());
    }
}
