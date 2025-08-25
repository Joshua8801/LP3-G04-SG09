package Actividad_3;

public class TestAgregacion {
    public static void main(String[] args) {
        Motor m1 = new Motor(100, 2000);
        Motor m2 = new Motor(150, 3000);

        Automovil a1 = new Automovil("aeiuo1", 4, "Honda", "MMM");
        Automovil a2 = new Automovil("123456", 6, "Tesla", "ModeloX");

        a1.setMotor(m1);
        a2.setMotor(m2);

        System.out.println(a1);
        System.out.println(a2);
    }
}
