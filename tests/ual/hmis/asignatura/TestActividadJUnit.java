package ual.hmis.asignatura;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import ual.hmis.asignatura.*;

public class TestActividadJUnit {
	
	@Test
	public void testNotasActividad(){
		
		//Creamos las actividades existentes
		Ejercicio ej1 = new Ejercicio();
		Ejercicio ej2 = new Ejercicio();
		Ejercicio ej3 = new Ejercicio();
		Ejercicio ej4 = new Ejercicio();
		Ejercicio ej5 = new Ejercicio();
		
		//Le asignamos las puntuaciones del alumno en dichos ejercicios
		ej1.setPuntuacion(8.5);
		ej2.setPuntuacion(4.5);
		ej3.setPuntuacion(6.75);
		ej4.setPuntuacion(7);
		ej5.setPuntuacion(4.25);
		
		//Creamos actividades distintas
		Actividad ac1 = new Actividad();
		ac1.setNombre("Actividad 1");
		Actividad ac2 = new Actividad();
		ac2.setNombre("Actividad 2");
		Actividad ac3 = new Actividad();
		ac3.setNombre("Actividad 3");
		Actividad ac4 = new Actividad();
		ac4.setNombre("Actividad 4");
		
		//A cada actividad le asignamos ejercicios diferentes
		ArrayList<Ejercicio> e1 = new ArrayList<Ejercicio>();
		ArrayList<Ejercicio> e2 = new ArrayList<Ejercicio>();
		ArrayList<Ejercicio> e3 = new ArrayList<Ejercicio>();
		ArrayList<Ejercicio> e4 = new ArrayList<Ejercicio>();
		
		//Actividad 1 con Ejercicios 1,3 y 5
		e1.add(ej1);
		e1.add(ej3);
		e1.add(ej5);		
		ac1.setEjercicios(e1);
		
		//Actividad 2 con Ejercicios 1,4 y 5
		e2.add(ej1);
		e2.add(ej4);
		e2.add(ej5);		
		ac2.setEjercicios(e2);
		
		//Actividad 3 con Ejercicios 2,3 y 4
		e3.add(ej2);
		e3.add(ej3);
		e3.add(ej4);		
		ac3.setEjercicios(e3);
		
		//Actividad 4 con Ejercicios 1 y 2
		e4.add(ej1);
		e4.add(ej2);		
		ac4.setEjercicios(e4);
		
		//Creamos el alumno que ha realizado los ejercicios, tendrá 
		//asignado todas las actividades creadas anteriormente
		Alumno pepe = new Alumno();
		ArrayList<Actividad> actividadesAsignadas = new ArrayList<Actividad>();
		actividadesAsignadas.add(ac1);
		actividadesAsignadas.add(ac2);
		actividadesAsignadas.add(ac3);
		actividadesAsignadas.add(ac4);
		pepe.setActividadesAsignadas(actividadesAsignadas);

		double puntuacionAc1 = pepe.calcularNotaActividad("Actividad 1");
		double puntuacionAc2 = pepe.calcularNotaActividad("Actividad 2");
		double puntuacionAc3 = pepe.calcularNotaActividad("Actividad 3");
		double puntuacionAc4 = pepe.calcularNotaActividad("Actividad 4");
		assertEquals(puntuacionAc1, 19.5, 0.0);
		assertEquals(puntuacionAc2, 19.75, 0.0);
		assertEquals(puntuacionAc3, 18.25, 0.0);
		assertEquals(puntuacionAc4, 13.0, 0.0);
	}
	
	@Test
	public void testActividad(){
		
		Actividad ac1 = new Actividad();
		Ejercicio ej1 = new Ejercicio();
		Ejercicio ej2 = new Ejercicio();
		ArrayList<Ejercicio> e = new ArrayList<Ejercicio>();
		e.add(ej1);
		e.add(ej2);
		ac1.setEjercicios(e);
		ac1.setApta(true);
		boolean esApta = ac1.isApta();
		ac1.setPuntuacionTotal(100.5);
		double punt = ac1.getPuntuacionTotal();
		ac1.agregarEjercicioCalificado("Matrices", 7.5);
		String nombre = ac1.getEjercicios().get(2).getNombre();
		double puntEje = ac1.getEjercicios().get(2).getPuntuacion();
		
		assertEquals(esApta, true);
		assertEquals(punt, 100.5, 0.0);
		assertEquals(nombre, "Matrices");
		assertEquals(puntEje, 7.5, 0.0);
	}
	
	@Test
	public void testAlumno(){
		
		Alumno pepe = new Alumno();
		pepe.setNombre("Pepe");
		String nombre = pepe.getNombre();
		Actividad ac1 = new Actividad();
		Actividad ac2 = new Actividad();
		ArrayList<Actividad> actividadesAsignadas = new ArrayList<Actividad>();
		actividadesAsignadas.add(ac1);
		actividadesAsignadas.add(ac2);
		pepe.setActividadesAsignadas(actividadesAsignadas);
		ArrayList<Actividad> actividadesAsignadas2 = new ArrayList<Actividad>();
		actividadesAsignadas2 = pepe.getActividadesAsignadas();
		
		assertEquals(nombre, "Pepe");
	}
	
	@Test
	public void testProfesor(){
		
		Profesor pr = new Profesor();
		Ejercicio ej1 = new Ejercicio();
		Ejercicio ej2 = new Ejercicio();
		Actividad ac1 = new Actividad();
		ac1.setNombre("ac1");
		Actividad ac2 = new Actividad();
		ac2.setNombre("ac2");
		ArrayList<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
		ejercicios.add(ej1);
		ejercicios.add(ej2);
		ac1.setEjercicios(ejercicios);
		ac2.setEjercicios(ejercicios);
		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		actividades.add(ac1);
		actividades.add(ac2);
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		Alumno Fran = new Alumno();
		Fran.setActividadesAsignadas(actividades);
		for(Actividad a: Fran.getActividadesAsignadas()) {
			for(Ejercicio e: a.getEjercicios()) {
				e.setPuntuacion(5);
			}
		}		
		alumnos.add(Fran);
		pr.setAlumnos(alumnos);
		pr.calificarAlumnos();

		for(Actividad a: Fran.getActividadesAsignadas()) {
			assertEquals(a.isApta(), true);
		}
		
		for(Actividad a: Fran.getActividadesAsignadas()) {
			for(Ejercicio e: a.getEjercicios()) {
				e.setPuntuacion(0);
			}
		}
		pr.calificarAlumnos();
		for(Actividad a: Fran.getActividadesAsignadas()) {
			assertEquals(a.isApta(), false);
		}
	}
}