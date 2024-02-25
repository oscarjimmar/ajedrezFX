package org.example.ajedrezfx;

public abstract class Pieza {
    protected boolean primerMov = true;
    protected boolean color;
    protected String nombre;

    /**
     * metodo que devera ser implementado en las clases hijas
     * @param mov hace referencia al movimiento que va a hacer la pieza
     * @return devuelve si ese movimiento se puede hacer o no
     */
    public abstract boolean validoMovimiento(Movimiento mov);

    /**
     * constructor vacio de la clase pieza
     */
    public Pieza() {
    }

    /**
     * constructor de la clase pieza que inicializa el color y coje el nombre de la clase para la pieza
     * @param color establece si la pieza es negra o blanca
     */
    public Pieza(boolean color) {
        this.color = color;
        this.nombre=getClass().getSimpleName();
    }

    public boolean getColor() {
        return color;
    }

    public abstract String getUnicode() ;

    @Override
    public String toString() {
        return "Pieza{" +
                "color=" + color +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
