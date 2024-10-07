public class Pila_<E> {
    private E[] elementos;
    private int tope;

    @SuppressWarnings("unchecked")
    public Pila_(int tamanio) {
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

    // Método para obtener el tamaño de la pila
    public int size() {
        return tope + 1;
    }

    // Método para verificar si una pila está vacía
    public boolean isEmpty() {
        return tope == -1;
    }

    // Método para obtener el elemento en la posición actual del tope (sin eliminarlo)
    public E peek() {
        if (tope == -1) {
            throw new IllegalStateException("La pila está vacía.");
        }
        return elementos[tope];
    }

    // Método genérico para comparar dos pilas
    public boolean esIgual(Pila_<E> otraPila) {
        if (this.size() != otraPila.size()) {
            return false;
        }

        // Se utilizan pilas temporales para no modificar el estado original de las pilas
        Pila_<E> tempPila1 = new Pila_<>(this.size());
        Pila_<E> tempPila2 = new Pila_<>(otraPila.size());

        boolean sonIguales = true;

        // Comparar elemento por elemento
        while (!this.isEmpty() && !otraPila.isEmpty()) {
            E elemento1 = this.pop();
            E elemento2 = otraPila.pop();

            // Verificar si los elementos son diferentes
            if (!elemento1.equals(elemento2)) {
                sonIguales = false;
            }

            // Almacenar los elementos en las pilas temporales para restaurarlos más tarde
            tempPila1.push(elemento1);
            tempPila2.push(elemento2);
        }

        // Restaurar los elementos a las pilas originales
        while (!tempPila1.isEmpty()) {
            this.push(tempPila1.pop());
            otraPila.push(tempPila2.pop());
        }

        return sonIguales;
    }

    public static void main(String[] args) {
        Pila_<Integer> pila1 = new Pila_<>(5);
        Pila_<Integer> pila2 = new Pila_<>(5);

        pila1.push(1);
        pila1.push(2);
        pila1.push(3);

        pila2.push(1);
        pila2.push(2);
        pila2.push(3);

        // Comparar las pilas
        System.out.println("¿Son iguales las pilas? " + pila1.esIgual(pila2));  // true

        pila2.pop();
        pila2.push(4);

        // Comparar nuevamente tras modificar una pila
        System.out.println("¿Son iguales las pilas? " + pila1.esIgual(pila2));  // false
    }
}
