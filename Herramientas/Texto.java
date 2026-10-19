package Herramientas;

public class Texto {

    // Devuelve el campo numero k (empezando en 0) de un texto separado por 'sep'.
    public static String campo(String texto, char sep, int k) {
        int inicio = 0;
        for (int i = 0; i < k; i++) {
            inicio = texto.indexOf(sep, inicio) + 1;
        }
        int fin = texto.indexOf(sep, inicio);
        if (fin == -1) fin = texto.length();
        return texto.substring(inicio, fin);
    }
}
