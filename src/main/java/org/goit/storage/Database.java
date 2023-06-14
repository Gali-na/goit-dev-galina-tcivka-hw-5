package org.goit.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Database {
    private static Database instance;
    private Connection connection;
    private Database() {
        try {
            connection = DriverManager.getConnection(Prefs.DB_JDBS_CONECTION_URL);
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }


    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public  Connection getConnection(){

        return connection;
    }
}
