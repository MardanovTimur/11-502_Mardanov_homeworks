package ru.itis.inform;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ManagementSystem
{
    private static Connection con;
    private static ManagementSystem instance;
    private static DataSource dataSource;

    private ManagementSystem() {
    }

    public static synchronized ManagementSystem getInstance() {
        if (instance == null) {
            try {
                instance = new ManagementSystem();
                Context ctx = new InitialContext();
                instance.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/StudentsDS");
                con = dataSource.getConnection();
            } catch (NamingException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public List getGroups() throws SQLException {
        List groups = new ArrayList();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT group_id, groupName, curator, speciality FROM groups");
        while (rs.next()) {
            Group gr = new Group();
            gr.setGroupId(rs.getInt(1));
            gr.setNameGroup(rs.getString(2));
            gr.setCurator(rs.getString(3));
            gr.setSpeciality(rs.getString(4));
            groups.add(gr);
        }
        rs.close();
        stmt.close();
        return groups;
    }

    public Collection getAllStudents() throws SQLException {
        Collection students = new ArrayList();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT student_id, firstName, patronymic, surName, "
                + "sex, dateOfBirth, group_id, educationYear FROM students ORDER BY surName, firstName, patronymic");
        while (rs.next()) {
            Student st = new Student(rs);
            students.add(st);
        }
        rs.close();
        stmt.close();
        return students;
    }

    public Collection getStudentsFromGroup(Group group, int year) throws SQLException {
        Collection students = new ArrayList();
        PreparedStatement stmt = con.prepareStatement("SELECT student_id, firstName, patronymic, surName, "
                + "sex, dateOfBirth, group_id, educationYear FROM students "
                + "WHERE group_id =  ? AND  educationYear =  ? "
                + "ORDER BY surName, firstName, patronymic");
        stmt.setInt(1, group.getGroupId());
        stmt.setInt(2, year);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Student st = new Student(rs);
            students.add(st);
        }
        rs.close();
        stmt.close();
        return students;
    }

    public Student getStudentById(int studentId) throws SQLException {
        Student student = null;
        PreparedStatement stmt = con.prepareStatement("SELECT student_id, firstName, patronymic, surName,"
                + "sex, dateOfBirth, group_id, educationYear FROM students WHERE student_id = ?");
        stmt.setInt(1, studentId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            student = new Student(rs);
        }
        rs.close();
        stmt.close();
        return student;
    }

    public void moveStudentsToGroup(Group oldGroup, int oldYear, Group newGroup, int newYear) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE students SET group_id =  ?, educationYear=? "
                + "WHERE group_id =  ? AND  educationYear = ?");
        stmt.setInt(1, newGroup.getGroupId());
        stmt.setInt(2, newYear);
        stmt.setInt(3, oldGroup.getGroupId());
        stmt.setInt(4, oldYear);
        stmt.execute();
    }

    public void removeStudentsFromGroup(Group group, int year) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("DELETE FROM students WHERE group_id = ? AND educationYear = ?");
        stmt.setInt(1, group.getGroupId());
        stmt.setInt(2, year);
        stmt.execute();
    }

    public void insertStudent(Student student) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("INSERT INTO students "
                + "(firstName, patronymic, surName, sex, dateOfBirth, group_id, educationYear)"
                + "VALUES( ?,  ?,  ?,  ?,  ?,  ?,  ?)");
        stmt.setString(1, student.getFirstName());
        stmt.setString(2, student.getPatronymic());
        stmt.setString(3, student.getSurName());
        stmt.setString(4, new String(new char[]{student.getSex()}));
        stmt.setDate(5, new Date(student.getDateOfBirth().getTime()));
        stmt.setInt(6, student.getGroupId());
        stmt.setInt(7, student.getEducationYear());
        stmt.execute();
    }

    public void updateStudent(Student student) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE students "
                + "SET firstName=?, patronymic=?, surName=?, sex=?, dateOfBirth=?, group_id=?,"
                + "educationYear=? WHERE student_id=?");
        stmt.setString(1, student.getFirstName());
        stmt.setString(2, student.getPatronymic());
        stmt.setString(3, student.getSurName());
        stmt.setString(4, new String(new char[]{student.getSex()}));
        stmt.setDate(5, new Date(student.getDateOfBirth().getTime()));
        stmt.setInt(6, student.getGroupId());
        stmt.setInt(7, student.getEducationYear());
        stmt.setInt(8, student.getStudentId());
        stmt.execute();
    }

    public void deleteStudent(Student student) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("DELETE FROM students WHERE student_id =  ?");
        stmt.setInt(1, student.getStudentId());
        stmt.execute();
    }
}