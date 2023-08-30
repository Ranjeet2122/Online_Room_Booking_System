package com.app.pojos;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users_tbl")

public class User extends BaseEntity {
	@NotBlank(message = "name can't be blank")
	@Length(min = 4, max = 40, message = "invalid name!!!!!")
	@Column(name = "first_name", length = 40)
	private String name;
	@Column(unique = true)
	@Email(message = "Invalid email format")
	private String email;
//	@Pattern(regexp = "/[0-9]/")
	@Column(length = 10)
	private String phone;
//	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@Column(length = 20)
	private String address;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	@NotNull(message = "Role must be supplied....!")
	private Role role;
	@Column(length = 10)
	private String gender;
//	@NotNull(message = "Regi date must be supplied....!")
//	@Future(message = "Invalid date..!")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;


//	private 
	public User() {
	}

//	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true , fetch = FetchType.EAGER )
	// private List<IssueRecord> issuedRecord1 = new ArrayList<>();

	public User(
			@NotBlank(message = "name can't be blank") @Length(min = 4, max = 20, message = "invalid name!!!!!") String name,
			String email, String phone, String password, String address,
			@NotNull(message = "Role must be supplied....!") Role role, String gender, LocalDate date) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.address = address;
		this.role = role;
		this.gender = gender;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", phone=" + phone + ", password=" + password + ", address="
				+ address + ", role=" + role + ", gender=" + gender + ", date=" + date + "]";
	}

}
