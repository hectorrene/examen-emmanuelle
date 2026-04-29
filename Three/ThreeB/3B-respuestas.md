# Justifica la ubicación.

- La interfaz RepositorioPrestamos debe ubicarse en la capa de reglas de negocio por que al poner la interfaz en la capa interna, obligamos a que las capas externas se adapten a las reglas del caso de uso, y no al revés.

# Explica cómo la Dependency Rule garantiza que cambiar de MySQL a MongoDB no requiera tocar el use case.

- El RegistrarPrestamoUseCase vive en el centro y solo conoce la interfaz RepositorioPrestamos. MySQL y MongoDB viven en la capa más externa, si se quiere cambiar de MySQL a MongoDB, solo necesitamos crear una nueva clase MongoPrestamosImpl en la capa externa que implemente nuestra interfaz interna. 

# ¿Qué patrón de los estudiados en clase aparece implícitamente en este diseño?

- Se utiilizó el adaptador, en Clean Architecture las implementaciones de los repositorios en la capa externa actúan como Interface Adapters. Toman los datos de la base de datos (MySQL/MongoDB) y los adaptan para que cumplan con la interfaz que espera la capa de Casos de Uso.