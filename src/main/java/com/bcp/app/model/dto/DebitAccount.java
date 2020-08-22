package com.bcp.app.model.dto;

import com.bcp.app.document.Customer;
import com.bcp.app.document.Debit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DebitAccount {
    private Customer customer;
    private Debit debit;
}
