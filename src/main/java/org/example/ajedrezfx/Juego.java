package org.example.ajedrezfx;

public class Juego {

    private boolean turno;

    public Juego(boolean turno) {
        turno = turno;
    }

    public boolean getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
    }

    /**
     * se utiliza para saber de que posicion a que posicion se va a mover una pieza
     *
     * @param jugada  este parametro es lo que introduce el usuario
     * @param tablero este parametro se utiliza para saber si hay una pieza en esa posicion
     * @return si se cumplen las condiciones devolvera el movimiento que hara mover a la pieza
     */
    public Movimiento jugada(String jugada, Tablero tablero) {
        if (jugada.length() == 4) {
            int col1 = jugada.toUpperCase().charAt(0) - 65;
            int fil1 = jugada.charAt(1) - 49;
            int col2 = jugada.toUpperCase().charAt(2) - 65;
            int fil2 = jugada.charAt(3) - 49;
            Movimiento mov = new Movimiento(new Posicion(col1, fil1), new Posicion(col2, fil2));
            if ((col1 >= 0 && col1 <= 8 && fil1 >= 0 && fil1 <= 8) && (col2 >= 0 && col2 <= 8 && fil2 >= 0 && fil2 <= 8)) {
                //if (tablero.hayPieza(col2, fil2) && tablero.devolverPieza(col1,fil1).getColor()!= tablero.devolverPieza(col2,fil2).getColor()) {
                return new Movimiento(new Posicion(col1, fil1), new Posicion(col2, fil2));
                //}
            }
        }
        return new Movimiento();
    }
}
