package com.wse.Nclick_store.response;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MerchantUpdateResponse {

    private String gstNo;

//    private String panNo;
//    private String companyName;
//    private String address;
//    private String contactPerson;
//    private String email;
}
