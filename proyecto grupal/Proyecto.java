package proyecto;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.csvreader.CsvWriter;  
import com.csvreader.CsvReader;
import java.io.FileNotFoundException;

public class Proyecto {

    
    public static void main(String[] args) {
        
        //guardar
        ArrayList<Producto> array = new ArrayList<>();
        
        Producto prod = new Producto("producto1","0001",1500,15);
        array.add(prod);
        Producto prod2 = new Producto("producto2","0002",200,10);
        array.add(prod2);
        
        String outputFile = "test/productos.csv";
        boolean alreadyExists = new File(outputFile).exists();
         
        if(alreadyExists){
            File ficheroProductos = new File(outputFile);
            ficheroProductos.delete();
        }        
         
        try {
         
            CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
             
            csvOutput.write("Nombre");
            csvOutput.write("Codigo");
            csvOutput.write("Precio");
            csvOutput.write("Cantidad");
            csvOutput.endRecord();
             
            for(int i=0;i<array.size();i++){
                 
                csvOutput.write(array.get(i).getNombre());
                csvOutput.write(array.get(i).getCodigo());
                csvOutput.write(Integer.toString(array.get(i).getPrecio()));
                csvOutput.write(Integer.toString(array.get(i).getCantidad()));
                csvOutput.endRecord();                   
            }
             
            csvOutput.close();
         
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // cargar
        
        try {
         
        CsvReader productos_import = new CsvReader("test/productos.csv");
        productos_import.readHeaders();
         
        while (productos_import.readRecord())
        {
            String nombre = productos_import.get(0);
            String codigo = productos_import.get(1);
            String precio = productos_import.get(2);
            String cantidad = productos_import.get(3);
             
            array.add(new Producto(nombre, codigo, Integer.parseInt(precio), Integer.parseInt(cantidad)));    
        }
         
        productos_import.close();
          
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println(array.get(0).getNombre());
        System.out.println(array.get(0).getCodigo());
        System.out.println(array.get(0).getPrecio());
        System.out.println(array.get(0).getCantidad());
        
        System.out.println(array.get(1).getNombre());
        System.out.println(array.get(1).getCodigo());
        System.out.println(array.get(1).getPrecio());
        System.out.println(array.get(1).getCantidad());
    }
}

