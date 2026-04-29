# Identifica qué principios SOLID viola esta clase y explica por qué en cada caso.

- La clase viola el principio de responsabilidad única, tiene varios métodos que realizan diferentes actividades no relacionadas en la misma clase. Además, viola el principio de Inversión de Dependencias ya que al tener todos estos métodos juntos, la lógica de alto nivel está fuertemente acoplada a detalles de bajo nivel.

# Gestión de clases

## GESTION LIBROS

- prestarLibro()
- devolverLibro()

## GESTION MULTAS

- registrarMulta()

## CATALOGO

- consultarCatalogoCETYS()

## AUTENTICACION

- autenticarUsuario()

## NOTIFICACIONES

- enviarEmailNotificacion()

## REPORTES

- generarReportePDF()

# ¿Cómo se relaciona esta refactorización con la Dependency Rule de Clean Architecture?

- La Regla de Dependencia establece que el código debe apuntar hacia adentro, hacia las reglas de negocio. En el diseño original, la lógica central dependía de tecnologías externas. Al separarlas, permitimos que las clases de infraestructura vivan en las capas externas, mientras que la regla de negocio principal vive protegida en el centro.

