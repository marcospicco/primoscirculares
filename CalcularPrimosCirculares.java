
package primoscircularesfinal;

import java.util.ArrayList;


public class CalcularPrimosCirculares extends Thread
{
        private Buffer b;
        private static ArrayList <Integer> primosCirculares;
        private static int totalCirculares;
        
        public CalcularPrimosCirculares(Buffer b)
        {
            this.b=b;
            primosCirculares=new ArrayList();
            
        }
        
        @Override
        public void run()
        {
            int posibleCircular=0;
            try {
                    posibleCircular=b.extraer();
            } catch (InterruptedException ex) {
                    ex.printStackTrace();
            }
            while(posibleCircular!=-1)
            {
                
                    
                    
                    
                    int posibleCircularAux=posibleCircular;
                    ArrayList <Integer> aux = new ArrayList <>();
                    while(posibleCircularAux!=0) //paso los digitos al arreglo
                    {
                        aux.add(posibleCircularAux%10);
                        posibleCircularAux=(int) posibleCircularAux/10;
                    }

                    if(aux.size()>1)
                    {
                        ArrayList <Integer> aux2 = new ArrayList <>();
                        int cont=aux.size();
                        while(0<cont) //ordeno igual a posibleCircular;
                        {
                            aux2.add(aux.get(cont-1));
                            cont--;
                        }

                        boolean esCircular=true;
                        int k=0;
                        while(k<aux.size()-1) //verifico si todos los giros son primos
                        {
                            cont=aux.size();
                            int ultimo=aux2.get(cont-1);
                            while(1<cont)//hago shift a derecha
                            {
                                aux2.set(cont-1, aux2.get(cont-2));
                                cont--;
                            }
                            aux2.set(0, ultimo);


                            posibleCircularAux=0;
                            cont=aux.size();
                            int acu=1;
                            while(0<cont)
                            {
                                posibleCircularAux=posibleCircularAux+(aux2.get(cont-1)*acu);
                                acu=acu*10;
                                cont--;
                            }

                            int i=2;
                            while(i<=(int)Math.sqrt(posibleCircularAux) && i>1) //verifica si es primo
                            {
                                if(posibleCircularAux%i==0)
                                {
                                    esCircular=false;
                                    i=-1;
                                    k=aux.size()-1;
                                }
                                i++;
                            }
                            k++;
                        }

                        if(k==aux.size()-1 && esCircular==true)
                        {
                            totalCirculares++;
                            primosCirculares.add(posibleCircular);
                            System.out.println(posibleCircular);
                        }


                    }
                    else
                    {
                        totalCirculares++;
                        primosCirculares.add(posibleCircular);
                        System.out.println(posibleCircular);
                    }
                    try {
                            posibleCircular=b.extraer();
                    } catch (InterruptedException ex) {
                            ex.printStackTrace();
                    }
                    
                }
            System.out.println("Total De Primos Circulares = " + totalCirculares);
            }
        
            
        public static void mostrar()
        {
            System.out.println(totalCirculares);
            int i=0;
            while(i<primosCirculares.size())
            {
                System.out.println(primosCirculares.get(0));
                i++;
                        
            }
        }
}
