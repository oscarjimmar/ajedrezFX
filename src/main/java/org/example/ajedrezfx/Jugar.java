package org.example.ajedrezfx;

import javafx.fxml.Initializable;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Jugar  implements Initializable {
    public static void jugar() throws UnsupportedEncodingException {
        Scanner scan = new Scanner(System.in);
        Tablero tablero = new Tablero();
        boolean turn = false;
        boolean finJuego = false;
        Juego movi = new Juego(turn);
        while (!finJuego) {
            if (!turn) {
                tablero.pintarTablero();
                System.out.println("Turno Blancas");
                System.out.println("jugada");
                String jugadadw = scan.nextLine();
                if (movi.jugada(jugadadw, tablero) != null) {
                    Posicion inicio = movi.jugada(jugadadw, tablero).getPosInicio();
                    Posicion fin = movi.jugada(jugadadw, tablero).getPosFinal();
                    Pieza aux = tablero.DevolverPieza(inicio);
                    if (aux != null && aux.validoMovimiento(movi.jugada(jugadadw, tablero))) {
                        if (!tablero.hayPieza(inicio) && !tablero.DevolverPieza(inicio).getColor()) {
                            //if (!tablero.DevolverPieza(inicio).getClass().getSimpleName().equalsIgnoreCase("Peon"))
                            if (!tablero.hayPiezasEntre(movi.jugada(jugadadw, tablero))/*&&!tablero.DevolverPieza(inicio).getClass().getSimpleName().equalsIgnoreCase("Peon")*/) {
                                if (tablero.DevolverPieza(inicio).getClass().getSimpleName().equalsIgnoreCase("Peon")) {
                                    if (tablero.hayPieza(fin) && !movi.jugada(jugadadw, tablero).esDiagonal()) {
                                        tablero.ponPieza(tablero.DevolverPieza(inicio), fin);
                                        tablero.quitaPieza(inicio);
                                        turn = true;
                                        if (tablero.hayPromocion(movi.jugada(jugadadw, tablero))) {
                                            tablero.piezaPromocion(movi.jugada(jugadadw, tablero));
                                        }
                                    } else if (movi.jugada(jugadadw, tablero).esDiagonal() && tablero.hayPieza(fin)) {
                                        System.out.println("movimiento no valido");
                                    } else if (tablero.DevolverPieza(inicio).getColor() != tablero.DevolverPieza(fin).getColor() && !tablero.hayPieza(fin) && movi.jugada(jugadadw, tablero).esDiagonal()) {
                                        if (tablero.DevolverPieza(fin).getClass().getSimpleName().equalsIgnoreCase("Rey")) {
                                            finJuego = true;
                                        } else {
                                            tablero.quitaPieza(fin);
                                            tablero.ponPieza(tablero.DevolverPieza(inicio), fin);
                                            tablero.quitaPieza(inicio);
                                            turn = true;
                                            if (tablero.hayPromocion(movi.jugada(jugadadw, tablero))) {
                                                tablero.piezaPromocion(movi.jugada(jugadadw, tablero));
                                            }
                                        }
                                    } else
                                        System.out.println("movimiento no valido");
                                } else {
                                    if (tablero.hayPieza(fin)) {
                                        tablero.ponPieza(tablero.DevolverPieza(inicio), fin);
                                        tablero.quitaPieza(inicio);
                                        turn = true;
                                    } else if (tablero.DevolverPieza(inicio).getColor() != tablero.DevolverPieza(fin).getColor() && !tablero.DevolverPieza(inicio).getClass().getSimpleName().equalsIgnoreCase("Peon")) {
                                        if (tablero.DevolverPieza(fin).getClass().getSimpleName().equalsIgnoreCase("Rey")) {
                                            finJuego = true;
                                        } else {
                                            tablero.quitaPieza(fin);
                                            tablero.ponPieza(tablero.DevolverPieza(inicio), fin);
                                            tablero.quitaPieza(inicio);
                                            turn = true;
                                        }
                                    } else
                                        System.out.println("movimiento no valido");
                                    /* else if (tablero.DevolverPieza(inicio).getColor() != tablero.DevolverPieza(fin).getColor() && !tablero.hayPieza(fin)) {
                                        if (movi.jugada(jugadadw, tablero).esDiagonal()) {
                                            tablero.quitaPieza(fin);
                                            tablero.ponPieza(tablero.DevolverPieza(inicio), fin);
                                            tablero.quitaPieza(inicio);
                                            turn = true;
                                        }
                                    } else
                                        System.out.println("movimiento no valido");*/
                                }
                            } else
                                System.out.println("movimiento no valido");
                        } else
                            System.out.println("no valido");
                    } else
                        System.out.println("no valido");

                } else
                    System.out.println("jugada no valida");
            } else {
                tablero.pintarTablero();
                System.out.println("Turno Negras");
                System.out.println("jugada");
                String jugadadw = scan.nextLine();
                if (movi.jugada(jugadadw, tablero) != null) {
                    Posicion inicio = movi.jugada(jugadadw, tablero).getPosInicio();
                    Posicion fin = movi.jugada(jugadadw, tablero).getPosFinal();
                    Pieza aux = tablero.DevolverPieza(inicio);
                    if (aux != null && aux.validoMovimiento(movi.jugada(jugadadw, tablero))) {
                        if (!tablero.hayPieza(inicio) && tablero.DevolverPieza(inicio).getColor()) {
                            if (!tablero.hayPiezasEntre(movi.jugada(jugadadw, tablero))) {
                                if (tablero.DevolverPieza(inicio).getClass().getSimpleName().equalsIgnoreCase("Peon")) {
                                    if (tablero.hayPieza(fin) && !movi.jugada(jugadadw, tablero).esDiagonal()) {
                                        tablero.ponPieza(tablero.DevolverPieza(inicio), fin);
                                        tablero.quitaPieza(inicio);
                                        turn = false;
                                        if (tablero.hayPromocion(movi.jugada(jugadadw, tablero))) {
                                            tablero.piezaPromocion(movi.jugada(jugadadw, tablero));
                                        }
                                    } else if (movi.jugada(jugadadw, tablero).esDiagonal() && tablero.hayPieza(fin)) {
                                        System.out.println("movimiento no valido");
                                    } else if (tablero.DevolverPieza(inicio).getColor() != tablero.DevolverPieza(fin).getColor() && !tablero.hayPieza(fin) && movi.jugada(jugadadw, tablero).esDiagonal()) {
                                        if (tablero.DevolverPieza(fin).getClass().getSimpleName().equalsIgnoreCase("Rey")) {
                                            finJuego = true;
                                        } else {
                                            tablero.quitaPieza(fin);
                                            tablero.ponPieza(tablero.DevolverPieza(inicio), fin);
                                            tablero.quitaPieza(inicio);
                                            turn = false;
                                            if (tablero.hayPromocion(movi.jugada(jugadadw, tablero))) {
                                                tablero.piezaPromocion(movi.jugada(jugadadw, tablero));
                                            }
                                        }
                                    } else
                                        System.out.println("movimiento no valido");
                                } else {
                                    //if (!tablero.Enroque(movi.jugada(jugadadw, tablero))) {
                                        if (tablero.hayPieza(fin)) {
                                            tablero.ponPieza(tablero.DevolverPieza(inicio), fin);
                                            tablero.quitaPieza(inicio);
                                            turn = false;
                                        } else if (tablero.DevolverPieza(inicio).getColor() != tablero.DevolverPieza(fin).getColor() && !tablero.DevolverPieza(inicio).getClass().getSimpleName().equalsIgnoreCase("Peon")) {
                                            if (tablero.DevolverPieza(fin).getClass().getSimpleName().equalsIgnoreCase("Rey")) {
                                                finJuego = true;
                                            } else {
                                                tablero.quitaPieza(fin);
                                                tablero.ponPieza(tablero.DevolverPieza(inicio), fin);
                                                tablero.quitaPieza(inicio);
                                                turn = false;
                                            }
                                        } else
                                            System.out.println("movimiento no valido");
                                    /*} else if (tablero.Enroque(movi.jugada(jugadadw, tablero))) {
                                        //tablero.hacerEnroque(movi.jugada(jugadadw, tablero));
                                    } else
                                        System.out.println("movimiento no valido");*/

                                }
                            } else
                                System.out.println("movimiento no valido");
                        } /*else if (tablero.Enroque(movi.jugada(jugadadw, tablero))) {
                            //tablero.hacerEnroque(movi.jugada(jugadadw, tablero));
                            tablero.ponPieza(tablero.DevolverPieza(inicio),fin.getColumna()+1, fin.getFila() );
                        }*/ else
                            System.out.println("no valido");
                    } else
                        System.out.println("movv no valido");
                } else
                    System.out.println("jugada no valida");
            }
        }
        System.out.println("fin de la partida");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
