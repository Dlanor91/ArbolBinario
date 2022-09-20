package inicio;

import ab.AB;
import ab.Nodo;

public class Main {
    public static void main(String[] args) { //creo con psvm y ahi el intelligent identifica como proyecto de inicio
        Nodo subIzqDer = new Nodo(5,new Nodo(6),new Nodo(3));// seria un sub nodo
        Nodo subIzq = new Nodo(10,null,null);// seria un sub nodo
        Nodo subDer = new Nodo(1,null,null);
        Nodo raiz = new Nodo(8,subIzq,subDer);

        //Nodo subIzqDer2 = new Nodo(5,new Nodo(6),new Nodo(3));// seria un sub nodo
        Nodo subIzqDer2 = new Nodo(5,new Nodo(6),new Nodo(3));// seria un sub nodo
        Nodo subIzq2 = new Nodo(10,new Nodo(7),subIzqDer2);// seria un sub nodo
        //Nodo subDer = new Nodo(1,new Nodo(4),new Nodo(0));
        Nodo raiz2 = new Nodo(8,subIzq2,null);
        AB ab1 =new AB(raiz2);

        //Nodo subIzqDer = new Nodo(5,new Nodo(6),new Nodo(3));// seria un sub nodo
        //Nodo subIzq = new Nodo(10,new Nodo(7),subIzqDer);// seria un sub nodo
        //Nodo subDer = new Nodo(1,new Nodo(4),new Nodo(0));
        //Nodo raiz = new Nodo(8,subIzq,subDer);

        AB ab = new AB(raiz);
        System.out.println("ab.cantNodos() 9 = " + ab.cantNodos());//soutv captura la variable
        System.out.println("ab.cantHojas() 5 = " + ab.cantHojas());
        System.out.println("ab.altura() 3 = " + ab.altura());
        System.out.println("ab.todosPares() false = " + ab.todosPares());

        System.out.println("ab.pertenece() 3 true = " + ab.pertenece(3));
        System.out.println("ab.pertenece() 11 false = " + ab.pertenece(11));
        System.out.println("ab.pertenece() 7 true = " + ab.pertenece(7));
        System.out.println("ab.pertenece() 20 false = " + ab.pertenece(20));

        System.out.println("ab.equilibrado() false = " + ab.equilibrado());

        System.out.println("ab.iguales(ab1) true = "+ab.iguales(ab1));

        System.out.println("ab.clon() true = "+ab.clon());
        System.out.println("ab.espejo() true = "+ab.espejo());

    }
}
