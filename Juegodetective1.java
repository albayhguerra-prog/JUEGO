import java.util.Random;
import java.util.Scanner;

import Datos.Historias;
import Datos.Personajes;
import Datos.Pistas;
import Herramientas.Entrada;
import Vista.Pantalla;

public class Juegodetective1 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random azar = new Random();
        int puntosTotales = 0;
        String respuesta;

        System.out.println("=== DETECTIVE DE CULPABLES ===");

        do {
            int nivel = Pantalla.elegirNivel(teclado);
            int cantidadSospechosos = Personajes.sospechosos[nivel].length;
            int cantidadPistas = Pistas.pistas[nivel].length;
            int culpable = azar.nextInt(cantidadSospechosos);
            boolean[] pistaUsada = new boolean[cantidadPistas];
            String[] pistasHalladas = new String[cantidadPistas];
            int pistasUsadas = 0;
            boolean quiereAcusar = false;

            System.out.println();
            System.out.println(Historias.historias[nivel]);
            System.out.println("Nadie te dira a quien descartar: tu debes deducirlo.");
            System.out.println("Mientras menos pistas uses, mas puntos ganas.");
            System.out.println();
            Pantalla.mostrarSospechosos(nivel);

            while (pistasUsadas < cantidadPistas && !quiereAcusar) {
                System.out.println();
                System.out.println("Que quieres hacer?");
                for (int pista = 0; pista < cantidadPistas; pista++) {
                    if (!pistaUsada[pista]) System.out.println((pista + 1) + ". " + Pistas.rasgo(nivel, pista, 0));
                }
                System.out.println((cantidadPistas + 1) + ". Acusar ahora");

                int opcion = Entrada.leerNumero(teclado, "> ", 1, cantidadPistas + 1);
                if (opcion == cantidadPistas + 1) {
                    quiereAcusar = true;
                } else if (pistaUsada[opcion - 1]) {
                    System.out.println("Esa pista ya la revisaste.");
                } else {
                    pistaUsada[opcion - 1] = true;
                    pistasHalladas[pistasUsadas++] = Pistas.rasgo(nivel, opcion - 1,
                            Personajes.tiene(nivel, culpable, opcion - 1) ? 4 : 3);

                    System.out.println();
                    System.out.println("PISTA: " + pistasHalladas[pistasUsadas - 1]);
                    System.out.println();
                    System.out.println("PISTAS ENCONTRADAS:");
                    for (int posicion = 0; posicion < pistasUsadas; posicion++) {
                        System.out.println("- " + pistasHalladas[posicion]);
                    }
                    System.out.println();
                    Pantalla.mostrarSospechosos(nivel);
                }
            }

            System.out.println();
            System.out.println("Es hora de acusar!");
            int sospechosoAcusado = Entrada.leerNumero(teclado,
                    "Quien es el culpable (1-" + cantidadSospechosos + ")? ", 1, cantidadSospechosos) - 1;

            if (sospechosoAcusado == culpable) {
                int puntosGanados = (cantidadPistas + 1 - pistasUsadas) * (nivel + 1);
                puntosTotales += puntosGanados;
                System.out.println();
                System.out.println("CASO RESUELTO! " + Personajes.nombre(nivel, culpable)
                        + " era el culpable. +" + puntosGanados + " puntos");
                System.out.println(Historias.finales[nivel]);
            } else {
                System.out.println();
                System.out.println("Te equivocaste... el culpable era " + Personajes.nombre(nivel, culpable) + " y escapo.");
            }
            System.out.println("Puntos totales: " + puntosTotales);

            System.out.println();
            System.out.print("Jugar otro caso? (si/no): ");
            respuesta = teclado.nextLine().trim();
        } while (respuesta.equalsIgnoreCase("si"));

        System.out.println();
        System.out.println("Gracias por jugar, detective!");
        teclado.close();
    }
}

//LEANDRO COME MIERDA Y SI QUIERES OTRO CAMBIO HAZLO TU MLP