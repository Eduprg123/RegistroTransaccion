public class CalculadoraFactoriali 
{
    // declaración recursiva del método factorial 
    public static long factorial(long numero) 
    { 
        long resultado = 1;
  
         // declaración iterativa del método factorial
         for (long i = numero; i >= 1; i--)
            resultado *= i;                     
  
         return resultado;
     } 
  
      // muestra los factoriales para los valores del 0 al 10
      public static void main(String[] args)
      {
         // calcula los factoriales del 0 al 10
         for (int contador = 0; contador <= 10; contador++)
          System.out.printf("%d! = %d%n", contador, factorial(contador));
     } 
   } // fin de la clase CalculadoraFactorial

