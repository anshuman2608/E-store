package com.wse.Nclick_store.service;

import com.wse.Nclick_store.model.Merchant;
import com.wse.Nclick_store.request.MerchantRegisterRequest;
import com.wse.Nclick_store.request.MerchantUpdateRequest;


import java.util.List;
import java.util.Optional;

public interface MerchantService  {

    List<Merchant> getAllMerchantService();
    Optional<Merchant> getMerchantByIdService(String id);
    String merchantUpdateService(MerchantUpdateRequest merchantUpdateRequest);
    Merchant saveMerchantService(Merchant merchant);

    String deleteMerchantService(String id);

    String registerMerchantService(MerchantRegisterRequest merchantRegisterRequest);



    Merchant getByEmailService(String email);

    //Merchant registerMerchantService(MerchantRegisterRequest merchantRegisterRequest);

}
