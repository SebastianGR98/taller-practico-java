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
}
