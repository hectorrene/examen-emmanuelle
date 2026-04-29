package TwoC;

public class AdaptadorCatalogoCETYS implements CatalogoBiblioteca {
    private CatalogoCETYS apiExterna;

    public AdaptadorCatalogoCETYS(CatalogoCETYS apiExterna) {

        this.apiExterna = apiExterna;

    }

    @Override
    public Libro buscarLibro(String isbn) {
        String formatoRequerido = "XML"; 
        ResultadoSOAP respuestaSoap = apiExterna.consultarObra(isbn, formatoRequerido);
        Libro libroMapeado = new Libro(); 
        libroMapeado.setIsbn(isbn);
        return libroMapeado;
    }
}

