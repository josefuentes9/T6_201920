package controller;

import java.io.IOException;
import java.util.Scanner;

import model.logic.MVCModelo;
import view.MVCView;

public class Controller {

	/* Instancia del Modelo*/
	private MVCModelo modelo;

	/* Instancia de la Vista*/
	private MVCView view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new MVCView();
		modelo = new MVCModelo();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				System.out.println("--------- \nCargar los datos: ");
				try {
					modelo.cargar();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				break;

			case 2:
				view.printMessage("-----consultar Zona por Id--------");
				view.printMessage("Escriba el id de la zona a consultar:");
				String id=lector.next();
				modelo.consultarZonaporId(id);
				break;

			case 3:
				
				view.printMessage("--------consultar Zonas por Id en un rango--------");
				view.printMessage("Escriba el rango  minimo (id de las zonas) a consultar:");
				String min=lector.next();
				view.printMessage("Escriba el rango  maximo (id de las zonas) a consultar:");
				String max=lector.next();
				modelo.consultarZonaporIdRango(min,max);
				view.printMessage("ya lo envie");
				break;
			case 4:
				System.out.println("altura arbol"); 
				modelo.llenartabla();
				break;	
			case 5:
				System.out.println("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;

			default: 
				System.out.println("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}
