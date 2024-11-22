import java.util.ArrayList;
class Comida {
    private String nombre;
    private String tipo; 
    private int disponibilidad;
    public Comida(String nombre, String tipo, int disponibilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.disponibilidad = disponibilidad;
    }
    public boolean servir() {
        if (disponibilidad > 0) {
            disponibilidad--;
            System.out.println("Comida servida: " + nombre + " (" + tipo + "). Disponibilidad restante: " + disponibilidad);
            return true;
        } else {
            System.out.println("Lo siento, " + nombre + " no está disponible.");
            return false;
        }
    }
    public void reponer(int cantidad) {
        disponibilidad += cantidad;
        System.out.println("Se ha repuesto " + cantidad + " unidades de " + nombre + ". Disponibilidad actual: " + disponibilidad);
    }
    public void mostrarDisponibilidad() {
        System.out.println(nombre + " (" + tipo + ") - Disponibilidad: " + disponibilidad);
    }
    public String getNombre() {
        return nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public int getDisponibilidad() {
        return disponibilidad;
    }
}
class Estudiante {
    private String nombre;
    private int idEstudiante;
    public Estudiante(String nombre, int idEstudiante) {
        this.nombre = nombre;
        this.idEstudiante = idEstudiante;
    }
    public void seleccionarComida(Comida comida) {
        System.out.println(nombre + " ha intentado seleccionar " + comida.getNombre());
        if (!comida.servir()) {
            System.out.println("No se pudo servir " + comida.getNombre() + " a " + nombre);
        }
    }
    public String getNombre() {
        return nombre;
    }
    public int getIdEstudiante() {
        return idEstudiante;
    }
}
class GestionComedor {
    private ArrayList<Comida> comidas;
    public GestionComedor() {
        comidas = new ArrayList<>();
    }
    public void registrarComida(Comida comida) {
        comidas.add(comida);
        System.out.println("Comida " + comida.getNombre() + " registrada correctamente.");
    }
    public void mostrarDisponibilidadComidas() {
        System.out.println("\nDisponibilidad de comidas en el comedor:");
        for (Comida comida : comidas) {
            comida.mostrarDisponibilidad();
        }
    }
    public void registrarConsumo(Estudiante estudiante, Comida comida) {
        System.out.println("\nRegistro de consumo: " + estudiante.getNombre() + " ha consumido " + comida.getNombre());
        comida.servir();
    }
}
public class SistemaComedor {
    public static void main(String[] args) {
        Comida comida1 = new Comida("Ensalada Vegana", "Vegana", 10);
        Comida comida2 = new Comida("Pollo Asado", "Estándar", 5);
        Comida comida3 = new Comida("Pasta Vegetariana", "Vegetariana", 7);
        GestionComedor gestionComedor = new GestionComedor();
        gestionComedor.registrarComida(comida1);
        gestionComedor.registrarComida(comida2);
        gestionComedor.registrarComida(comida3);
        Estudiante estudiante1 = new Estudiante("adrian guerrero", 192415);
        Estudiante estudiante2 = new Estudiante("yhoryi carrascal", 192406);
        gestionComedor.mostrarDisponibilidadComidas();
        estudiante1.seleccionarComida(comida1);
        estudiante2.seleccionarComida(comida2);
        gestionComedor.mostrarDisponibilidadComidas();
        comida2.reponer(3);
        gestionComedor.mostrarDisponibilidadComidas();
        gestionComedor.registrarConsumo(estudiante1, comida3);
        gestionComedor.mostrarDisponibilidadComidas();
    }
}
