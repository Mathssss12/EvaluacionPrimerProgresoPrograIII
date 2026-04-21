/*
Elaborado por Nicolas Muñoz
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa la palabra o número a evaluar: ");
        String entrada = scanner.nextLine();

        // Llamada directa al método procesar
        String resultado = procesar(entrada);

        System.out.println(":" + resultado);

        scanner.close();
    }

    /*
     * Métodos del programador
     */

// Metodo para verificar si la cadena contiene únicamente dígitos del 0 al 9
    public static String limpiarCadena(String cadena) {
        String limpia = "";
        String cadenaMinuscula = cadena.toLowerCase();

        for (int i = 0; i < cadenaMinuscula.length(); i++) {
            char c = cadenaMinuscula.charAt(i);

            if (c != ' ') {
                limpia += c;
            }
        }
        return limpia;
    }
// Metodo para verificar si la cadena contiene únicamente dígitos del 0 al 9

    public static boolean esNumero(String cadena) {
        // Si después de limpiar la cadena quedó vacía, no es número
        if (cadena.length() == 0) return false;

        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);

            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }
// Metodo para verificar simetría usando una Pila y  Cola

    public static boolean esPalindromoOCapicua(String cadena) {
        ColaDinamica cola = new ColaDinamica();
        PilaDinamica pila = new PilaDinamica();

        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            cola.encolar(c);
            pila.push(c);
        }

        while (!cola.estaVacia() && !pila.estaVacia()) {
            if (cola.desencolar() != pila.pop()) {
                return false;
            }
        }
        return true;
    }
// Metodo principal que coordina la limpieza, detección y verificación
    public static String procesar(String entrada) {
        String limpia = limpiarCadena(entrada);

        if (limpia.length() == 0) {
            return "Entrada no válida";
        }

        boolean num = esNumero(limpia);


        boolean simetrica = esPalindromoOCapicua(limpia);

        if (simetrica) {
            if (num) {
                return "Es capicúa";
            } else {
                return "Es palíndromo";
            }
        } else {
            return "No es palíndromo ni capicúa";
        }
    }



    /*
    El algoritmo tiene una complejidad temporal y espacial de O(n) lineal,
    donde el proceso de n es la cantidad de caracteres de la entrada.
    A nivel temporal es O(n) debido a que todas sus operaciones principales como:
    limpiar la cadena, verificar el tipo de dato, llenar las estructuras y comparar los elementos,
    se ejecutan de una manera secuencial muy específica y sin bucles anidados, dando como resultado
    una simplificación asintóticamente a un comportamiento lineal. En cuanto al nivel espacial también es O(n),
    debido a que la Pila y la Cola utilizan memoria dinámica basada en Nodos, instanciando exactamente "n"
    elementos en base al tamaño de la palabra, lo que garantiza un uso eficiente de los recursos sin desperdiciar espacio estático.
     */

}
