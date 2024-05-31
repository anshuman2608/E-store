package com.wse.Nclick_store.controller;


import com.wse.Nclick_store.model.Merchant;
import com.wse.Nclick_store.request.MerchantRegisterRequest;
import com.wse.Nclick_store.request.MerchantUpdateRequest;
import com.wse.Nclick_store.service.impl.MerchantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    MerchantServiceImpl merchantService;


    //POST MAPPING


    @PostMapping("/register")
    public ResponseEntity<?> registerMerchantController(@RequestBody MerchantRegisterRequest merchantRegisterRequest){

        try{
            Merchant merchant=merchantService.getByEmailService(merchantRegisterRequest.getEmail());
            if(merchant==null){
                return new ResponseEntity<>(merchantService.registerMerchantService(merchantRegisterRequest),HttpStatus.OK);
            }else {
                return new ResponseEntity<>("Merchant already registred",HttpStatus.OK);
            }

        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //@ApiOperation(value = "Method for saving a Merchant " , reponse = ResponseEntity.class)
    @PostMapping("/save")
    public ResponseEntity<?> saveMerchant( @Valid @RequestBody Merchant merchant){
        try {

            return new ResponseEntity<>(merchantService.saveMerchantService(merchant),HttpStatus.OK);

        }catch (Exception e){

            return new ResponseEntity<>("provide proper body",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //GET MAPPING

    @GetMapping("/email")
    public ResponseEntity<?> getMerchantByEmail(@RequestParam("email") String email){

       try {
           Merchant merchant=merchantService.getByEmailService(email);
           if(merchant!=null){
               return new ResponseEntity<>(merchant,HttpStatus.OK);
           }else {
               return new ResponseEntity<>("No Merchant Found",HttpStatus.OK);
           }


       }catch (Exception e){
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }


    }

    @GetMapping("/allMerchant")
    public ResponseEntity<?> getAllMerchant(){
        try {
            List<Merchant> allMerchant= merchantService.getAllMerchantService();
            if(allMerchant.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(allMerchant, HttpStatus.OK);
            }

        }
        catch (Exception e){
              return new ResponseEntity<>("Some error occoured",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

//    @PostMapping("/save")
//    public Merchant saveMerchantController(@RequestBody Merchant merchant){
//        return merchantService.saveMerchant(merchant);
//    }




//    @DeleteMapping("/delete/{id}")
//    public String deleteMerchantById(@PathVariable String id){
//        return  merchantService.deleteMerchant(id);
//    }


    //PUT MAPPING


    @PutMapping("/update")
    public ResponseEntity<?>  updateMerchant(@Valid @RequestBody MerchantUpdateRequest merchantUpdateRequest){
        try {

            return new ResponseEntity<>(merchantService.merchantUpdateService(merchantUpdateRequest),HttpStatus.OK);


        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //DELETE MAPPING


    @DeleteMapping("/delete")
    public ResponseEntity<?>   deleteMerchantById(@RequestParam("id") String id){
        try {
            Optional<Merchant> merchant=merchantService.getMerchantByIdService(id);
            if(merchant.isPresent()){
               String str= merchantService.deleteMerchantService(id);
               return new ResponseEntity<>(str,HttpStatus.OK);
            }else {
                return new ResponseEntity<>("No Merchant Found with id"+id, HttpStatus.NOT_FOUND);
            }



        }catch (Exception e){
            return new ResponseEntity<>("No Merchant found with id "+id,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
