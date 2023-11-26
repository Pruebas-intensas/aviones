import java.util.ArrayList;

public class Vuelo{
    private String id;
    private String origen;
    private String destino;
    private int horaSalida;
    private int duracion;
    private int asientosDisponibles;
    private ArrayList<Reserva> reservas;
    private int contadorReservas;


    public Vuelo(String id, String origen, String destino, int horaSalida, int duracion, int asientosDisponibles){
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.duracion = duracion;
        this.asientosDisponibles = asientosDisponibles;
        this.reservas = new ArrayList<Reserva>();
        this.contadorReservas = 0;
    }

    public Vuelo(String id, String origen, String destino, int horaSalida, int duracion, int asientosDisponibles, int contadorReservas){
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.duracion = duracion;
        this.asientosDisponibles = asientosDisponibles;
        this.reservas = new ArrayList<Reserva>();
        this.contadorReservas = contadorReservas;
    }

    public String getId(){
        return this.id;
    }

    public String getOrigen(){
        return this.origen;
    }

    public String getDestino(){
        return this.destino;
    }

    public int getHoraSalida(){
        return this.horaSalida;
    }

    public int getDuracion(){
        return this.duracion;
    }

    public int getAsientosDisponibles(){
        return this.asientosDisponibles;
    }

    public ArrayList<Reserva> getReservas(){
        return this.reservas;
    }

    public int getContadorReservas(){
        return this.contadorReservas;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setOrigen(String origen){
        this.origen = origen;
    }

    public void setDestino(String destino){
        this.destino = destino;
    }

    public void setHoraSalida(int horaSalida){
        this.horaSalida = horaSalida;
    }

    public void setDuracion(int duracion){
        this.duracion = duracion;
    }

    public void setAsientosDisponibles(int asientosDisponibles){
        this.asientosDisponibles = asientosDisponibles;
    }

    public int aumentarContadorReservas(){
        this.contadorReservas += 1;
        return this.contadorReservas;
    }

    public String agregarReserva(String nombre, String apellido, int cantidadAsientos){        
        if (cantidadAsientos > this.asientosDisponibles){
            System.out.println("No hay suficientes asientos disponibles");
            return "-1";
        }        
        String codigoConfirmacion = this.id + "-" + this.aumentarContadorReservas();
        Reserva reserva = new Reserva(nombre, apellido, cantidadAsientos, codigoConfirmacion);
        this.reservas.add(reserva);
        this.asientosDisponibles -= cantidadAsientos;
        return codigoConfirmacion;
    }
}