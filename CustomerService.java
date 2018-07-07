package com.nucleus.service;

import java.io.IOException;
import java.sql.SQLException;

import com.nucleus.controller.Rejection;
import com.nucleus.dao.CustomerDAO;
import com.nucleus.dao.CustomerDAOI;
import com.nucleus.pojo.Customer;
import com.nucleus.validation.Validation;
import com.nucleus.validation.ValidationI;

public class CustomerService implements ServiceI
{

	public Boolean service(Customer cus,char ch)
	{
		CustomerDAOI dao = new CustomerDAO();
		try {			
			if(ch=='R')
			{
			Rejection r = new Rejection();
				int n =	r.reject(cus, ch);
			}
			if(ch=='F')
			{
			Rejection r = new Rejection();
				int n =	r.reject(cus, ch);
				if(n==0)
				return false;
			}
				
		} catch (NumberFormatException e) {
			
			System.out.println(e);
			
		} catch (IOException e) {
			
			System.out.println(e);
			
		} catch (SQLException e) {
		
			System.out.println(e);
		}

		return true;
	}
	
}
