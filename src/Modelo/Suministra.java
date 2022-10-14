package Modelo;

public class Suministra {

		private int idPieza;
		private char idProveedor;
		private int Precio;
		
		public Suministra(int idPieza, char idProveedor, int Precio) {
			this.idPieza = idPieza;
			this.idProveedor = idProveedor;
			this.Precio = Precio;	
		}
		public int getIdPieza() {return idPieza;}
		public char getIdProveedor() {return idProveedor;}
		public int getPrecio() {return Precio;}
}
