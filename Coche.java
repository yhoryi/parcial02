// Definimos la clase Coche
class Coche {
    // Atributos
    private String marca;
    private String modelo;
    private int año;
    private String color;
    private int velocidad;

    // Constructor para inicializar los atributos
    public Coche(String marca, String modelo, int año, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.color = color;
        this.velocidad = 0;  // Inicializamos la velocidad en 0
    }

    // Método para acelerar
    public void acelerar(int cantidad) {
        this.velocidad += cantidad;
        System.out.println("El coche ha acelerado y ahora va a " + this.velocidad + " km/h.");
    }

    // Método para frenar
    public void frenar(int cantidad) {
        if (this.velocidad - cantidad < 0) {
            this.velocidad = 0;
        } else {
            this.velocidad -= cantidad;
        }
        System.out.println("El coche ha frenado y ahora va a " + this.velocidad + " km/h.");
    }

    // Método para mostrar los detalles del coche
    public void detalles() {
        System.out.println("Detalles del coche:");
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Año: " + this.año);
        System.out.println("Color: " + this.color);
        System.out.println("Velocidad: " + this.velocidad + " km/h");
    }

    // Método principal (main) para ejecutar el código
    public static void main(String[] args) {
        // Crear un objeto de la clase Coche
        Coche miCoche = new Coche("Toyota", "Corolla", 2020, "Rojo");

        // Mostrar los detalles del coche
        miCoche.detalles();

        // Acelerar y frenar el coche
        miCoche.acelerar(50);
        miCoche.acelerar(30);
        miCoche.frenar(40);

        // Mostrar los detalles después de acelerar y frenar
        miCoche.detalles();
    }
}
