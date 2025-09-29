package actividad3;

public class IgualGenerico {
    public static <T> boolean esIgualA(T a, T b) {
        if (a == null || b == null) {
            return a == b; 
        }
        return a.equals(b);
    }
}