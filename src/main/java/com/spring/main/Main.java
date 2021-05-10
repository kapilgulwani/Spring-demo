package com.spring.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import org.hibernate.*;

import org.hibernate.cfg.Configuration;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.beans.Employee;

public class Main {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/springdemo";
		String username = "root";
		String password = "Kapil321";
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			String sql = "select * from employee";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			int count = 0;
			while(result.next()) {
				int eid = result.getInt(1);
				String ename = result.getString("ename");
				String addresses = result.getNString("addresses");
				System.out.println(eid+ " Employee "+ ename + " lives at " + addresses);
			}
		} catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		Configuration con = new Configuration();
		con.configure("spring.cfg.xml");
		SessionFactory factory=con.buildSessionFactory();    
	    
		   
		Session session=factory.openSession();    
		    
		    
		Transaction t=session.beginTransaction();    
		        
		Employee e1=new Employee(5,"Arjun","Kolhapur");    
		session.persist(e1);   
		    
		t.commit();    
		session.close();    
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		Employee employee = context.getBean("employee", Employee.class);
		employee.perform();

	}

}
