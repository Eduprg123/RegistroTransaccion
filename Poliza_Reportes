import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Locale; 
import java.util.Scanner;

public class Poliza_Reportes {
    
     static  String[] vendedor = new String[6];  //listado  de vendedor   
    static  String[] nombres = new String[1002]; //almacena datos del excel
          static  String[] NSeguro = new String[1002]; 
          static  String[] TSeguro = new String[1002]; 
          static  String[] valor = new String[1002]; 
          static  String[] AContratacion = new String[1002];
          static  String[] AExpiracion = new String[1002];//fin de variable de excel
 
private static void LLenarArreglo( )
  { try {
            
            //FLUJO DE ENTRADA del archivo.
            Scanner inArchivo = new Scanner(new File("Listado_Venta-Polizas1.csv"));
            String contenido;
            int nroEst = 1; 
            System.out.println("POLIZAS  DE SEGUROS"  );
            while (inArchivo.hasNext()) {
                
                contenido = inArchivo.nextLine();
                String[] tokens = contenido.split(";");
                //System.out.println(tokens[0] + ", " + tokens[1] + ", " + tokens[2]);
               // System.out.printf("%-5s %-5s %-5s %-5s %-5s %-5s%n", tokens[0], tokens[1], tokens[2],tokens[3], tokens[4], tokens[5]);
               //llena los datos del Listado_Venta-Polizas1.csv en Vectores
               nombres[nroEst] = tokens[0];
                NSeguro[nroEst] = tokens[1];
                TSeguro[nroEst] = tokens[2];
                valor[nroEst] = tokens[3];
                AContratacion[nroEst] = tokens[4];
                AExpiracion[nroEst] = tokens[5];
                int i = 1;
                String[] fila = null;
                nroEst++;
            }        
        } catch (NumberFormatException numberFormatException) {
            System.err.println("Formato de numero invalido");
        } catch (Exception e) {
            System.err.println("Excepcion generada: " + e);
            System.exit(1); //Termina el programa.
        }
  
  } // fin del método ordenarArreglo

private static void ListaVendedor( )
  { 
    vendedor[0]= "Alina";
    vendedor[1]= "Jorge Luis";
    vendedor[2]= "Lourdes";
    vendedor[3]= "Mauricio";
    vendedor[4]= "Miguel";
    vendedor[5]= "Pilar";
    
  }
private static void SegurosVendidos( )
  {//declaracion de contadores
  double casa = 0;
  double coche = 0;
  double vida = 0;
  
      //vectos con listado de vendedor
 for(int i=0;i<vendedor.length-1;i++){   
       // System.out.println(valor[i]);
        //vector con los datos del excel para proceser hacer la busqueda
        //vectores tiene el mismo tamano y misma posicion
        for (int j = 0; j<nombres.length ; j++) {
            if (vendedor[i] == nombres[j]) {
                if (TSeguro[j]=="Casa") {
                     casa++;
                }else{
                    if (TSeguro[j]=="Coche") {
                        coche++;
                    }else{
                        vida ++ ;
                    }
                }  
            } 
           
        }
         //Imprimimos a nivel de Linea
            System.out.printf("%-5s %-5s %-5s %-5s  %-5s %n", vendedor[i], casa, coche, vida ,(casa+coche+vida) );
        //limpiamos contadores
        casa = 0;
        coche = 0;
        vida = 0;  
 }
  }

private static void MontoTotales( )
  {//declaracion de Acumuladores
  double casa = 0;
  double coche = 0;
  double vida = 0;
  
      //vectos con listado de vendedor
 for(int i=0;i<vendedor.length-1;i++){   
       // System.out.println(valor[i]);
        //vector con los datos del excel para proceser hacer la busqueda
        //vectores tiene el mismo tamano y misma posicion
        for (int j = 0; j<nombres.length ; j++) {
            if (vendedor[i] == nombres[j]) {
                if (TSeguro[j]=="Casa") {
                     casa =  Double.parseDouble(valor[j]) ;
                }else{
                    if (TSeguro[j]=="Coche") {
                        coche =  Double.parseDouble(valor[j]) ;
                    }else{
                        vida =  Double.parseDouble(valor[j]) ;
                    }
                }  
            } 
           
        }
         //Imprimimos a nivel de Linea
            System.out.printf("%-5s %-5s %-5s %-5s  %-5s %n", vendedor[i], casa, coche, vida ,(casa+coche+vida) );
        //limpiamos acumuladores
        casa = 0;
        coche = 0;
        vida = 0;  
 }
  }
private static void BusqeudaNombreporfecha( String nombr , int inicio, int fin)
  {//declaracion de Acumuladores
  double contar = 0;

   
       // System.out.println(valor[i]);
        //vector con los datos del excel para proceser hacer la busqueda
        //vectores tiene el mismo tamano y misma posicion
        for (int j = 0; j<nombres.length ; j++) {
            //pregunta por el nombre a buscar
            if (nombr == nombres[j]) {
               // pregunta si esta en el rango de la fecha
                if (Integer.parseInt( AExpiracion[j])  >= inicio && Integer.parseInt( AExpiracion[j]) <= fin  ) {
                     contar++;  
                }  
            }   
        }
         //Imprimimos
            System.out.printf("%-5s %-5s  %n", nombr, contar );
        
 
  }

private static void SegurosVendidosXFecha( int inicio, int fin)
  {//declaracion de contadores
  double casa = 0;
  double coche = 0;
  double vida = 0;
  
      //vectos con listado de vendedor
 for(int i=0;i<vendedor.length-1;i++){   
       // System.out.println(valor[i]);
        //vector con los datos del excel para proceser hacer la busqueda
        //vectores tiene el mismo tamano y misma posicion
        for (int j = 0; j<nombres.length ; j++) {
            if (vendedor[i] == nombres[j]) {
                if (Integer.parseInt( AExpiracion[j])  >= inicio && Integer.parseInt( AExpiracion[j]) <= fin  ) {
               
                 if (TSeguro[j]=="Casa") {
                     casa++;
                }else{
                    if (TSeguro[j]=="Coche") {
                        coche++;
                    }else{
                        vida ++ ;
                    }
                }    
                }
                 
            } 
           
        }
         //Imprimimos a nivel de Linea
            System.out.printf("%-5s %-5s %-5s %-5s  %-5s %n", vendedor[i], casa, coche, vida ,(casa+coche+vida) );
        //limpiamos contadores
        casa = 0;
        coche = 0;
        vida = 0;  
 }
  }

public static void main(String[] args) {
        Poliza_Reportes.LLenarArreglo();
        Poliza_Reportes.ListaVendedor();
        Poliza_Reportes.SegurosVendidos();//figura 2
        Poliza_Reportes.MontoTotales();//figura 3
        Poliza_Reportes.BusqeudaNombreporfecha("Miguel", 2017 , 2018); //figura 4
        Poliza_Reportes.SegurosVendidosXFecha(2017 , 2018);//figura 5
            
 }
}//fin
