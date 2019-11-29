/* PROBLEMA 1
 * Programa en java que crea tres hilos y los ejecuta. Los hilos escriben 25 veces el número de iteración
del bucle y su nombre. En cada iteración, después de escribir su nombre, se bloquean durante un
tiempo aleatorio de segundos y después vuelven a estar disponibles para su ejecución. El programa
principal no terminará hasta que hayan terminado los tres hilos, escribiendo un mensaje que indique
que terminó.

PROBLEMA 2
Modifica el programa del ejercicio 1 para que los hilos se comporten de forma secuencial inverso,
(espera a que el tercer hilo acabe para que se ejecute el segundo y a su vez, que el segundo acabe
para que se ejecute el primero) y termina por último el programa principal escribiendo un mensaje que
indique que terminó.


 */
package lara_examen;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lara Vázquez Dorna
 */
public class Lara_Examen extends Thread{

     public Lara_Examen(String str) {
        super(str);

    }

     //metodo en el que se ejecutan las instruciones del hilo
    public void run() {
        
        //bucle que escribe 25 veces 
        for (int i = 0; i < 25; i++) {
            System.out.println("Iteración: "+i + " :Soy  " + getName());
         
            try {
              
                //esperan un tiempo indeterminado
                Thread.sleep((long) (1000 * Math.random()));
           
       
            } catch (InterruptedException ex) {
                Logger.getLogger(Lara_Examen.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }

        System.out.println("El hilo " + getName() + "ha terminado.");
    }
   
    public static void main(String[] args) throws InterruptedException {
       //crear hilos
        Lara_Examen h1 = new Lara_Examen("Hilo 1");
        Lara_Examen h2 = new Lara_Examen("Hilo 2");
        Lara_Examen h3 = new Lara_Examen("Hilo 3");

        /*
        //PROBLEMA 1
        //se inician los hilos
        h1.start();
        h2.start();
        h3.start();
        
        //obliga al resto de codigo a esperar a que la ejecucion del hilo se acabe para continuar las tareas.
        h1.join();
        h2.join();
        h3.join();
        */
        
        /*
        //PROBLEMA 2
        //se inician los hilos de forma inversa y por cada hilo se ejecuta el join para que este sea la primera ejecucion en realizarse
        h3.start();
        h3.join();
        h2.start();
        h2.join();
        h1.start();
        h1.join();
        */
        System.out.println("EL PROGRAMA HA TERMINADO"); 
        
    }
 
}
