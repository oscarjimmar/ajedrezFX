package org.example.ajedrezfx;

public class Alfil extends Pieza{
    public Alfil(boolean color) {
        super(color);
    }

    @Override
    public String getUnicode() {
        return color ? "\u2657" : "\u265D";
    }


    @Override
    public boolean validoMovimiento(Movimiento mov) {
        Boolean valido=false;
        if (mov.esDiagonal())
            valido=true;
        return valido;
    }
}
