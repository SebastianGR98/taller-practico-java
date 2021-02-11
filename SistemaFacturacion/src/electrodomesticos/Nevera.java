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

    @Override
    protected void calcularPrecio() {
        super.calcularPrecio();

        if (this.capacidad > 120) {
            for (int i = 120; i <= this.capacidad; i+=10) {
                this.precio += (this.precio * 0.05);
            }
        }
    }
}
