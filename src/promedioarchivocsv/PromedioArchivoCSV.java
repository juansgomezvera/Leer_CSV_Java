/*
 Basado en el codigo de Cesar Aceros.
 Creado por Juan Sebastian Gomez Vera
 https://www.tutorialspoint.com/how-to-read-the-data-from-a-csv-file-in-java
 */

package promedioarchivocsv;
import java.io.*;
import java.util.Scanner;

public class PromedioArchivoCSV {
    public static final String delimiter = ",";
    public static void read(String csvFile) {
     try {
         /*A continuación el proceso para pedir el dato de la cantidad de 
          estudiantes presentes en el curso */
         Scanner entrada = new Scanner(System.in);
         int cantNot;
         System.out.print("Ingrese la cantidad de notas: ");
         cantNot = entrada.nextInt();
         System.out.println();
         /*Ahora abriremos el archivo y creamos el string que almacenará la
          linea */
         File file = new File(csvFile);
         FileReader fr = new FileReader(file);
         BufferedReader br = new BufferedReader(fr);
         String line;
         String[] tempArr;
         /* Creamos variables que nos servirán para almacenar las sumas y 
          acumulados del promedio */
         float sum = 0;
         int nest = 0;
         /* En este while leeremos linea por linea el archivo */
         while((line = br.readLine()) != null) {
             float num = 0;
             tempArr = line.split(delimiter);
             /* Ahora leeremos la primera columna que contiene notas, que 
              es la 2, y leeremos hasta la columna +1 de la cantidad de notas
              que el usuario indicó */
             for(int i = 2; i<=cantNot+1 ;i++) {
                 num += Float.parseFloat(tempArr[i]);
                }
             /* Haremos operaciones para el promedio individual y lo imprimimos,
             y acumuladores para el promedio total */
             float prom = num /cantNot;  
             nest ++;
             System.out.println("Promedio del estudiante "+nest+": "+prom);       
             sum += prom;                           
            }
         /* Haremos operaciones para el promedio total y lo imprimimos */
         float promT = sum / nest ;  
         System.out.println();
         System.out.println("El promedio total del salón es: "+promT); 
         System.out.println();
         br.close();
        }
         catch(IOException ioe) {
         ioe.printStackTrace();
        }
    }  
    
    public static void main(String[] args) {
     String csvFile = "C:\\Users\\chach\\OneDrive\\Documentos\\UNIVERSIDAD\\CUARTO SEMESTRE\\PROGRAMACION APLICADA II\\Proyectos Java\\PromedioArchivoCSV\\src\\promedioarchivocsv\\PromedioCSV.csv";
     PromedioArchivoCSV.read(csvFile);
    }  
}