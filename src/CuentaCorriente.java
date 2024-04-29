public class CuentaCorriente extends CuentaBancaria {
    public CuentaCorriente(String iban_cuenta, Double saldo_arg) {
        if (saldo_arg < 0) {
            throw new IllegalArgumentException("Saldo no valido...");
        }
        super(iban_cuenta, saldo_arg);
    }

    public void calcularIntereses() {
        Double inter_apl = getinteresAnualBasico()/100;

        // Ingreso los el saldo con intereses
        this.ingresar(this.getsaldo()*inter_apl);
    }
}
