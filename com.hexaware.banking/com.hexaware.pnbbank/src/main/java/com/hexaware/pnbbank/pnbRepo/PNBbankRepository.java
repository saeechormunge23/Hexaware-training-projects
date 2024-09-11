package com.hexaware.pnbbank.pnbRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.pnbbank.Entity.PNBbank_user;


@Repository
public interface PNBbankRepository extends CrudRepository<PNBbank_user,Integer>{
	

}
