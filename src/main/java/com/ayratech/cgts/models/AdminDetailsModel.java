package com.ayratech.cgts.models;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(value = Include.NON_NULL)
@Document("AdminDetails")
public class AdminDetailsModel {
	@Id
	private String id;
	private String uid;
    private String fullname;
    private String email;
    private AccountStatus accountStatus;
    private Role role;
    private String activatedBy;
    private Instant activatedAt;
    private Instant lastLogin;
    private Instant createdAt;
    
    public enum AccountStatus {
    	ACTIVE, SUSPENDED, INACTIVE
    }
    
    public enum Role {
    	ADMIN, SUPERADMIN
    }
}