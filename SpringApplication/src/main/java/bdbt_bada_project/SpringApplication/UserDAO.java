package bdbt_bada_project.SpringApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
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
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Operatorzy").usingColumns("ID_Operatora", "Nazwa", "Data_zalozenia", "NIP", "Numer_KRS", "Numer_REGON");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(user);
		insertActor.execute(param);
	}
	/* Read
	odczytywanie danych z bazy */
	public User get( int id ) {

		String sql = "SELECT * FROM Operatorzy WHERE ID_Operatora = ?";
		Object[] args = {id};
		User user = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(User.class));
		return user;

	}
	/* Update
	aktualizacja danych */
	public void update(User user ) {
		String sql = "UPDATE Operatorzy SET Nazwa=:Nazwa, Data_zalozenia=:Data_zalozenia, NIP=:NIP, Numer_KRS=:Numer_KRS, Numer_REGON=:Numer_REGON";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(user);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

		template.update(sql, param);
	}
	/* Delete
	wybrany rekord z danym id */
	public void delete(int id) {
		String sql = "DELETE FROM Operatorzy WHERE ID_Operatora = ?";
		jdbcTemplate.update(sql, id);

	}



}
