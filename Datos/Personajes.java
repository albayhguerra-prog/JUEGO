package Datos;

import Herramientas.Texto;

public class Personajes {

    // Sospechoso = "Nombre:bits". Cada bit es un rasgo (1 = lo tiene), en el orden de las pistas del nivel.
    public static String[][] sospechosos = {
        {"Don Ricardo:101", "Sra. Luna:010", "Guardia Pablo:110", "Srta. Valeria:011"},
        {"Chef Bruno:1010", "Mesera Camila:0110", "Sommelier Hugo:1100", "Pastelera Rocio:0011",
         "Lavaplatos Tito:1001", "Gerente Olga:0101"},
        {"Dr. Mateo:10110", "Dra. Ines:01011", "Ing. Tomas:11001", "Becaria Sol:00101",
         "Prof. Andres:10011", "Tec. Gloria:01100", "Dr. Leon:11110", "Quim. Elena:00010"},
        {"Capitana Rosa:10110", "Piloto Zeta:01101", "Agente Nube:11010", "Ing. Orion:00111",
         "Medico Sirio:10001", "Cadete Vega:01010", "Cocinero Lobo:11100", "Navegante Kira:00001",
         "Comandante Axel:10101", "Biologa Nina:01110"}};

    public static String nombre(int n, int s) {
        return Texto.campo(sospechosos[n][s], ':', 0);
    }

    public static boolean tiene(int n, int s, int r) {
        return Texto.campo(sospechosos[n][s], ':', 1).charAt(r) == '1';
    }
}
