package primoscircularesfinal;

import java.util.ArrayList;


public class PrimosCircularesFinal {

    private final int NUMEROMAXIMO = 1000000;
   
    
    public void ejecutar()
    {
       Buffer b=new Buffer(5);

       CalcularPrimos p=new CalcularPrimos(b, NUMEROMAXIMO);
       CalcularPrimosCirculares pc=new CalcularPrimosCirculares(b);
       p.start();
       pc.start();
       
       
    }
    
    public static void main(String[] args) {
        PrimosCircularesFinal p=new PrimosCircularesFinal();
        p.ejecutar();
    }
    
}
