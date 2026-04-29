package TwoD; 

import java.util.Date;

public class SolicitudPrestamo {
    private final Estudiante estudiante;
    private final Libro libro;
    private final Date fechaDevolucion;
    private final String notasEspeciales;
    private final boolean renovacionAutomatica;
    private final int numRenovaciones;

    private SolicitudPrestamo(SolicitudPrestamoBuilder builder) {
        this.estudiante = builder.estudiante;
        this.libro = builder.libro;
        this.fechaDevolucion = builder.fechaDevolucion;
        this.notasEspeciales = builder.notasEspeciales;
        this.renovacionAutomatica = builder.renovacionAutomatica;
        this.numRenovaciones = builder.numRenovaciones;
    }

    public static class SolicitudPrestamoBuilder {

        private Estudiante estudiante;
        private Libro libro;
        private Date fechaDevolucion;
        private String notasEspeciales = null;
        private boolean renovacionAutomatica = false;
        private int numRenovaciones = 1;

        public SolicitudPrestamoBuilder conEstudiante(Estudiante estudiante) {
            this.estudiante = estudiante;
            return this;
        }

        public SolicitudPrestamoBuilder conLibro(Libro libro) {
            this.libro = libro;
            return this;
        }

        public SolicitudPrestamoBuilder conFechaDevolucion(Date fechaDevolucion) {
            this.fechaDevolucion = fechaDevolucion;
            return this;
        }

        public SolicitudPrestamoBuilder conNotasEspeciales(String notasEspeciales) {
            this.notasEspeciales = notasEspeciales;
            return this;
        }

        public SolicitudPrestamoBuilder conRenovacionAutomatica(boolean renovacionAutomatica) {
            this.renovacionAutomatica = renovacionAutomatica;
            return this;
        }

        public SolicitudPrestamoBuilder conNumRenovaciones(int numRenovaciones) {
            this.numRenovaciones = numRenovaciones;
            return this;
        }

        public SolicitudPrestamo construir() {
            if (this.estudiante == null) {
                throw new IllegalStateException("Error: El estudiante es obligatorio para la solicitud.");
            }
            if (this.libro == null) {
                throw new IllegalStateException("Error: El libro es obligatorio para la solicitud.");
            }

            if (this.fechaDevolucion == null) {
                throw new IllegalStateException("Error: La fecha de devolución es obligatoria.");
            }

            return new SolicitudPrestamo(this);
        }
    }
}