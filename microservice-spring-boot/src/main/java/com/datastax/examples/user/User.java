/**
 * 
 */
package com.datastax.examples.user;

import java.util.UUID;

/**
 * @author Ajith Kumara
 *
 */
public class User {
	
	private String username;
	private UUID nic;
	private String address;
	private String firstName;
	private String middleName;
	private String lastName;
	
	public User(
			String username,
			UUID nic,
			String address,
			String firstName,
			String middleName,
			String lastName
			) {
		this.username = username;
		this.nic = nic;
		this.address = address;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UUID getNic() {
		return nic;
	}
	public void setNic(UUID nic) {
		this.nic = nic;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
