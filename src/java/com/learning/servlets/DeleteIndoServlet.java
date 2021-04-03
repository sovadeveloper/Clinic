package com.learning.servlets;

import com.learning.JDBC.DatabaseMain;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteData")
public class DeleteIndoServlet extends HttpServlet {
    private DatabaseMain db;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int clientID = Integer.parseInt(req.getParameter("clientID1"));
        try {
            db.deleteClientFromDB(clientID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
