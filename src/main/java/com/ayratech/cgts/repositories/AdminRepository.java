package com.ayratech.cgts.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ayratech.cgts.models.AdminDetailsModel;

@Repository
public interface AdminRepository extends MongoRepository<AdminDetailsModel, String>{
	
	AdminDetailsModel findByuid(String uid);
}
