package bdbt_bada_project.SpringApplication;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserDAOTest {

	private UserDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		datasource.setUsername("MBEDNAR2");
		datasource.setPassword("MBEDNAR2");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");

		/* Import JdbcTemplate */
		dao = new UserDAO(new JdbcTemplate(datasource));

	}

	@Test
	void testUserDAO() {
		fail("Not yet implemented");
	}

	@Test
	void testList() {
		/* Import java.util */
		List<User> listUser = dao.list();

		assertTrue(listUser.isEmpty());
	}

	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testGet() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}
