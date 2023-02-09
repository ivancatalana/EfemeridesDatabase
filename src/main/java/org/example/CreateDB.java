package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateDB {
    Connection connection;

    public CreateDB(Connection connection) {
            this.connection = connection;
        }



        public void CreateDBTables() throws ClassNotFoundException, SQLException {

            Statement st = connection.createStatement();

    //Creem les noves taules
            st.executeUpdate("CREATE TABLE acontecimientos (id SERIAL PRIMARY KEY, fecha DATE ,year INTEGER, descripcion TEXT )");
            st.executeUpdate(    "CREATE TABLE nacimientos (id SERIAL PRIMARY KEY,fecha DATE , year_nacimiento INTEGER, year_defuncion INTEGER , Nombre TEXT, descripcion TEXT)");
            st.executeUpdate("CREATE TABLE defunciones (id SERIAL PRIMARY KEY,fecha DATE,  year_defuncion INTEGER , year_nacimiento  INTEGER , Nombre TEXT, descripcion TEXT)");

    }
    public void CreateNewDB() throws ClassNotFoundException, SQLException {

        Statement st = connection.createStatement();

        //Creem les noves taules
        st.executeUpdate("CREATE DATABASE ddbb");

    }

    public void dropDB() throws ClassNotFoundException, SQLException {

        Statement st = connection.createStatement();

        //Creem les noves taules
        st.executeUpdate("DROP DATABASE ddbb");

    }
    public void dropDBtables() throws ClassNotFoundException, SQLException {

        Statement st = connection.createStatement();

        //Borramos  todas las  tablas

        st.executeUpdate("DROP TABLE acontecimientos");
        st.executeUpdate("DROP TABLE nacimientos");
        st.executeUpdate("DROP TABLE defunciones");
    }

}
