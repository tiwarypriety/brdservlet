package com.nucleus.controller;

import java.io.FileWriter;
import java.io.IOException;

import com.nucleus.pojo.Customer;

public class Write {
		
	
	public int saveToFile(Customer c)
	{
		try {
			FileWriter out = new FileWriter("d:/ServletErrorLog.txt",true);
			out.write(c.getCode()+" "+c.getName()+" "+c.getAddress1()+" "+c.getAddress2()+" "+c.getPin_code()+" "+c.getEmail()+" "+c.getContact_number()+" "+c.getPrimary_contact_person()+" "+c.getRecordStatus()+" "+c.getFlag()+" "+c.getCreateDate()+" "+c.getCreatedBy()+" "+c.getModifiedDate()+" "+c.getModifiedBy()+" "+c.getAuthorizedDate()+" "+c.getAuthorizedBy());
			out.write("\r\n");
			out.flush();
			System.out.println("Writing done");

	} catch (IOException e)
	{
		e.printStackTrace();
	}
	return 1;
	}
}
