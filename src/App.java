public class App {
    public static void main(String[] args) throws Exception {
        // Creo 2 cuentas
        CuentaCorriente c1 = new CuentaCorriente("ES2343237654323456784325", 300.56);
        CuentaAhorro c2 = new CuentaAhorro("ES2343237654323456784325", 300.56, 600.0);

        System.out.println(c1.toString());
        System.out.println(c2.toString());

        c1.ingresar(300.23);
        System.out.println(c1.toString());

        c1.transpaso(c2, 200.0);

        System.out.println(c1.toString());
        System.out.println(c2.toString());

        System.out.println("Aplico intereses...");
        c1.calcularIntereses();
        System.out.println(c1.toString());

    }
}
