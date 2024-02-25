package org.example.ajedrezfx;

public class Torre extends Pieza{
    private boolean primerMov = true;
    public Torre(boolean color) {
        super(color);

    }

    @Override
    public String getUnicode() {
        return color ? "\u2656" : "\u265C";
    }

    @Override
    public boolean validoMovimiento(Movimiento mov) {
        boolean respuesta=false;
        if (mov.esVertical()|| mov.esHorizontal()) {
            respuesta = true;
            primerMov = false;
        }
        return respuesta;
    }
}
