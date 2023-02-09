package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EfemeridesController {

    private Connection connection;

    public EfemeridesController(Connection connection) {
        this.connection = connection;
    }

    public void showAcontecimientos(int result) throws SQLException, IOException {

        Statement st = connection.createStatement();
        ResultSet rs;

        rs = st.executeQuery("SELECT * FROM acontecimientos OFFSET "+result+ " ROWS" +
                "FETCH NEXT 200 ROWS ONLY;");
        while (rs.next()) {
            System.out.println("id: " + rs.getString("id") + " " +
                    "Fecha: " + rs.getString("fecha") + " " +
                    "Year: " + rs.getString("year") + " " +
                    "Descripcion: " + rs.getString("descripcion") + " "
                  //  "Court name: " + rs.getString("court_name")
                      );
        }

        rs.close();
        st.close();
    }

    public void showAcontecimientosPorCampo(String column , String value) throws SQLException, IOException {

        Statement st = connection.createStatement();
        ResultSet rs = null;
        try {


            rs = st.executeQuery("SELECT * FROM acontecimientos WHERE " + column + " LIKE '%" + value + "%'");
            while (rs.next()) {
                System.out.println("id: " + rs.getString("id") + " " +
                                "Fecha: " + rs.getString("fecha") + " " +
                                "Year: " + rs.getString("year") + " " +
                                "Descripcion: " + rs.getString("descripcion") + " "
                        //  "Court name: " + rs.getString("court_name")
                );
            }
        } catch (Exception e) {

             try {

                 rs = st.executeQuery("SELECT * FROM acontecimientos WHERE " + column + " =" + value );
                 while (rs.next()) {
                     System.out.println("id: " + rs.getString("id") + " " +
                                     "Fecha: " + rs.getString("fecha") + " " +
                                     "Year: " + rs.getString("year") + " " +
                                     "Descripcion: " + rs.getString("descripcion") + " "
                             //  "Court name: " + rs.getString("court_name")
                     );
                 }
             }
             catch (Exception ex){
                 rs = st.executeQuery("SELECT * FROM acontecimientos WHERE " + column + "= '" + value +"'");
                 while (rs.next()) {
                     System.out.println("id: " + rs.getString("id") + " " +
                                     "Fecha: " + rs.getString("fecha") + " " +
                                     "Year: " + rs.getString("year") + " " +
                                     "Descripcion: " + rs.getString("descripcion") + " "
                             //  "Court name: " + rs.getString("court_name")
                     );
                 }             }

            rs.close();
            st.close();
        }
    }

    public void showNacimientos(int result) throws SQLException, IOException {

        Statement st = connection.createStatement();
        ResultSet rs;

        rs = st.executeQuery("SELECT * FROM nacimientos OFFSET "+result+ " ROWS" +
                                "FETCH NEXT 200 ROWS ONLY;");
        while (rs.next()) {
            System.out.println("id: " + rs.getString("id") + " " +
                            "Fecha: " + rs.getString("fecha") + " " +
                            "Year Nacimiento: " + rs.getString("year_nacimiento") + " " +
                            "Year:Defuncion " + rs.getString("year_defuncion") + " " +
                            "Nombre: " + rs.getString("nombre") + " " +
                            "Descripcion: " + rs.getString("descripcion") + " "
                    //  "Court name: " + rs.getString("court_name")
            );
        }

        rs.close();
        st.close();
    }
    public void showNacimientosPorCampo(String column , String value) throws SQLException, IOException {

        Statement st = connection.createStatement();
        ResultSet rs = null;
        try {


            rs = st.executeQuery("SELECT * FROM nacimientos WHERE " + column + " LIKE '%" + value + "%'");
            while (rs.next()) {
                System.out.println("id: " + rs.getString("id") + " " +
                                "Fecha: " + rs.getString("fecha") + " " +
                                "Year Nacimiento: " + rs.getString("year_nacimiento") + " " +
                                "Year:Defuncion " + rs.getString("year_defuncion") + " " +
                                "Nombre: " + rs.getString("nombre") + " " +
                                "Descripcion: " + rs.getString("descripcion") + " "
                        //  "Court name: " + rs.getString("court_name")
                );
            }
        } catch (Exception e) {

            try {

                rs = st.executeQuery("SELECT * FROM nacimientos WHERE " + column + " =" + value );
                while (rs.next()) {
                    System.out.println("id: " + rs.getString("id") + " " +
                                    "Fecha: " + rs.getString("fecha") + " " +
                                    "Year Nacimiento: " + rs.getString("year_nacimiento") + " " +
                                    "Year:Defuncion " + rs.getString("year_defuncion") + " " +
                                    "Nombre: " + rs.getString("nombre") + " " +
                                    "Descripcion: " + rs.getString("descripcion") + " "
                            //  "Court name: " + rs.getString("court_name")
                    );
                }
            }
            catch (Exception ex){
                rs = st.executeQuery("SELECT * FROM nacimientos WHERE " + column + "= '" + value +"'");
                while (rs.next()) {
                    System.out.println("id: " + rs.getString("id") + " " +
                                    "Fecha: " + rs.getString("fecha") + " " +
                                    "Year Nacimiento: " + rs.getString("year_nacimiento") + " " +
                                    "Year:Defuncion " + rs.getString("year_defuncion") + " " +
                                    "Nombre: " + rs.getString("nombre") + " " +
                                    "Descripcion: " + rs.getString("descripcion") + " "
                            //  "Court name: " + rs.getString("court_name")
                    );
                }             }

            rs.close();
            st.close();
        }
    }
    public void showDefunciones(int result) throws SQLException, IOException {

        Statement st = connection.createStatement();
        ResultSet rs;

        rs = st.executeQuery("SELECT * FROM defunciones OFFSET "+result+ " ROWS" +
                "FETCH NEXT 200 ROWS ONLY;");
        while (rs.next()) {
            System.out.println("id: " + rs.getString("id") + " " +
                            "Fecha: " + rs.getString("fecha") + " " +
                            "Year:Defuncion " + rs.getString("year_defuncion") + " " +
                            "Year Nacimiento: " + rs.getString("year_nacimiento") + " " +
                            "Nombre: " + rs.getString("nombre") + " " +
                            "Descripcion: " + rs.getString("descripcion") + " "
                    //  "Court name: " + rs.getString("court_name")
            );
        }

        rs.close();
        st.close();
    }
    public void showDefuncionesPorCampo(String column , String value) throws SQLException, IOException {

        Statement st = connection.createStatement();
        ResultSet rs = null;
        try {


            rs = st.executeQuery("SELECT * FROM defunciones WHERE " + column + " LIKE '%" + value + "%'");
            while (rs.next()) {
                System.out.println("id: " + rs.getString("id") + " " +
                                "Fecha: " + rs.getString("fecha") + " " +
                                "Year:Defuncion " + rs.getString("year_defuncion") + " " +
                                "Year Nacimiento: " + rs.getString("year_nacimiento") + " " +
                                "Nombre: " + rs.getString("nombre") + " " +
                                "Descripcion: " + rs.getString("descripcion") + " "
                        //  "Court name: " + rs.getString("court_name")
                );
            }
        } catch (Exception e) {

            try {

                rs = st.executeQuery("SELECT * FROM defunciones WHERE " + column + " =" + value );
                while (rs.next()) {
                    System.out.println("id: " + rs.getString("id") + " " +
                                    "Fecha: " + rs.getString("fecha") + " " +
                                    "Year:Defuncion " + rs.getString("year_defuncion") + " " +
                                    "Year Nacimiento: " + rs.getString("year_nacimiento") + " " +
                                    "Nombre: " + rs.getString("nombre") + " " +
                                    "Descripcion: " + rs.getString("descripcion") + " "
                            //  "Court name: " + rs.getString("court_name")
                    );
                }
            }
            catch (Exception ex){
                rs = st.executeQuery("SELECT * FROM defunciones WHERE " + column + "= '" + value +"'");
                while (rs.next()) {
                    System.out.println("id: " + rs.getString("id") + " " +
                                    "Fecha: " + rs.getString("fecha") + " " +
                                    "Year:Defuncion " + rs.getString("year_defuncion") + " " +
                                    "Year Nacimiento: " + rs.getString("year_nacimiento") + " " +
                                    "Nombre: " + rs.getString("nombre") + " " +
                                    "Descripcion: " + rs.getString("descripcion") + " "
                            //  "Court name: " + rs.getString("court_name")
                    );
                }             }

            rs.close();
            st.close();
        }
    }

}


