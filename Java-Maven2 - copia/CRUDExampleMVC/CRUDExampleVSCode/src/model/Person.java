package model;

import java.sql.Date;

public class Person {

    private int id;
    private String nombrep;
    private int referencia;
    private int precio;
    private int peso;
    private String categoria;
    private int stock;
    private String fecha;
   

    public Person(){}

    public Person(int id, String nombrep, int referencia, int precio, int peso, String categoria, int stock, 
                 String fecha ){

        this.id=id;
        this.nombrep=nombrep;
        this.referencia=referencia;
        this.precio=precio;
        this.peso=peso;
        this.categoria=categoria;
        this.stock=stock;
        this.fecha=fecha;
        

    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getNombrep() {
        return nombrep;
    }

    public void setNombrep(String nombrep) {
        this.nombrep = nombrep;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getFecha() {
        return fecha;
    }
   

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }





    


}