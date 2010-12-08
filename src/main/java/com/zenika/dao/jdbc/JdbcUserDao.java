/**
 * 
 */
package com.zenika.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zenika.dao.UserDao;
import com.zenika.domain.User;

/**
 * @author acogoluegnes
 *
 */
@Repository
public class JdbcUserDao implements UserDao {
	
	private JdbcTemplate template;
	
	@Autowired
	public JdbcUserDao(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	/* (non-Javadoc)
	 * @see com.zenika.dao.UserDao#getUser(java.lang.String)
	 */
	@Override
	public User getUser(String username) {
		try {
			User user = template.queryForObject("select id,username,password from users where username = ?",
					new RowMapper<User>() {
				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User user = new User();
					user.setId(rs.getLong("id"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					return user;
				}
			},username);
			return user;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
