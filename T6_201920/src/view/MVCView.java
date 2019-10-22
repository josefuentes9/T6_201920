package view;

import model.logic.MVCModelo;

public class MVCView 
{
	    /**
	     * Metodo constructor
	     */
	    public MVCView()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Cargar datos de Zonas");
			System.out.println("2. Consultar una zona por id.");
			System.out.println("3.Consultar las zonas con un id en un rango específico.");
			System.out.println("4. Altura Arbol");
			System.out.println("5. Exit");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(MVCModelo modelo)
		{
			// TODO implementar
		}
}
