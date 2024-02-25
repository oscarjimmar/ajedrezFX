package org.example.ajedrezfx;

public class Rey extends Pieza {
    private boolean primerMov = true;
    public Rey(boolean color) {
        super(color);
    }

    @Override
    public String getUnicode() {
        return color ? "\u2654" : "\u265A";
    }


    @Override
    public boolean validoMovimiento(Movimiento mov) {
        boolean respuesta = false;
        if (mov.esVertical() || mov.esHorizontal() || mov.esDiagonal())
            if (Math.abs(mov.saltoHorizontal()) == 1 || Math.abs(mov.saltoVertical()) == 1 ) {
                respuesta = true;
                primerMov=false;
            }
        return respuesta;
    }
}