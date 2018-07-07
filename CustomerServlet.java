package com.nucleus.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nucleus.pojo.Customer;
import com.nucleus.service.CustomerService;
import com.nucleus.service.ServiceI;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CustomerServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter p = response.getWriter();
		try
		{
			
			response.setContentType("text/html");
			String path = request.getParameter("file");
			String s = request.getParameter("Rejection");
			char ch = s.charAt(0);
			BufferedReader br = new BufferedReader(new FileReader(path));		
			ReadFile r =new ReadFile();
			Customer cus = new Customer();
			String c;
			while((c = br.readLine())!=null)							
			{		
				cus=r.read(c);		 
			ServiceI  cs = new CustomerService();
			boolean check = cs.service(cus,ch);
			System.out.println(check);
			if(!check)
				break;	
			}	
				
			p.println("Records inserted Successfully!!");
			
		}
	catch(Exception e)
	{
		p.println("Invalid File!!");
	}
	}
}
