package com.wse.Nclick_store.request;

import com.wse.Nclick_store.enums.MerchantStatus;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MerchantRegisterRequest {


    @NotNull
    @NotEmpty(message = "GST Number can not be Empty")
    private String gstNo;
    @NotNull
    @NotEmpty(message = "PAN Number can not be Empty")
    private String panNo;
    @NotNull
    @NotEmpty(message = "Company Name can not be Empty")
    private String companyName;
    @NotNull
    @NotEmpty(message = "Address can not be Empty")
    private String address;
    @NotNull
    @NotEmpty(message = "contact person can not be Empty")
    private String contactPerson;
    @NotNull
    @NotEmpty(message = "Email cannot be Empty")
    @Email(message = "Provide a valid email")
    private String email;
    @NotNull
    @NotEmpty(message = "Phone Number cannot be Empty")
    private  String phoneNumber;

}
