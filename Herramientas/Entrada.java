package Herramientas;

import java.util.Scanner;

public class Entrada {

    // Revisa que el texto tenga entre 1 y 3 caracteres y todos sean digitos
    public static boolean esNumero(String texto) {
        if (texto.length() == 0 || texto.length() > 3) return false;
        for (int posicion = 0; posicion < texto.length(); posicion++) {
            char caracter = texto.charAt(posicion);
            if (caracter < '0' || caracter > '9') return false;
        }
        return true;
    }

    // Pide un numero entre minimo y maximo y repite hasta que sea valido
    public static int leerNumero(Scanner teclado, String mensaje, int minimo, int maximo) {
        while (true) {
            System.out.print(mensaje);
            String texto = teclado.nextLine().trim();
            if (esNumero(texto)) {
                int numero = Integer.parseInt(texto);
                if (numero >= minimo && numero <= maximo) return numero;
            }
            System.out.println("Escribe un numero entre " + minimo + " y " + maximo + ".");
        }
    }
}
