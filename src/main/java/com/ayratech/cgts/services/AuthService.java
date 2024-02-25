package com.ayratech.cgts.services;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayratech.cgts.models.AdminDetailsModel;
import com.ayratech.cgts.models.AdminDetailsModel.AccountStatus;
import com.ayratech.cgts.models.AdminDetailsModel.Role;
import com.ayratech.cgts.repositories.AdminRepository;
import com.google.firebase.auth.FirebaseToken;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class AuthService {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
	
	public static String uid;
	public static String email;
	public static String token;
	
	@Autowired
	FirebaseService firebaseService;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	HttpServletRequest httpServletRequest;
	
	public AdminDetailsModel signUpAdmin(String fullname, String email) throws Exception {

    	logger.info("Executing signUpAdmin under AuthService...");

    	try {
    		
    		AuthService.token = httpServletRequest.getHeader("FirebaseToken");
    		
    		FirebaseToken decodedToken = firebaseService.getDecodedUser(token);
    		
    		AdminDetailsModel adminDetailsModel = AdminDetailsModel.builder()
    				.uid(decodedToken.getUid())
    				.fullname(fullname)
    				.email(email)
    				.accountStatus(AccountStatus.INACTIVE)
    				.role(Role.ADMIN)
    				.createdAt(Instant.now())
    				.build();
    		
    		return adminRepository.save(adminDetailsModel);
    		    		
		} catch (Exception e) {
			
			logger.info(e.toString());
			throw new Exception("Exception occured in signUpAdmin under AuthService...");
			
		}
    }
	
	public AdminDetailsModel signInAdmin() throws Exception {

    	logger.info("Executing signUpAdmin under AuthService...");
    	
    	try {

    		return adminRepository.findByuid(AuthService.uid);
    		    		
		} catch (Exception e) {
			
			logger.info(e.toString());
			throw new Exception("Exception occured in signUpAdmin under AuthService...");
			
		}
    }
	
	public boolean isUserAuthorised() throws Exception {
		
		logger.info("Executing isUserAuthorised under AuthService...");
		
		try {
			
			AuthService.token = httpServletRequest.getHeader("FirebaseToken");
			
			FirebaseToken decodedToken = firebaseService.getDecodedUser(token);
			
			if(decodedToken.isEmailVerified()) {
				AuthService.uid = decodedToken.getUid();
				AuthService.email = decodedToken.getUid();
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			
			logger.info(e.toString());
			throw new Exception("Exception occured in isUserAuthorised under AuthService...");
			
		}
		
	}
	
}