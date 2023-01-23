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

		User user = new User(27,"play", "2022-10-01", 1, 1, 1);
		dao.save(user);
	}

	@Test
	void testGet() {
		int id = 27;
		User user = dao.get(id);
		assertNotNull(user);
	}

	@Test
	void testUpdate() {
		User user = new User();
		user.setID_Operatora(11);
		user.setData_zalozenia("2022-11-12");
		user.setNazwa("Orange");
		user.setNIP(123);
		user.setNumer_KRS(123);
		user.setNumer_REGON(123);

		dao.update(user);
	}

	@Test
	void testDelete() {
		int id = 27;
		dao.delete(id);
	}

}
