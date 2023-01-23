package bdbt_bada_project.SpringApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
//import org.springframework.jdbc.core.JdbcTemplate;
@Repository
public class UserDAO {

	/* Import org.springframework.jd....Template */
	@Autowired
	private	JdbcTemplate jdbcTemplate;

	public UserDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	/* Import java.util.List */
	public List<User> list(){
		String sql = "SELECT * FROM Operatorzy";
		List<User> listUser = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));
		return listUser;
	}
	/* Insert
	wstawianie nowego wiersza do bazy */
	public	void save(User user) {
	}
	/* Read
	odczytywanie danych z bazy */
	public User get( int id ) {
		return null;
	}
	/* Update
	aktualizacja danych */
	public void update(User user ) {
	}
	/* Delete
	wybrany rekord z danym id */
	public void delete(int id) {
	}



}
