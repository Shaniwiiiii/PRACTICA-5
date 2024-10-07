public class Main {
    // Método genérico para imprimir cualquier par de elementos
    public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println(par);
    }

    public static void main(String[] args) {
        // Crear y mostrar pares de diferentes tipos
        Par<String, Integer> par1 = new Par<>("Holi", 10);
        Par<Double, Boolean> par2 = new Par<>(5.24, true);
        Par<String, String> par3 = new Par<>("Nombree", "Valor");

        imprimirPar(par1);
        imprimirPar(par2);
        imprimirPar(par3);
    }
}
