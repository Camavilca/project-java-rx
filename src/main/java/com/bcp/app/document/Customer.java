package com.bcp.app.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bcp.app.utils.CustomerTypeEnum;
import com.bcp.app.utils.DocumentTypeEnum;

@Getter
@Setter
@Document(collection = "customer")
public class Customer {

    @Id
    private String customerId;
    private DocumentTypeEnum documentType;
    private String documentNumber;
    private String name;
    private String lastName;
    private String address;
    private String cellphone;
    private CustomerTypeEnum customerType;
}
