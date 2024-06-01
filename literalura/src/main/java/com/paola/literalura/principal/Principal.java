package com.paola.literalura.principal;

import com.paola.literalura.repository.Repository;
import com.paola.literalura.service.ConsumoAPI;

import java.util.Scanner;

public class Principal {
    private Scanner entrada = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private String URL_BASE = "https://gutendex.com/books/";
    private Repository repository;

    public Principal(Repository repository){
        this.repository = repository;
    }

    public void mostrarMenu() {
        var opcion = -1;
        var menu = """
                -------------
                Elija la opcion a través de su numero:
                1 - Buscar libro por titulo
                2 - Listar libros registrados
                3 - Listar autores registrados
                4 - Listar autores vivos en un determinado año
                5 - Listar libros por idioma
                0 - Salir
                """;
        while (opcion != 0) {
            System.out.println(menu);
            try {
                opcion = Integer.valueOf(entrada.nextLine());
                switch (opcion) {
                    case 1:
                        buscarLibroPorTitulo();
                        break;
                    case 2:
                        listarLibrosRegistrados();
                        break;
                    case 3:
                        listarAutoresRegistrados();
                        break;
                    case 4:
                        listarAutoresVivos();
                        break;
                    case 5:
                        listarLibrosPorIdioma();
                        break;
                    case 0:
                        System.out.println("Gracias por usar LiterAlura");
                        System.out.println("Cerrando la aplicacion...");
                        break;
                    default:
                        System.out.println("Opcion no valida!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Opcion no valida: " + e.getMessage());

            }
        }
    }