package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    //write your code here!
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Warehouse warehouse = Warehouse.getInstance();
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        User user = new User(firstName, lastName);
        warehouse.addUser(user);
        req.setAttribute("user", user);

        getServletContext().getRequestDispatcher("/jsp/add.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/add.jsp").include(req, resp);
    }
}
