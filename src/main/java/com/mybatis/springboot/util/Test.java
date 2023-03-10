package com.mybatis.springboot.util;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Cursos profesional de Java", 6.5f, 50, 200 ));
        cursos.add(new Curso("Cursos profesional de Python", 8.5f, 60, 800 ));
        cursos.add(new Curso("Cursos profesional de DB", 4.5f, 70, 700 ));
        cursos.add(new Curso("Cursos profesional de Android", 7.5f, 10, 400 ));
        cursos.add(new Curso("Cursos profesional de Escritura", 1.5f, 10, 300 ));

        cursos.stream()
                .filter(c -> c.getDuracion() >= 5)
                .forEach(c -> System.out.println(c.getTitulo()));

        cursos.stream()
                .filter(c -> c.getDuracion() <= 2)
                .forEach(c -> System.out.println(c.getTitulo()));

        cursos.stream().filter(c -> c.getVideos() >= 50)
                .forEach(c -> System.out.println(c.getTitulo()));

        System.out.println("Ordenar por duración");
        cursos.stream()
                .sorted(Comparator.comparing(Curso::getDuracion).reversed())
                .limit(3)
                .map(Curso::getTitulo)
                .forEach(System.out::println);

        System.out.println("Mostrar en consola la duración total de todos los cursos");
        Double suma = cursos.stream()
                        .mapToDouble(Curso::getDuracion).sum();

        System.out.println("La suma de los videos es: " + suma);

        System.out.println("Mostrar en consola todos aquellos libros que superen el promedio en cuanto a duración se refiere");
        Double promedio = cursos.stream()
                .mapToDouble(Curso::getDuracion).average().getAsDouble();

        cursos.forEach(c -> {
            if (c.getDuracion() > promedio) {
                System.out.println(c.getTitulo());
            }
        });

        System.out.println("Mostrar en consola la duración de todos aquellos cursos que tengan una cantidad de alumnos inscritos menor a 500.");

        cursos.forEach(c -> {
            if (c.getAlumnos() < 500) {
                System.out.println(c.getTitulo());
            }
        });

        System.out.println("Obtener el curso de mayo duración");
        Curso curso = cursos.stream()
                .max(Comparator.comparing(Curso::getDuracion)).get();

        System.out.println(curso.getTitulo());

        System.out.println("Crear una lista de Strings con todos los títulos de los cursos");
        List<String> titulos = new ArrayList<>();
        cursos.forEach(c -> titulos.add(c.getTitulo()));

        System.out.println(titulos);


    }
}
