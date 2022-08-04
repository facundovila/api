package com.example.demo;

import com.example.demo.model.Estaciones;
import org.jboss.resteasy.client.jaxrs.BasicAuthentication;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.core.Headers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {


		String URL_API_SAN_LUIS = DemoApplication.URL_API_SAN_LUIS;

		String URL_API_INTA = DemoApplication.URL_API_INTA;

		String URL_API_CORDOBA = DemoApplication.URL_API_CORDOBA;

		// Cliente para la conexión
		ResteasyClient client = new ResteasyClientBuilder().build();
		// Definición de URL
		ResteasyWebTarget target = client.target(URL_API_SAN_LUIS);

		ResteasyWebTarget target1 = client.target(URL_API_INTA);

		ResteasyWebTarget target2 = (ResteasyWebTarget) client.target(URL_API_CORDOBA).request().header("Authorization", "Token fb7d91496c44f6085b73c9a5196be5799d31f988");



		// Recogemos el resultado en una variable String
		String estacionesSanLuis = target.request(MediaType.APPLICATION_JSON).get(String.class);

		String estacionesInta = target1.request(MediaType.APPLICATION_JSON).get(String.class);

		String estacionesCordoba = target2.request(MediaType.APPLICATION_JSON).get(String.class);




		//Almacenamos la información del json en una lista java

		ArrayList<Estaciones> listaEstaciones = saveJsonToList(estacionesSanLuis, estacionesInta,  estacionesCordoba);


		imprimirLista(listaEstaciones);

		//mostrarEstacionesPorIdEstacion(18l, listaEstaciones);

		mostrarEstacionesPorIdPropietario(2l, listaEstaciones);



	}



	public static String URL_API_CORDOBA= "http://clima.bccba.com.ar/api/stations";

	public static String URL_API_INTA = "http://siga2.inta.gov.ar/sigarest/webresources/smn.estaciones/";

	public static String URL_API_SAN_LUIS = "http://wsestaciones.sanluis.gov.ar/Modulos/Datos/Datos.aspx?function=estaciones";




	private static void imprimirLista(ArrayList<Estaciones> listaEstaciones) {
		for (int i = 0; i < listaEstaciones.size(); i++) {
			System.out.println(listaEstaciones.get(i));
		}

	}
	private static void mostrarEstacionesPorIdEstacion(Long idEstacion, ArrayList<Estaciones> listaEstaciones){

		for (int i = 0 ; i< listaEstaciones.size(); i++){

			if(listaEstaciones.get(i).getId().equals(idEstacion)){

				System.out.println("la estacion con id " + idEstacion + "es " + listaEstaciones.get(i).getNombre());

			}

		}

	}

	private static void mostrarEstacionesPorIdPropietario(Long idPropietario, ArrayList<Estaciones> listaEstaciones){

		for (int i = 0 ; i< listaEstaciones.size(); i++){



			if(listaEstaciones.get(i).getIdPropietario().equals(idPropietario)){

				System.out.println("las estaciones con id propietario: " + idPropietario + " son " + listaEstaciones.get(i).getNombre());

			}

		}

	}


	private static ArrayList<Estaciones> saveJsonToList(String estacionesSanluis, String estacionesInta, String estacionesCordoba) {

		ArrayList<Estaciones> listaEstaciones = new ArrayList<>();

		Estaciones estacion;

		// esto es por que en la api viene como un objeto .
		JSONObject jsonEstacionAuxiliar =  new JSONObject(estacionesSanluis);

		JSONArray jsonarraySanLuis = jsonEstacionAuxiliar.getJSONArray("Estaciones");

		JSONArray jsonArrayInta = new JSONArray(estacionesInta);

		JSONArray jsonArrayCordoba = new JSONArray(estacionesCordoba);


		for (int i = 0; i < jsonarraySanLuis.length(); i++) {

			JSONObject jsonEstacionSanLuis = jsonarraySanLuis.getJSONObject(i);

			estacion = new Estaciones();

			estacion.setIdPropietario(8l);
			estacion.setId(jsonEstacionSanLuis.getLong(Estaciones.ID_ESTACION_SANLUIS));
			estacion.setEstado(jsonEstacionSanLuis.getBoolean(Estaciones.ESTADO));
			estacion.setAltura(jsonEstacionSanLuis.getString(Estaciones.ALTURA));
			estacion.setLatitud(jsonEstacionSanLuis.getString(Estaciones.LATITUD));
			estacion.setLongitud(jsonEstacionSanLuis.getString(Estaciones.LONGITUD));
			estacion.setSistema(jsonEstacionSanLuis.getString(Estaciones.SISTEMA));
			estacion.setCrepusculoMatutino(jsonEstacionSanLuis.getString(Estaciones.CREPUSCULO_MATUTINO));
			estacion.setCrepusculoVespertino(jsonEstacionSanLuis.getString(Estaciones.CREPUSCULO_VESPERTINO));
			estacion.setLocalidad(jsonEstacionSanLuis.getString(Estaciones.NOMBRE));


			listaEstaciones.add(estacion);

		}


		for(int i = 0; i < jsonArrayInta.length() ; i++ ){

			JSONObject jsonEstacionInta = jsonArrayInta.getJSONObject(i);
			estacion = new Estaciones();

			estacion.setIdPropietario(2l);
			estacion.setId(jsonEstacionInta.getLong(Estaciones.ID_ESTACION));
			estacion.setAltura(String.valueOf(jsonEstacionInta.getFloat(Estaciones.ALTURA_INTA)));
			estacion.setDescripcion(jsonEstacionInta.getString(Estaciones.DESC));
			estacion.setLatitud(String.valueOf(jsonEstacionInta.getFloat(Estaciones.LATITUD_INTA)));
			estacion.setLongitud(String.valueOf(jsonEstacionInta.getFloat(Estaciones.LONGITUD_INTA)));
			estacion.setLocalidad(jsonEstacionInta.getString(Estaciones.LOCALIDAD_INTA));
			estacion.setNombre(jsonEstacionInta.getString(Estaciones.NOMBRE_INTA));
			estacion.setProvincia(jsonEstacionInta.getString(Estaciones.PROVINCIA_INTA));
			estacion.setTipo(jsonEstacionInta.getString(Estaciones.TIPO_INTA));
			estacion.setUbicacion(jsonEstacionInta.getString(Estaciones.UBICACION_INTA));

			listaEstaciones.add(estacion);

		}


		for(int i = 0; i < jsonArrayCordoba.length() ; i++ ){

			JSONObject jsonEstacionCordoba = jsonArrayCordoba.getJSONObject(i);
			estacion = new Estaciones();

			estacion.setIdPropietario(3l);
			estacion.setId(jsonEstacionCordoba.getLong(Estaciones.ID_ESTACION));
			estacion.setCode(jsonEstacionCordoba.getLong(Estaciones.CODE));
			estacion.setNombre(jsonEstacionCordoba.getString(Estaciones.NOMBRE_REDES));
			estacion.setLocalidad(jsonEstacionCordoba.getString(Estaciones.LOCALIDAD_REDES));
			estacion.setLongitud(jsonEstacionCordoba.getString(Estaciones.LONGITUD_OMIXON));
			estacion.setLatitud(jsonEstacionCordoba.getString(Estaciones.LATITUD_OMIXON));


			listaEstaciones.add(estacion);

		}

		return listaEstaciones;

	}


}
