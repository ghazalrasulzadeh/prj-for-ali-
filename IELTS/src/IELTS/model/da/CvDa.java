package IELTS.model.da;

import IELTS.model.entity.Cv;
import IELTS.model.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CvDa implements AutoCloseable{
    private Connection connection;
    private PreparedStatement statement;

    public CvDa() throws SQLException {
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","javase","java123");
    }

    public Cv save(Cv cv) throws SQLException {
        statement = connection.prepareStatement("INSERT CV(id,goal,gender)VALUES(cv_seq.nextval,?,?)");
        statement.setString(1,cv.getGoal());
        statement.setString(2, cv.getGender());
        statement.execute();
        return cv;
    }

    public Cv edit(Cv cv) throws SQLException {
        statement = connection.prepareStatement("UPDATE CV SET goal=?,gender=? WHERE id=?");
        statement.setString(1, cv.getGoal());
        statement.setString(2, cv.getGender());
        statement.execute();
        return cv ;
    }

    public Cv remove(int id) throws SQLException {
        Cv cv = findById(id);
        if (cv != null){
            statement = connection.prepareStatement("DELETE FROM CV WHERE id=?");
            statement.execute();
        }
        return cv ;

    }

    public List<Cv> findAll() throws SQLException {
        statement = connection.prepareStatement("SELECT * FROM CV");
        ResultSet resultSet = statement.executeQuery();
        List<Cv> cvList = new ArrayList<>();
        while (resultSet.next()) {

            Cv cv = new Cv(
                    resultSet.getInt("id"),
                    resultSet.getString("goal"),
                    resultSet.getString("gender"));
            cvList.add(cv);
        }
        return cvList;
    }

    public Cv findById(int id) throws SQLException {
        statement = connection.prepareStatement("SELECT * FROM CV WHERE id=?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        Cv cv = null;
        if(resultSet.next()){
            cv= new Cv(
                    resultSet.getInt("id"),
                    resultSet.getString("goal"),
                    resultSet.getString("gender"));
        }
        return cv;
    }

    public void close() throws Exception{
        statement.close();
        connection.close();
    }
}
