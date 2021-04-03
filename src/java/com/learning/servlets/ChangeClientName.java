package com.learning.servlets;

import com.learning.JDBC.DatabaseMain;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changeData")
public class ChangeClientName extends HttpServlet {
    private DatabaseMain db;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        db = new DatabaseMain();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int clientID = Integer.parseInt(req.getParameter("clientID"));
        String name = req.getParameter("clientName1");
        try {
            db.renameClientInDB(clientID, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
