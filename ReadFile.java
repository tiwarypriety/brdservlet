package com.nucleus.controller;

import com.nucleus.pojo.Customer;

public class ReadFile 
{
				
	public Customer read(String c)

	{				
						Customer cus=new Customer();
						String s[] = c.split("~",-1);
						cus.setCode(s[0]);
						cus.setName(s[1]);
						cus.setAddress1(s[2]);
						cus.setAddress2(s[3]);
						cus.setPin_code(Integer.parseInt(s[4]));
						cus.setEmail(s[5]);
						cus.setContact_number(Long.parseLong(s[6]));
						cus.setPrimary_contact_person(s[7]);
						cus.setRecordStatus(s[8]);
						cus.setFlag(s[9]);
						cus.setCreateDate(s[10]);
						cus.setCreatedBy(s[11]);
						cus.setModifiedDate(s[12]);
						cus.setModifiedBy(s[13]);
						cus.setAuthorizedDate(s[14]);
						cus.setAuthorizedBy(s[15]);	

	return cus;		
     
	}
}

