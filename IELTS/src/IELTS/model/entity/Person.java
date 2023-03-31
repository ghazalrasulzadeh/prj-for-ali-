package IELTS.model.entity;

import com.google.gson.Gson;
import com.sun.xml.internal.fastinfoset.util.CharArray;

public class Person {
    private int id;
    private String name;
    private String family;
    private String PhoneNumber;
    private String UserName;
    private String password;


    public Person() {
    }

    public Person(int id, String name, String family, String phoneNumber, String userName, String password) {
        this.id = id;
        this.name = name;
        this.family = family;
        PhoneNumber = phoneNumber;
        UserName = userName;
        this.password = password;
    }

    public Person(String name, String family, String phoneNumber, String userName, String password) {
        this.name = name;
        this.family = family;
        PhoneNumber = phoneNumber;
        UserName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public Person setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Person setFamily(String family) {
        this.family = family;
        return this;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public Person setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
        return this;
    }

    public String getUserName() {
        return UserName;
    }

    public Person setUserName(String userName) {
        UserName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Person setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
