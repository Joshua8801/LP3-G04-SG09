package Actividad_5;

class CuentaCorriente extends CuentaBancaria {
    private int retirosGratis = 3;
    private int contadorRetiros = 0;
    private final double tarifa = 3.0;

    public CuentaCorriente(String numeroCuenta, double saldoInicial) {
        super(numeroCuenta, saldoInicial);
    }

    @Override
    public void retirar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            contadorRetiros++;
            if (contadorRetiros > retirosGratis) {
                saldo -= tarifa;
                System.out.println("Se aplicó una tarifa de S/." + tarifa);
            }
            System.out.println("Retiro realizado. Saldo actual: S/." + saldo);
        } else {
            System.out.println("Fondos insuficientes.");
        }
    }

    @Override
    public void consultar() {
        contadorRetiros = 0; 
        System.out.println("Consultando cuenta corriente. Retiros reiniciados. Saldo actual: S/." + saldo);
    }
}
