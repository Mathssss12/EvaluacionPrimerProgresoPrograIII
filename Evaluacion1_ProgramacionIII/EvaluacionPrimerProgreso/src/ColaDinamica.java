public class ColaDinamica {
    private Nodo frente;
    private Nodo fin;

    public ColaDinamica() {
        this.frente = null;
        this.fin = null;
    }
// Metodo para verificar si la cola está vacía

    public boolean estaVacia() {
        return frente == null;
    }
// Metodo para insertar un carácter al final de la cola

    public void encolar(char dato) {
        Nodo nuevo = new Nodo(dato);
        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }
// Metodo para extraer el carácter del frente de la cola

    public char desencolar() {
        if (estaVacia()) throw new RuntimeException("Cola vacía");
        char valor = frente.dato;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        return valor;
    }
}