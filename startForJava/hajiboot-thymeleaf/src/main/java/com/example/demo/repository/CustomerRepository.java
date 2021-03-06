package com.example.demo.repository;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.domain.Customer;

@Repository
@Transactional
public class CustomerRepository {

  @Autowired
  NamedParameterJdbcTemplate jdbcTemplate;

  SimpleJdbcInsert insert;

  @PostConstruct
  public void init() {
    insert = new SimpleJdbcInsert((JdbcTemplate)jdbcTemplate.getJdbcOperations())
        .withTableName("customers")
        .usingGeneratedKeyColumns("id");
  }

  /**
   *
   */
  private static final RowMapper<Customer> customerRowMapper = (rs, i) -> {
    Integer id = rs.getInt("id");
    String firstName = rs.getString("first_name");
    String lastName = rs.getString("last_name");
    return new Customer(id, firstName, lastName);
  };

  public List<Customer> findAll() {
    String sql = "SELECT id, first_name, last_name FROM CUSTOMERS ORDER BY id";
    List<Customer> customers = jdbcTemplate.query(sql, customerRowMapper);
    return customers;
  }

  public Customer findOne(Integer customerId) {
    SqlParameterSource param = new MapSqlParameterSource().addValue("id", customerId);
    String sql = "SELECT id, first_name, last_name FROM CUSTOMERS WHERE id=:id ";
    return jdbcTemplate.queryForObject(sql, param, customerRowMapper);
  }

  public Customer save(Customer customer) {
    SqlParameterSource param = new BeanPropertySqlParameterSource(customer);

    if (customer.getId() == null) {
      Number key = insert.executeAndReturnKey(param);
      customer.setId(key.intValue());

//      jdbcTemplate.update("INSERT INTO customers(first_name, last_name) values(:firstName, :lastName)", param);
    } else {
      jdbcTemplate.update("UPDATE CUSTOMERS SET first_name=:firstName, last_name=:lastName WHERE id=:id", param);
    }
    return customer;
  }

  public void delete(Integer customerId) {
    SqlParameterSource param = new MapSqlParameterSource().addValue("id", customerId);
    jdbcTemplate.update("DELETE FROM CUSTOMERS WHERE id=:id", param);
  }

}
