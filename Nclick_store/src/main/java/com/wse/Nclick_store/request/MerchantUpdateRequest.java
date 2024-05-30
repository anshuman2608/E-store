package com.wse.Nclick_store.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MerchantUpdateRequest {
    String id;
    @NotNull
    @NotEmpty(message = "GST Number can not be Empty")
    private String gstNo;
    @NotNull
    @NotEmpty(message = "PAN Number can not be Empty")
    private String panNo;
    @NotNull
    @NotEmpty(message = "Company Name can not be Empty")
    private String companyName;
    private String address;
    private String contactPerson;
    @NotNull
    @NotEmpty(message = "Email cannot be Empty")
    @Email(message = "Provide a valid email")
    private String email;
}
