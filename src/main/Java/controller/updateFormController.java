package controller;
import bean.Student;
import dao.StudentDao;

import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updateFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("id");
        StudentDao sd = new StudentDao();
        Student updateOne = sd.getStudent(name);
        RequestDispatcher dispatcher = req.getRequestDispatcher("addStudent.jsp");
        req.setAttribute("student", updateOne);
        dispatcher.forward(req, resp);
    }
}
