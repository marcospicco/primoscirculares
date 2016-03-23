package primoscircularesfinal;




public class CalcularPrimos extends Thread
    {
        private int numeroMaximo;
        private Buffer b;
        

        
        public CalcularPrimos(Buffer b,int num)
        {
            this.numeroMaximo=num;
            this.b=b;
        }
        
        @Override
        public void run()
        {
            int posiblePrimo=2;
            while(posiblePrimo<=numeroMaximo)
            {
                int i=2;
                while(i<=(int)Math.sqrt(posiblePrimo) && i>1)
                {
                    if(posiblePrimo%i==0)
                    {
                        i=-1;
                    }
                    
                    i++;
                }
                if(i!=0)
                {
                    try {
                        b.poner(posiblePrimo);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    
                }
                posiblePrimo++;
            }
            try {
                b.poner(-1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
