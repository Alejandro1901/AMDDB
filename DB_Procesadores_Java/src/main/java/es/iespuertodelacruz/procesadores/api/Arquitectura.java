package es.iespuertodelacruz.procesadores.api;

public class Arquitectura {
    int id;
    String versionArquitectura;
    String disenio;
    String tecnologia;
    String estandar;

    /**
     * Constructor con todos los parametros
     * @param id de la arquitectura 
     * @param versionArquitectura de la arquitectura 
     * @param disenio es el nombre del tipo de arquitectura 
     * @param tecnologia de la arquitectura (Solo ARM)
     * @param estandar de la arquietctura (Solo x86-64)
     */
   
    /**
     * Creación de un constructor con todos los atributos de las tablas
     */
   
     public Arquitectura(int id, String versionArquitectura, String disenio, 
        String tecnologia, String estandar) {
        this.id = id;
        this.versionArquitectura = versionArquitectura;
        this.disenio = disenio;
        this.tecnologia = tecnologia;
        this.estandar = estandar;
    }

    /**
     * Constructor vacio
     */
    
     public Arquitectura() {
    }

    /**
     * Creacion de getter and setters
     */

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersionArquitectura() {
        return this.versionArquitectura;
    }

    public void setVersionArquitectura(String versionArquitectura) {
        this.versionArquitectura = versionArquitectura;
    }

    public String getDisenio() {
        return this.disenio;
    }

    public void setDisenio(String disenio) {
        this.disenio = disenio;
    }

    public String getTecnologia() {
        return this.tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public String getEstandar() {
        return this.estandar;
    }

    public void setEstandar(String estandar) {
        this.estandar = estandar;
    }

}
