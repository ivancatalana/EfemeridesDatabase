package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;

public class EfemeridesMain {

    public static void main(String[] args) throws IOException, SQLException, ParseException, ClassNotFoundException {
        EfemeridesMenu menu = new EfemeridesMenu();

        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection c = connectionFactory.connect();
        Class.forName("org.postgresql.Driver");

        String dbURL = "jdbc:postgresql://192.168.56.3:5432/ddbb";
        Connection c1 = DriverManager.getConnection(dbURL, "usuario", "password");

        EfemeridesController efemeridesController = new EfemeridesController(c);
        ReadCSV readCSV = new ReadCSV(c);
        CreateDB createDB=new CreateDB(c);

        //	PlayerController playerController = new PlayerController(c);


//		Connection conn = null;
//		Identity identity;
//		int option;
//		int intents = 0;
//		DBAccessor dbaccessor = new DBAccessor();
//		dbaccessor.init();
//		while (intents < 3 && conn == null) {
//			identity = menu.authenticate(intents);
//			// prova de test
//			identity.toString();
//
//			conn = dbaccessor.getConnection(identity);
//			intents++;
//		}
        int option = menu.mainMenu();
        while (option > 0 && option < 12) {
            switch (option) {
                case 1:
                    option = menu.opcion1Menu();
                    if (option == 1) {
                        efemeridesController.showAcontecimientos(menu.opcion1_1Menu());

                    } else if (option == 2) {
                             String query = menu.opcion1_2Menu();
                             String result[]=query.split(",");
                        System.out.println(result[0]+" "+result[1]);
                             efemeridesController.showAcontecimientosPorCampo(result[0],result[1]);

                    } else {
                        System.out.println("Introdueixi una de les opcions anteriors");
                        continue;
                    }
                    break;

                case 2:
                    option = menu.opcion2Menu();
                    if (option == 1) {


                    } else if (option == 2) {

                    } else if (option == 3) {

                    } else if (option == 4) {
                        break;

                    } else {
                        System.out.println("Introdueixi una de les opcions anteriors");
                        continue;
                    }
                    break;

                case 3:
                    option = menu.opcion3Menu();
                    if (option == 1) {
                        efemeridesController.showNacimientos(menu.opcion3_1Menu());

                    } else if (option == 2) {
                        String query = menu.opcion3_2Menu();
                        String result[]=query.split(",");
                        System.out.println(result[0]+" "+result[1]);
                        efemeridesController.showNacimientosPorCampo(result[0],result[1]);


                    } else {
                        System.out.println("Introdueixi una de les opcions anteriors");
                        continue;
                    }
                    break;

                case 4:
                    option = menu.opcion4Menu();
                    if (option == 1) {


                    } else if (option == 2) {

                    } else if (option == 3) {

                    } else if (option == 4) {
                        break;

                    } else {
                        System.out.println("Introdueixi una de les opcions anteriors");
                        continue;
                    }
                    break;

                case 5:
                    option = menu.opcion5Menu();
                    if (option == 1) {
                        efemeridesController.showDefunciones(menu.opcion5_1Menu());

                    } else if (option == 2) {
                        String query = menu.opcion5_2Menu();
                        String result[]=query.split(",");
                        System.out.println(result[0]+" "+result[1]);
                        efemeridesController.showDefuncionesPorCampo(result[0],result[1]);



                    } else {
                        System.out.println("Introdueixi una de les opcions anteriors");
                        continue;
                    }
                    break;

                case 6:
                    option = menu.opcion6Menu();
                    if (option == 1) {

                    } else if (option == 2) {

                    } else if (option == 3) {

                    } else if (option == 4) {
                        break;

                    } else {
                        System.out.println("Introdueixi una de les opcions anteriors");
                        continue;
                    }
                    break;

                case 7:
                    option = menu.opcion7Menu();
                    if (option == 1) {

                    } else if (option == 2) {

                    } else if (option == 3) {

                    } else if (option == 4) {
                        break;

                    } else {
                        System.out.println("Introdueixi una de les opcions anteriors");
                        continue;
                    }
                    break;

                case 8:
                    option = menu.opcion8Menu();
                    if (option == 1) {
                        // Eliminamos el contenido de las tablas
                        createDB.dropDBtables();
                        // Creamos las tablas
                        createDB.CreateDBTables();

                    } else if (option == 2) {
                         //break;
                    } else {
                        System.out.println("Introdueixi una de les opcions anteriors");
                        continue;
                    }
                    break;

                case 9:
                    option = menu.opcion9Menu();
                    if (option == 1) {
                        option=menu.opcion9_1Menu();
                        if (option == 1) {
                            readCSV.ReadCsvAcontecimientos();

                        } else if (option == 2) {
                            readCSV.ReadCsvNacimientos();

                        } else if (option == 3) {
                            readCSV.ReadCsvDefunciones();

                        } else if (option == 4) {

                            readCSV.ReadCsvAcontecimientos();

                            readCSV.ReadCsvNacimientos();

                            readCSV.ReadCsvDefunciones();

                        } else {
                            System.out.println("Introdueixi una de les opcions anteriors");
                            continue;
                        }
                        break;

                    } else if (option == 2) {


                    } else {
                        System.out.println("Introdueixi una de les opcions anteriors");
                        continue;
                    }
                    break;

                case 10:
                    System.out.println("Adios. ");
                    return;

                default:
                    System.out.println("Introdueixi una de les opcions anteriors");
                    break;

            }

            option = menu.mainMenu();
        }

    }

}
