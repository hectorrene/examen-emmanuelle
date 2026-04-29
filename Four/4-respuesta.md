# Flujo cronológico de la operación

Cuando un estudiante solicita un préstamo y el sistema cobra la fianza, los componentes interactúan en el siguiente orden:

- El estudiante envía la petición de préstamo desde la interfaz.

- El Controlador recibe la petición y utiliza la FabricaDeUsuarios para instanciar el objeto del usuario que está haciendo la solicitud.

- Se utiliza el SolicitudPrestamoBuilder para construir la solicitud paso a paso, integrando al estudiante, el libro, las fechas y los atributos opcionales.

- El controlador pasa la solicitud ya construida al RegistrarPrestamoUseCase.

- El caso de uso orquesta la lógica de negocio: primero, llama a la interfaz del sistema de cobros.

- El AdaptadorSistemaPagos recibe la instrucción interna, la traduce al formato REST de la firma bancaria y ejecuta el cobro con el Sistema de Pagos Bancario.

- Una vez aprobado el pago, el caso de uso llama al RepositorioPrestamos para guardar la solicitud en la base de datos.

- Finalmente, el caso de uso manda a llamar al AuditoriaLogger para dejar registro en la bitácora central de que la operación fue un éxito.

# Intervención de los 4 patrones de diseño

- Factory: Actúa al inicio (paso 2) para crear la instancia del tipo de usuario correcto sin que el controlador necesite hacer un new directo de la clase concreta.

- Builder: Actúa en el paso 3 para ensamblar el objeto complejo SolicitudPrestamo y validar que los campos obligatorios estén presentes antes de enviarlo a las reglas de negocio.

- Adapter: Actúa en el paso 6. Permite que el caso de uso solicite el cobro usando una interfaz interna y limpia, mientras el adaptador se ensucia las manos lidiando con la API REST y las firmas diferentes del banco.

- Singleton: Actúa al final (paso 8). Garantiza que el caso de uso escriba el registro del evento en la única instancia global del log de auditoría.

# Niveles del Modelo C4 en el flujo

- Nivel 1 (Contexto): Representado por la interacción inicial del Actor (Estudiante) con nuestro Sistema, y la salida de nuestro Sistema hacia el Sistema Externo (Pagos Bancario).

- Nivel 2 (Contenedores): Representado por la comunicación entre la aplicación cliente (UI) llamando al contenedor API Backend (Controlador), y el Backend comunicándose con la Base de Datos.

- Nivel 3 (Componentes): Representado por el trabajo interno del Backend: el Controlador delegando el trabajo al componente de Seguridad (Factory), a la lógica de negocio (UseCase) y la integración (Adapter/Repositorio).

# Decisión Arquitectónica y Justificación

- Decisión: Aislar el Sistema de Pagos Bancario utilizando el patrón Adapter y la Inyección de Dependencias en el Caso de Uso.

Justificación: El sistema de pagos es el componente con mayor probabilidad de cambiar (por actualización de APIs bancarias o cambio de proveedor de pagos por parte de la Universidad). Al aislarlo, el RegistrarPrestamoUseCase no sabe nada sobre firmas REST bancarias o tokens externos; solo conoce un contrato interno. Si el banco cambia su API el mes que viene, la lógica de préstamos y fianzas queda intacta, solo se debe escribir un nuevo Adaptador, garantizando alta mantenibilidad y bajo riesgo de romper el sistema.