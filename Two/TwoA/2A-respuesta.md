# Qué se hizo con el constructor

- El modificador de acceso al constructor se hizo privado para evitar que otras clases creen nuevas instancias con el logger de auditoría.

# ¿qué problema concreto de este sistema resuelve tener una sola instancia? ¿Qué pasaría si hubiera dos instancias simultáneas?

- Al tener una única instancia de auditoría se crea una sola fuente de verdad, facilitando la búsqueda de soluciones en caso de que algo falle dentro del sistema. Si hubiera más de una instancia simultáneamente habría un error de concurrencia lo cual corrompería los datos. 