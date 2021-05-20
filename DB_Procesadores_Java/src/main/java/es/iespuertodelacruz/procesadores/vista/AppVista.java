package es.iespuertodelacruz.procesadores.vista;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

import es.iespuertodelacruz.procesadores.api.*;
import es.iespuertodelacruz.procesadores.controlador.*;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class AppVista {

    private static final String DEBES_INSERTAR_UN_NUMERO = "Debes insertar un número";
    private static final String ADIOS = "¡Adios!";
    private static final String ESCRIBE_UNA_DE_LAS_OPCIONES = "Escribe una de las opciones";
    private static final String SALIR = "7. Atras";
    private static final String ZOCALO = "6. Zocalo";
    private static final String PLACA_BASE = "5. Placa Base";
    private static final String PROCESADOR = "4. Procesador";
    private static final String GRAFICA_INTEGRADA = "3. Grafica integrada";
    private static final String FABRICANTE = "2. Fabricante";
    private static final String ARQUITECTURA = "1. Arquitectura";
    private static final String SOLO_NUMEROS_ENTRE_1_Y_7 = "Solo números entre 1 y 7";

    public static ProcesadorControlador procesadorControlador = new ProcesadorControlador();
    public static ArquitecturaControlador arquitecturaControlador = new ArquitecturaControlador();
    public static FabricanteControlador fabricanteControlador = new FabricanteControlador();
    public static GraficaIntegradaControlador graficaIntegradaControlador = new GraficaIntegradaControlador();
    public static NombreProcesadorControlador nombreProcesadorControlador = new NombreProcesadorControlador();
    public static PlacaBaseControlador placaBaseControlador = new PlacaBaseControlador();
    public static ProcesadorGraficaIntegradaControlador procesadorGraficaIntegradaControlador = new ProcesadorGraficaIntegradaControlador();
    public static ZocaloControlador zocaloControlador = new ZocaloControlador();

    public static void main(String[] args) throws ControladoresDBException, PersistenciaException {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("¡Hola! Bienvenido a ProcesadoresDB");
            System.out.println("¿Que tipo de usuario eres?");
            System.out.println("1. Admin"); 
            System.out.println("2. Usuario estandar"); //Sin permiso para modificar la BBDD
            System.out.println("3. Salir");
 
            try {
 
                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado Admin");
                        menuAdmin();
                        break;
                    case 2:
                        System.out.println("Has seleccionado Usuario");
                        menuUsuario();
                        break;
                    case 3:
                        System.out.println(ADIOS);
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println(DEBES_INSERTAR_UN_NUMERO);
                sn.next();
            }
        }
    }

    /**
     * Submenu para el admin
     * @throws PersistenciaException
     * @throws ControladoresDBException
     */
    private static void menuAdmin() throws ControladoresDBException, PersistenciaException {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("Usted ha iniciado sesion como Admin");
            System.out.println("¿Que accion desea realizar?");
            System.out.println("1. Insertar");
            System.out.println("2. Modificar");
            System.out.println("3. Eliminar");
            System.out.println("4. Buscar");
            System.out.println("5. Listar");
            System.out.println("6. Atras");
 
            try {
 
                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado insertar");
                        menuInsertar();
                        break;
                    case 2:
                        System.out.println("Has seleccionado modificar");
                        menuModificar();
                        break;
                    case 3:
                        System.out.println("Has seleccionado eliminar");
                        menuEliminar();
                        break;
                    case 4:
                        System.out.println("Has seleccionado buscar");
                        menuBuscar();
                        break;
                    case 5:
                        System.out.println("Has seleccionado listar");
                        menuListar();
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 6");
                }
            } catch (InputMismatchException e) {
                System.out.println(DEBES_INSERTAR_UN_NUMERO);
                sn.next();
            }
        }
    }

    /**
     * Submenu para el usuario (usuario estandar, sin permisos para modificar la BBDD)
     */
    private static void menuUsuario() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("Usted ha iniciado sesion como Usuario");
            System.out.println("¿Que accion desea realizar?");
            System.out.println("1. Buscar");
            System.out.println("2. Listar");
            System.out.println("3. Atras");
 
            try {
 
                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado buscar");
                        menuBuscar();
                        break;
                    case 2:
                        System.out.println("Has seleccionado listar");
                        menuListar();
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println(DEBES_INSERTAR_UN_NUMERO);
                sn.next();
            }
        }
    }

    private static void menuInsertar() throws ControladoresDBException, PersistenciaException {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("¿En que tabla deseas insertar una nueva fila?");
            System.out.println(ARQUITECTURA);
            System.out.println(FABRICANTE);
            System.out.println(GRAFICA_INTEGRADA);
            System.out.println(PROCESADOR);
            System.out.println(PLACA_BASE);
            System.out.println(ZOCALO);
            System.out.println(SALIR);
 
            try {
 
                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado insertar una Arquitectura");
                        insertarArquitectura();
                        break;
                    case 2:
                        System.out.println("Has seleccionado insertar un Fabricante");
                        insertarFabricante();
                        break;
                    case 3:
                        System.out.println("Has seleccionado insertar una Grafica integrada");
                        insertarGraficaIntegrada();
                        break;
                    case 4:
                        System.out.println("Has seleccionado insertar un Procesador");
                        insertarProcesador();
                        break;
                    case 5:
                        System.out.println("Has seleccionado insertar una Placa Base");
                        insertarPlacaBase();
                        break;
                    case 6:
                        System.out.println("Has seleccionado insertar un Zocalo");
                        insertarZocalo();
                        break;
                    case 7:
                        salir = true;
                        break;
                    default:
                        System.out.println(SOLO_NUMEROS_ENTRE_1_Y_7);
                }
            } catch (InputMismatchException e) {
                System.out.println(DEBES_INSERTAR_UN_NUMERO);
                sn.next();
            }
        }
    }

    private static void menuModificar() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("¿En que tabla desea modificar una fila?");
            System.out.println(ARQUITECTURA);
            System.out.println(FABRICANTE);
            System.out.println(GRAFICA_INTEGRADA);
            System.out.println(PROCESADOR);
            System.out.println(PLACA_BASE);
            System.out.println(ZOCALO);
            System.out.println(SALIR);
 
            try {
 
                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado modificar una Arquitectura");
                        break;
                    case 2:
                        System.out.println("Has seleccionado modificar un Fabricante");
                        break;
                    case 3:
                        System.out.println("Has seleccionado modificar una Grafica integrada");
                        break;
                    case 4:
                        System.out.println("Has seleccionado modificar un Procesador");
                        break;
                    case 5:
                        System.out.println("Has seleccionado modificar una Placa Base");
                        break;
                    case 6:
                        System.out.println("Has seleccionado modificar un Zocalo");
                        break;
                    case 7:
                        System.out.println("Has seleccionado modificar una fila de NombreProcesador");
                        break;
                    case 8:
                        System.out.println("Has seleccionado modificar una fila de ProcesadorGraficaIntegrada");
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        System.out.println(SOLO_NUMEROS_ENTRE_1_Y_7);
                }
            } catch (InputMismatchException e) {
                System.out.println(DEBES_INSERTAR_UN_NUMERO);
                sn.next();
            }
        }
    }

    private static void menuEliminar() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("¿En que tabla desea eliminar una fila?");
            System.out.println(ARQUITECTURA);
            System.out.println(FABRICANTE);
            System.out.println(GRAFICA_INTEGRADA);
            System.out.println(PROCESADOR);
            System.out.println(PLACA_BASE);
            System.out.println(ZOCALO);
            System.out.println(SALIR);
 
            try {
 
                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado eliminar una Arquitectura");
                        break;
                    case 2:
                        System.out.println("Has seleccionado eliminar un Fabricante");
                        break;
                    case 3:
                        System.out.println("Has seleccionado eliminar una Grafica integrada");
                        break;
                    case 4:
                        System.out.println("Has seleccionado eliminar un Procesador");
                        break;
                    case 5:
                        System.out.println("Has seleccionado eliminar una Placa Base");
                        break;
                    case 6:
                        System.out.println("Has seleccionado eliminar un Zocalo");
                        break;
                    case 7:
                        salir = true;
                        break;
                    default:
                        System.out.println(SOLO_NUMEROS_ENTRE_1_Y_7);
                }
            } catch (InputMismatchException e) {
                System.out.println(DEBES_INSERTAR_UN_NUMERO);
                sn.next();
            }
        }
    }

    private static void menuBuscar() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("¿En que tabla deseas buscar?");
            System.out.println(ARQUITECTURA);
            System.out.println(FABRICANTE);
            System.out.println(GRAFICA_INTEGRADA);
            System.out.println(PROCESADOR);
            System.out.println(PLACA_BASE);
            System.out.println(ZOCALO);
            System.out.println(SALIR);
 
            try {
 
                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado buscar una Arquitectura");
                        break;
                    case 2:
                        System.out.println("Has seleccionado buscar un Fabricante");
                        break;
                    case 3:
                        System.out.println("Has seleccionado buscar una Grafica integrada");
                        break;
                    case 4:
                        System.out.println("Has seleccionado buscar un Procesador");
                        break;
                    case 5:
                        System.out.println("Has seleccionado buscar una Placa Base");
                        break;
                    case 6:
                        System.out.println("Has seleccionado buscar un Zocalo");
                        break;
                    case 7:
                        salir = true;
                        break;
                    default:
                        System.out.println(SOLO_NUMEROS_ENTRE_1_Y_7);
                }
            } catch (InputMismatchException e) {
                System.out.println(DEBES_INSERTAR_UN_NUMERO);
                sn.next();
            }
        }
    }

    private static void menuListar() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("¿Que tabla deseas listar?");
            System.out.println(ARQUITECTURA);
            System.out.println(FABRICANTE);
            System.out.println(GRAFICA_INTEGRADA);
            System.out.println(PROCESADOR);
            System.out.println(PLACA_BASE);
            System.out.println(ZOCALO);
            System.out.println(SALIR);
 
            try {
 
                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado listar una Arquitectura");
                        break;
                    case 2:
                        System.out.println("Has seleccionado listar un Fabricante");
                        break;
                    case 3:
                        System.out.println("Has seleccionado listar una Grafica integrada");
                        break;
                    case 4:
                        System.out.println("Has seleccionado listar un Procesador");
                        break;
                    case 5:
                        System.out.println("Has seleccionado listar una Placa Base");
                        break;
                    case 6:
                        System.out.println("Has seleccionado listar un Zocalo");
                        break;
                    case 7:
                        salir = true;
                        break;
                    default:
                        System.out.println(SOLO_NUMEROS_ENTRE_1_Y_7);
                }
            } catch (InputMismatchException e) {
                System.out.println(DEBES_INSERTAR_UN_NUMERO);
                sn.next();
            }
        }
    }

    private static Arquitectura crearArquitectura() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Escribe la id del procesador");
        int id = sn.nextInt();
        System.out.println("Escribe la version de la arquitectura (x86-64 o ARM)");
        String versionArquitectura = sn.next();
        System.out.println("Escribe el diseño de la arquitectura (Por ejemplo Zen 3)");
        String disenio = sn.next();
        System.out.println("Escribe la tecnologia de la arquitectura (si tiene)");
        String tecnologia = sn.next();
        System.out.println("Escribe el estandar de la arquitectura (si tiene)");
        String estandar = sn.next();
        sn.close();
        return new Arquitectura(id, versionArquitectura, disenio, tecnologia, estandar);
    }

    private static Fabricante crearFabricante() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Escribe el codigo del fabricante");
        String codigo = sn.next();
        System.out.println("Escribe el codigo postal del fabricante");
        String codigoPostal = sn.next();
        System.out.println("Escribe el nombre del fabricante");
        String nombre = sn.next();
        System.out.println("Escribe el numero de la sede del fabricante");
        int numero = sn.nextInt();
        System.out.println("Escirbe el pais donde se ubica la sede del fabricante");
        String pais = sn.next();
        System.out.println("Escribe la calle donde se ubica la sede del fabricante");
        String calle = sn.next();
        System.out.println("Escribe el telefono de contacto del fabricante");
        String telefono = sn.next();
        System.out.println("Escribe el correo de contacto del fabricante");
        String correo = sn.next();
        System.out.println("Escribe la web del fabricante");
        String web = sn.next();
        sn.close();
        return new Fabricante(codigo, codigoPostal, nombre, calle, numero, pais, telefono, correo, web);
    }

    private static GraficaIntegrada crearGraficaIntegrada() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Escribe la id de la grafica integrada");
        int id = sn.nextInt();
        System.out.println("Escibe el nombre de la grafica integrada");
        String nombreGrafica = sn.next();
        System.out.println("Escribe la frecuencia basica a la que trabaja la grafica integrada");
        float frecuenciaBasica = sn.nextFloat();
        System.out.println("Escribe la frecuencia maxima a la que trabaja la grafica integrada");
        float frecuenciaMaxima = sn.nextFloat();
        System.out.println("Escribe la memoria maxima de la grafica integrada");
        int memoriaMaxima = sn.nextInt();
        System.out.println("Escribe la resolucion maxima que puede alcanzar la grafica integrada");
        System.out.println("(720p, 1080p ,2K, 4K, 8K o 16K)");
        String resolucion = sn.next();
        sn.close();
        return new GraficaIntegrada(id, nombreGrafica, frecuenciaBasica, frecuenciaMaxima, memoriaMaxima, resolucion);
    }

    private static Procesador crearProcesador() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Escribe la id del procesador");
        int id = sn.nextInt();
        System.out.println("Escibe la id del fabricante del procesador");
        String codigoFabricante = sn.next();
        System.out.println("Escribe la id del tipo de socket donde se puede alojar el procesador");
        int idSocket = sn.nextInt();
        System.out.println("Escribe la id de la arquitectura del procesador");
        int idArquitectura = sn.nextInt();
        System.out.println("Escribe el modelo del procesador");
        String modelo = sn.next();
        System.out.println("Escribe la fecha de lanzamiento del procesador");
        String fechaLanzamiento = sn.next(); //Hay que validar este valor
        System.out.println("Escribe el numero de nucleos del procesador");
        int nucleos = sn.nextInt();
        System.out.println("Escribe el numero de hilos del procesador");
        int hilos = sn.nextInt();
        System.out.println("Escribe la frecuencia a la que va el procesador");
        float frecuencia = sn.nextFloat();
        System.out.println("¿Se puede hacer overclock al procesador? (True o false)");
        boolean overclock = sn.nextBoolean();
        System.out.println("Escribe el tdp del procesador");
        float tdp = sn.nextFloat();
        System.out.println("Escribe el precio del procesador");
        float precio = sn.nextFloat();
        sn.close();
        return new Procesador(id, codigoFabricante, idSocket, idArquitectura, modelo, fechaLanzamiento, nucleos, hilos, frecuencia, overclock, tdp, precio);
    }

    private static NombreProcesador crearNombreProcesador(String modelo) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Escribe la familia del procesador");
        String familia = sn.next();
        System.out.println("Escribe la generacion del procesador");
        int generacion = sn.nextInt();
        return new NombreProcesador(modelo, familia, generacion);
    }

    private static NombreProcesador crearNombreProcesador() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Escribe el modelo del procesador");
        String modelo = sn.next();
        System.out.println("Escribe la familia del procesador");
        String familia = sn.next();
        System.out.println("Escribe la generacion del procesador");
        int generacion = sn.nextInt();
        return new NombreProcesador(modelo, familia, generacion);
    }

    private static PlacaBase crearPlacaBase() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Escribe la id de la placa base");
        int id = sn.nextInt();
        System.out.println("Escribe la id del socket de la placa base");
        int idSocket = sn.nextInt();
        System.out.println("Escribe el nombre de la placa base");
        String nombre = sn.next();
        sn.close();
        return new PlacaBase(id, idSocket, nombre);
    }

    private static Zocalo crearZocalo() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Escribe la id del zocalo");
        int id = sn.nextInt();
        System.out.println("Escribe el tipo del zocalo");
        String tipo = sn.next();
        System.out.println("Escribe la tecnologia del zocalo");
        String tecnologia = sn.next();
        System.out.println("Escribe la fecha de lanzamiento del zocalo");
        String fechaLanzamiento = sn.next(); //Validar fecha
        sn.close();
        return new Zocalo(id, tipo, tecnologia, fechaLanzamiento);
    }

    private static ProcesadorGraficaIntegrada crearProcesadorGraficaIntegrada() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Escribe la id del procesador");
        int idProcesador = sn.nextInt();
        System.out.println("Escribe la id de la grafica integrada");
        int idGraficaIntegrada = sn.nextInt();
        sn.close();
        return new ProcesadorGraficaIntegrada(idProcesador, idGraficaIntegrada);
    }

    private static void insertarArquitectura() throws ControladoresDBException, PersistenciaException {
        Arquitectura arquitectura = crearArquitectura();
        arquitecturaControlador.insertar(arquitectura);
    }

    private static void insertarFabricante() {
        Fabricante fabricante = crearFabricante();
        fabricanteControlador.insertar(fabricante);
    }

    private static void insertarGraficaIntegrada() {
        GraficaIntegrada graficaIntegrada = crearGraficaIntegrada();
        graficaIntegradaControlador.insertar(graficaIntegrada);
    }

    private static void insertarProcesador() {
        Scanner sn = new Scanner(System.in);
        Procesador procesador = crearProcesador();
        NombreProcesador nombreProcesador = crearNombreProcesador(procesador.getModelo());
        System.out.println("Escribe la id de la grafica integrada que contiene el procesador (Si tiene)");
        int idGraficaIntegrada = sn.nextInt();
        ProcesadorGraficaIntegrada procesadorGraficaIntegrada = new ProcesadorGraficaIntegrada(procesador.getId(), idGraficaIntegrada);
        nombreProcesadorControlador.insertar(nombreProcesador);
        procesadorControlador.insertar(procesador);
        procesadorGraficaIntegradaControlador.modificar(procesadorGraficaIntegrada);
    }

    private static void insertarPlacaBase() {
        PlacaBase placaBase = crearPlacaBase();
        placaBaseControlador.insertar(placaBase);
    }

    private static void insertarZocalo() {
        Zocalo zocalo = crearZocalo();
        zocaloControlador.insertar(zocalo);
    }

    private static void modificarArquitectura() throws ControladoresDBException, PersistenciaException {
        Arquitectura arquitectura = crearArquitectura();
        arquitecturaControlador.modificar(arquitectura);
    }

    private static void modificarFabricante() {
        Fabricante fabricante = crearFabricante();
        fabricanteControlador.modificar(fabricante);
    }

    private static void modificarGraficaIntegrada() {
        GraficaIntegrada graficaIntegrada = crearGraficaIntegrada();
        graficaIntegradaControlador.modificar(graficaIntegrada);
    }

    private static void modificarProcesador() {
        Procesador procesador = crearProcesador();
        procesadorControlador.modificar(procesador);
    }

    private static void modificarNombreProcesador() {
        NombreProcesador nombreProcesador = crearNombreProcesador();
        nombreProcesadorControlador.modificar(nombreProcesador);
    }

    private static void modificarProcesadorGraficaIntegrada() {
        ProcesadorGraficaIntegrada procesadorGraficaIntegrada = crearProcesadorGraficaIntegrada();
        procesadorGraficaIntegradaControlador.modificar(procesadorGraficaIntegrada);
    }

    private static void modificarPlacaBase() {
        PlacaBase placaBase = crearPlacaBase();
        placaBaseControlador.modificar(placaBase);
    }

    private static void modificarZocalo() {
        Zocalo zocalo = crearZocalo();
        zocaloControlador.modificar(zocalo);
    }
    
}
