package electrodomesticos;

public class Nevera extends Electrodomestico{
    private int capacidad;

    public Nevera(char consumo, String procedencia, int capacidad) {
        super(consumo, procedencia);
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }
}
