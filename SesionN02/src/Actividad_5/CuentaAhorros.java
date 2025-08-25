package Actividad_5;

class CuentaAhorros extends CuentaBancaria {
    private double tasaInteres;
    private double saldoMinimoMensual;

    public CuentaAhorros(String numeroCuenta, double saldoInicial, double tasaInteres) {
        super(numeroCuenta, saldoInicial);
        this.tasaInteres = tasaInteres;
        this.saldoMinimoMensual = saldoInicial;
    }

    @Override
    public void retirar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            if (saldo < saldoMinimoMensual) {
                saldoMinimoMensual = saldo;
            }
            System.out.println("Retiro realizado. Saldo actual: S/." + saldo);
        } else {
            System.out.println("Fondos insuficientes.");
        }
    }

    @Override
    public void consultar() {
        double interes = saldoMinimoMensual * tasaInteres;
        saldo += interes;
        System.out.println("Intereses acumulados: S/." + interes + ". Saldo actual: S/." + saldo);
        saldoMinimoMensual = saldo; 
    }
}
