/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciospractica;

/**
 *
 * @author Jeremy Suquillo
 */
public class Producto {
//atributos    
    private int codigo, stock;
    private String nombre;
    private double precio;
//constructores
    public Producto() {
    }

    public Producto(int codigo, int stock, String nombre, double precio) {
        this.codigo = codigo;
        this.stock = stock;
        this.nombre = nombre;
        this.precio = precio;
    }
//get n set
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
 //metodos
    public double calcularSubtotal(){
        return precio * stock;
    }
    public void mostrarDatos(){
        System.out.println("====================informacion del Producto ====================");
        System.out.println("Codigo: " +codigo);
        System.out.println("nombre: " +nombre);
        System.out.println("precio: " +precio);
        System.out.println("stock: " +stock);
    }
    
    public static boolean validadPrecio(double precio){
        if(precio > 0){
            return true;
        }else{
            return false;
        }
    }
}
