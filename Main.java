import java.util.ArrayList;
import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        System.out.println("================Bienvenido al sistema de gestión de Vuelos de LATAM Airlines================");
        System.out.println("Seleccione una opcion:");
        System.out.println("1. Crear vuelo");
        System.out.println("2. Ver vuelos");
        System.out.println("3. Buscar vuelo");
        System.out.println("4. Modificar vuelo");
        System.out.println("5. Eliminar vuelo");
        System.out.println("6. Realizar reserva");
        System.out.println("7. Buscar reserva");
        System.out.println("8. Salir");

        int opcion = 0;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();

        while(opcion != 8) {
            opcion = scanner.nextInt();
            switch(opcion) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Ingrese el id del vuelo:");
                    String id = scanner.nextLine();
                    System.out.println("Ingrese el origen del vuelo:");
                    String origen = scanner.nextLine();
                    System.out.println("Ingrese el destino del vuelo:");
                    String destino = scanner.nextLine();
                    System.out.println("Ingrese la hora de salida del vuelo:");
                    int horaSalida = scanner.nextInt();
                    System.out.println("Ingrese la duracion del vuelo:");
                    int duracion = scanner.nextInt();
                    System.out.println("Ingrese la cantidad de asientos disponibles del vuelo:");
                    int asientosDisponibles = scanner.nextInt();
                    Vuelo vuelo = new Vuelo(id, origen, destino, horaSalida, duracion, asientosDisponibles);
                    vuelos.add(vuelo);
                    System.out.println("\nVuelo creado exitosamente con id: " + id + ", origen: " + origen + 
                                        ", destino: " + destino + ", hora de salida: " + horaSalida +
                                        ", duracion: " + duracion + ", asientos disponibles: " + asientosDisponibles);                    

                    break;
                case 2:
                    System.out.println("Ver vuelos");
                    boolean hayVuelos = false;
                    for (Vuelo vueloActual : vuelos) {
                        System.out.println("Id: " + vueloActual.getId() + ", origen: " + vueloActual.getOrigen() + 
                                            ", destino: " + vueloActual.getDestino() + ", hora de salida: " + vueloActual.getHoraSalida() +
                                            ", duracion: " + vueloActual.getDuracion() + ", asientos disponibles: " + vueloActual.getAsientosDisponibles());
                        hayVuelos = true;
                    }

                    if (!hayVuelos) {
                        System.out.println("No hay vuelos disponibles");
                    }
                    break;
                case 3:
                    System.out.println("Buscar vuelo");
                    System.out.println("Ingrese el id del vuelo a buscar:");
                    scanner.nextLine();
                    String idVueloBuscar = scanner.nextLine();
                    boolean encontradoBuscar = false;
                    for (Vuelo vueloActual : vuelos) {
                        if (vueloActual.getId().equals(idVueloBuscar)) {
                            System.out.println("Id: " + vueloActual.getId() + ", origen: " + vueloActual.getOrigen() + 
                                                ", destino: " + vueloActual.getDestino() + ", hora de salida: " + vueloActual.getHoraSalida() +
                                                ", duracion: " + vueloActual.getDuracion() + ", asientos disponibles: " + vueloActual.getAsientosDisponibles());
                            encontradoBuscar = true;
                        }
                    }

                    if (!encontradoBuscar) {
                        System.out.println("No se encontro el vuelo con id: " + idVueloBuscar);
                    }

                    break;

                case 4:
                    System.out.println("Modificar vuelo");
                    System.out.println("Ingrese el id del vuelo a modificar:");
                    scanner.nextLine();
                    String idVuelo = scanner.nextLine();
                    boolean encontrado = false;
                    for (Vuelo vueloActual : vuelos) {
                        if (vueloActual.getId().equals(idVuelo)) {
                            System.out.println("Ingrese el nuevo id del vuelo:");
                            String nuevoId = scanner.nextLine();
                            System.out.println("Ingrese el nuevo origen del vuelo:");
                            String nuevoOrigen = scanner.nextLine();
                            System.out.println("Ingrese el nuevo destino del vuelo:");
                            String nuevoDestino = scanner.nextLine();
                            System.out.println("Ingrese la nueva hora de salida del vuelo:");
                            int nuevaHoraSalida = scanner.nextInt();
                            System.out.println("Ingrese la nueva duracion del vuelo:");
                            int nuevaDuracion = scanner.nextInt();
                            System.out.println("Ingrese la nueva cantidad de asientos disponibles del vuelo:");
                            int nuevosAsientosDisponibles = scanner.nextInt();
                            vueloActual.setId(nuevoId);
                            vueloActual.setOrigen(nuevoOrigen);
                            vueloActual.setDestino(nuevoDestino);
                            vueloActual.setHoraSalida(nuevaHoraSalida);
                            vueloActual.setDuracion(nuevaDuracion);
                            vueloActual.setAsientosDisponibles(nuevosAsientosDisponibles);
                            System.out.println("\nVuelo modificado exitosamente con id: " + nuevoId + ", origen: " + nuevoOrigen + 
                                                ", destino: " + nuevoDestino + ", hora de salida: " + nuevaHoraSalida +
                                                ", duracion: " + nuevaDuracion + ", asientos disponibles: " + nuevosAsientosDisponibles);
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontro el vuelo con id: " + idVuelo);
                    }

                    break;
                case 5:
                    System.out.println("Eliminar vuelo");
                    System.out.println("Ingrese el id del vuelo a eliminar:");
                    scanner.nextLine();
                    String idVueloEliminar = scanner.nextLine();
                    boolean encontradoEliminar = false;
                    for (Vuelo vueloActual : vuelos) {
                        if (vueloActual.getId().equals(idVueloEliminar)) {
                            vuelos.remove(vueloActual);
                            System.out.println("\nVuelo eliminado exitosamente con id: " + idVueloEliminar);
                            encontradoEliminar = true;
                            break;
                        }
                    }

                    if (!encontradoEliminar) {
                        System.out.println("No se encontro el vuelo con id: " + idVueloEliminar);
                    }


                    break;
                case 6:
                    System.out.println("Realizar reserva");
                    System.out.println("Ingrese el id del vuelo en el que desea reservar:");
                    scanner.nextLine();
                    String idVueloReserva = scanner.nextLine();
                    boolean encontradoReserva = false;
                    for (Vuelo vueloActual : vuelos) {
                        if (vueloActual.getId().equals(idVueloReserva)) {
                            System.out.println("Ingrese su nombre:");
                            String nombre = scanner.nextLine();
                            System.out.println("Ingrese su apellido:");
                            String apellido = scanner.nextLine();
                            System.out.println("Ingrese la cantidad de asientos que desea reservar:");
                            int cantidadAsientos = scanner.nextInt();
                            String numeroConfirmacion = vueloActual.agregarReserva(nombre, apellido, cantidadAsientos);
                            if (numeroConfirmacion != "-1") {
                                System.out.println("\nReserva realizada exitosamente con numero de confirmacion: " + numeroConfirmacion);
                            }
                            else {
                                System.out.println("\nNo se pudo realizar la reserva");
                            }
                            encontradoReserva = true;
                        }
                    }

                    if (!encontradoReserva) {
                        System.out.println("No se encontro el vuelo con id: " + idVueloReserva);
                    }
                    
                    break;
                case 7:
                    System.out.println("Buscar reserva");
                    System.out.println("Ingrese el numero de confirmacion de la reserva a buscar:");
                    scanner.nextLine();
                    String codigoConfirmacion = scanner.nextLine();
                    boolean encontradoVuelo = false;
                    boolean encontradoReserva2 = false;
                    String idVueloAux = codigoConfirmacion.split("-")[0];

                    for (Vuelo vueloActual : vuelos) {
                        if (vueloActual.getId().equals(idVueloAux)) {
                            encontradoVuelo = true;
                            for (Reserva reservaActual : vueloActual.getReservas()) {
                                if (reservaActual.getCodigoConfirmacion().equals(codigoConfirmacion)) {
                                    System.out.println("Nombre: " + reservaActual.getNombrePasajero() + ", apellido: " + reservaActual.getApellidoPasajero() + 
                                                        ", cantidad de asientos: " + reservaActual.getCantidadAsientos() + ", codigo de confirmacion: " + reservaActual.getCodigoConfirmacion());
                                    encontradoReserva2 = true;
                                }
                            }                            
                        }
                    }

                    if (!encontradoVuelo) {
                        System.out.println("No se encontro el vuelo con id: " + idVueloAux);
                    }

                    if (!encontradoReserva2) {
                        System.out.println("No se encontro la reserva con codigo de confirmacion: " + codigoConfirmacion);
                    }

                    break;
                case 8:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
            System.out.println("\nSeleccione una opcion:");
            System.out.println("1. Crear vuelo");
            System.out.println("2. Ver vuelos");
            System.out.println("3. Buscar vuelo");
            System.out.println("4. Modificar vuelo");
            System.out.println("5. Eliminar vuelo");
            System.out.println("6. Realizar reserva");
            System.out.println("7. Buscar reserva");
            System.out.println("8. Salir");
        }
        scanner.close();
    }
}