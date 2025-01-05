package com.project.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class Students {

    private JdbcTemplate jdbcTemplate;
    
    public Students(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
    }
    
    public void saveData() {
//	jdbcTemplate.update("insert into students values (107, 'Geetha', 'valuri', 28)");
//	System.err.println(" Row inserted into table.");
	
	jdbcTemplate.update("update students set id=106 where first_name = 'Geetha' ");
	System.err.println(" Row updated in the table.");
    }
   
}