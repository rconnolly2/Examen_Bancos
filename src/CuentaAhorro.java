public class CuentaAhorro extends CuentaBancaria {
    
    private final Double saldoMinimo;

    public CuentaAhorro(String iban_cuenta, Double saldo_arg, Double saldo_min) {
        if (saldo_min < 0) {
            throw new IllegalArgumentException("Saldo minimo no valido...");
        }
        super(iban_cuenta, saldo_arg);
        this.saldoMinimo = saldo_min;
    }

    public void calcularIntereses() {
        Double inter_apl;

        if (this.getsaldo() < this.saldoMinimo) {
            inter_apl = (getinteresAnualBasico()/2)/100; // mitad
        } else {
            inter_apl = (getinteresAnualBasico()*2)/100; // doble de interes
        }

        // Ingreso los el saldo con intereses
        this.ingresar(this.getsaldo()*inter_apl);
    }
}
