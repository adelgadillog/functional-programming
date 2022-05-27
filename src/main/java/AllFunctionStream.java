import model.Libro;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllFunctionStream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 4, 6, 12, 20);

        allMatch(list);
        anyMatch(list);
        streamBuilder();
        streamCollector();
        streamConcat();
        streamCount();

    }

    private static void streamConcat() {
        Libro l1= new Libro ("El señor de los anillos",1000);
        Libro l2= new Libro ("La fundacion",500);
        Libro l3= new Libro ("El caliz de fuego",600);
        Stream<Libro> libros = Stream.of(l1,l2,l3);
        Stream<Libro> librosDos = Stream.of(l1,l2,l3);
        Stream<Libro> librosConcatenado = Stream.concat(libros,librosDos);
        librosConcatenado.forEach(libro -> System.out.println("Libros concatenados: " + libro.getTitulo()));
    }

    private static void streamCollector() {
        Libro l1= new Libro ("El señor de los anillos",1000);
        Libro l2= new Libro ("La fundacion",500);
        Libro l3= new Libro ("El caliz de fuego",600);

        Stream<Libro> libros = Stream.of(l1,l2,l3);
        libros.forEach(libro -> System.out.println("libro: " + libro.getTitulo()));
        //other way to print the data is using collector to convert stream to list
        libros = Stream.of(l1,l2,l3);
        List<Libro> listaLibros = libros.collect(Collectors.toList());
        listaLibros.forEach(libro -> System.out.println("Lista libro: " + libro.getTitulo()));
        // Collect with BiConsumer
        libros = Stream.of(l1,l2,l3);
        List<Libro> libroList = libros.collect(ArrayList::new, ArrayList::add,
                ArrayList::addAll);
        libroList.forEach(libro -> System.out.println("Lista BiConsumer: " + libro.getTitulo()));
    }

    private static void anyMatch(List<Integer> list) {
        System.out.println("Anymatch: " + list.stream().anyMatch((n) -> n == 4));
    }

    private static void allMatch(List<Integer> list) {
        System.out.println("Allmatch: " + list.stream().allMatch(n -> n % 2 == 0));
    }

    private static void streamBuilder() {
        Stream.Builder<String> builder = Stream.builder();
        Stream<String> stream = builder.add("Geeks")
                .add("for")
                .add("Geeks")
                .add("GeeksQuiz")
                .build();
        System.out.println("Builder: ");
        stream.forEach(System.out::println);
    }

    private static void streamCount() {
        Stream.Builder<String> builder = Stream.builder();
        Stream<String> stream = builder.add("Geeks")
                .add("for")
                .add("Geeks")
                .add("GeeksQuiz")
                .build();
        System.out.println("Count: " + stream.count());

    }
}
