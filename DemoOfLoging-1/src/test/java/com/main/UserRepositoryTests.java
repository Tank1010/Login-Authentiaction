/*
*@author Admin 88
*@date Feb 7, 2022
*version 1.0
*/


package com.main;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class UserRepositoryTests {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("dosomethingbro@gmail.com");
		user.setPassword("donowman1010");
		user.setFirstName("Tran Bao");
		user.setLastName("Linh");
		
		User userSave =  repo.save(user);
		
		User existUser = entityManager.find(User.class, userSave.getId());
		
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
	}
}
