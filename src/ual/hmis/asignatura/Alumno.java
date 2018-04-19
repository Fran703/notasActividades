package ual.hmis.asignatura;

import java.util.ArrayList;
import java.util.*;

public class Alumno {

	private String nombre;
	private ArrayList<Actividad> actividadesAsignadas;


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Actividad> getActividadesAsignadas() {
		return actividadesAsignadas;
	}

	public void setActividadesAsignadas(ArrayList<Actividad> actividadesAsignadas) {
		this.actividadesAsignadas = actividadesAsignadas;
	}

	public double calcularNotaActividad(String nombreActividad) {
		ArrayList<Ejercicio> ejerciciosAct = new ArrayList<Ejercicio>();
		Actividad act = new Actividad();
		for(Actividad a: actividadesAsignadas) {
			if(a.getNombre().equals(nombreActividad)) {
				act = a;
				ejerciciosAct = a.getEjercicios();
			}
		}
		double punt = 0;
		for(Ejercicio e: ejerciciosAct) {
			punt = punt + e.getPuntuacion();
		}
		act.setPuntuacionTotal(punt);
		return punt;
	}
}