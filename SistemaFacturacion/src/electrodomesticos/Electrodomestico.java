package electrodomesticos;

public class Electrodomestico {
    protected char consumo;
    protected String procedencia;
    protected int precio;

    public Electrodomestico(char consumo, String procedencia) {
        this.consumo = consumo;
        this.procedencia = procedencia;
        this.precio = 0;
        calcularPrecio();
    }

    public char getConsumo() {
        return consumo;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public int getPrecio() {
        return precio;
    }

    protected void calcularPrecio() {
        // Precio base
        this.precio = calcularPrecioConsumo() + calcularPrecioProcedencia();
    }

    private int calcularPrecioConsumo() {
        // Precio de acuerdo al consumo
        switch (this.consumo) {
            case 'A':
                return 450000;
            case 'B':
                return 350000;
            case 'C':
                return 250000;
            default:
                return 0;
        }
    }

    private int calcularPrecioProcedencia() {
        // Precio de acuerdo a la procedencia
        if (this.procedencia.equals("Nacional")) {
            return 250000;
        } else {
            return 350000;
        }
    }

    public void mostrarInformacion() {
        System.out.println("Consumo: " + getConsumo());
        System.out.println("Procedencia: " + getProcedencia());
        System.out.println("Precio: " + getPrecio());
    }
}
