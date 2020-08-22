package com.bcp.app.model.dto;

import com.bcp.app.document.Credit;
import com.bcp.app.document.Customer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditAccount {
    private Customer customer;
    private Credit credit;
}
