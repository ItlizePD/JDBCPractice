package dao;

import bean.Student;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class StudentDao {
    public List<Student> getAllStudent(){
        List<Student> stus = new ArrayList<Student>();
        String sql="select * from student";
        Connection conn = JDBCUtil.getCon();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Student student =new Student();
                student.setName(rs.getString("name"));
                student.setAge(Integer.valueOf(rs.getString("age")));
                stus.add(student);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            JDBCUtil.closeCon(conn);
        }
        return stus;
    }

    public Student getStudent(String name){
        Student s = new Student();
        String sql ="select * from student where name =?";
        Connection conn = JDBCUtil.getCon();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,name);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                s.setName(rs.getString("name"));
                s.setAge(Integer.parseInt(rs.getString("age")));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            JDBCUtil.closeCon(conn);
        }
        return s;
    }

    public void addStudent(String name,int age){
        String sql="insert into student values(?,?)";
        Connection conn = JDBCUtil.getCon();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,name);
            pst.setInt(2,age);
            pst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            JDBCUtil.closeCon(conn);
        }
    }

    public void updateStudent(String name, int age){
        String sql="update student set age=? where name=? ";
        Connection conn=JDBCUtil.getCon();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, age);
            pst.setString(2, name);
            pst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            JDBCUtil.closeCon(conn);
        }
    }

    public void deleteStudent(String name){
        String sql ="delete from student where name=? ";
        Connection con = JDBCUtil.getCon();
        try {
            PreparedStatement pst=con.prepareCall(sql);
            pst.setString(1, name);
            pst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            JDBCUtil.closeCon(con);
        }
    }

}
