package electrodomesticos;

public class Televisor extends Electrodomestico {
    private float tamano;
    private boolean tieneTDT;

    public Televisor(char consumo, String procedencia, float tamano, boolean tieneTDT) {
        super(consumo, procedencia);
        this.tamano = tamano;
        this.tieneTDT = tieneTDT;
    }

    public float getTamano() {
        return tamano;
    }

    public boolean isTieneTDT() {
        return tieneTDT;
    }

    @Override
    protected void calcularPrecio() {
        // Precio base
        this.precio = calcularPrecioConsumo() + calcularPrecioProcedencia();

        // Si el tamaño es superior a 40 pulgadas y tiene sintonizador TDT
        this.precio += (calcularPrecioTamano() + calcularPrecioTDT());
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

    private int calcularPrecioTamano() {
        // Precio de acuerdo al tamaño
        if (this.tamano > 40) {
            return (int) (this.precio*0.3);
        }
        return 0;
    }

    private int calcularPrecioTDT() {
        // Precio de acuerdo a la TDT
        if (this.tieneTDT) {
            return 250000;
        }
        return 0;
    }
}
