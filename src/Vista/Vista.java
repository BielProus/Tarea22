package Vista;

import java.util.Scanner;

public class Vista {

	public int Menu;
	public int MenuCRUD;
	Scanner teclat = new Scanner(System.in);

	public int menuPrincipal() {
		System.out.println("1.Inicializar Tablas\n" + "2.Insertar datos\n" + "3.Borrar Tabla\n" + "4.CRUD\n" + "5.Salir\n");
		return Menu=teclat.nextInt();
	}
	
	public int menuCRUD() {
		System.out.println("1.Añadir\n" + "2.Buscar\n" + "3.Listar\n" + "4.Actualizar\n" + "5.Borrar\n" + "6.Salir\n");
		return MenuCRUD=teclat.nextInt();
	}
	
	public void missatge(String missatge) {
		System.out.println(missatge + "\n");
	}
	
	public void listarRegistros(String[][] matriu) {
		System.out.println("IdPieza - IdProveedor - Precio");
		for (int f=0;f<matriu.length;f++) {
			System.out.println("............................");
			for(int c=0;c<matriu[f].length;c++) {
				System.out.print(matriu[f][c]+"............................");
			}
			System.out.println();
		}
		System.out.println("............................");
	}
	
	public int idPieza,Precio;
	public char idProveedor;
	
	public int getIdPieza() {
		System.out.println("idPieza");
		idPieza = teclat.nextInt();
		return idPieza;
	}
	public int getPrecio() {
		System.out.println("Precio");
		Precio = teclat.nextInt();
		return Precio;
	}
	public char getidProveedor() {
		System.out.println("idProveedor");
		idProveedor = teclat.next().charAt(0);
		return idProveedor;
	}
}
