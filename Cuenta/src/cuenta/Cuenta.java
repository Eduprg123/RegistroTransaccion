
package cuenta;

import java.io.Serializable; 
import java.io.FileNotFoundException;     
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Paths;
import java.util.Formatter;            
import java.util.NoSuchElementException; 
import java.util.Scanner;

class Cuenta implements Serializable{
    
     private int cuenta; 
     private String primerNombre;   
     private String apellidoPaterno;
    private double saldo;
    
     // inicializa un objeto Cuenta con valores predeterminados
     public Cuenta() 
   {
   this(0, "", "", 0.0); // llama a otro constructor
    } 
     // inicializa un objeto Cuenta con los valores proporcionados
     public Cuenta(int cuenta, String primerNombre, 
        String apellidoPaterno, double saldo)
     {
       this.cuenta = cuenta;
       this.primerNombre = primerNombre;
       this.apellidoPaterno = apellidoPaterno;
       this.saldo = saldo;      
     }
     
      // establece el número de cuenta   
      public void establecerCuenta(int cuenta)
    {
         this.cuenta = cuenta;
     } 
      // obtiene el número de cuenta   
      public int obtenerCuenta() 
      { 
         return cuenta; 
     } 
      // establece el primer nombre   
      public void establecerPrimerNombre(String primerNombre)
      {
       this.primerNombre = primerNombre;
      } 
      // obtiene el primer nombre   
      public String obtenerPrimerNombre() 
     { 
         return primerNombre; 
      } 
     
    // establece el apellido paterno   
      public void establecerApellidoPaterno(String apellidoPaterno)
    {
       this.apellidoPaterno = apellidoPaterno;
     } 
 // obtiene el apellido paterno   
     public String obtenerApellidoPaterno() 
      {
       return apellidoPaterno; 
    } 
    // establece el saldo  
     public void establecerSaldo(double saldo)
      {
        this.saldo = saldo;
      } 
  
      // obtiene el saldo   
    public double obtenerSaldo() 
     { 
        return saldo; 
     } 
 } //

 class RegistroTransaccion{
       


  private static ObjectInputStream entAntMaest, entTransaccion, salNuevMaest;// envía los datos a un archivo      
   // abre el archivo clientes.txt
      public static void abrirArchivo()
     {
         try
        {
            Formatter entAntMaest = new Formatter("nuevomaest.txt"); // abre el archivo
        }
         catch (SecurityException securityException)
         {
            System.err.println("Permiso de escritura denegado. Terminando.");
            System.exit(1); // termina el programa
         } 
         catch (FileNotFoundException fileNotFoundException)
         {
            System.err.println("Error al abrir el archivo. Terminando.");
            System.exit(1); // termina el programa
         } 
 
     }

   public static void agregarRegistros()
   {
       Scanner entrada = new Scanner(System.in);
   
  
        System.out.printf("%s%n%s%n? ", 
           "Escriba numero de cuenta, primer nombre, apellido paterno y saldo.",
           "Escriba el indicador de fin de archivo para terminar la entrada.");
 
         while (entrada.hasNext()) // itera hasta el indicador de fin de archivo
         {
            try 
            {
               // crea nuevo registro; este ejemplo asume una entrada válida
               Cuenta cuenta = new Cuenta();
               cuenta.establecerCuenta(entrada.nextInt()); 
               cuenta.establecerPrimerNombre(entrada.next());
               cuenta.establecerApellidoPaterno(entrada.next());
               cuenta.establecerSaldo(entrada.nextDouble());
  
             // serializa el objeto registro en el archivo
             // entTransaccion.writeObject(cuenta);         
            } 
            catch (NoSuchElementException elementException)
            {
              System.err.println("Entrada invalida. Intente de nuevo.");
               entrada.nextLine(); // d escarta la entrada para que el usuario pueda intentar de nuevo 
           } 
           
             System.out.print("? ");
        }
          // cierra el archivo y termina la aplicación
}
   //Buscar registo por Numero de Cuenta
     public static void BuscarRegistros(int numerCuent)
     {
         // abre el archivo y procesa el contenido
       try (Scanner antmaest = new Scanner(Paths.get("antmaest.txt")))
       {
          while (antmaest.hasNext()) // más datos a leer
           { 
              int numeroCuenta = antmaest.nextInt();
              String primerNombre = antmaest.next();
               String apellidoPaterno = antmaest.next();
              double saldo = antmaest.nextDouble();
 
               // si el tipo de cuenta es apropiado, muestra el registro
               if (numeroCuenta == numerCuent)       
                  System.out.printf("%-10d%-12s%-12s%10.2f%n", numeroCuenta,
                     primerNombre, apellidoPaterno, saldo);
               else
                 antmaest.nextLine(); // descarta el resto del registro actual
           }
         }
         catch (NoSuchElementException | 
            IllegalStateException | IOException e)
         {
            System.err.println("Error al procesar el archivo. Terminando.");
           System.exit(1);
         } 
 
      } // fin del método leerRegistros 
     
      //leerRegistros
     public static void leerRegistros()
     {
         // abre el archivo y procesa el contenido
       try (Scanner antmaest = new Scanner(Paths.get("antmaest.txt")))
       {
          while (antmaest.hasNext()) // más datos a leer
           { 
              int numeroCuenta = antmaest.nextInt();
              String primerNombre = antmaest.next();
               String apellidoPaterno = antmaest.next();
              double saldo = antmaest.nextDouble();
               // si el tipo de cuenta es apropiado, muestra el registro
                  System.out.printf("%-10d%-12s%-12s%10.2f%n", numeroCuenta,
                     primerNombre, apellidoPaterno, saldo);
               
           }
         }
         catch (NoSuchElementException | 
            IllegalStateException | IOException e)
         {
            System.err.println("Error al procesar el archivo. Terminando.");
           System.exit(1);
         } 
 
      } // fin del método leerRegistros 
  // cierra el archivo y termina la aplicación
     public static void cerrarArchivo()
      {
         try
        {
            if (entAntMaest != null)
              entAntMaest.close();
         } 
        catch (IOException ioException)
        {
           System.err.println("Error al cerrar el archivo. Terminando.");
            System.exit(1);
        } 
     }  
 }

class TestRegistroTransaccion{
   
    public static void main(String[] args) {
        
        RegistroTransaccion regtrans = new RegistroTransaccion();
        regtrans.agregarRegistros();   //Metodo Agregar registro
        regtrans.cerrarArchivo();      //cerramos el archivo
        regtrans.BuscarRegistros(1001); //proceso para buscar un registo por numero de cuenta
        
    }
}


  

 

    

