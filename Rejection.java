package com.nucleus.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import com.nucleus.dao.CustomerDAO;
import com.nucleus.dao.CustomerDAOI;
import com.nucleus.pojo.Customer;
import com.nucleus.validation.Validation;
import com.nucleus.validation.ValidationI;

public class Rejection 
{	
	int number;
	
public int reject(Customer cus ,char ch) throws NumberFormatException, IOException, SQLException
	{
				ValidationI v = new Validation();
				CustomerDAOI dao = new CustomerDAO();
				Write w = new Write();
				
				
try
{					
if(ch=='R')
{

	if(v.checkNull(cus)&&v.checkName(cus.getName())&&v.checkPinCode(cus.getPin_code())&&v.checkEmailFormat(cus.getEmail())&&v.checkRecordStatus(cus.getRecordStatus())&&v.checkFlag(cus.getFlag())&&v.checkContact(cus.getContact_number())&&v.code(cus.getCode()))	
	{
	 number= dao.insertRecord(cus);
	 dao.committ();
	}	
	else
	{			
		w.saveToFile(cus);	
	}
	System.out.println(number+" record inserted ");
}

}
catch(Exception e){
	
	System.out.println(e);
	
}
try
{
	
if(ch=='F')
{
	if(v.checkNull(cus)&&v.checkName(cus.getName())&&v.checkPinCode(cus.getPin_code())&&v.checkEmailFormat(cus.getEmail())&&v.checkRecordStatus(cus.getRecordStatus())&&v.checkFlag(cus.getFlag())&&v.checkContact(cus.getContact_number())&&v.code(cus.getCode()))	
	{		
		number= dao.insertRecord(cus);
		w.saveToFile(cus);
	}
	else
	{
		dao.rollBack();
		return 0;
	}
	System.out.println(number+" record inserted ");
}
		
}	
catch(Exception e)
	{
		e.printStackTrace();
	}
return number;

	}
				
}
