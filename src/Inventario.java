import java.util.*;

public class Inventario {

    private ArrayList<ProductoInformatico> productos = new ArrayList<>();

    public Inventario() {
    }

    public Inventario(ArrayList<ProductoInformatico> productos) {
        this.productos = productos;
    }

    public void listarTodos() {
        for (ProductoInformatico p : productos){
            System.out.println(p.toString());
        }
    }

    public void listarSinStock() {

        for (ProductoInformatico p : productos){
            if (p.getStock() == 0){
            System.out.println(p.toString());
            }
        }
    }

    public boolean agregarProducto(ProductoInformatico p) {
        return productos.add(p);
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "productos=" + productos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Inventario that = (Inventario) o;
        return Objects.equals(productos, that.productos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productos);
    }

    public List<ProductoInformatico> buscarPorNombre(String nombre) {
        List<ProductoInformatico> resultados = new ArrayList<>();
        for (ProductoInformatico p : productos){
           if (p.getNombre().toLowerCase().contains(nombre.toLowerCase())){
               resultados.add(p);
           }
        }
        return resultados;
    }

    public List<ProductoInformatico> buscarPorCategoria(String cat) {
        List<ProductoInformatico> resultados = new ArrayList<>();
        for (ProductoInformatico p : productos){
            if (p.getCategoria().toLowerCase().contains(cat.toLowerCase())){
                resultados.add(p);
            }
        }return resultados;
    }

    public List<ProductoInformatico> buscarPorPrecio(double min, double max) {
        List<ProductoInformatico> resultados = new ArrayList<>();
        for (ProductoInformatico p : productos){
            if (min <= p.getPrecio() && max >= p.getPrecio()){
                resultados.add(p);
            }
        } return resultados;
    }

    public boolean incrementarStock(String cod, int c) {
        boolean incremente = false;
        if (c >0){
            for (ProductoInformatico p : productos){
                if (p.getCodigo().equals(cod)){
                    p.setStock(p.getStock()+c);
                    incremente= true;
                }
            }
        } return incremente;
    }

    public boolean decrementarStock(String cod, int c) {
        boolean decremente = false;
        if (c >0){
            for (ProductoInformatico p : productos){
                if (p.getCodigo().equals(cod)){
                    if (p.getStock()>= c) {
                        p.setStock(p.getStock() - c);
                        decremente = true;
                    }
                }
            }
        } return decremente;
    }

    public List<ProductoInformatico> ordenarPorPrecioAsc() {

    }
}