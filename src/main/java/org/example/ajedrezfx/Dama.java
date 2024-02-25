package org.example.ajedrezfx;

public class Dama extends Pieza{

    public Dama(boolean color) {
        super(color);
    }

    @Override
    public String getUnicode() {
        return color ? "\u2655" : "\u265B";
    }

    @Override
    public boolean validoMovimiento(Movimiento mov) {
        boolean respuesta=false;
        if (mov.esVertical()|| mov.esHorizontal()||mov.esDiagonal())
            respuesta=true;
        return respuesta;
    }
}
