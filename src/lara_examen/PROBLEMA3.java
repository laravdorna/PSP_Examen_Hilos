/*
 * PROBLEMA 3
Modifica el programa del ejercicio 1 para que después de cada iteración, después de escribir su
nombre, dejen paso al otro hilo. Para resolver este programa, solo puede existir el programa principal
y un único código para los hilos (el programa principal crea un único hilo y el resto son creados
recurrentemente en el código del hilo).
 */
package lara_examen;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam2
 */
public class PROBLEMA3 extends Thread{
       private int nHilos;
     
       
       //constructor al que se le pasa el numero de hilos que se quieren 
    public PROBLEMA3(int num) {
        this.nHilos = num;
    }

   
    public void run() {
        
        //el hilo principal crea hilos y resta 1 al numero de hilos para que no cree 1 por cada iteracion del primer hilo
        PROBLEMA3 hilo = null;
        if (nHilos > 0) {
            hilo = new PROBLEMA3(nHilos - 1);
            hilo.start();
        }
        
        //bucle que escribe 25 veces 
        for (int i = 0; i < 25; i++) {
         
             System.out.println("Iteración: "+i + " :Soy el hilo " + nHilos);
              //el metodo yield para el hilo despues de que se ejecute una vez 
            Thread.yield();
            try {
                //el sleep
                Thread.sleep (1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PROBLEMA3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (nHilos > 0) {
            try {
                hilo.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(PROBLEMA3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("El hijo " + nHilos + " ha terminado");
    }
    public static void main(String[] args) {
      
        //inicializa el hilo al que se le pasa el numero de hilos 
        PROBLEMA3 hiloPrincipal = new PROBLEMA3(3);
        hiloPrincipal.start();
        try {
            hiloPrincipal.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("EL PROGRAMA DEL PROBLEMA 3 HA ACABADO");
    }

    
}
