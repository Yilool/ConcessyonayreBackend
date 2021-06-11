package com.concesionarie.concesyonarye.segurity.common;

// TODO: Auto-generated Javadoc
/**
 * The Class SecurityConstant.
 */
public class SecurityConstant {
	
	/** The Constant SECRET. */
	public static final String SECRET = "FinalProject@Concessyonarye:FinalProject@Concessyonarye:FinalProject@Concessyonarye";

	/** The Constant EXPIRATION_TIME. */
	public static final long EXPIRATION_TIME = 604_000_000;
	
	/** The Constant TOKEN_PREFIX. */
	public static final String TOKEN_PREFIX = "Bearer ";
	
	/** The Constant HEADER. */
	public static final String HEADER = "Authorization";
	
	/** The Constant SIGN_UP_URL. */
	public static final String SIGN_UP_URL = "/user/signup";
	
	/** The Constant SIGN_IN_URL. */
	public static final String SIGN_IN_URL = "/user/signin";
	
	/** The Constant LOG_IN_URL. */
	public static final String LOG_IN_URL = "/user/login";
}
