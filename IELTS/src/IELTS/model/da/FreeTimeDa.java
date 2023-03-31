package IELTS.model.da;

import IELTS.model.entity.FreeTime;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FreeTimeDa implements AutoCloseable{
    private Connection connection;
    private PreparedStatement statement;

    public FreeTimeDa() throws SQLException {
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","javase","java123");
    }

    public FreeTime save(FreeTime freeTime) throws SQLException {
        statement = connection.prepareStatement("INSERT FREETIME(id,day,starthour,endhour)VALUES(freetime_seq.nextval,?,?,?)");
        statement.setString(1,freeTime.getDay());
        statement.setInt(2,freeTime.getStartHour());
        statement.setInt(3,freeTime.getEndHour());
        statement.execute();
        return freeTime;
    }

    public void edit(FreeTime freeTime) throws SQLException {
        statement = connection.prepareStatement("UPDATE FREETIME SET day=?,starthour=?,endhour=? WHERE id=?");
        statement.setString(1, freeTime.getDay());
        statement.setInt(2,freeTime.getStartHour());
        statement.setInt(3,freeTime.getEndHour());
        statement.execute();
    }

    public void remove(int id) throws SQLException {
        statement = connection.prepareStatement("DELETE FROM FREETIME WHERE id=?");
        statement.execute();
    }

    public List<FreeTime> findAll() throws SQLException {
        statement = connection.prepareStatement("SELECT * FROM FREETIME");
        ResultSet resultSet = statement.executeQuery();
        List<FreeTime> freeTimeList = new ArrayList<>();
        while (resultSet.next()){

            FreeTime freeTime = new FreeTime(
                    resultSet.getInt("id"),
                    resultSet.getString("day"),
                    resultSet.getInt("StartHour"),
                    resultSet.getInt("EndHour"));
            freeTimeList.add(freeTime);
        }
        return freeTimeList;
    }

    public FreeTime findByDay(String day) throws SQLException {
        statement = connection.prepareStatement("SELECT * FROM FREETIME WHERE day=?");
        statement.setString(1,day);
        ResultSet resultSet = statement.executeQuery();
        FreeTime freeTime = null;
        if (resultSet.next()){
            freeTime = new FreeTime(
                    resultSet.getInt("id"),
                    resultSet.getString("day"),
                    resultSet.getInt("StartHour"),
                    resultSet.getInt("EndHour"));
        }
        return freeTime;
    }

    public void close() throws SQLException {
        statement.close();
        connection.close();
    }

}
