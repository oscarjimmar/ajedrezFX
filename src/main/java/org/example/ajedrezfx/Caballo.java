package org.example.ajedrezfx;

public class Caballo extends Pieza{
    public Caballo(boolean color) {
        super(color);
    }

    @Override
    public String getUnicode() {
        return color ? "\u2658" : "\u265E";
    }

    @Override
    public boolean validoMovimiento(Movimiento mov) {
        boolean valido = false;
        if (Math.abs(mov.getPosInicio().getColumna()-mov.getPosFinal().getColumna())==2||Math.abs(mov.getPosInicio().getFila()-mov.getPosFinal().getFila())==2){
            if (Math.abs(mov.getPosInicio().getColumna()-mov.getPosFinal().getColumna())==1||Math.abs(mov.getPosInicio().getFila()-mov.getPosFinal().getFila())==1){
                   valido=true;
            }
        }
        return valido;
    }
}
