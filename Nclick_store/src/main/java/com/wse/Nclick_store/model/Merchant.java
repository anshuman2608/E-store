package com.wse.Nclick_store.model;



import com.wse.Nclick_store.enums.MerchantStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Document(collection = "merchant")
public class Merchant {

    @Id
    private String id;
    private String gstNo;
    private String panNo;
    private String companyName;
    private String address;
    private String contactPerson;
    private String email;
    private String phoneNumber;
    private String merchantCode;
    private String password;
    private MerchantStatus merchantStatus=MerchantStatus.DRAFT;
    private long createTime;
    private long updateTime;
    public Merchant(String gstNo, String panNo, String companyName, String address, String contactPerson, String email,String phoneNumber) {
        this.gstNo = gstNo;
        this.panNo = panNo;
        this.companyName = companyName;
        this.address = address;
        this.contactPerson = contactPerson;
        this.email = email;
        this.phoneNumber=phoneNumber;
        this.createTime = System.currentTimeMillis();
        this.updateTime = System.currentTimeMillis();
    }

    public Merchant(String id, String merchantId, String password, String email,String phoneNumber) {
        this.id = id;
        this.merchantCode = merchantId;
        this.password = password;
        this.email = email;
        this.phoneNumber=phoneNumber;
    }
}
