package controller;

import bean.Student;
import dao.StudentDao;

import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class StudentController extends HttpServlet {

    public StudentDao sd = new StudentDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    public void showNewForm(HttpServletRequest req, HttpServletResponse resp)
            throws  IOException, ServletException {
        req.getRequestDispatcher("addStudent.jsp").forward(req,resp);
    }

    public void listStudent(HttpServletRequest req, HttpServletResponse resp)
            throws  IOException, ServletException {
        List<Student> stus = sd.getAllStudent();
        System.out.println(stus);
        req.setAttribute("liststudent",stus);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }


    public void updateStudent(HttpServletRequest req, HttpServletResponse resp)
            throws  IOException, ServletException {

        List<Student> stus = sd.getAllStudent();
        System.out.println(stus);
        req.setAttribute("liststudent",stus);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    public void deleteStudent(HttpServletRequest req, HttpServletResponse resp)
            throws  IOException, ServletException {

        List<Student> stus = sd.getAllStudent();
        System.out.println(stus);
        req.setAttribute("liststudent",stus);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    public void insertStudent(HttpServletRequest req, HttpServletResponse resp)
            throws  IOException, ServletException {

        String name = req.getParameter("sname");
        int age = Integer.valueOf(req.getParameter("sage"));
        sd.addStudent(name,age);
    }

    public void showEditForm(HttpServletRequest req, HttpServletResponse resp)
            throws  IOException, ServletException {

    }
}
