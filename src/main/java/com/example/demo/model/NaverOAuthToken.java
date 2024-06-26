package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class NaverOAuthToken {
	private String access_token;
	private String refresh_token;
	private String token_type;
	private String expires_in;
}
