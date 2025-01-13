package zona_fit.presentacion;

import zona_fit.conexion.Conexion;
import zona_fit.datos.IClienteDAO;
import zona_fit.datos.ICuotasDAO;
import zona_fit.datos.implementado.ClienteDAO;
import zona_fit.datos.implementado.CuotasDAO;
import zona_fit.dominio.Cliente;
import zona_fit.dominio.Cuota;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static zona_fit.conexion.Conexion.actualizarEstructura;
import static zona_fit.conexion.Conexion.cargarDatosIniciales;

public class ZonaFitApp {

    public static void main(String[] args) {

        zonaFitApp();
    }

    private static void zonaFitApp() {
        boolean salir = false;
        while (!salir) {
            try {
                salir = ejecutarOpciones(mostrarMenu());
            } catch (Exception e) {
                System.out.println("Error al ejecutar el programa");
                System.out.println("Mensaje de error" + e.getMessage());
            }
        }
    }

    private static int mostrarMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.print("""
                *** Zona Fit App ***
                1. Actualizar BBDD
                2. Cargar datos iniciales
                3. Listar Clientes
                4. Buscar Cliente
                5. Agregar Cliente
                6. Modificar Cliente
                7. Eliminar Cliente
                8. Listar Cuotas
                9. Buscar Cuotas
                10. Agregar Cuotas
                11. Modificar Cuotas
                12. Eliminar Cuotas
                13. Salir
                Elige una opción:\s""");

        return sc.nextInt();
    }

    private static boolean ejecutarOpciones(int opcion) throws SQLException {

        boolean salir = false;
        switch (opcion) {

            case 1 -> {
                System.out.println("--- Actualización de la base de datos ---");
                actualizarEstructura();
            }
            case 2 -> {
                System.out.println("--- Carga de datos iniciales ---");
                cargarDatosIniciales();
            }
            case 3 -> {
                System.out.println("--- Listado de Clientes ---");
                listarClientes();
            }
            case 4 -> {
                System.out.println("--- Buscar Cliente ---");
                buscarCliente();
            }
            case 5 -> {
                System.out.println("--- Agregar Cliente ---");
                agregarCliente();
            }
            case 6 -> {
                System.out.println("--- Modificar Cliente ---");
                modificarCliente();
            }
            case 7 -> {
                System.out.println("--- Eliminar Cliente ---");
                eliminarCliente();
            }
            case 8 -> {
                System.out.println("--- Listado de Cuotas ---");
                listarCuotas();
            }
            case 9 -> {
                System.out.println("--- Buscar Cuota ---");
                buscarCuotas();
            }
            case 10 -> {
                System.out.println("--- Agregar Cuota ---");
                agregarCuotas();
            }
            case 11 -> {
                System.out.println("--- Modificar Cuota ---");
                modificarCuotas();
            }
            case 12 -> {
                System.out.println("--- Eliminar Cuota ---");
                eliminarCuotas();
            }
            case 13 -> {
                System.out.println("Saliste de la aplicación");
                salir = true;
            }
        }
        return salir;
    }

    private static int pedirID() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el ID: ");
        return sc.nextInt();
    }

    private static String pedirNombre() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre: ");
        return sc.next();
    }

    private static String pedirApellidos() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el apellido: ");
        return sc.next();
    }

    private static String pedirEmail() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el email: ");
        return sc.next();
    }

    private static String pedirTelefono() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el telefono: ");
        return sc.next();
    }

    private static String pedirEstado() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el estado: ");
        return sc.next();
    }

    private static int pediridCuota() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el idCuota: ");
        return sc.nextInt();
    }

    private static String pedirModalidad() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la modalidad: ");
        return sc.next();
    }

    private static double pedirCuota() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cuota: ");
        return sc.nextDouble();
    }

    private static String pedirSituacion() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la situacion: ");
        return sc.next();
    }


    private static void listarClientes() {
        IClienteDAO clienteDAO = new ClienteDAO();

        List<Cliente> clientes = clienteDAO.listarClientes();
        if(clientes.isEmpty()) {
            System.out.println("No hay ningún cliente");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    private static void buscarCliente() {
        IClienteDAO clienteDAO = new ClienteDAO();

        int clienteID = pedirID();
        Cliente cliente = new Cliente(clienteID);
        if (clienteDAO.buscarClientePorId(cliente)) {
            System.out.println("Cliente encontrado: " + cliente);
        } else {
            System.out.println("No se encontró el cliente: " + cliente.getId());
        }
    }

    private static void agregarCliente() {
        IClienteDAO clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente(pedirNombre(), pedirApellidos(), pedirEmail(), pedirTelefono(), pedirEstado(), pediridCuota());
        if (clienteDAO.agregarCliente(cliente)) {
            System.out.println("Cliente agregado correctamente");
        } else {
            System.out.println("Error al agregar el cliente");
        }
    }

    private static void modificarCliente() {
        IClienteDAO clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente(pedirID(), pedirNombre(), pedirApellidos(), pedirEmail(), pedirTelefono(), pedirEstado(), pediridCuota());
        if (!clienteDAO.buscarClientePorId(new Cliente(cliente.getId()))) {
            System.out.println("Cliente no encontrado: " + cliente.getId());
        } else {
            if (clienteDAO.modificarCliente(cliente)) {
                System.out.println("Se modifico el cliente: " + cliente);
            } else {
                System.out.println("No se pudo modificar el cliente");
            }
        }
    }

    private static void eliminarCliente() {
        IClienteDAO clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente(pedirID());

        if (!clienteDAO.buscarClientePorId(new Cliente(cliente.getId()))) {
            System.out.println("Cliente no encontrado: " + cliente.getId());
        } else {
            boolean eliminado = clienteDAO.eliminarCliente(cliente);
            if (eliminado) {
                System.out.println("Cliente eliminado");
            } else {
                System.out.println("No se pudo eliminar al cliente");
            }
        }


    }

    private static void listarCuotas() {
        ICuotasDAO cuotasDAO = new CuotasDAO();

        List<Cuota> cuotas = cuotasDAO.listarCuota();
        if(cuotas.isEmpty()) {
            System.out.println("No hay ninguna cuota");
        } else {
            for (Cuota cuota : cuotas) {
                System.out.println(cuota);
            }
        }
    }

    private static void buscarCuotas() {
        ICuotasDAO cuotasDAO = new CuotasDAO();

        int cuotaID = pediridCuota();
        Cuota cuota = new Cuota(cuotaID);
        if (cuotasDAO.buscarCuotasPorId(cuota)) {
            System.out.println("Cuota encontrada: " + cuota);
        } else {
            System.out.println("No se encontró la cuota: " + cuota.getIdCuota());
        }
    }

    private static void agregarCuotas() {
        ICuotasDAO cuotasDAO = new CuotasDAO();

        Cuota cuota = new Cuota(pedirModalidad(), pedirCuota(), pedirSituacion());
        if (cuotasDAO.agregarCuotas(cuota)) {
            System.out.println("Cuota agregada correctamente");
        } else {
            System.out.println("Error al agregar la cuota");
        }
    }

    private static void modificarCuotas() {
        ICuotasDAO cuotasDAO = new CuotasDAO();

        Cuota cuota = new Cuota(pediridCuota(), pedirModalidad(), pedirCuota(), pedirSituacion());
        if (!cuotasDAO.buscarCuotasPorId(new Cuota(cuota.getIdCuota()))) {
            System.out.println("Cuota no encontrado: " + cuota.getIdCuota());
        } else {
            if (cuotasDAO.modificarCuotas(cuota)) {
                System.out.println("Se modifico la cuota: " + cuota);
            } else {
                System.out.println("No se pudo modificar la cuota");
            }
        }
    }

    private static void eliminarCuotas() {
        ICuotasDAO cuotasDAO = new CuotasDAO();

        Cuota cuota = new Cuota(pediridCuota());

        if (!cuotasDAO.buscarCuotasPorId(new Cuota(cuota.getIdCuota()))) {
            System.out.println("Cuota no encontrada: " + cuota.getCuota());
        } else {
            boolean eliminado = cuotasDAO.eliminarCuotas(cuota);
            if (eliminado) {
                System.out.println("Cuota eliminada");
            } else {
                System.out.println("No se pudo eliminar la cuota");
            }
        }


    }
}
