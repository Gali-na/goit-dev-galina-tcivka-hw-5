package org.goit.storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.goit.storage.SQLFile.getSqlFromFile;


public class DatabasePopulateService {

    private static void populateDatabase(Database database) {
        String sql= getSqlFromFile(Prefs.POPULATE_DB_SQL_FILE_PATH);
        try (Connection connection =database.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(sql)){
           preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Database database=Database.getInstance();
        populateDatabase(database);
    }

}
