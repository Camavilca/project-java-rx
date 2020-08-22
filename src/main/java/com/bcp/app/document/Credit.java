package com.bcp.app.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.bcp.app.utils.AccountTypeEnum;
import com.bcp.app.utils.CreditTypeEnum;
import java.time.LocalDate;

@Getter
@Setter
@Document(collection = "credit")
public class Credit extends Account {

    @Id
    private String accountId;
    private CreditTypeEnum crediType;
    private double amount;
    private double limitAmount;
    private double fee;
    private int totalFee;
    private double interestRate;
    private LocalDate startDate;
    private LocalDate endtDate;

    public Credit() {
        setAccountType(AccountTypeEnum.CREDIT);
        setCreationDate(LocalDate.now());
    }

    public Credit(CreditTypeEnum crediType, double amount, double fee, int totalFee, double interestRate) {
        this.crediType = crediType;
        this.amount = amount;
        this.fee = fee;
        this.totalFee = totalFee;
        this.interestRate = interestRate;
        this.startDate = LocalDate.now();
        this.endtDate = LocalDate.now();
    }
}
