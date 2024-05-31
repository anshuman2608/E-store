package com.wse.Nclick_store.service.impl;

import com.wse.Nclick_store.model.Merchant;
import com.wse.Nclick_store.repo.MerchantRepo;
import com.wse.Nclick_store.request.MerchantRegisterRequest;
import com.wse.Nclick_store.request.MerchantUpdateRequest;
import com.wse.Nclick_store.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    MerchantRepo merchantRepo;


    @Override
    public List<Merchant> getAllMerchantService() {
        return merchantRepo.findAll();
    }

    @Override
    public Optional<Merchant> getMerchantByIdService(String id) {
        return merchantRepo.findById(id);
    }

    @Override
    public String merchantUpdateService(MerchantUpdateRequest merchantUpdateRequest) {
        Optional<Merchant> merchant=merchantRepo.findById(merchantUpdateRequest.getId());
        if(merchant.isPresent()){
            Merchant merchant1=merchant.get();
            merchant1.setGstNo(merchantUpdateRequest.getGstNo());
            merchant1.setPanNo(merchantUpdateRequest.getPanNo());
            merchant1.setCompanyName(merchantUpdateRequest.getCompanyName());
            merchant1.setAddress(merchantUpdateRequest.getAddress());
            merchant1.setContactPerson(merchantUpdateRequest.getContactPerson());
            merchant1.setEmail(merchantUpdateRequest.getEmail());
            merchantRepo.save(merchant1);
            return "Merchant updated with Id "+merchantUpdateRequest.getId();
        }else {
            return "No Merchant found with Id "+ merchantUpdateRequest.getId();
        }

    }

    @Override
    public Merchant saveMerchantService(Merchant merchant) {
        return merchantRepo.save(merchant);
    }

    @Override
    public String deleteMerchantService(String id) {
        merchantRepo.deleteById(id);
        return "Merchant deleted with Id "+ id;
    }

    @Override
    public String registerMerchantService(MerchantRegisterRequest merchantRegisterRequest) {

        Merchant merchant=new Merchant();
        merchant.setGstNo(merchantRegisterRequest.getGstNo());
        merchant.setPanNo(merchantRegisterRequest.getPanNo());
        merchant.setCompanyName(merchantRegisterRequest.getCompanyName());
        merchant.setCompanyName(merchantRegisterRequest.getCompanyName());
        merchant.setContactPerson(merchantRegisterRequest.getContactPerson());
        merchant.setEmail(merchantRegisterRequest.getEmail());
        merchant.setPhoneNumber(merchantRegisterRequest.getPhoneNumber());

        merchantRepo.save(merchant);


        return "Merchant saved with Email " + merchantRegisterRequest.getEmail();
    }

    @Override
    public Merchant getByEmailService(String email) {
        Merchant merchant=null;
               merchant= merchantRepo.findByEmail(email);
        if(merchant!=null){
            return merchantRepo.findByEmail(email);
        }else {
            return null;
        }

    }


}
