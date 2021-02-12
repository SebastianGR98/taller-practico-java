package electrodomesticos;

public class Televisor extends Electrodomestico {
    private int tamano;
    private boolean tieneTDT;

    public Televisor(char consumo, String procedencia, int tamano, boolean tieneTDT) {
        super(consumo, procedencia);
        this.tamano = tamano;
        this.tieneTDT = tieneTDT;
        calcularPrecio();
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

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tamaño: " + getTamano());

        if (isTieneTDT()) {
            System.out.println("Tiene TDT");
        } else {
            System.out.println("No tiene TDT");
        }
    }
}
