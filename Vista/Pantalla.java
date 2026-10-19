package Vista;

import java.util.Scanner;
import Datos.Historias;
import Datos.Personajes;
import Datos.Pistas;
import Herramientas.Entrada;

public class Pantalla {

    public static void mostrarSospechosos(int nivel) {
        System.out.println("SOSPECHOSOS:");
        for (int sospechoso = 0; sospechoso < Personajes.sospechosos[nivel].length; sospechoso++) {
            String linea = (sospechoso + 1) + ". " + Personajes.nombre(nivel, sospechoso) + " - ";
            for (int pista = 0; pista < Pistas.pistas[nivel].length; pista++) {
                linea += Pistas.rasgo(nivel, pista, Personajes.tiene(nivel, sospechoso, pista) ? 2 : 1)
                        + (pista < Pistas.pistas[nivel].length - 1 ? ", " : "");
            }
            System.out.println(linea);
        }
    }

    public static int elegirNivel(Scanner teclado) {
        System.out.println();
        System.out.println("Elige el caso:");
        for (int nivel = 0; nivel < Historias.titulos.length; nivel++) {
            System.out.println((nivel + 1) + ". " + Historias.titulos[nivel] + " (" + Personajes.sospechosos[nivel].length
                    + " sospechosos, " + Pistas.pistas[nivel].length + " pistas"
                    + (nivel >= 2 ? ", pistas dificiles" : "") + ")");
        }
        return Entrada.leerNumero(teclado, "> ", 1, Historias.titulos.length) - 1;
    }
}