package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EfemeridesMenu {
	private int option;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public EfemeridesMenu() {
		super();
	}

	public int mainMenu() {


		do {

			System.out.println(" \nMENU PRINCIPAL \n");

			System.out.println("1. Muestra Acontecimientos");
			System.out.println("2. Introduce, Edita, o Elimina Acontecimiento");
			System.out.println("3. Muestra Nacimientos");
			System.out.println("4. Introduce, Edita, o Elimina Nacimiento");
			System.out.println("5. Muestra Defunciones");
			System.out.println("6. Introduce, Edita, o Elimina Defuncion");
			System.out.println("7. Muestra efemérides por Campo");
			System.out.println("8. Borrar todo el contenido de la Base de datos");
			System.out.println("9. Regenerar contenido desde los Archivos Backup");
			System.out.println("10. Salir");
			System.out.println("Escoja opción: ");
			try {
				option = Integer.parseInt(br.readLine());
			} catch (NumberFormatException | IOException e) {
				System.out.println("valor no vàlid");
				e.printStackTrace();

			}

		} while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6 && option != 7
				&& option != 8 && option != 9 && option != 10);

		return option;
	}

	public Identity authenticate(int tries) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("============================ACB=============================");
		System.out.println("============================================================");
		System.out.println("Avís: tens " + (3 - tries) + " intents per loginarte");
		System.out.println("============================================================");
		System.out.println("Inserta nom del usuari: ");
		String user = br.readLine();
		System.out.println("Inserta contrasenya: ");
		String password = br.readLine();

		Identity identity = new Identity(user, password);
		return identity;

	}

	public int opcion1Menu() {
		System.out.println(" \nMENU OPCION 1 \n");
		System.out.println("1. Muestra Acontecimientos");
		System.out.println("2. Muestra Nacimientos que contengan un determinado valor");
		System.out.println("3. Volver");
		try {
			option = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("valor no vàlid");
			e.printStackTrace();

		}
		return option;
	}

	public int opcion2Menu() {
		System.out.println(" \nMENU OPCION 2 \n");

		System.out.println("1. Edita Acontecimientos que contengan un determinado valor");
		System.out.println("2. Volver");
		try {
			option = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("valor no vàlid");
			e.printStackTrace();

		}
		return option;
	}

	public int opcion3Menu() {
		System.out.println(" \nMENU OPCION 3 \n");

		System.out.println("1. Muestra NAcimientos");
		System.out.println("2. Muestra Nacimientos que contengan un determinado valor");
		System.out.println("3. Introduce, Edita, o Elimina Defuncion");
		try {
			option = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("valor no vàlid");
			e.printStackTrace();

		}
		return option;
	}

	public int opcion4Menu() {
		System.out.println(" \nMENU OPCION 4 \n");

		System.out.println("1. Edita Nacimientos que contengan un determinado valor");
		System.out.println("2. Volver");
		try {
			option = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("valor no vàlid");
			e.printStackTrace();

		}
		return option;
	}

	public int opcion5Menu() {
		System.out.println(" \nMENU OPCION 5 \n");
		System.out.println("1. Muestra Defunciones");
		System.out.println("3. Muestra Defunciones que contengan un determinado valor");
		System.out.println("4. Introduce, Edita, o Elimina Defuncion");
		try {
			option = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("valor no vàlid");
			e.printStackTrace();

		}

		return option;
	}
	public int opcion6Menu() {
		System.out.println(" \nMENU OPCION 6 \n");

		System.out.println("1. Edita Defunciones que contengan un determinado valor");
		System.out.println("2. Volver");
		try {
			option = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("valor no vàlid");
			e.printStackTrace();

		}

		return option;
	}
	public int opcion7Menu() {
		System.out.println(" \nMENU OPCION 7 \n");
		System.out.println("1. Introduce un campo de busqueda");
		System.out.println("2. Volver");
		try {
			option = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("valor no vàlid");
			e.printStackTrace();

		}
		return option;
	}
	public int opcion8Menu() {
		System.out.println(" \nMENU OPCION 8 \n");
		System.out.println("Seguro que quieres borrar todo el contenido de la Base de Datos?");
		System.out.println("1. Aceptar");
		System.out.println("2. Volver");
		try {
			option = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("valor no vàlid");
			e.printStackTrace();

		}
		return option;
	}
	public int opcion9Menu() {
		System.out.println(" \nMENU OPCION 9 \n");
		System.out.println("Seguro que quieres regenerar todos los registros desde los CSV de Backup?");
		System.out.println("1. Aceptar");
		System.out.println("2. Volver");
		try {
			option = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("valor no vàlid");
			e.printStackTrace();

		}
		return option;
	}

	public int opcion1_1Menu() {
		System.out.println(" \nMENU OPCION 1.1 \n");
		System.out.println("Introduce el numero de resultado desde el que quieres comenzar a listar. Se mostrarán 200 registros");
		try {
			option = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("valor no vàlid");
			e.printStackTrace();

		}
		return option;
	}


	public String opcion1_2Menu() {
		String parameters="";
		System.out.println(" \nMENU OPCION 1.2 \n");
		System.out.println("Introduce el campo y el valor que quieres comenzar a listar separado por una coma");
		System.out.println(" id          | \n" +
				" fecha       |\n" +
				" year        | \n" +
				" descripcion |");
		try {
			parameters = br.readLine();
		} catch (NumberFormatException | IOException e) {
			System.out.println("valor no vàlid");
			e.printStackTrace();

		}
		return parameters;
	}
	public int opcion3_1Menu() {
		System.out.println(" \nMENU OPCION 3.1 \n");
		System.out.println("Introduce el numero de resultado desde el que quieres comenzar a listar. Se mostrarán 200 registros");
		try {
			option = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("valor no vàlid");
			e.printStackTrace();

		}
		return option;
	}
	public String opcion3_2Menu() {
		String parameters="";
		System.out.println(" \nMENU OPCION 3.2 \n");
		System.out.println("Introduce el campo y el valor que quieres comenzar a listar separado por una coma");
		System.out.println(" id          | \n" +
				" fecha       |\n" +
				" year_nacimiento |\n" +
		        " year_defuncion  |\n" +
				" nombre       |\n" +
				" descripcion |");
		try {
			parameters = br.readLine();
		} catch (NumberFormatException | IOException e) {
			System.out.println("valor no vàlid");
			e.printStackTrace();

		}
		return parameters;
	}
	public int opcion5_1Menu() {
		System.out.println(" \nMENU OPCION 5.1 \n");
		System.out.println("Introduce el numero de resultado desde el que quieres comenzar a listar. Se mostrarán 200 registros");
		try {
			option = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("valor no vàlid");
			e.printStackTrace();

		}
		return option;
	}
	public String opcion5_2Menu() {
		String parameters="";
		System.out.println(" \nMENU OPCION 5.2 \n");
		System.out.println("Introduce el campo y el valor que quieres comenzar a listar separado por una coma");
		System.out.println(" id          | \n" +
				" fecha       |\n" +
				" year_defuncion  |\n" +
				" year_nacimiento |\n" +
				" nombre       |\n" +
				" descripcion |");
		try {
			parameters = br.readLine();
		} catch (NumberFormatException | IOException e) {
			System.out.println("valor no vàlid");
			e.printStackTrace();

		}
		return parameters;
	}

		public int opcion9_1Menu() {
		System.out.println(" \nMENU OPCION 9.1 \n");
		System.out.println("Elige un documento a regenerar");

		System.out.println("1. Acontecimientos.csv");
		System.out.println("2. Nacimientos.csv");
		System.out.println("3. Defunciones.csv");
		System.out.println("4. Todos Los Archivos");

			try {
			option = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("valor no vàlid");
			e.printStackTrace();

		}
		return option;
	}


}
