/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciospractica;
import java.util.ArrayList;
/**
 *
 * @author Jeremy Suquillo
 */
public class Inventario {
    //atributos
    private ArrayList<Producto> productos = new ArrayList<>();
    //constructores

    public Inventario() {
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    public void agregarProducto(Producto producto){
        productos.add(producto);
    }
    public void mostrarProductos(){
     for (Producto producto: productos){
        producto.mostrarDatos();
     }   
    }    
    public double calcularInventario(){
        double total = 0;
        for (Producto producto : productos){
            total = total + producto.calcularSubtotal();
        }
        return total;
    }
}
