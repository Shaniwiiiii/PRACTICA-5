public class IgualGenerico {

    // Método genérico que compara dos elementos usando equals()
    public static <T> boolean esIgualA(T a, T b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.equals(b);
    }

    public static void main(String[] args) {
        // Pruebas con diferentes tipos
        System.out.println("Comparando Integer: " + esIgualA(5, 5));  // true
        System.out.println("Comparando Integer y null: " + esIgualA(5, null));  // false
        System.out.println("Comparando null y null: " + esIgualA(null, null));  // true
        System.out.println("Comparando Object: " + esIgualA(new Object(), new Object()));  // false
        System.out.println("Comparando Integer con String: " + esIgualA((Integer) 5, (Integer) 5));  // true
        System.out.println("Comparando String: " + esIgualA("Hola", "Hola"));  // true
        System.out.println("Comparando String y null: " + esIgualA("Hola", null));  // false
    }
}
