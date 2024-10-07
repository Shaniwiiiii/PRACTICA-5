import java.util.ArrayList;

public class Contenedor<F, S> {
    private ArrayList<Par<F, S>> pares;

    // Constructor para inicializar el contenedor de pares
    public Contenedor() {
        pares = new ArrayList<>();
    }

    // Método para agregar un nuevo par al contenedor
    public void agregarPar(F primero, S segundo) {
        pares.add(new Par<>(primero, segundo));
    }

    // Método para obtener un par específico por su índice
    public Par<F, S> obtenerPar(int indice) {
        if (indice >= 0 && indice < pares.size()) {
            return pares.get(indice);
        }
        return null;
    }

    // Método para obtener la lista completa de pares
    public ArrayList<Par<F, S>> obtenerTodosLosPares() {
        return pares;
    }

    // Método para mostrar todos los pares almacenados
    public void mostrarPares() {
        for (Par<F, S> par : pares) {
            System.out.println(par);
        }
    }

    public static void main(String[] args) {
        // Crear contenedor y agregar pares de distintos tipos
        Contenedor<String, Integer> contenedor = new Contenedor<>();
        contenedor.agregarPar("Uno", 1);
        contenedor.agregarPar("Dos", 2);
        contenedor.agregarPar("Tres", 3);

        // Mostrar todos los pares del contenedor
        contenedor.mostrarPares();

        // Obtener un par específico por su índice
        System.out.println("Par en el índice 1: " + contenedor.obtenerPar(1));

        // Obtener la lista completa de pares
        System.out.println("Todos los pares: " + contenedor.obtenerTodosLosPares());
    }
}
