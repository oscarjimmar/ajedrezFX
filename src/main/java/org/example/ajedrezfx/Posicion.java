package org.example.ajedrezfx;

public class Posicion {
    private int fila;
    private int columna;

    /**
     * constructor vacio de la clase posicion
     */
    public Posicion() {

    }

    /**
     * constructor de posicion que recibe dos parametros que son enteros fila y columna
     * @param fila hace referencia a la fila en la que esta la pieza
     * @param columna hace referencia a la columna en la que esta la pieza
     */
    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
