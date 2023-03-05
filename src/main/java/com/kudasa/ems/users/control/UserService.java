/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kudasa.ems.users.control;

import com.kudasa.ems.users.entity.User;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

/**
 *
 * @author abdussamad
 */
@Transactional
public class UserService {

	@PersistenceContext(unitName = "UsersDS")
	private EntityManager em;

	public boolean isValid(String username, String password) {
        return username.equals(password);
    }

	public List<User> getUsers() {
		return em.createQuery("SELECT u FROM User u", User.class)
			.getResultList();
	}

	public Optional<User> getUser(Long id) {
		User found = em.find(User.class, id);
		return found != null ? Optional.of(found) : Optional.empty();
	}

	public User createUser(@Valid User user) {
		em.persist(user);
		return user;
	}

	public void removeUser(Long id) {
		User u = em.find(User.class, id);
		em.remove(u);
	}

	public boolean updateUser(User updated) {
		User found = em.find(User.class, updated.getId());
		if (found != null) {
			em.merge(updated);
			return true;
		}
		return false;
	}
}
