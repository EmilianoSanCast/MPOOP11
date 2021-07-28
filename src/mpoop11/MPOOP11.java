/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpoop11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emiliano SC
 */
public class MPOOP11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("############File########");
        try {
            // TODO code application logic here
            File archivo = new File("archivo.txt");
            System.out.println(archivo.exists());
            boolean seCreo = archivo.createNewFile();
            System.out.println(seCreo);
            System.out.println(archivo.exists());
        } catch (IOException ex) {
            Logger.getLogger(MPOOP11.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.out.println("############FileOutPut########");
         FileOutputStream fos = null;
         byte[] buffer = new byte[150];
         int nBytes;
         try{
             System.out.println("Escribir el texto a guardar en el archivo");
             nBytes= System.in.read(buffer);
             fos = new FileOutputStream("fos.txt");
             fos.write(buffer, 0, nBytes);
         }
         catch(IOException ex){
             System.out.println("Error: "+ex.toString());
                 }
         finally{
             if(fos != null){
                 try {
                     fos.close();
                 } catch (IOException ex) {
                     Logger.getLogger(MPOOP11.class.getName()).log(Level.SEVERE, null, ex);
                 }
                
             }
             
         }
         System.out.println("#####FileInputStream####");
         FileInputStream fis = null;
         String texto;
        try {
            fis = new FileInputStream("fos.txt");
            nBytes = fis.read(buffer, 0, 150);
             texto= new String(buffer, 0, nBytes);
            System.out.println(texto);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MPOOP11.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MPOOP11.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("#####FileWriter####");
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escribe el texto a guardar: ");
        try {
            texto = br.readLine();
            FileWriter fw = new FileWriter("fw.txt");
            BufferedWriter bw = new BufferedWriter (fw);
            PrintWriter salida = new PrintWriter(bw);
            salida.println(texto);
            salida.close();    
        } catch (IOException ex) {
            Logger.getLogger(MPOOP11.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("#####FileReader####");
        try {
            FileReader fr = new FileReader("fw.txt");
            br = new BufferedReader(fr); 
            System.out.println("El texto contenido en el archivo es: ");
            String linea = br.readLine();
            while(linea != null){
                System.out.println(linea);
                linea = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MPOOP11.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MPOOP11.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("#####LecturaDeTeclado####");
        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escribir texto deseado: ");
            texto= br.readLine();
            System.out.println("El texto escrito fue: "+texto);
            
        }catch(IOException ioe){
            System.out.println("Error al leer caracteres "+ioe);
            
        }
         System.out.println("#####StringTokenizer####");
         try{
             br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escribir texto: ");
            texto= br.readLine();
            
             System.out.println("El texto separado por espacios es: ");
             StringTokenizer st = new StringTokenizer(texto);
             while(st.hasMoreTokens()){
                 System.out.println(st.nextToken());
             }     
         }catch (Exception e){
             System.out.println("Error al leer del teclado");
             e.printStackTrace();
         }
         System.out.println("#####Serialization####");
        
        try{
            Date d = new Date ();
            System.out.println(d);
            FileOutputStream f = new FileOutputStream("date.ser");
            ObjectOutputStream s = new ObjectOutputStream (f);
            s.writeObject (d);
            s.close();    
        }catch (IOException e){
            e.printStackTrace ();
        }
         System.out.println("#####Deserealizar####");
         Date d = null;
         try{
             FileInputStream f = new FileInputStream("date.ser");
             ObjectInputStream s = new ObjectInputStream (f);
             d = (Date) s.readObject ();
             s.close();
         }catch(Exception e){
             e.printStackTrace();
         }
         System.out.println("Deserialized Date object from date.ser");
         System.out.println("Date: "+d);
         
        
        
    
         
         
    }
   
}
