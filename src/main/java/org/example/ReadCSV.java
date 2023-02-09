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

public class ReadCSV {
    Connection connection;

    public ReadCSV(Connection connection) {
        this.connection = connection;
    }


    public void ReadCsvAcontecimientos() throws ClassNotFoundException, SQLException, IOException {
        int contador = 1;
        FileReader fileReader=  new FileReader("src/main/resources/Acontecimientos.csv");

        String sql = "INSERT INTO acontecimientos(id,fecha,year,descripcion) VALUES  (DEFAULT,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        List<List<String>> records = new ArrayList<List<String>>();

        try (CSVReader csvReader = new CSVReader(fileReader);) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

        for (List<String> l : records) {
            String defaultS = "DEFAULT";
            if (contador != 1) {
                try {
                    String[] parts = l.get(0).split("-");
                    if (parts[0].length() < 4) {
                        String year = StringUtils.leftPad(parts[0].toString(), 4, '0');
                        String correctDate = year + "-" + parts[1].toString() + "-" + parts[2].toString();
                      //  System.out.println(correctDate);
                      //  String insert = "INSERT INTO acontecimientos(id,fecha,year,descripcion) VALUES (" + defaultS + ",'" + correctDate + "'," + l.get(1).toString() + ",'" + l.get(2).toString() + "')";
                        //st.execute(insert);

                        preparedStatement.clearParameters();
                        preparedStatement.setDate(1, Date.valueOf(correctDate));
                        preparedStatement.setInt(2, Integer.parseInt(l.get(1)));
                        preparedStatement.setString(3, l.get(2).toString());
                        preparedStatement.executeUpdate();
                        contador++;


                    } else {

                       // String insert = "INSERT INTO acontecimientos(id,fecha,year,descripcion) VALUES (" + defaultS + ",'" + l.get(0).toString() + "'," + l.get(1).toString() + ",'" + l.get(2).toString() + "')";

                        preparedStatement.clearParameters();
                        preparedStatement.setDate(1, Date.valueOf(l.get(0)));
                        preparedStatement.setInt(2, Integer.parseInt(l.get(1)));
                        preparedStatement.setString(3, l.get(2).toString());
                        preparedStatement.executeUpdate();
                        contador++;

                    }
                } catch (SQLException e) {
                    System.out.println("INSERT INTO acontecimientos(id,fecha,year, descripcion) VALUES (" + defaultS + ",'" + l.get(0).toString() + "'," + l.get(1).toString() + ",'" + l.get(2).replace("'", "").replace("(", "").replace(")", "") + "')");
                    contador++;
                }
            } else {
                contador++;
            }

        }
        System.out.println("Acontecimientos.csv Importado");
        //connection.close();
    }
    public void ReadCsvNacimientos() throws ClassNotFoundException, SQLException, IOException {
        FileReader fileReader=  new FileReader("src/main/resources/Nacimientos.csv");
        int contador = 1;
        //Carreguem el driver de postgreSQL
        String sql = "INSERT INTO nacimientos( id, fecha, year_nacimiento, year_defuncion, nombre, descripcion) VALUES  (DEFAULT,?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);


        List<List<String>> records = new ArrayList<List<String>>();

        try (CSVReader csvReader = new CSVReader(fileReader);) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

        for (List<String> l : records) {
            String defaultS = "DEFAULT";
            if (contador != 1) {
                try {

                    String[] parts = l.get(0).split("-");
                    if (parts[0].length() < 4 || parts[2].contains(" ")||parts[1].contains(" ")||!l.get(2).matches("[0-9]+")||l.get(2).length()>4) {
                        String year = StringUtils.leftPad(parts[0].toString(), 4, '0');
                        String correctDate = year + "-" + parts[1].toString().replace(" ","") + "-" + parts[2].toString().replace(" ","");

                       // System.out.println(correctDate);
                       // String insert = "INSERT INTO acontecimientos(id,fecha,year,descripcion) VALUES (" + defaultS + ",'" + correctDate + "'," + l.get(1).toString() + ",'" + l.get(2).toString() + "')";
                        //st.execute(insert);
                        if (!l.get(2).matches("[0-9]+")||l.get(2).length()>4){
                            preparedStatement.clearParameters();
                            preparedStatement.setDate(1, Date.valueOf(correctDate));
                            preparedStatement.setInt(2, Integer.parseInt(l.get(1)));
                            preparedStatement.setInt(3, -1);
                            preparedStatement.setString(4, l.get(3).toString());
                            preparedStatement.setString(5, l.get(4).toString());
                            preparedStatement.executeUpdate();
                            contador++;
                        }
                        else{
                            preparedStatement.clearParameters();
                            preparedStatement.setDate(1, Date.valueOf(correctDate));
                            preparedStatement.setInt(2, Integer.parseInt(l.get(1)));
                            preparedStatement.setInt(3, Integer.parseInt(l.get(2)));
                            preparedStatement.setString(4, l.get(3).toString());
                            preparedStatement.setString(5, l.get(4).toString());
                            preparedStatement.executeUpdate();
                            contador++;
                        }


                    } else {



                       // String insert = "INSERT INTO acontecimientos(id,fecha,year,descripcion) VALUES (" + defaultS + ",'" + l.get(0).toString() + "'," + l.get(1).toString() + ",'" + l.get(2).toString() + "')";
                        //  st.execute(insert);
                        preparedStatement.clearParameters();
                        preparedStatement.setDate(1, Date.valueOf(l.get(0)));
                        preparedStatement.setInt(2, Integer.parseInt(l.get(1)));
                        preparedStatement.setInt(3, Integer.parseInt(l.get(2)));
                        preparedStatement.setString(4, l.get(3).toString());
                        preparedStatement.setString(5, l.get(4).toString());

                        preparedStatement.executeUpdate();
                        contador++;
                    }


                } catch (Exception e) {
                    System.out.println("***ERROR***, INSERT INTO nacimientos( id, fecha, year_nacimiento, year_defuncion, nombre, descripcion) VALUES (" + defaultS + ",'" + l.get(0).toString() + "'," + l.get(1).toString() + "," + l.get(2).toString()+ ",'"+l.get(3).toString() +"','"+ l.get(4).toString() + "')");
                    contador++;
                }
            } else {
                contador++;
            }

        }
        System.out.println("Nacimientos.csv Importado");
       // connection.close();
    }
    public void ReadCsvDefunciones() throws ClassNotFoundException, SQLException, IOException {
        int contador = 1;
        FileReader fileReader=  new FileReader("src/main/resources/Defunciones.csv");
        //Carreguem el driver de postgreSQL
        String sql = "INSERT INTO defunciones( id, fecha, year_defuncion, year_nacimiento, nombre, descripcion) VALUES  (DEFAULT,?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);


        List<List<String>> records = new ArrayList<List<String>>();

        try (CSVReader csvReader = new CSVReader(fileReader);) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

        for (List<String> l : records) {
            String defaultS = "DEFAULT";
            if (contador != 1) {
                try {

                    String[] parts = l.get(0).split("-");
                    if (parts[0].length() < 4) {
                        String year = StringUtils.leftPad(parts[0].toString(), 4, '0');
                        String correctDate = year + "-" + parts[1].toString() + "-" + parts[2].toString();
                        String insert = "INSERT INTO acontecimientos(id,fecha,year,descripcion) VALUES (" + defaultS + ",'" + correctDate + "'," + l.get(1).toString() + ",'" + l.get(2).toString() + "')";
                        //st.execute(insert);

                        preparedStatement.clearParameters();
                        preparedStatement.setDate(1, Date.valueOf(correctDate));
                        preparedStatement.setInt(2, Integer.parseInt(l.get(1)));
                        preparedStatement.setInt(3, Integer.parseInt(l.get(2)));
                        preparedStatement.setString(4, l.get(3).toString());
                        preparedStatement.setString(5, l.get(4).toString());

                        preparedStatement.executeUpdate();
                        contador++;


                    } else {



                        //String insert = "INSERT INTO acontecimientos(id,fecha,year,descripcion) VALUES (" + defaultS + ",'" + l.get(0).toString() + "'," + l.get(1).toString() + ",'" + l.get(2).toString() + "')";
                        //  st.execute(insert);
                    preparedStatement.clearParameters();
                    preparedStatement.setDate(1, Date.valueOf(l.get(0)));
                    preparedStatement.setInt(2, Integer.parseInt(l.get(1)));
                    preparedStatement.setInt(3, Integer.parseInt(l.get(2)));
                    preparedStatement.setString(4, l.get(3).toString());
                    preparedStatement.setString(5, l.get(4).toString());

                    preparedStatement.executeUpdate();
                    contador++;
                    }


                } catch (Exception e) {
                    System.out.println("***ERROR***, INSERT INTO defunciones(id,fecha,year, descripcion) VALUES (" + defaultS + ",'" + l.get(0).toString() + "'," + l.get(1).toString() + "," + l.get(2).toString()+ ",'"+l.get(3).toString() +"','"+ l.get(4).toString() + "')");
                    contador++;
                }
            } else {
                contador++;
            }

        }
        System.out.println("Defunciones.csv Importado");

        // connection.close();
    }

}