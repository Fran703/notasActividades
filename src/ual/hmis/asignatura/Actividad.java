package ual.hmis.asignatura;

import java.util.ArrayList;
import java.util.*;

public class Actividad {

	private String nombre; // nombre de la actividad
	private ArrayList<Ejercicio> ejercicios;
	private boolean apta;
	private double puntuacionTotal;


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Ejercicio> getEjercicios() {
		return ejercicios;
	}

	public void setEjercicios(ArrayList<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}

	public boolean isApta() {
		return apta;
	}

	public void setApta(boolean apta) {
		this.apta = apta;
	}


	public double getPuntuacionTotal() {
		return this.puntuacionTotal;
	}

	public void setPuntuacionTotal(double value) {
		this.puntuacionTotal = value;
	}

	public void agregarEjercicioCalificado(String nombreEjercicio, double puntuacion) {

		Ejercicio nuevoEjercicio = new Ejercicio();

		nuevoEjercicio.setNombre(nombreEjercicio);
		nuevoEjercicio.setPuntuacion(puntuacion);

		ejercicios.add(nuevoEjercicio);
	}

}
