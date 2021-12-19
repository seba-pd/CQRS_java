package command.impl;

import command.ItemWriteRepository;
import domain.Item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InMemoryItemWriteRepository implements ItemWriteRepository {

    @Override
    public void addItem(Item item) {
        final String addItemQuery = "INSERT INTO items (id, name) VALUES(\'" + item.getId() + "\' ,\'" + item.getName() + "\')";
        Connection connection = null;
        Statement stmt = null;

        try {
            connection = DriverManager.getConnection("jdbc:h2:~/dbname", "sa", "");
            stmt = connection.createStatement();
            stmt.execute(addItemQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
