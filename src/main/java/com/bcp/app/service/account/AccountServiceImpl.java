package com.bcp.app.service.account;

import com.bcp.app.document.Credit;
import com.bcp.app.document.Customer;
import com.bcp.app.document.Debit;
import com.bcp.app.document.Product;
import com.bcp.app.model.dto.CreditAccount;
import com.bcp.app.model.dto.DebitAccount;
import com.bcp.app.service.credit.CreditService;
import com.bcp.app.service.customer.CustomerService;
import com.bcp.app.service.debit.DebitService;
import com.bcp.app.service.product.ProductService;
import com.bcp.app.utils.RelationTypeEnum;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private DebitService debitService;

	@Autowired
	private CreditService creditService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;

	@Override
	public Single<DebitAccount> createDebitAccount(DebitAccount debitAccount) {
		Customer customer = customerService.findByDocumentNumber(debitAccount.getCustomer().getDocumentNumber())
				.switchIfEmpty(customerService.create(debitAccount.getCustomer())).blockingGet();

		

		return null;
	}

	@Override
	public Single<CreditAccount> createCredittAccount(CreditAccount creditAccount) {
		Customer customer = customerService.findByDocumentNumber(creditAccount.getCustomer().getDocumentNumber())
                .switchIfEmpty(customerService.create(creditAccount.getCustomer()))
                .blockingGet();
        Credit credit = creditService.create(creditAccount.getCredit()).blockingGet();

        Product product = new Product();
        product.setCustomerId(customer.getCustomerId());
        product.setAccountId(credit.getAccountId());
        product.setRelationType(RelationTypeEnum.TITULAR);

        product = productService.create(product).blockingGet();

        creditAccount.setCustomer(customer);
        creditAccount.setCredit(credit);

        return Single.just(creditAccount);
	}
}
