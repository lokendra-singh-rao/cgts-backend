package com.ayratech.cgts.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.ayratech.cgts.models.AdminDetailsModel;
import com.ayratech.cgts.services.AuthService;

@Controller
public class AuthController {

	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	AuthService authService;
	
	/**
	 * creates admin details document in database on sign up
	 *
	 * @param adminDetailsModel 
	 * @return adminDetailsModel
	 * @throws Exception 
	 */
    @MutationMapping("signUpAdmin")
    public AdminDetailsModel signUpAdmin(@Argument("fullname") String fullname, @Argument("email") String email) throws Exception {

    	logger.info("Executing signUpAdmin under AuthController...");
    	
    	try {

    		if(fullname.isBlank() || email.isEmpty())
    			throw new IllegalArgumentException("Required fields cannot be empty");
    		
    		return authService.signUpAdmin(fullname, email);
    		    		
		} catch (Exception e) {
			
			logger.info(e.toString());
			throw new Exception("Exception occured in signUpAdmin under AuthController...");
			
		}
    }
    
    /**
	 * return admin details document for sign in authentication
	 * 
	 * @param adminDetailsModel 
	 * @return adminDetailsModel
	 * @throws Exception 
	 */
    @QueryMapping("signInAdmin")
    public AdminDetailsModel signInAdmin() throws Exception {

    	logger.info("Executing signUpAdmin under AuthController...");
    	
    	if(!authService.isUserAuthorised())
    		throw new IllegalAccessError("User cannot be authenticated");
    	
    	try {

    		return authService.signInAdmin();
    		    		
		} catch (Exception e) {
			
			logger.info(e.toString());
			throw new Exception("Exception occured in signUpAdmin under AuthController...");
			
		}
    }

}
