package IELTS.model.da;

import IELTS.model.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDa implements AutoCloseable {
    private Connection connection;
    private PreparedStatement statement;

    public PersonDa() throws SQLException {
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "javase", "java123");
    }

    public Person save(Person person) throws SQLException {
        statement = connection.prepareStatement("INSERT PERSON(id,name,family,phonenumber,username,password)VALUES(person_seq.nextval,?,?,?,?,?)");
        statement.setString(1, person.getName());
        statement.setString(2, person.getFamily());
        statement.setString(3, person.getPhoneNumber());
        statement.setString(4, person.getUserName());
        statement.setString(5, person.getPassword());
        statement.execute();
        return person;
    }


    public Person edit(Person person) throws SQLException {
        statement = connection.prepareStatement("UPDATE PERSON SET name=?,family=?,phonenumber=?,username=?,password=? WHERE id=?");
        statement.setString(1, person.getName());
        statement.setString(2, person.getFamily());
        statement.setString(3, person.getPhoneNumber());
        statement.setString(4, person.getUserName());
        statement.setString(5, person.getPassword());
        statement.execute();

    return person;
    }


    public Person remove(int id) throws SQLException {
        Person person = findById(id);
        if (person !=null){
            statement = connection.prepareStatement("DELETE FROM PERSON WHERE id=?");
            statement.execute();
        }

        return null;
    }

    public List<Person> findAll() throws SQLException {
        statement = connection.prepareStatement("SELECT * FROM PERSON");
        ResultSet resultSet = statement.executeQuery();
        List<Person> personList = new ArrayList<>();
        while (resultSet.next()) {

            Person person = new Person(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("family"),
                    resultSet.getString("PhoneNumber"),
                    resultSet.getString("UserName"),
                    resultSet.getString("PassWord"));
            personList.add(person);

        }
        return personList;
    }

    public Person findById(int id) throws SQLException {
        Person person= null;
        statement = connection.prepareStatement("select * from person where id=?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
             person = new Person(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("family"),
                    resultSet.getString("PhoneNumber"),
                    resultSet.getString("UserName"),
                    resultSet.getString("password"));

        }

        return person;
    }

    public Person findByUserName(String UserName) throws SQLException {
        statement = connection.prepareStatement("SELECT * FROM PERSON WHERE UserName=?");
        statement.setString(1, UserName);
        ResultSet resultSet = statement.executeQuery();
        Person person = null;
        if (resultSet.next()) {
            person = new Person(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("family"),
                    resultSet.getString("PhoneNumber"),
                    resultSet.getString("UserName"),
                    resultSet.getString("PassWord"));
        }
        return person;
    }

    public void close() throws Exception {
        statement.close();
        connection.close();
    }
}
