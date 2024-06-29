package com.anushka.SportyShoesWebapplication.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.anushka.SportyShoesWebapplication.entity.EProduct;



public class EproductDAO {
	// JdbcTemplate

		JdbcTemplate template;

		public JdbcTemplate getTemplate() {
			return template;
		}

		public void setTemplate(JdbcTemplate template) {
			this.template = template;
		}

		// list all products
		public List<EProduct> getProducts() {
			List<EProduct> list = template.query("select * from eproduct", new RowMapper<EProduct>() {
				public EProduct mapRow(ResultSet res, int row) throws SQLException {
					EProduct product = new EProduct();
					product.setId(res.getInt(1));
					product.setName(res.getString(2));
					product.setPrice(res.getBigDecimal(3));
					product.setDateAdded(res.getDate(4));
					return product;
				}

			});
			return list;
		}

		// add products
		public int addProduct(EProduct product) {
			String query = "insert into eproduct(name,price) values ('" + product.getName() + "','" + product.getPrice()
					+ "')";
			return template.update(query);
		}

		// update products
		public void updatesaveProduct(EProduct product) {
			String sqlQuery = "update eproduct set  name = ?, price = ?  where id = ?";
			 template.update(sqlQuery
					                , product.getName()
					                , product.getPrice()
					                , product.getId());
		}
		
		
	    
		// delete products
		public boolean deleteProduct(long id) {
			String sqlQuery="delete from eproduct where id=?";
      	  return template.update(sqlQuery, id) > 0;
		}


}
