import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class LibretaDeNotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, ArrayList<Float>> calificaciones = new HashMap<>();

        System.out.println("Ingrese la cantidad de alumnos en la sala de generation: ");
        int cantidadAlumnos = sc.nextInt();
        while (cantidadAlumnos <= 0) {
            System.out.println("Parametros no aceptados");
            System.out.println("Ingrese la cantidad de alumnos: ");
            cantidadAlumnos = sc.nextInt();
        }

        System.out.println("Ingrese la cantidad de notas que tienes: ");
        int cantidadNotas = sc.nextInt();

        while (cantidadNotas <= 0) {
            System.out.println("Error!!! Parametro no aceptado");
            System.out.println("Ingrese la cantidad de notas: ");
            cantidadNotas = sc.nextInt();
        }
        System.out.println();



        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println("Ingrese nombre del alumno " + (i + 1) + ":");
            String nombreAlumno = sc.next();
            ArrayList<Float> notas = new ArrayList<>();

            // Ingresa las notas
            for (int j = 0; j < cantidadNotas; j++) {
                System.out.println("Ingrese la nota " + (j + 1) + " de " + nombreAlumno + ":");
                System.out.println("Notas del 1-10 (Incluye decimales)");
                Float notaAlumno = sc.nextFloat();

                // Validación de la nota
                while (notaAlumno > 10 || notaAlumno < 0) {
                    System.out.println("Error!!! Nota no aceptada");
                    System.out.println("Ingrese la nota " + (j + 1) + " de " + nombreAlumno + ":");
                    System.out.println("Notas del 1-10 (Incluye decimales)");
                    notaAlumno = sc.nextFloat();
                }
                notas.add(notaAlumno);
            }
            calificaciones.put(nombreAlumno, notas);
            System.out.println();
        }

        System.out.println("---- Informe de Notas ----");

        /** Recorrer el HashMap y Evaluar Calificaciones **/
        for (String nombre : calificaciones.keySet()) {
            ArrayList<Float> notas = calificaciones.get(nombre);

            float sumaNotas = 0f;
            float promedio = 0f;
            float maxNotas = 0f;
            float minNotas = 10f;


            for (Float nota : notas) {
                sumaNotas += nota;
                //Máxima nota
                if (nota > maxNotas) {
                    maxNotas = nota;
                }
                //Mínima nota
                if (nota < minNotas) {
                    minNotas = nota;
                }
            }

            //Calculo de el promedio
            promedio = sumaNotas / notas.size();

            System.out.println("-- " + nombre.toUpperCase());
            System.out.println("Notas: " + notas);
            System.out.println("Promedio: " + promedio);
            System.out.println("Nota Máxima: " + maxNotas);
            System.out.println("Nota Mínima: " + minNotas);
            System.out.println();
        }
        /** Menú de Opciones **/
        int opciones;
        do {
            System.out.println("---- Menu de opciones ----");
            System.out.println("1. ingresa el Promedio de Notas por Estudiante.");
            System.out.println("2. ingresa si la Nota es Aprobatoria o Reprobatoria por Estudiante.");
            System.out.println("3. ingresa si la Nota está por Sobre o por Debajo del Promedio por Estudiante.");
            System.out.println("0. Salir del menu");
            System.out.println("Ingrese una opcion:");
            opciones = sc.nextInt();
            System.out.println();

            switch (opciones) {
                case 1:
                    for (String nombre : calificaciones.keySet()) {

                        float sumaNotas = 0f;
                        float promedio = 0f;
                        ArrayList<Float> notas = calificaciones.get(nombre);

                        for (Float nota : notas) {
                            sumaNotas += nota;
                        }
                        promedio = sumaNotas / notas.size();

                        System.out.println("Promedio de " + nombre + ": " + promedio);
                    }
                    break;

                case 2:
                    for (String nombre : calificaciones.keySet()) {
                        float aprobado = 4f;
                        int contador = 0;
                        ArrayList<Float> notas = calificaciones.get(nombre);
                        System.out.println("-- Ils nforme de " + nombre);

                        for (float nota : notas) {
                            contador++;
                            if (nota >= aprobado) {
                                System.out.println("Nota " + contador + ": Aprobado");
                            } else {
                                System.out.println("Nota " + contador + ": Reprobado");
                            }
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    float sumaTotal = 0f;
                    int notasTotal = cantidadAlumnos * cantidadNotas;

                    for (String nombre : calificaciones.keySet()) {
                        ArrayList<Float> notas = calificaciones.get(nombre);
                        for (float nota : notas) {
                            sumaTotal += nota;
                        }
                    }

                    float promedioFinal = sumaTotal / notasTotal;

                    for (String nombre : calificaciones.keySet()) {
                        ArrayList<Float> notas = calificaciones.get(nombre);
                        int contador = 0;

                        System.out.println("Informe del Estudiante " + nombre);
                        for (float nota : notas) {
                            contador++;
                            if (nota > promedioFinal) {
                                System.out.println("Nota " + contador + ": Sobre");
                            } else if (nota < promedioFinal) {
                                System.out.println("Nota " + contador + ": Debajo");
                            } else {
                                System.out.println("Nota " + contador + ": Es igual");
                            }
                        }
                        System.out.println();
                    }
                    break;

                case 0:
                    System.out.println("Saliendo");
                    break;

                default:
                    System.out.println("Error" + "\n "+ "Ingrese un dato que se encuentre");
                    break;
            }
            System.out.println();
        } while (opciones != 0);
        System.out.println("Gracias");
    }
}