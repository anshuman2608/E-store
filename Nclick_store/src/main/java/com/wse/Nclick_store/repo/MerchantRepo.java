package com.wse.Nclick_store.repo;

import com.wse.Nclick_store.model.Merchant;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MerchantRepo extends MongoRepository<Merchant,String> {

//       List<Merchant>  findByName(String name);
//       boolean existByEmail(String email);
//       Merchant findByEmail(String email);


         Merchant findByEmail(String email);
}
