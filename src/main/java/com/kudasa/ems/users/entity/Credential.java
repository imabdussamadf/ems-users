/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kudasa.ems.users.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author abdussamad
 */
@Embeddable 
public class Credential implements Serializable {
    private String username;
    private String password;

    public Credential(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public Credential() { }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 79 * hash + Objects.hashCode(this.username);
		hash = 79 * hash + Objects.hashCode(this.password);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Credential other = (Credential) obj;
		if (!Objects.equals(this.username, other.username)) {
			return false;
		}
		return Objects.equals(this.password, other.password);
	}
    
}
