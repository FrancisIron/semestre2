import java.util.Scanner;
public class TestCurso
{
    static Curso curso = new Curso();
    public static void main(){
        menu();
    }
    
    private static void menu()
    {
        int selec=0;
        while(selec!=6)
        {
            System.out.println("Seleccione: \n1)Agregar alumno predeterminado\n2)Agregar alumno con atributos\n3)Eliminar alumno\n4)Ver curso\n5)Buscar alumno por rut\n6)Salir");
            selec=leerInt();
            seleccion(selec);
        }
    }
    
    private static void seleccion(int sel)
    {
        switch(sel)
        {
            case 1:
            curso.crearAlumno();
            break;
            
            case 2:
            System.out.println("Ingrese nombre");
            String nom=leerString();
            System.out.println("Ingrese apellido");
            String ap=leerString();
            String mat="";
            do{
                System.out.println("Ingrese matrícula");
                mat=leerString();
            }while(validarMat(mat)==false);
            String rut="";
            do{
                System.out.println("Ingrese rut con puntos y guión(ej: 12.345.678-9)");
                rut=leerString();
            }while(validarRut(rut)==false);
            curso.crearAlumno(nom,ap,mat,rut);
            break;
            
            case 3:
            System.out.println("Ingrese nombre, apellido, matrícula o rut para eliminar alumno");
            curso.eliminar(leerString());
            break;
            
            case 4:
            System.out.println(curso.toString());
            break;
            
            case 5:
            System.out.println("Ingrese rut a buscar con puntos y guión(ej: 12.345.678-9)");
            String str=leerString();
            if(validarRut(str))
            {
                if(curso.buscar(str))
                {
                   System.out.println("El rut ingresado existe en el cruso");
                }else{System.out.println("No existe el rut ingresado en el curso");}
            }
            break;
        }
    }
    
    private static boolean validarMat(String m)
    {
        try{
            int n=m.length();
            if(m.length()==11){return true;}
        }catch(java.util.InputMismatchException ex){System.out.println("Ingrese un n° de matrícula válido");return false;}
        System.out.println("Ingrese un n° de matrícula válido");
        return false;
    }
    
    private static int leerInt()
    {
        int num=0;
        boolean confirm=false;
        while(confirm==false)
        {
            try
            {
                Scanner n = new Scanner(System.in);
                num=n.nextInt();
                confirm=true;
            }catch(java.util.InputMismatchException ex){System.out.println("Ingrese un número válido");return 0;}
        }
        return num;
    }
    
    private static String leerString()
    {
        boolean confirm=false;
        String str="";
        Scanner n = new Scanner(System.in);
        str=n.next();
        return str;
    }
    
    private static boolean validarRut(String r)
    {
        try{
        if(r.contains("."))
        {
            String part[]=r.split("\\.");
            if(part.length==3)
            {
                String part2[]=part[2].split("\\-");
                if(part[0].length()<3 && part[0].length()>0 && Integer.parseInt(part[0])>0 && part[1].length()==3 && Integer.parseInt(part[1])>0 && part2[0].length()==3 && Integer.parseInt(part2[0])>0 && part2[1].length()==1)
                {
                   if(part2[1].contains("k")){return true;}else{
                       if(Integer.parseInt(part2[1])==1 || Integer.parseInt(part2[1])==2 || Integer.parseInt(part2[1])==3 ||Integer.parseInt(part2[1])==4 || Integer.parseInt(part2[1])==5 || Integer.parseInt(part2[1])==6 || Integer.parseInt(part2[1])==7 || Integer.parseInt(part2[1])==8 || Integer.parseInt(part2[1])==9)
                       {
                           return true;
                       }else{System.out.println("Ingrese un rut válido"); return false;}
                   }
                }else{System.out.println("Ingrese un rut válido"); return false;}
            }else{System.out.println("Ingrese un rut válido"); return false;}
        }else{System.out.println("Ingrese un rut válido");}
        return false;
        }catch(java.lang.NumberFormatException Ex){System.out.println("Ingrese un rut válido"); return false;}
    }
}
