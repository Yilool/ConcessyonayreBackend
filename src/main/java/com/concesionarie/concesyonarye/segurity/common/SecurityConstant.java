package com.concesionarie.concesyonarye.segurity.common;

public class SecurityConstant {
	public static final String SECRET = "FinalProject@Concessyonarye:FinalProject@Concessyonarye:FinalProject@Concessyonarye";

	public static final long EXPIRATION_TIME = 604_000_000;
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER = "Authorization";
	public static final String SIGN_UP_URL = "/user/signup";
	public static final String SIGN_IN_URL = "/user/signin";
	public static final String LOG_IN_URL = "/user/login";
}
