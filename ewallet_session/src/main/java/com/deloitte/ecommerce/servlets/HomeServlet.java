package com.deloitte.ecommerce.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deloitte.ecommerce.dao.CustomerDaoImpl;
import com.deloitte.ecommerce.entities.Customer;
import com.deloitte.ecommerce.service.CustomerServiceImpl;
import com.deloitte.ecommerce.service.ICustomerService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/second")
public class HomeServlet extends HttpServlet {

    private ICustomerService service=new CustomerServiceImpl(new CustomerDaoImpl());

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        String signedOutVal = req.getParameter("signout");
        boolean sessionDestroyed = false;
        if (signedOutVal != null && signedOutVal.equals("true")) {
            session.invalidate();
            sessionDestroyed = true;
        }
        Object usernameObj=null;
        if (!sessionDestroyed) {
            usernameObj = session.getAttribute("mobileNo");
        }

        if (usernameObj == null || usernameObj.toString().isEmpty()) {
            resp.getWriter().println("you are not signed in yet");
            String signInLink = "<a href='/html/loginform.html'>Sign In </a> ";
            writer.println(signInLink);
            return;
        }
        String mobileNo=usernameObj.toString();
        Customer c= service.getCustomerByMobileNo(mobileNo);
        String name = c.getName();
        double balance = c.getBalance();
        writer.println("Welcome " + name +" balance="+balance);
        String signoutLink = "<a href='/second?signout=true'>Sign out </a> ";
        writer.println(signoutLink);

    }


}



