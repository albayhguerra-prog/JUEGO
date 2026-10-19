package Herramientas;

public class Texto {

    // Devuelve el campo numero numeroCampo (empezando en 0) de un texto separado por 'separador'.
    
    public static String campo(String texto, char separador, int numeroCampo) {
        int inicio = 0;
        for (int contador = 0; contador < numeroCampo; contador++) {
            inicio = texto.indexOf(separador, inicio) + 1;
        }
        int fin = texto.indexOf(separador, inicio);
        if (fin == -1) fin = texto.length();
        return texto.substring(inicio, fin);
    }
}