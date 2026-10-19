package Vista;

import java.util.Scanner;
import Datos.Historias;
import Datos.Personajes;
import Datos.Pistas;
import Herramientas.Entrada;

public class Pantalla {

    public static void mostrarSospechosos(int n) {
        System.out.println("SOSPECHOSOS:");
        for (int s = 0; s < Personajes.sospechosos[n].length; s++) {
            String texto = (s + 1) + ". " + Personajes.nombre(n, s) + " - ";
            for (int r = 0; r < Pistas.pistas[n].length; r++) {
                texto += Pistas.rasgo(n, r, Personajes.tiene(n, s, r) ? 2 : 1)
                        + (r < Pistas.pistas[n].length - 1 ? ", " : "");
            }
            System.out.println(texto);
        }
    }

    public static int elegirNivel(Scanner sc) {
        System.out.println("\nElige el caso:");
        for (int i = 0; i < Historias.titulos.length; i++) {
            System.out.println((i + 1) + ". " + Historias.titulos[i] + " (" + Personajes.sospechosos[i].length
                    + " sospechosos, " + Pistas.pistas[i].length + " pistas"
                    + (i >= 2 ? ", pistas dificiles" : "") + ")");
        }
        return Entrada.leerNumero(sc, "> ", 1, Historias.titulos.length) - 1;
    }
}