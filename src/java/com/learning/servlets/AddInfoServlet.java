package com.learning.servlets;

import com.learning.Animal;
import com.learning.Client;
import com.learning.JDBC.DatabaseMain;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sendData")
public class AddInfoServlet extends HttpServlet {
    private DatabaseMain db;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        db = new DatabaseMain();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("clientName");
        String petName = req.getParameter("petName");
        try {
            db.setClientInDB(name);
            db.setPetInDB(petName, name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/users");
    }
}
