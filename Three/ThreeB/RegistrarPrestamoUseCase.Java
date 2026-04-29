package ThreeB;

public class RegistrarPrestamoUseCase {

    private final RepositorioPrestamos repositorio;

    public RegistrarPrestamoUseCase(RepositorioPrestamos repositorio) {
        this.repositorio = repositorio;
    }

    public void ejecutar(SolicitudPrestamo solicitud) {
        System.out.println("Validando reglas de negocio para el préstamo...");
        repositorio.guardar(solicitud);
        System.out.println("Préstamo registrado exitosamente.");
    }
}

