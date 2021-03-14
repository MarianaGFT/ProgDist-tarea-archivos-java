package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException {
        File myFile;
        myFile = new File("fileName124589.txt");

       createFile(myFile);
//      writeContent(myFile, "Esto es el contenido de la prueba WUUUUUUUU");
//        readContent(myFile);
//        getPath(myFile);
//        deleteFile(myFile);
    }

    public static void createFile(File myFile){
        try{
            if (myFile.createNewFile()) {
                System.out.println("Archivo creado con el nombre: " + myFile.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
        }
    }

    public static void writeContent(File myFile, String contents){
        FileWriter writer = null;
        try{
            writer= new FileWriter(myFile);
            writer.write(contents);
            System.out.println("Archivo editado: "+contents);
            writer.close();

        }catch (IOException e){
            System.out.println("Ocurrió un error durante la escritura: "+ e.getMessage());
        }
    }

    public static void readContent(File myFile) throws FileNotFoundException {
        try{
            Scanner reader = new Scanner(myFile);
            System.out.println("Leyendo el archivo....");
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ocurrió un error");
            e.printStackTrace();
        }
    }

    public static void getPath(File myFile){
        System.out.println("Ruta del archivo: "+myFile.getAbsolutePath());
    }

    public static void deleteFile(File myFile){
        if (myFile.delete()) {
            System.out.println("Archivo borrado: " + myFile.getName());
        } else {
            System.out.println("Error al eliminar el archivo");
        }
    }
}