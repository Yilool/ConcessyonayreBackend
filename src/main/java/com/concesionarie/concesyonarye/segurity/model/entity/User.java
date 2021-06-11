package com.concesionarie.concesyonarye.segurity.model.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.concesionarie.concesyonarye.model.entity.Customer;
import com.concesionarie.concesyonarye.segurity.model.enumerate.UserRoles;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@SuppressWarnings("serial")
public class User implements UserDetails {
	
	/** The Constant MAX_AUTH_ATTEMPTS. */
	private static final int MAX_AUTH_ATTEMPTS = 3;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** The username. */
	@Column(unique = true)
	private String username;

	/** The password. */
	private String password;

	/** The roles. */
	@ElementCollection(fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	private Set<UserRoles> roles;

	/** The customer. */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
	private Customer customer;

	/** The create time. */
	@CreatedDate
	private LocalDateTime createTime;

	/** The delete time. */
	private LocalDateTime deleteTime;

	/** The last password change. */
	private LocalDateTime lastPasswordChange;

	/** The password policy exp date. */
	private LocalDateTime passwordPolicyExpDate;

	/** The authentication attempts. */
	private int authenticationAttempts;

	/**
	 * Instantiates a new user.
	 */
	public User() {
		this.roles = new HashSet<>();
		this.roles.add(UserRoles.CUSTOM);
		this.customer = new Customer();
		this.createTime = LocalDateTime.now();
		this.deleteTime = null;
		this.lastPasswordChange = LocalDateTime.now();
		this.passwordPolicyExpDate = LocalDateTime.now().plusMonths(1);
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param username the username
	 * @param password the password
	 * @param rol the rol
	 */
	public User(String username, String password, UserRoles rol) {
		this();
		this.username = username;
		this.password = password;
		this.roles = new HashSet<>();
		this.roles.add(rol);
	}
	
	/**
	 * Instantiates a new user.
	 *
	 * @param username the username
	 * @param password the password
	 * @param name the name
	 * @param surname the surname
	 * @param bank the bank
	 * @param address the address
	 * @param phone the phone
	 * @param dni the dni
	 */
	public User(String username, String password, String name, String surname, String bank,
			String address, String phone, String dni) {
		this();
		this.username = username;
		this.password = password;
		this.customer = new Customer(name, surname, bank, address, phone, dni, this);
	}

	/**
	 * Gets the authorities.
	 *
	 * @return the authorities
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream().map(rol -> new SimpleGrantedAuthority("ROLE_" + rol.name())).collect(Collectors.toList());
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	@Override
	public String getPassword() {
		return this.password;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	@Override
	public String getUsername() {
		return this.username;
	}

	/**
	 * Checks if is account non expired.
	 *
	 * @return true, if is account non expired
	 */
	@Override
	public boolean isAccountNonExpired() {
//		Boolean expired = false;
//
//		if (LocalDateTime.now().isAfter(passwordPolicyExpDate)) {
//			expired = true;
//		}

		return true;
	}

	/**
	 * Checks if is account non locked.
	 *
	 * @return true, if is account non locked
	 */
	@Override
	public boolean isAccountNonLocked() {
//		Boolean locked = false;
//		
//		if (this.authenticationAttempts <= MAX_AUTH_ATTEMPTS) {
//			locked = true;
//		}
		
		return true;
	}

	/**
	 * Checks if is credentials non expired.
	 *
	 * @return true, if is credentials non expired
	 */
	@Override
	public boolean isCredentialsNonExpired() {
//		Boolean expired = false;
//
//		if (LocalDateTime.now().isBefore(passwordPolicyExpDate)) {
//			expired = true;
//		}

		return true;
	}

	/**
	 * Checks if is enabled.
	 *
	 * @return true, if is enabled
	 */
	@Override
	public boolean isEnabled() {
//		Boolean enabled = false;
//
//		if (this.isAccountNonExpired() && this.isAccountNonLocked() && this.isCredentialsNonExpired()) {
//			enabled = true;
//		}
		
		return true;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the roles.
	 *
	 * @return the roles
	 */
	public Set<UserRoles> getRoles() {
		return roles;
	}

	/**
	 * Sets the roles.
	 *
	 * @param roles the new roles
	 */
	public void setRoles(Set<UserRoles> roles) {
		this.roles = roles;
	}

	/**
	 * Gets the customer.
	 *
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Sets the customer.
	 *
	 * @param customer the new customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Gets the creates the time.
	 *
	 * @return the creates the time
	 */
	public LocalDateTime getCreateTime() {
		return createTime;
	}

	/**
	 * Sets the creates the time.
	 *
	 * @param createTime the new creates the time
	 */
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	/**
	 * Gets the delete time.
	 *
	 * @return the delete time
	 */
	public LocalDateTime getDeleteTime() {
		return deleteTime;
	}

	/**
	 * Sets the delete time.
	 *
	 * @param deleteTime the new delete time
	 */
	public void setDeleteTime(LocalDateTime deleteTime) {
		this.deleteTime = deleteTime;
	}

	/**
	 * Gets the last password change.
	 *
	 * @return the last password change
	 */
	public LocalDateTime getLastPasswordChange() {
		return lastPasswordChange;
	}

	/**
	 * Sets the last password change.
	 *
	 * @param lastPasswordChange the new last password change
	 */
	public void setLastPasswordChange(LocalDateTime lastPasswordChange) {
		this.lastPasswordChange = lastPasswordChange;
	}

	/**
	 * Gets the password policy exp date.
	 *
	 * @return the password policy exp date
	 */
	public LocalDateTime getPasswordPolicyExpDate() {
		return passwordPolicyExpDate;
	}

	/**
	 * Sets the password policy exp date.
	 *
	 * @param passwordPolicyExpDate the new password policy exp date
	 */
	public void setPasswordPolicyExpDate(LocalDateTime passwordPolicyExpDate) {
		this.passwordPolicyExpDate = passwordPolicyExpDate;
	}

	/**
	 * Gets the authentication attempts.
	 *
	 * @return the authentication attempts
	 */
	public int getAuthenticationAttempts() {
		return authenticationAttempts;
	}

	/**
	 * Sets the authentication attempts.
	 *
	 * @param authenticationAttempts the new authentication attempts
	 */
	public void setAuthenticationAttempts(int authenticationAttempts) {
		this.authenticationAttempts = authenticationAttempts;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
