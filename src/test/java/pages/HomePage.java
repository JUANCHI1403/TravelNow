package pages;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
  private String origen;
  private String destino;
  private String fecha;
  private boolean soloIda;

  // Lista simulada de resultados de vuelos
  private List<String> vuelosDisponibles = new ArrayList<>();

  // Simula ingresar los datos de búsqueda
  public void search(String origen, String destino, String fecha) {
    System.out.println("Simulando ingreso de datos:");
    System.out.println("Origen: " + origen);
    System.out.println("Destino: " + destino);
    System.out.println("Fecha: " + fecha);

    this.origen = origen;
    this.destino = destino;
    this.fecha = fecha;

    // Generar resultados simulados
    vuelosDisponibles.clear();
    vuelosDisponibles.add("Aerolínea A - 08:00 - $200");
    vuelosDisponibles.add("Aerolínea B - 10:30 - $250");
    vuelosDisponibles.add("Aerolínea C - 13:45 - $180");
  }

  // Simula seleccionar solo ida o ida y vuelta
  public void seleccionarSoloIda(boolean soloIda) {
    this.soloIda = soloIda;
    System.out.println(
      "Simulando selección: " + (soloIda ? "Solo ida" : "Ida y vuelta")
    );
  }

  // Devuelve resultados simulados
  public List<String> getVuelosDisponibles() {
    System.out.println("Mostrando resultados simulados:");
    for (String vuelo : vuelosDisponibles) {
      System.out.println(vuelo);
    }
    return vuelosDisponibles;
  }
}
