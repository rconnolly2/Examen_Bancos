public abstract class CuentaBancaria {
    private final String iban;
    private Double saldo;
    private static final Double interesAnualBasico = 3.0;

    public CuentaBancaria(String iban_cuenta, Double saldo_arg) {
        if (!iban_cuenta.matches("[A-Z]{2}[0-9]{22}")) { // Es un iban valido
            throw new IllegalArgumentException("IBAN no valido");
        }

        this.iban = iban_cuenta;
        this.saldo = saldo_arg;
    }

    public Double getinteresAnualBasico() {
        return interesAnualBasico;
    }

    public String getnumeroCuenta() {
        return this.iban;
    }

    public Double getsaldo() {
        return this.saldo;
    }

    public void ingresar(Double cant) {
        if (cant >= 0) {
            this.saldo += cant;
            System.out.println("Ingreso realizado correctamente...");
        } else {
            System.err.println("Cantidad no valida...");
        }
    }

    public void retirar(Double cant) {
        if (this.saldo >= cant) {
            this.saldo -= cant;
            System.out.println("Retirada de: "+this.saldo+"Eur");
        } else {
            System.err.println("Retirada menor al saldo, no tienes suficiente dinero...");
        }
    }

    public void transpaso(CuentaBancaria cb_recept, Double cant) {
        if (this.saldo >= cant) { // Si el saldo es mayor o igual a la cantidad que se intenta enviar
            this.retirar(cant); // Retiro dinero del emisor
            cb_recept.ingresar(cant); // Se ingresa el dinero al banco receptor
            System.out.println("Transferencia realizada...");
        } else {
            System.err.println("No tienes suficiente dinero para enviar...");
        }
    }

    @Override
    public String toString() {
        return "Cuenta bancaria: "+"IBAN: "+this.iban+" Saldo: "+this.saldo+" Interes anual basico: "+CuentaBancaria.interesAnualBasico;
    }

    public abstract void calcularIntereses();
    

}
