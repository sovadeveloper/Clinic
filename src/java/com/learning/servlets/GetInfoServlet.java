package com.learning.servlets;

import com.google.gson.Gson;
import com.learning.Client;
import com.learning.JDBC.DatabaseMain;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet("/getOwners")
public class GetInfoServlet extends HttpServlet {
    DatabaseMain db;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        db = new DatabaseMain();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<Client> listOfClients = null;
        try {
            listOfClients = db.getAllClients();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        PrintWriter writer=resp.getWriter();
        writer.print(gson.toJson(listOfClients));
        writer.flush();
    }
}

