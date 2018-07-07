package com.nucleus.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.nucleus.connection.ConnectionI;
import com.nucleus.connection.OracleConnection;
import com.nucleus.pojo.Customer;
public class CustomerDAO implements CustomerDAOI
{
	
	Connection con  = null;
	ConnectionI ci = null;
	PreparedStatement pst = null ;
	int rowsaffected = 0;
	public int insertRecord(Customer c)
	{
		
		try
		{
			if(con==null)
			{
			ci = new OracleConnection();
			con = ci.getConnection();
			}
			con.setAutoCommit(false);
			
		String str = "insert into customer_master1909 values(cus_id.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		
		pst = con.prepareStatement(str);	
	
        pst.setString(1,c.getCode());
        pst.setString(2,c.getName());
        pst.setString(3,c.getAddress1());
        pst.setString(4,c.getAddress2());
        pst.setInt(5,c.getPin_code());
        pst.setString(6,c.getEmail());
        pst.setLong(7,c.getContact_number());
        pst.setString(8,c.getPrimary_contact_person());
        pst.setString(9,c.getRecordStatus());
        pst.setString(10,c.getFlag());
        pst.setString(11,c.getCreateDate());
        pst.setString(12,c.getCreatedBy());
        pst.setString(13,c.getModifiedDate());
        pst.setString(14,c.getModifiedBy());
        pst.setString(15,c.getAuthorizedDate());
        pst.setString(16,c.getAuthorizedBy()); 
        rowsaffected = pst.executeUpdate();	  
  
		}
		catch(SQLException ex)
		{

			System.out.println("Record Already Exist in Database");
	
		}

				return rowsaffected;		
	}
	
	public void rollBack() 
	{
		if(con==null)
		{
		ci = new OracleConnection();
		con = ci.getConnection();
		}
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
				} catch (SQLException e) 
				{
				e.printStackTrace();
				}
		}
		System.out.println(" Data rollbacked!!");
	
	}
	public void committ() 
	{
		if(con==null)
		{
		ci = new OracleConnection();
		con = ci.getConnection();
		}
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
				} catch (SQLException e) 
				{
				e.printStackTrace();
				}
		}
	
	}
	
}

