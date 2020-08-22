package com.bcp.app.document;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import com.bcp.app.utils.AccountTypeEnum;

@Getter
@Setter
public class Account {
    private AccountTypeEnum accountType;
    private LocalDate creationDate;
}
	