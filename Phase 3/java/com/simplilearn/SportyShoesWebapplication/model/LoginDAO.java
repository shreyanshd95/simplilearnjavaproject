package com.anushka.SportyShoesWebapplication.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.anushka.SportyShoesWebapplication.entity.User;

public class LoginDAO {
	
		JdbcTemplate template;

		public JdbcTemplate getTemplate() {
			return template;
		}

		public void setTemplate(JdbcTemplate template) {
			this.template = template;
		}
		  public User loginUser(User user) {

			    String sql = "select * from euser where username='" + user.getUsername() + "' and password='" + user.getPassword()
			    + "'";

			    List<User> users = template.query(sql, new UserMapper());

			    return users.size() > 0 ? users.get(0) : null;
			    }

			  }

			  class UserMapper implements RowMapper<User> {

			  public User mapRow(ResultSet rs, int arg1) throws SQLException {
			    User user = new User();

			    user.setUsername(rs.getString("username"));
			    user.setPassword(rs.getString("password"));
			   
			    return user;
			  }
}
