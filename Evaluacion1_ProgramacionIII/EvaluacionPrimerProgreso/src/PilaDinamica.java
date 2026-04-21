public class PilaDinamica {
    private Nodo top;

    public PilaDinamica() {
        this.top = null;
    }
// Metodo para verificar si la pila está vacía
    public boolean estaVacia() {
        return top == null;
    }
// Metodo para insertar un carácter en la cima de la pila
    public void push(char dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = top;
        top = nuevo;
    }
// Metodo para extraer el carácter de la cima de la pila
    public char pop() {
        if (estaVacia()) throw new RuntimeException("Pila vacía");
        char valor = top.dato;
        top = top.siguiente;
        return valor;
    }
}