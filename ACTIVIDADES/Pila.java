public class Pila<E> {
    private E[] elementos;
    private int tope;

    @SuppressWarnings("unchecked")
    public Pila(int tamanio) {
        elementos = (E[]) new Object[tamanio];
        tope = -1;
    }

    public void push(E valor) {
        if (tope == elementos.length - 1) {
            throw new IllegalStateException("La pila está llena.");
        }
        elementos[++tope] = valor;
    }

    public E pop() {
        if (tope == -1) {
            throw new IllegalStateException("La pila está vacía.");
        }
        return elementos[tope--];
    }

    public static void main(String[] args) {
        Pila<Integer> pilaEnteros = new Pila<>(5);
        pilaEnteros.push(10);
        pilaEnteros.push(20);
        System.out.println("Elemento extraído: " + pilaEnteros.pop());  // Imprime: 20
    }
}
