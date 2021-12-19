package query.impl;

import domain.Item;
import query.ItemReadRepository;

import java.sql.*;
import java.util.UUID;

public class InMemoryItemReadRepository implements ItemReadRepository {

    @Override
    public Item getItem(UUID id) {
        final String getItemQuery = "SELECT name FROM items WHERE id = \' " + id.toString() + "\'";
        String name = null;
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection("jdbc:h2:~/dbname", "sa", "");
            stmt = connection.createStatement();
            rs = stmt.executeQuery(getItemQuery);
            rs.next();
            name = rs.getString("name");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
        return new Item(id, name);
    }
}
