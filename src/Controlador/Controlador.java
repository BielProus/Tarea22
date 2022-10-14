package Controlador;

import Modelo.Consulta;
import Vista.Vista;
import Modelo.Suministra;
import Vista.Vista;

public class Controlador {

	public static void main(String[] args) {
		Vista vista = new Vista();
		Consulta consulta = new Consulta();
		
		int opcion=0, opcion2=0;
		do {
			opcion = vista.menuPrincipal();
			switch(opcion) {
			case 1:
				vista.missatge(consulta.inicializacionTabla());
				break;
			case 2:
				vista.missatge(consulta.inserirDatos());
				break;
			case 3:
				vista.missatge(consulta.borrarTabla());
				break;
			case 4:
				do {
					opcion2 = vista.menuCRUD();
					switch(opcion2) {
					case 1:
						vista.missatge("Datos del registro:");
						Suministra registrar=new Suministra(vista.getIdPieza(),vista.getidProveedor(),vista.getPrecio());
						vista.missatge(consulta.registrar(registrar));
						break;
					case 2:
						vista.missatge("Inserte el Precio que quiere buscar");
						vista.listarRegistros(consulta.buscar(vista.getPrecio()));
						break;
					case 3:
						vista.listarRegistros(consulta.mostrarTabla());
						break;
					case 4:
						vista.missatge("Datos nuevos del registro:");
						Suministra modificar=new Suministra(vista.getIdPieza(),vista.getidProveedor(),vista.getPrecio());
						vista.missatge("Registro que quiere modificar:");
						vista.missatge(consulta.actualizar(modificar,vista.getIdPieza(),vista.getidProveedor()));
						break;
					case 5:
						vista.missatge("Registro que quiere eliminar");
						vista.missatge(consulta.eliminar(vista.getIdPieza(),vista.getidProveedor()));
						break;
					case 6:
						vista.missatge("Has salido del CRUD");
						break;
					}
				}while(opcion2!=6);
				break;
			case 5:
				vista.missatge("Adios");
				break;
			}
		}while(opcion!=5);
	}
}
