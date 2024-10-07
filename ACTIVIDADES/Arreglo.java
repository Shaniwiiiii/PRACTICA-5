// Define la clase de excepción personalizada
class InvalidSubscriptException extends Exception {
    public InvalidSubscriptException(String message) {
        super(message);
    }
}

public class Arreglo {
    public static <E> void imprimirArreglo(E[] arregloEntrada) {
        for (E elemento : arregloEntrada) {
            System.out.printf("%s ", elemento);
        }
        System.out.println();
    }
    
    public static <E> int imprimirArreglo(E[] arregloEntrada, int subindiceInferior, int subindiceSuperior) throws InvalidSubscriptException {
        if (subindiceInferior < 0 || subindiceSuperior >= arregloEntrada.length || subindiceSuperior < subindiceInferior) {
            throw new InvalidSubscriptException("Índices fuera de rango o no válidos.");
        }
        
        int elementosImpresos = 0;
        for (int i = subindiceInferior; i <= subindiceSuperior; i++) {
            System.out.printf("%s ", arregloEntrada[i]);
            elementosImpresos++;
        }
        System.out.println();
        return elementosImpresos;
    }
    
    public static void main(String[] args) {
        Integer[] arregloInteger = {1, 2, 3, 4, 5, 6};
        imprimirArreglo(arregloInteger);  // Imprime todo el arreglo
        try {
            imprimirArreglo(arregloInteger, 1, 4);  // Imprime del índice 1 al 4
        } catch (InvalidSubscriptException e) {
            System.out.println(e.getMessage());
        }
    }
}
