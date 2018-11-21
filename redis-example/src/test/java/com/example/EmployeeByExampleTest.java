package com.example;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.model.SpecialUser;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.mastercard.config.RepositoryTestSupport;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmployeeByExampleTest extends RepositoryTestSupport {
	@Autowired
	UserRepository repository;

	User skyler, walter, flynn;

	@Before
	public void setUp() {

		repository.deleteAll();

		this.skyler = repository.save(new User("Skyler", "White", 45));
		this.walter = repository.save(new SpecialUser("Walter", "White", 50));
		this.flynn = repository.save(new SpecialUser("Walter Jr. (Flynn)", "White", 17));
	}

	@Test
	public void countByExample() {
		assertThat(repository.count(Example.of(new User(null, "White", null))), is(3L));
	}

	@Test
	public void countSubtypesByExample() {
		assertThat(repository.count(Example.of(new SpecialUser(null, "White", null))), is(2L));
	}
}
