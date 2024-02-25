package org.example.ajedrezfx;

public class Peon extends Pieza {
    private boolean primerMov = true;

    public Peon(boolean color) {
        super(color);
    }

    @Override
    public boolean validoMovimiento(Movimiento mov) {
        boolean valido = false;
        if (!color) {
            if (mov.esHorizontal()) {
                if (primerMov) {
                    if (mov.saltoHorizontal() == 1 || mov.saltoHorizontal() == 2) {
                        valido = true;
                        primerMov = false;
                    }
                } else {
                    if (mov.saltoHorizontal() == 1) {
                        valido = true;
                        primerMov = false;
                    }
                }
            } else if (mov.esDiagonal()) {
                if (Math.abs(mov.saltoHorizontal()) == 1 || Math.abs(mov.saltoVertical()) == 1) {
                    valido = true;
                    primerMov = false;
                }
            }
        }else {
            if (mov.esHorizontal()) {
                if (primerMov) {
                    if (mov.saltoHorizontal() == -1 || mov.saltoHorizontal() == -2) {
                        valido = true;
                        primerMov = false;
                    }
                } else {
                    if (mov.saltoHorizontal() == -1) {
                        valido = true;
                        primerMov = false;
                    }
                }
            } else if (mov.esDiagonal()) {
                if (Math.abs(mov.saltoHorizontal()) == 1 || Math.abs(mov.saltoVertical()) == 1) {
                    valido = true;
                    primerMov = false;
                }
            }
        }
        return valido;
    }

    @Override
    public String getUnicode() {
        return color ? "\u2659" : "\u265F";
    }

}
