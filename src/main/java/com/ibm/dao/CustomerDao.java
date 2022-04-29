package com.ibm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ibm.model.Customer;


public class CustomerDao {
	
	 
//	public CustomerDao() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//	public CustomerDao(JdbcTemplate jdbcTemplate) {
//		super();
//		this.jdbcTemplate = jdbcTemplate;
//	}

	private JdbcTemplate jdbcTemplate;  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	  
	public int saveCustomer(Customer c){  
	    String query="insert into customer values('"+c.getCustno() +"','"+c.getCustname()+"','"+c.getOrdervalue()+"','"+c.getCreatedAt()+"' )";  
	    System.out.println("\n inside saveCustomer:"+query.toString());
	    return jdbcTemplate.update(query);  
	  

	}  
	
	public int updateCustomer(Customer c){  
	    String query="update customer set custno='"+c.getCustno()+"' ,custname='"+c.getCustname()+"', ordervalue='"+c.getOrdervalue()+"', createdAt='"+c.getCreatedAt()+"' where custcode='"+c.getCustno()+"' ";  
	    return jdbcTemplate.update(query);  
	}  

	public int deleteCustomer(int id){  
	    String query="delete from customer where custno='"+id+"' ";  
	    return jdbcTemplate.update(query);  
	}  
	
	//By using result set extractor
//	public List<Customer> getAllCustomers(){  
//		 return jdbcTemplate.query("select * from customer",new ResultSetExtractor<List<Customer>>(){  
//		    public List<Customer> extractData(ResultSet rs) throws SQLException, DataAccessException {  
//		      
//		    	
//		        List<Customer> list=new ArrayList<Customer>();  // Array list declared
//		        while(rs.next()){  
//		        Customer c = new Customer();
//		        c.setCustno(rs.getInt(1));
//		        c.setCustname(rs.getString(2));
//		        c.setOrdervalue(rs.getInt(3));
//		      //  c.setCreatedAt(rs.getDate(4) .toLocalDate());
////		        c.setCreatedAt(rs.getDate(4).toInstant()
////		        	      .atZone(ZoneId.systemDefault())
////		        	      .toLocalDateTime());
//		        LocalDateTime now = LocalDateTime.now();
//		        
//		        // Print statement
//		        System.out.println(now);
//		        c.setCreatedAt(now);
//		        
//		        list.add(c);  
//		        }  
//		        return list;  
//		        }  
//		    });  
//}
	
	//By using rowmapper
	
	public List<Customer> getAllCustomers(){    
		 return jdbcTemplate.query("select * from customer",new RowMapper<Customer>(){  
			    public Customer mapRow(ResultSet rs, int row) throws SQLException {  
			      
			    	
			     //   List<Customer> list=new ArrayList<Customer>();  // Array list declared
			       
			        Customer c = new Customer();
			        c.setCustno(rs.getInt(1));
			        c.setCustname(rs.getString(2));
			        c.setOrdervalue(rs.getInt(3));
			      //  c.setCreatedAt(rs.getDate(4) .toLocalDate());
//			        c.setCreatedAt(rs.getDate(4).toInstant()
//			        	      .atZone(ZoneId.systemDefault())
//			        	      .toLocalDateTime());
			        LocalDateTime now = LocalDateTime.now();
			        
			        // Print statement
			        System.out.println(now);
			        c.setCreatedAt(now);
			        
			       // list.add(c);  
			       
			        return c;  
			        }  
			    });  
	
	}    

}
