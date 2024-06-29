package com.anushka.SportyShoesWebapplication.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.anushka.SportyShoesWebapplication.entity.EProduct;
import com.anushka.SportyShoesWebapplication.entity.User;



public class UserDAO {
	// JdbcTemplate

		JdbcTemplate template;

		public JdbcTemplate getTemplate() {
			return template;
		}

		public void setTemplate(JdbcTemplate template) {
			this.template = template;
		}

		// list all products
		public List<User> getUsers() {
			List<User> list = template.query("select * from euser", new RowMapper<User>() {
				public User mapRow(ResultSet res, int row) throws SQLException {
					User user = new User();
					user.setId(res.getInt(1));
					user.setUsername(res.getString(2));
					user.setPassword(res.getString(3));
					user.setRole(res.getString(4));
					user.setDateAdded(res.getDate(5));
					return user;
				}

			});
			return list;
		}

		// add products
		public int addUser(User user) {
			String query = "insert into euser(username,password,role) values ('" + user.getUsername() + "','" + user.getPassword()+ "','" + user.getRole()
					+ "')";
			return template.update(query);
		}
		// update products
				public void updatesaveUser(User user) {
					String sqlQuery = "update euser set  username = ?, password = ?, role = ?  where id = ?";
					 template.update(sqlQuery
							                , user.getUsername()
							                , user.getPassword()
							                , user.getRole()
							                , user.getId());
				}
				
		
	    
		// delete products
		public boolean deleteUser(long id) {
			String sqlQuery="delete from euser where id=?";
      	  return template.update(sqlQuery, id) > 0;
		}

		
	
		}
	

