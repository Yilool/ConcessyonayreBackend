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

@Entity
@EntityListeners(AuditingEntityListener.class)
@SuppressWarnings("serial")
public class User implements UserDetails {
	private static final int MAX_AUTH_ATTEMPTS = 3;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	private String username;

	private String password;

	@ElementCollection(fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	private Set<UserRoles> roles;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
	private Customer customer;

	@CreatedDate
	private LocalDateTime createTime;

	private LocalDateTime deleteTime;

	private LocalDateTime lastPasswordChange;

	private LocalDateTime passwordPolicyExpDate;

	private int authenticationAttempts;

	public User() {
		this.roles = new HashSet<>();
		this.roles.add(UserRoles.CUSTOM);
		this.customer = new Customer();
		this.createTime = LocalDateTime.now();
		this.deleteTime = null;
		this.lastPasswordChange = LocalDateTime.now();
		this.passwordPolicyExpDate = LocalDateTime.now().plusMonths(1);
	}

	public User(String username, String password, UserRoles rol) {
		this();
		this.username = username;
		this.password = password;
		this.roles = new HashSet<>();
		this.roles.add(rol);
	}
	
	public User(String username, String password, String name, String surname, String bank,
			String address, String phone, String dni) {
		this();
		this.username = username;
		this.password = password;
		this.customer = new Customer(name, surname, bank, address, phone, dni, this);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream().map(rol -> new SimpleGrantedAuthority("ROLE_" + rol.name())).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
//		Boolean expired = false;
//
//		if (LocalDateTime.now().isAfter(passwordPolicyExpDate)) {
//			expired = true;
//		}

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
//		Boolean locked = false;
//		
//		if (this.authenticationAttempts <= MAX_AUTH_ATTEMPTS) {
//			locked = true;
//		}
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
//		Boolean expired = false;
//
//		if (LocalDateTime.now().isBefore(passwordPolicyExpDate)) {
//			expired = true;
//		}

		return true;
	}

	@Override
	public boolean isEnabled() {
//		Boolean enabled = false;
//
//		if (this.isAccountNonExpired() && this.isAccountNonLocked() && this.isCredentialsNonExpired()) {
//			enabled = true;
//		}
		
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<UserRoles> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRoles> roles) {
		this.roles = roles;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(LocalDateTime deleteTime) {
		this.deleteTime = deleteTime;
	}

	public LocalDateTime getLastPasswordChange() {
		return lastPasswordChange;
	}

	public void setLastPasswordChange(LocalDateTime lastPasswordChange) {
		this.lastPasswordChange = lastPasswordChange;
	}

	public LocalDateTime getPasswordPolicyExpDate() {
		return passwordPolicyExpDate;
	}

	public void setPasswordPolicyExpDate(LocalDateTime passwordPolicyExpDate) {
		this.passwordPolicyExpDate = passwordPolicyExpDate;
	}

	public int getAuthenticationAttempts() {
		return authenticationAttempts;
	}

	public void setAuthenticationAttempts(int authenticationAttempts) {
		this.authenticationAttempts = authenticationAttempts;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
