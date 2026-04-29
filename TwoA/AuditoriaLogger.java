package TwoA;

public class AuditoriaLogger {

    private static AuditoriaLogger instanciaUnica;

    private AuditoriaLogger() {
        System.out.println("Sistema de auditoría inicializado.");
    }

    public static AuditoriaLogger getInstance() {
        if (instanciaUnica == null) {
            instanciaUnica = new AuditoriaLogger();
        }
        return instanciaUnica;
    }

    public void registrar(String evento, String usuario) {
        System.out.println("[LOG] Usuario: " + usuario + " -> Acción: " + evento);
    }
}
