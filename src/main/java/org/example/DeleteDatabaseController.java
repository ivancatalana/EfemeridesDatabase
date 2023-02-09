package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDatabaseController {
    Connection connection;

    public DeleteDatabaseController(Connection connection) {
        this.connection = connection;
    }

    public void dropDBtables() throws ClassNotFoundException, SQLException {

        Statement st = connection.createStatement();

        //Borramos  todas las  tablas

        st.executeUpdate("DROP TABLE acontecimientos");
        st.executeUpdate("DROP TABLE nacimientos");
        st.executeUpdate("DROP TABLE defunciones");
    }


}
