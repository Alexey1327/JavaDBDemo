package ru.lanit.demodb;

import java.sql.*;

public class JDBC {

    private final Connection connection;

    private PreparedStatement saveStmt = null;

    public JDBC() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/db_test?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "mysql";
        Class.forName("com.mysql.jdbc.Driver");

        connection = DriverManager.getConnection(url, username, password);
    }

    public void savePeople(String firstName, String middleName, String lastName, String birthDate) throws SQLException {

        if (saveStmt == null) {
            saveStmt = connection.prepareStatement("INSERT into peoples (firstname, middlename, lastname, birthdate) values (?, ?, ?, ?)");
        }

        saveStmt.setString(1, firstName);
        saveStmt.setString(2, middleName);
        saveStmt.setString(3, lastName);
        saveStmt.setDate(4, Date.valueOf(birthDate));
        saveStmt.execute();
        saveStmt.close();
    }
}
