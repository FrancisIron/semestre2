
public class Alumno
{
    String nombre;
    String apellido;
    String matricula;
    String rut;
    
    public Alumno()
    {
        this.nombre="Alumno";
        this.apellido="Alumno";
        this.matricula="00000000000";
        this.rut="00.000.000-0";
    } 

    public Alumno(String n,String a,String mat,String r)
    {
        this.nombre=n;
        this.apellido=a;
        this.matricula=mat;
        this.rut=r; 
    }
    
    public void setNombre(String n){this.nombre=n;}
    public void setApellido(String a){this.apellido=a;}
    public void setMatricula(String m){this.matricula=m;}
    public void setRut(String r){this.rut=r;}
    
    public String getNombre(){return this.nombre;}
    public String getApellido(){return this.apellido;}
    public String getMatricula(){return this.matricula;}
    public String getRut(){return this.rut;}
    
    public String toString()
    {
        String str="Nombre: "+this.getNombre()+"\nApellido: "+getApellido()+"\nMatrícula: "+getMatricula()+"\nRut: "+getRut();
        return str;
    }
}
