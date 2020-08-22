package com.bcp.app.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bcp.app.utils.RelationTypeEnum;

@Getter
@Setter
@Document(collection = "product")
public class Product {

    @Id
    private String productId;
    private String accountId;
    private String customerId;
    private RelationTypeEnum relationType;

    public Product() {
    }

    public Product(String accountId, String customerId, RelationTypeEnum relationType) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.relationType = relationType;
    }
}
