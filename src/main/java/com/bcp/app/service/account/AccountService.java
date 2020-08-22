package com.bcp.app.service.account;

import com.bcp.app.model.dto.CreditAccount;
import com.bcp.app.model.dto.DebitAccount;
import io.reactivex.Single;

public interface AccountService {
    Single<DebitAccount> createDebitAccount(DebitAccount debitAccount);
    Single<CreditAccount> createCredittAccount(CreditAccount creditAccount);
}
