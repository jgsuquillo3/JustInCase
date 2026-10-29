/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciospractica;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Jeremy Suquillo
 */
public class SistemasdeInventario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Producto producto = new Producto();
        Inventario inv = new Inventario();
        int n=0;
        boolean validez = false;
        while(!validez){
        try{
            System.out.print("Cuantos productos desea registrar?: ");
            n = sc.nextInt();
            sc.nextLine();
            if (n <= 0) {
                System.out.println("Solo ingrese # positivos");
            }else{
                validez = true;
            }
        }
        catch(InputMismatchException e){
            System.out.println("Solo ingrese # validos");
            sc.nextLine();
            }
        for (int i = 0; i < n; i++) {
                System.out.println("Ingrese datos del producto " +(i+1));
                System.out.print("Codigo: ");
                int codigo = sc.nextInt();
                sc.nextLine();
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                double precio;
            do {
                 System.out.print("Precio: ");
                precio = sc.nextDouble();
                sc.nextLine();
                if (!Producto.validadPrecio(precio)) {
                  System.out.println("El precio debe ser mayor que 0");
                 }
            }while (!Producto.validadPrecio(precio));
                sc.nextLine();
                System.out.print("Stock: ");
                int stock = sc.nextInt();
                sc.nextLine();
                producto = new Producto(codigo, stock, nombre, precio);
                inv.agregarProducto(producto);
            }
    }

        //Escritura de Datos de un archivo de texto:
        try{
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("productos.txt")
            );

            for(Producto p : inv.getProductos()){
                bw.write("Codigo: " + p.getCodigo() + ", Nombre: " + p.getNombre()
                        + ", Precio: " + p.getPrecio() + ", Stock: " + p.getStock());
                bw.newLine();
            }

            bw.close();
            System.out.println("Datos almacenados correctamente ");

        }catch(IOException e){
            System.out.println("Error al guardar en el archivo");
        }
        //Lectura de Datos de un archivo de texto
        try{
            BufferedReader br = new BufferedReader(
                    new FileReader("productos.txt")
            );
            String linea;
            System.out.println("Datos leidos desde el archivo: ");

            while((linea = br.readLine()) != null){
                System.out.println(linea);
            }
            br.close();

        }catch(IOException e){
            System.out.println("Error al leer el archivo");
        }

        int op = 0;
        do{
        System.out.println("====================SISTEMA DE INVENTARIO====================");
        System.out.println("1. Mostrar informacion de los productos");
        System.out.println("2. Calcular subtotal del inventario");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opcion: ");
        op = sc.nextInt();
        sc.nextLine();
        switch(op){
            case 1:
                inv.mostrarProductos();
                break;
            case 2:
                System.out.println("=============================================================");
                System.out.println("Subtotal del inventario: "+inv.calcularInventario()+"$");
                System.out.println("=============================================================");
                break;
            case 3:
                break;
            default:
                System.out.println("Ingresar una opcion valida");
                break;
        }
        }while(op!=3);
    }
}