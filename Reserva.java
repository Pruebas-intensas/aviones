public class Reserva {
    private String nombrePasajero;
    private String apellidoPasajero;
    private int cantidadAsientos;
    private String codigoConfirmacion;

    public Reserva(String nombrePasajero, String apellidoPasajero, int cantidadAsientos, String codigoConfirmacion){
        this.nombrePasajero = nombrePasajero;
        this.apellidoPasajero = apellidoPasajero;
        this.cantidadAsientos = cantidadAsientos;
        this.codigoConfirmacion = codigoConfirmacion;
    }

    public String getNombrePasajero(){
        return this.nombrePasajero;
    }

    public String getApellidoPasajero(){
        return this.apellidoPasajero;
    }

    public int getCantidadAsientos(){
        return this.cantidadAsientos;
    }

    public String getCodigoConfirmacion(){
        return this.codigoConfirmacion;
    }

    public void setNombrePasajero(String nombrePasajero){
        this.nombrePasajero = nombrePasajero;
    }

    public void setApellidoPasajero(String apellidoPasajero){
        this.apellidoPasajero = apellidoPasajero;
    }

    public void setCantidadAsientos(int cantidadAsientos){
        this.cantidadAsientos = cantidadAsientos;
    }

    public void setNumeroConfirmacion(String numeroConfirmacion){
        this.codigoConfirmacion = numeroConfirmacion;
    }
}
