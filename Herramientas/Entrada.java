package Herramientas;

import java.util.Scanner;

public class Entrada {

    // Revisa que el texto tenga entre 1 y 3 caracteres y todos sean digitos
    public static boolean esNumero(String texto) {
        if (texto.length() == 0 || texto.length() > 3) return false;
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c < '0' || c > '9') return false;
        }
        return true;
    }

    // Pide un numero entre min y max y repite hasta que sea valido
    public static int leerNumero(Scanner sc, String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine().trim();
            if (esNumero(texto)) {
                int n = Integer.parseInt(texto);
                if (n >= min && n <= max) return n;
            }
            System.out.println("Escribe un numero entre " + min + " y " + max + ".");
        }
    }
}
