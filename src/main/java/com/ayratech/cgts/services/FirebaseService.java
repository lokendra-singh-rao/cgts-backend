package com.ayratech.cgts.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

@Service
public class FirebaseService {

	private static final Logger logger = LoggerFactory.getLogger(FirebaseService.class);
	
	private final FirebaseAuth firebaseAuth;

    public FirebaseService(FirebaseApp firebaseApp) {
        this.firebaseAuth = FirebaseAuth.getInstance(firebaseApp);
    }
    
	public FirebaseToken getDecodedUser(String token) throws FirebaseAuthException {
		
		logger.info("Executing getDecodedUser under FirebaseService...");
		
		return firebaseAuth.verifyIdToken(token);
		
	}
}
