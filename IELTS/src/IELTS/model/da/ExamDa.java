package IELTS.model.da;


import IELTS.model.entity.Exam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static javax.rmi.PortableRemoteObject.connect;

public class ExamDa implements AutoCloseable {
    private Connection connection;
    private PreparedStatement statement;

    public ExamDa() throws SQLException {
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "javase", "java123");
    }

    // private long nextVal()throws SQLException {
    //  connect();


    //}

    public Exam save(Exam exam) throws SQLException {
        statement = connection.prepareStatement("INSERT INTO QUESTIONBANK(id,question,answer1,answer2,answer3,answer4,correctanswer,score)VALUES(QuestionBank_seq.nextval,?,?,?,?,?,?,?)");
        statement.setString(1, exam.getQuestion());
        statement.setString(2, exam.getAnswer1());
        statement.setString(3, exam.getAnswer2());
        statement.setString(4, exam.getAnswer3());
        statement.setString(5, exam.getAnswer4());
        statement.setInt(6, exam.getCorrectAnswer());
        statement.setInt(7, exam.getScore());
        statement.execute();
        return exam;
    }


    public void edit(Exam exam) throws SQLException {
        statement = connection.prepareStatement("UPDATE QUESTIONBANK SET question=?,answer1=?,answer2=?,answer3=?,answer4=?,correctanswer=?,score=? WHERE id=?");
        statement.setString(1, exam.getQuestion());
        statement.setString(2, exam.getAnswer1());
        statement.setString(3, exam.getAnswer2());
        statement.setString(4, exam.getAnswer3());
        statement.setString(5, exam.getAnswer4());
        statement.setInt(6, exam.getCorrectAnswer());
        statement.setInt(7, exam.getScore());
        statement.setInt(8, exam.getId());
        statement.execute();
    }

    public void remove(int id) throws SQLException {
        statement = connection.prepareStatement("DELETE FROM QUESTIONBANK WHERE id=?");
        statement.execute();
    }

    public List<Exam> findAll() throws SQLException {
        statement = connection.prepareStatement("SELECT * FROM QUESTIONBANK");
        ResultSet resultSet = statement.executeQuery();
        List<Exam> examList = new ArrayList<>();
        while (resultSet.next()) {

            Exam exam = new Exam(
                    resultSet.getInt("id"),
                    resultSet.getString("question"),
                    resultSet.getString("answer1"),
                    resultSet.getString("answer2"),
                    resultSet.getString("answer3"),
                    resultSet.getString("answer4"),
                    resultSet.getInt("correctAnswer"),
                    resultSet.getInt("score"));
            examList.add(exam);
        }
        return examList;
    }

    public Exam findById(int id) throws SQLException {
        statement = connection.prepareStatement("SELECT * FROM QUESTIONBANK WHERE ID=?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        Exam exam = null;
        if (resultSet.next()) {
            exam = new Exam(
                    resultSet.getInt("id"),
                    resultSet.getString("question"),
                    resultSet.getString("answer1"),
                    resultSet.getString("answer2"),
                    resultSet.getString("answer3"),
                    resultSet.getString("answer4"),
                    resultSet.getInt("correctAnswer"),
                    resultSet.getInt("score"));
        }
        return exam;
    }


    @Override
    public void close() throws Exception {
        statement.close();
        connection.close();
    }


}
