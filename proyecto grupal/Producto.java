package proyecto;

public class Producto
{
    private int precio;
    private String codigo;
    private String nombre;
    private int cantidad;
    
    public Producto(String newNombre,String newCodigo,int newPrecio,int newCantidad)
    {
        this.precio=newPrecio;
        this.codigo=newCodigo;
        this.nombre=newNombre;
        this.cantidad=newCantidad;
    }
    
    public void setPrecio(int newPrecio){this.precio=newPrecio;}
    public void setCodigo(String newCodigo){this.codigo=newCodigo;}
    public void setNombre(String newNombre){this.nombre=newNombre;}
    public void setCantidad(int newCantidad){this.cantidad=newCantidad;}
    
    public int getPrecio(){return this.precio;}
    public String getCodigo(){return this.codigo;}
    public String getNombre(){return this.nombre;}
    public int getCantidad(){return this.cantidad;}
    
    public String toString()
    {
        String str="Nombre del producto: "+this.nombre+"\nCodigo: "+this.codigo
        +"\nPrecio: "+this.precio+"\nCantidad: "+this.cantidad;
        return str;
    }
}

