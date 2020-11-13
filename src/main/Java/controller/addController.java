package controller;
import dao.StudentDao;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class addController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDao sd = new StudentDao();
        String name = req.getParameter("sname");
        int age = Integer.valueOf(req.getParameter("sage"));
        sd.addStudent(name,age);
        resp.sendRedirect("show");
    }
}
