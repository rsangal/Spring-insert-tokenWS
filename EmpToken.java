package com.inserttoken;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@RequestMapping("/token")
@Controller
public class EmpToken {
	@RequestMapping(value = "/{name}/{token}", method = RequestMethod.GET)
	public  @ResponseBody String setToken(@PathVariable String name,@PathVariable String token) {
		// String name="Amarabcs";
		  //  String token="A11";
		    	try {
		    		  Class.forName("com.mysql.jdbc.Driver");
		    		  Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", 
		    		"root", "pass");
		    		  PreparedStatement st = 
		    		con.prepareStatement("insert into token values(?,?)");
		    		  st.setString(2, token);
		    		  st.setString(1, name);
		    		  
		    		  st.executeUpdate();
		    		  } catch (Exception e) {
		    		  System.out.println(e.getMessage());
		    		  }
		        String result = "Data inserted";
		        return result;
		
}

}
