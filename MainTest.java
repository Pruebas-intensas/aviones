import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;


public class MainTest {

    @Test
    public void testVuelo() {
        Vuelo vuelo = new Vuelo("1", "Buenos Aires", "Madrid", 10, 10, 10);
        assertEquals("1", vuelo.getId());
        assertEquals("Buenos Aires", vuelo.getOrigen());
        assertEquals("Madrid", vuelo.getDestino());
        assertEquals(10, vuelo.getHoraSalida());
        assertEquals(10, vuelo.getDuracion());
        assertEquals(10, vuelo.getAsientosDisponibles());
        assertEquals(0, vuelo.getContadorReservas());
        System.out.println("Vuelo OK");
    }

    @Test
    public void testReserva() {
        Reserva reserva = new Reserva("Juan", "Perez", 1, "1");
        assertEquals("Juan", reserva.getNombrePasajero());
        assertEquals("Perez", reserva.getApellidoPasajero());
        assertEquals(1, reserva.getCantidadAsientos());
        assertEquals("1", reserva.getCodigoConfirmacion());
        System.out.println("Reserva OK");
    }

    @Test
    public void testReservaVuelo() {
        Vuelo vuelo = new Vuelo("1", "Buenos Aires", "Madrid", 10, 10, 11);

        String codigoConf = vuelo.agregarReserva("Juan", "Perez", 6);
        assertEquals("1-1", codigoConf);
        assertEquals(5, vuelo.getAsientosDisponibles());
        System.out.println("ReservaVuelo OK");
    }

    @Test
    public void testReservaVuelo2() {
        Vuelo vuelo = new Vuelo("1", "Buenos Aires", "Madrid", 10, 10, 11);

        String codigoConf = vuelo.agregarReserva("Juan", "Perez", 6);
        assertEquals("1-1", codigoConf);
        assertEquals(5, vuelo.getAsientosDisponibles());

        codigoConf = vuelo.agregarReserva("Juan", "Perez", 6);
        assertEquals("-1", codigoConf);
        assertEquals(5, vuelo.getAsientosDisponibles());

        codigoConf = vuelo.agregarReserva("Juan", "Perez", 5);
        assertEquals("1-2", codigoConf);
        assertEquals(0, vuelo.getAsientosDisponibles());

        codigoConf = vuelo.agregarReserva("Juan", "Perez", 1);
        assertEquals("-1", codigoConf);
        assertEquals(0, vuelo.getAsientosDisponibles());

        System.out.println("ReservaVuelo2 OK");
    }


    @Test
    public void testReservaVuelo3() {
        Vuelo vuelo = new Vuelo("1", "Buenos Aires", "Madrid", 10, 10, 11);

        String codigoConf = vuelo.agregarReserva("Juan", "Perez", 6);
        assertEquals("1-1", codigoConf);
        assertEquals(5, vuelo.getAsientosDisponibles());

        codigoConf = vuelo.agregarReserva("Juana", "Perez", 5);
        assertEquals("1-2", codigoConf);
        assertEquals(0, vuelo.getAsientosDisponibles());

        // buscar reserva por codigo, recibiendo todas las reservas con getReservas
        // y buscando en el array

        ArrayList<Reserva> reservas = vuelo.getReservas();

        Reserva reserva = null;
        Reserva reserva2 = null;

        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getCodigoConfirmacion().equals("1-1")) {
                reserva = reservas.get(i);
            }
            if (reservas.get(i).getCodigoConfirmacion().equals("1-2")) {
                reserva2 = reservas.get(i);
            }
        }

        assertEquals("Juan", reserva.getNombrePasajero());
        assertEquals("Perez", reserva.getApellidoPasajero());
        assertEquals(6, reserva.getCantidadAsientos());

        assertEquals("Juana", reserva2.getNombrePasajero());
        assertEquals("Perez", reserva2.getApellidoPasajero());
        assertEquals(5, reserva2.getCantidadAsientos());

        System.out.println("ReservaVuelo3 OK");
    }
}
