import java.util.Random;
import java.util.Scanner;

import Datos.Historias;
import Datos.Personajes;
import Datos.Pistas;
import Herramientas.Entrada;
import Vista.Pantalla;

public class Juegodetective1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random azar = new Random();
        int total = 0;
        String otra;

        System.out.println("=== DETECTIVE DE CULPABLES ===");

        do {
            int n = Pantalla.elegirNivel(sc);
            int cantidad = Personajes.sospechosos[n].length, np = Pistas.pistas[n].length;
            int culpable = azar.nextInt(cantidad);
            boolean[] usada = new boolean[np];
            String[] halladas = new String[np];
            int usadas = 0;
            boolean acusar = false;

            System.out.println(" " + Historias.historias[n]);
            System.out.println("Nadie te dira a quien descartar: tu debes deducirlo.");
            System.out.println("Mientras menos pistas uses, mas puntos ganas. ");
            Pantalla.mostrarSospechosos(n);

            while (usadas < np && !acusar) {
                System.out.println("Que quieres hacer?");
                for (int i = 0; i < np; i++) {
                    if (!usada[i]) System.out.println((i + 1) + ". " + Pistas.rasgo(n, i, 0));
                }
                System.out.println((np + 1) + ". Acusar ahora");

                int op = Entrada.leerNumero(sc, "> ", 1, np + 1);
                if (op == np + 1) {
                    acusar = true;
                } else if (usada[op - 1]) {
                    System.out.println("Esa pista ya la revisaste.");
                } else {
                    usada[op - 1] = true;
                    halladas[usadas++] = Pistas.rasgo(n, op - 1, Personajes.tiene(n, culpable, op - 1) ? 4 : 3);

                    System.out.println(" PISTA: " + halladas[usadas - 1] + "  PISTAS ENCONTRADAS:");
                    for (int i = 0; i < usadas; i++) System.out.println("- " + halladas[i]);
                    System.out.println();
                    Pantalla.mostrarSospechosos(n);
                }
            }

            System.out.println(" Es hora de acusar!");
            int acusado = Entrada.leerNumero(sc, "Quien es el culpable (1-" + cantidad + ")? ", 1, cantidad) - 1;

            if (acusado == culpable) {
                int puntos = (np + 1 - usadas) * (n + 1);
                total += puntos;
                System.out.println(" CASO RESUELTO! " + Personajes.nombre(n, culpable) + " era el culpable. +" + puntos + " puntos");
                System.out.println(Historias.finales[n]);
            } else {
                System.out.println(" Te equivocaste... el culpable era " + Personajes.nombre(n, culpable) + " y escapo.");
            }
            System.out.println("Puntos totales: " + total);

            System.out.print(" Jugar otro caso? (si/no): ");
            otra = sc.nextLine().trim();
        } while (otra.equalsIgnoreCase("si"));

        System.out.println("\nGracias por jugar, detective!");
        sc.close();
    }
}
