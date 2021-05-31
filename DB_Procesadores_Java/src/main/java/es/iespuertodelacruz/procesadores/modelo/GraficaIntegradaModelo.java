package es.iespuertodelacruz.procesadores.modelo;

import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.api.GraficaIntegrada;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class GraficaIntegradaModelo {
    
    MySqlBbdd persistencia;

    private static final String TABLA = "grafica_integrada";
    private static final String CLAVE_PRIMARIA = "id";

    /**
     * Constructor con la persistencia
     * 
     * @param persistencia elegida
     * @throws PersistenciaException controlada
     */
    public GraficaIntegradaModelo() throws PersistenciaException {
        persistencia = new MySqlBbdd(TABLA, CLAVE_PRIMARIA, null, null);
    }

    /**
     * Metodo que inserta una grafica integrada
     * 
     * @param graficaIntegrada a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(GraficaIntegrada graficaIntegrada) throws PersistenciaException {
        persistencia.insertar(graficaIntegrada);
    }

    /**
     * Metodo que elimina una grafica integrada
     * 
     * @param graficaIntegrada a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(GraficaIntegrada graficaIntegrada) throws PersistenciaException {
        persistencia.eliminar(graficaIntegrada);
    }

    /**
     * Metodo que modifica una grafica integrada
     * 
     * @param graficaIntegrada a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(GraficaIntegrada graficaIntegrada) throws PersistenciaException {
        persistencia.modificar(graficaIntegrada);
    }

    /**
     * Funcion que obtiene una grafica integrada segun su id
     * 
     * @param idGraficaIntegrada de la grafica integrada a obtener
     * @return la grafica integrada si existe
     * @throws PersistenciaException controlada
     */
    public GraficaIntegrada obtenerGraficaIntegrada(int idGraficaIntegrada) throws PersistenciaException {
        return persistencia.obtenerGraficaIntegrada(idGraficaIntegrada);
    }

    /**
     * Funcion que obtiene la lista de graficas integradas almacenadas
     * 
     * @return la lista de graficas integradas
     * @throws PersistenciaException controlada
     */
    public ArrayList<GraficaIntegrada> obtenerListaGraficaIntegrada() throws PersistenciaException {
        return persistencia.obtenerListadoGraficaIntegrada();
    }
}