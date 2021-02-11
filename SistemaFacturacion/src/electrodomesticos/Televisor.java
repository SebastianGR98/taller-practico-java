package electrodomesticos;

public class Televisor extends Electrodomestico {
    private int tamano;
    private boolean tieneTDT;

    public Televisor(char consumo, String procedencia, int tamano, boolean tieneTDT) {
        super(consumo, procedencia);
        this.tamano = tamano;
        this.tieneTDT = tieneTDT;
    }

    public int getTamano() {
        return tamano;
    }

    public boolean isTieneTDT() {
        return tieneTDT;
    }

    @Override
    protected void calcularPrecio() {
        super.calcularPrecio();

        // Si el tamaño es superior a 40 pulgadas y tiene sintonizador TDT
        this.precio += (calcularPrecioTamano() + calcularPrecioTDT());
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
