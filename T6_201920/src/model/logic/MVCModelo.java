package model.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.opencsv.CSVReader;

import model.data_structures.ArbolRojoNegro;
import model.data_structures.Queue;
import model.logic.Feature;
import model.logic.Properties;
import view.MVCView;
import model.logic.Geometry;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private ArbolRojoNegro<String, Feature> FeatureCollections;
	private FeatureCollection hola;
	private MVCView view;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo() {

		FeatureCollections = new ArbolRojoNegro<>();
	}

	public void cargar() throws IOException {
		cargarJsonArbol();
	}

	public void cargarJsonArbol() throws IOException {

		String path = "./data/bogota_cadastral.json";
		Gson gson = new Gson();
		JsonReader reader;
		/*
		 * try { reader = new JsonReader(new FileReader(path));
		 * FeatureCollection = gson.fromJson(reader, ArbolRojoNegro.class );
		 * view.printMessage("Numero Total de zonas:"+FeatureCollection.size());
		 * view.printMessage("Valor Minimo Movement id:"+FeatureCollection.min()
		 * );
		 * view.printMessage("Valor Maximo Movement id:"+FeatureCollection.max()
		 * ); } catch (FileNotFoundException e) { // TODO Auto-generated catch
		 * block System.out.println("error catch cargar"); e.printStackTrace();
		 * }
		 */
		try {
			System.out.println("paso1");
			reader = new JsonReader(new FileReader(path));
			reader.beginObject();
			// __________
			ArrayList<Coordinate> co = new ArrayList<Coordinate>();
			List<Feature> features = new ArrayList<Feature>();
			Properties pr = null;
			Geometry geo = null;
			Feature fe = null;
			String type3 = "";
			String type2 = "";
			String type = "";
			int i = 0;
			String key = "";

			// __________
			System.out.println("paso2");
			while (reader.hasNext()) {
				System.out.println("paso 4");
				String name = reader.nextName();
				if (name.equals("type")) {
					type = reader.nextString();
				}
				if (name.equals("features")) {
					System.out.println("paso 5");
					reader.beginArray();
					while (reader.hasNext()) {
						System.out.println("Se estan creando las Features");
						System.out.println("paso 6");
						// name= reader.nextName();
						reader.beginObject();

						while (reader.hasNext()) {

							System.out.println("paso 7");

							name = reader.nextName();
							if (name.equals("type")) {

								type2 = reader.nextString();
								System.out.println("paso 7a");
							}
							if (name.equals("geometry")) {
								System.out.println("paso 7b");
								reader.beginObject();

								while (reader.hasNext()) {
									System.out.println("Se  estan creando las Geometry");

									name = reader.nextName();
									if (name.equals("type")) {
										type3 = reader.nextString();
									}

									if (name.equals("coordinates")) {
										System.out.println("Se estan creando las coordenadas");
										reader.beginArray();
										while (reader.hasNext()) {
											reader.beginArray();
											while (reader.hasNext()) {
												reader.beginArray();
												while (reader.hasNext()) {
													reader.beginArray();

													double longitud = reader.nextDouble();

													double latitud = reader.nextDouble();

													Coordinate c = new Coordinate(longitud, latitud);
													co.add(c);

													reader.endArray();

												}

												System.out.println("paso1");
												reader.endArray();
											}

											System.out.println("paso2");

											reader.endArray();
										}
										System.out.println("paso3");
										reader.endArray();
									}

								}
								reader.endObject();

								geo = new Geometry(type3, co);
								System.out.println("Se  crearon las Geometry");
							}
							if (name.equals("properties")) {
								i++;
								System.out.println("paso 7c");
								reader.beginObject();

								int a = 0, c = 0;
								String b = "", d = "", g = "", h = "";
								double e = 0, f = 0;
								while (reader.hasNext()) {
									System.out.println("Se estan creando los properties");
									name = reader.nextName();
									if (name.equals("cartodb_id")) {
										a = reader.nextInt();
									}
									if (name.equals("scacodigo")) {
										b = reader.nextString();
									}
									if (name.equals("scatipo")) {
										c = reader.nextInt();
									}

									if (name.equals("scanombre")) {
										d = reader.nextString();
									}

									if (name.equals("shape_leng")) {
										e = reader.nextDouble();
									}

									if (name.equals("shape_area")) {
										f = reader.nextDouble();
									}

									if (name.equals("MOVEMENT_ID")) {
										g = reader.nextString();
										key = g;
									}

									if (name.equals("DISPLAY_NAME")) {
										h = reader.nextString();

									}
									System.out.println("Se Crearon los properties");
								}
								pr = new Properties(a, b, c, d, e, f, g, h);
								reader.endObject();

								fe = new Feature(type2, geo, pr);
								System.out.println(fe.getProperty().getScanombre());
								reader.endObject();
								// ___________________
								if (i < 1160) {
									reader.beginObject();
								}
								// _____________________
								features.add(fe);
							}
							System.out.println("Termino de crear un feature");

						}

					}
					reader.endArray();
				}

			}
			reader.endObject();
			hola = new FeatureCollection(features, type);
			for (int j = 0; j < hola.getFeatures().size(); j++) {
				FeatureCollections.put(hola.getFeatures().get(j).getProperty().getMOVEMENTID(),
						hola.getFeatures().get(j));

			}

		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error catch cargar");
			e.printStackTrace();
		}

	}

	public void consultarZonaporId(String MovementId) {
		Feature aux = FeatureCollections.get(MovementId);
		System.out.println("Movement id: " + MovementId);
		System.out.println("Nombre Zona: " + aux.getProperty().getScanombre());
		System.out.println("Perimetro zona: " + aux.getProperty().getShapeLeng() * 100 + "Km");
		System.out.println("Perimetro zona: " + aux.getProperty().getShapeArea() * 10000 + "Km^2");
		System.out.println("Numero de Puntos: " + aux.getGeometry().getCoordinates().size());
	}

	public void consultarZonaporIdRango(String Max, String Min) {
		 Iterable<String> hola=FeatureCollections.keys(Max,Min);
		Iterator iterador=hola.iterator();
		while ( iterador.hasNext()){
				System.out.println("no hago nada");
				Feature aux = FeatureCollections.get((String)iterador.next());
				System.out.println("Movement id: " + aux.getProperty().getMOVEMENTID());
				System.out.println("Nombre Zona: " + aux.getProperty().getScanombre());
				System.out.println("Perimetro zona: " + aux.getProperty().getShapeLeng() * 100 + "Km");
				System.out.println("Perimetro zona: " + aux.getProperty().getShapeArea() * 10000 + "Km^2");
				System.out.println("Numero de Puntos: " + aux.getGeometry().getCoordinates().size());
			}

		
	}
	public void llenartabla(){
		System.out.println("altura del arbol: "+FeatureCollections.height());
	}

}