package com.nucleus.dao;

import com.nucleus.pojo.Customer;

public interface CustomerDAOI
{
	public int insertRecord(Customer c);
	public void rollBack();
	public void committ();
}
 