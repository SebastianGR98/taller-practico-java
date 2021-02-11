package electrodomesticos;

public class Electrodomestico {
    protected char consumo;
    protected String procedencia;
    protected int precio;

    public Electrodomestico(char consumo, String procedencia) {
        this.consumo = consumo;
        this.procedencia = procedencia;
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

    protected void setPrecio(int precio) {
        this.precio = precio;
    }
}
