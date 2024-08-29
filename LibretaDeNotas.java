import java.sql.SQLOutput;
import java.util.*;

public class LibretaDeNotas {
    public static void main(String[] args) {
        System.out.println("Bienvenido a tu Libreta de Notas!!");
        HashMap<String, ArrayList<Float>> calificaciones = new HashMap<>();
        //Map<Map<Map<String, ArrayList<Integer>>, ArrayList<Integer>>, ArrayList<Integer>> estudiantes = new HashMap<>();
        ArrayList<Float> notas = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor, ingrese la cantidad de alumnos");
        Integer cantidadAlumnos = sc.nextInt();
        System.out.println("Por favor, ingrese la cantidad de notas");
        Integer cantidadNotas = sc.nextInt();

        for (int i = 1; i <= cantidadAlumnos; i++) {
            ArrayList<Float> notasAlumnos = new ArrayList<>();
            System.out.println("Nombre del alumno " + i);
            String alumno = sc.next();
            for (int j = 1; j <= cantidadNotas; j++) {
                System.out.println("Ingresa las notas de " + alumno);
                float nota = sc.nextInt();
                notasAlumnos.add(nota);
            }
            calificaciones.put(alumno,notasAlumnos);
            for (String nombreAlumno : calificaciones.keySet()) {
                ArrayList<Float> notasAlumno = calificaciones.get(alumno);
                System.out.println(notasAlumnos);
                Double promedio = 0D;
                for (Float nota : notasAlumnos) {
                    promedio += nota;
                }
                promedio = promedio/notasAlumnos.size();
                System.out.println("La nota mas alta es: " + Collections.max(notasAlumnos));
                System.out.println("Lo nota mas baja es: " + Collections.min(notasAlumnos));

            }
            System.out.println("Ingresa una opción del menú: " + '\n' +
                    "1. Mostrar el Promedio de Notas por Estudiante. " + '\n' +
                    "2. Mostrar si la Nota es Aprobatoria o Reprobatoria por Estudiante. " + '\n' +
                    "3. Mostrar si la Nota está por Sobre o por Debajo del Promedio del Curso por Estudiante. " + '\n'+
                    "0 para Salir del Menú. "
            );
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    for (String nombreAlumno : calificaciones.keySet()) {
                        ArrayList<Float> notasAlumno = calificaciones.get(alumno);
                        System.out.println(notasAlumnos);
                        Double promedio = 0D;
                        for (Float nota : notasAlumnos) {
                            promedio += nota;
                        }
                        promedio = promedio/notasAlumnos.size();
                        System.out.println("El promedio de notas del alumno "+ alumno + " es de: "+ promedio);

                    }
                    break;
                case 2:
                    for (String nombreAlumno : calificaciones.keySet()) {
                        ArrayList<Float> notasAlumno = calificaciones.get(alumno);
                        for (Float nota : notasAlumnos) {
                            if (nota>=4) {
                                System.out.println("Aprovado papitoooo");
                            }else {
                                System.out.println("Reprobado papito ):");
                            }
                        }
                    }
                    break;
                case 3:
                    float promedioGeneral = 0f;
                    int notasTotal = cantidadAlumnos * cantidadNotas;
                    for (String nombreAlumno : calificaciones.keySet()) {
                        ArrayList<Float> notasAlumno = calificaciones.get(alumno);
                        float promedio = 0F;
                        for (Float nota : notasAlumnos) {
                            promedio += nota;
                        }
                        promedioGeneral = promedio / notasTotal;
                    }
                    System.out.println();
                    for (Float nota : notasAlumnos) {
                        if (nota<promedioGeneral) {
                            System.out.println("Está por debajo del promedio general");
                        }else if (nota>promedioGeneral) {
                            System.out.println("Está sobre el promedio general");
                        }else {
                            System.out.println("Es igual al promedio general");
                        }
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del menú");
                    break;
                default:
                    System.out.println("Parámetros no aceptados");
                    break;
            }


        }
    }
}
