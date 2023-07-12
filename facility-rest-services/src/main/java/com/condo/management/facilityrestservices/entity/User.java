package com.condo.management.facilityrestservices.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "T_USER")
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String name;

	@Email
	private String email;

	@Enumerated(EnumType.STRING)
	private Role role;

	@NotBlank
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	@Size(min = 4, message = "Unit number should have atleast 2 characters")
	private String unitNumber;

	@Past(message = "Move in Date should be in the past")
	private LocalDate moveInDate;

	@Past(message = "Birth Date should be in the past")
	private LocalDate birthDate;

	@ManyToOne(fetch = FetchType.LAZY)
	private Condominium condominium;

	@OneToMany(mappedBy = "facilityUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Booking> bookings = new HashSet<>();

	public User() {
		super();
	}

	public User(Integer id, @Size(min = 2, message = "Name should have atleast 2 characters") String name,
			@Email String email, @NotBlank String password,
			@Size(min = 4, message = "Unit number should have atleast 2 characters") String unitNumber,
			@Past(message = "Move in Date should be in the past") LocalDate moveInDate,
			@Past(message = "Birth Date should be in the past") LocalDate birthDate, Condominium condominium,
			Set<Booking> bookings) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.unitNumber = unitNumber;
		this.moveInDate = moveInDate;
		this.birthDate = birthDate;
		this.condominium = condominium;
		this.bookings = bookings;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}

	public LocalDate getMoveInDate() {
		return moveInDate;
	}

	public void setMoveInDate(LocalDate moveInDate) {
		this.moveInDate = moveInDate;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Condominium getCondominium() {
		return condominium;
	}

	public void setCondominium(Condominium condominium) {
		this.condominium = condominium;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
