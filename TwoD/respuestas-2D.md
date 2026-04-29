# Muestra tres ejemplos de uso con distintas combinaciones de atributos opcionales.

- Estudiante renta el libro "El pequeño hoplita" el cual devolverá el 5 de mayo de 2026, en notas especiales se comentó que el alumno está usando el libro para una materia y suele hacer renovaciones seguido, tiene renovaciones automáticas activadas y lleva 6 renovaciones. 

SolicitudPrestamo solicitud1 = new SolicitudPrestamoBuilder()
    .conEstudiante(alumno)
    .conLibro(libroHoplita)
    .conFechaDevolucion(fechaMayo5)
    .conNotasEspeciales("El alumno está usando el libro para una materia y suele hacer renovaciones seguido")
    .conRenovacionAutomatica(true)
    .conNumRenovaciones(6)
    .construir();

- Estudiante renta el libro "Harry Potter y la piedra filosofal" el cual devolverá el 11 de mayo de 2026, no tiene notas especiales ni renovaciones automáticas, sin embargo, lleva 3 renovaciones.

SolicitudPrestamo solicitud2 = new SolicitudPrestamoBuilder()
    .conEstudiante(alumno)
    .conLibro(libroHarryPotter)
    .conFechaDevolucion(fechaMayo11)
    .conNumRenovaciones(3)
    .construir();

- Estudiante renta el libro "El retrato de Dorian Gray" el cual devolverá el 29 de abril de 2026, no tiene ningun atributo extra.

SolicitudPrestamo solicitud3 = new SolicitudPrestamoBuilder()
    .conEstudiante(alumno)
    .conLibro(libroDorianGray)
    .conFechaDevolucion(fechaAbril29)
    .construir();



# ¿por qué conviene que SolicitudPrestamo sea inmutable una vez construida? ¿Qué problemas evitamos?

- Conviene que no se pueda modificar una vez construida para evitar modificaciones accidentales o maliciosas que puedan afectar el funcionamiento del Sistema o la experiencia de  los usuarios que usan los servicios de biblioteca. Además, nos aseguramos de que no se creen objetos incompletes o sin datos fundamentales. 

