import java.util.*;
public class Curso
{
    ArrayList<Alumno> curso = new ArrayList<Alumno>();
    
    /*public void cambiarNombre(int n,String nom)
    {
        if(n>0 && n<curso.size()){
            curso.get(n-1).setNombre(nom);
        }else{System.out.println("Ingrese un número válido");}
    }
    
    public void cambiarApellido(int n,String ap)
    {
        if(n>0 && n<curso.size()){
            curso.get(n-1).setApellido(ap);
        }else{System.out.println("Ingrese un número válido");}
    }
    
    public void cambiarMatricula(int n,String mat)
    {
        if(n>0 && n<curso.size()){
            curso.get(n-1).setMatricula(mat);
        }else{System.out.println("Ingrese un número válido");}
    }
    
    public void cambiarRut(int n,String rut)
    {
        if(n>0 && n<curso.size()){
            curso.get(n-1).setRut(rut);
        }else{System.out.println("Ingrese un número válido");}
    }
    */
   
    public void crearAlumno()
    {
        Alumno al = new Alumno();
        curso.add(al);
    }
    
    public void crearAlumno(String nom,String ap,String mat,String rut)
    {
        Alumno al = new Alumno(nom,ap,mat,rut);
        curso.add(al);
    }
    
    public boolean buscar(String rut)
    {
        for(int i=0;i<curso.size();i++)
        {
            if(curso.get(i).getRut().equals(rut)){
                return true;
            }
        }
        return false;
    }
    
    public String toString()
    {
        String str="";
        for(int i=0;i<curso.size();i++)
        {
            str+="Alumno "+(i+1)+":\n"+curso.get(i).toString()+"\n";
        }
        return str;
    }
    
    public void eliminar(String n)
    {
        int confirm=0;
        if(confirm==0)
        {
            for(int i=0;i<curso.size();i++)
            {
                if(curso.get(i).getNombre().equals(n))
                {
                    curso.remove(i);
                    i=curso.size();
                    confirm=1;
                }
            }
        }
        if(confirm==0)
        {
            for(int i=0;i<curso.size();i++)
            {
                if(curso.get(i).getApellido().equals(n))
                {
                    curso.remove(i);
                    i=curso.size();
                    confirm=1;
                }
            }
        }
        if(confirm==0)
        {
            for(int i=0;i<curso.size();i++)
            {
                if(curso.get(i).getMatricula().equals(n))
                {
                    curso.remove(i);
                    i=curso.size();
                    confirm=1;
                }
            }
        }
        if(confirm==0)
        {
            for(int i=0;i<curso.size();i++)
            {
                if(curso.get(i).getRut().equals(n))
                {
                    curso.remove(i);
                    i=curso.size();
                    confirm=1;
                }
            }
        }
        if(confirm==0){System.out.println("No existe lo ingresado en ningún alumno");}
    }
}
