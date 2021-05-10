package es.iespuertodelacruz.procesadores.api;

public class Fabricante {
    String codigo;
    int codigoPostal;
    String nombre;
    String calle;
    int numero;
    String pais;
    int telefono;
    String correo;
    String web;

    /**
     * 
     * @param codigo
     * @param codigoPostal
     * @param nombre
     * @param calle
     * @param numero
     * @param pais
     * @param telefono
     * @param correo
     * @param web
     */
    public Fabricante(String codigo, int codigoPostal, String nombre, String calle, int numero, String pais, int telefono, String correo, String web) {
        this.codigo = codigo;
        this.codigoPostal = codigoPostal;
        this.nombre = nombre;
        this.calle = calle;
        this.numero = numero;
        this.pais = pais;
        this.telefono = telefono;
        this.correo = correo;
        this.web = web;
    }

    /**
     * Constructor vacio
     */
    public Fabricante() {
    }

}
