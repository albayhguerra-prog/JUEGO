package Datos;

import Herramientas.Texto;

public class Pistas {

    // Rasgo = "accion;etiqueta si NO;etiqueta si SI;pista si NO;pista si SI"
    // Niveles 1 y 2: pistas directas. Niveles 3 y 4: pistas indirectas (hay que pensar).
    public static String[][] pistas = {
        {"Medir las huellas del piso;bajo;alto;Alguien se subio a una caja para llegar a la vitrina: el culpable es BAJO.;Las huellas son de zapatos enormes: el culpable es ALTO.",
         "Examinar la ventana rota;abrigo negro;abrigo rojo;Hay un hilo NEGRO enganchado en la ventana: el abrigo es negro.;Hay un hilo ROJO enganchado en la ventana: el abrigo es rojo.",
         "Oler el cuarto;no fuma;fuma;El cuarto no huele a humo: el culpable NO fuma.;Hay ceniza de cigarro junto a la vitrina: el culpable FUMA."},
        {"Examinar el cajon forzado;diestro;zurdo;Las marcas del cajon van de izquierda a derecha: el culpable es DIESTRO.;Las marcas del cajon van de derecha a izquierda: el culpable es ZURDO.",
         "Revisar la camara del pasillo;sin bigote;con bigote;La camara muestra un rostro limpio: SIN bigote.;La camara muestra una sombra sobre el labio: CON bigote.",
         "Buscar en el perchero;sin gorro;con gorro;Hay un gorro de cocina tirado junto a la caja fuerte: USA gorro.;Hay un cabello suelto en la caja fuerte, nada lo cubria: NO usa gorro.",
         "Oler el cajon;no huele a ajo;huele a ajo;El cajon no huele a nada: NO huele a ajo.;El cajon huele a ajo: el culpable HUELE A AJO."},
        {"Revisar las camaras;sin gafas;con gafas;Las camaras muestran que leyo un letrero lejano sin entrecerrar los ojos.;En el piso brilla un pedacito de cristal redondo, como de un lente.",
         "Estudiar el hilo de la puerta;bata blanca;bata verde;Un hilo del color de la nieve quedo en la puerta.;Un hilo del color de las hojas quedo en la puerta.",
         "Analizar el teclado de la caja fuerte;diestro;zurdo;Las teclas se pulsaron con la mano con que la mayoria escribe.;Las teclas se pulsaron con la mano contraria a la que la mayoria usa para escribir.",
         "Escuchar la grabacion de audio;camina normal;cojea;Se oyen pasos parejos, uno tras otro, sin ritmo raro.;Se oyen pasos disparejos: uno firme y otro arrastrado.",
         "Revisar el registro de entradas;tarjeta plateada;tarjeta dorada;La puerta se abrio con una tarjeta del color de la luna.;La puerta se abrio con una tarjeta del color del sol."},
        {"Medir la compuerta del ducto;bajo;alto;Alguien entro al ducto de pie, sin rozar el techo.;Hay un rasguno en el techo de la compuerta, a la altura de una cabeza alta.",
         "Examinar el guante de seguridad;sin tatuaje;con tatuaje;El guante quedo limpio, con la piel de la muneca sin marcas.;En el guante quedo la huella de una tinta oscura, dibujada en la muneca.",
         "Inspeccionar el panel de control;diestro;zurdo;Los botones gastados estan del lado donde la mayoria apoya el lapiz.;Los botones gastados estan del lado contrario al que la mayoria apoya el lapiz.",
         "Analizar el aire del pasillo;sin perfume;con perfume;El aire esta limpio, sin ningun aroma.;Queda un aroma dulce flotando en el pasillo.",
         "Revisar la camara de maquinas;pelo corto;pelo largo;La sombra tiene la cabeza redonda, sin nada que cuelgue.;La sombra tiene algo largo que se mueve al caminar, como una cola."}};

    public static String rasgo(int n, int r, int k) {
        return Texto.campo(pistas[n][r], ';', k);
    }
}