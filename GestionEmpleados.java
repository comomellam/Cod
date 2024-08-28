
package claseMain;

import Clases.Desarrollador;
import Clases.Empleado;
import Clases.Gerente;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JB23006
 * Miercoles 29 de mayo de 2024
 * hora:22:28, san salvador
 */
public class GestionEmpleados {

   
    public static void main(String[] args) {
       
        /**
         * declaramos dos objetos para iniciar dentro de un for 
         * clave
         */
        double bono=0;
        
        List<Gerente> gerentes = new ArrayList<>();
        List<Desarrollador> desarrollo = new ArrayList<>();
        int cantidad[] = new int[2];
      
       
         
        String datos = null,nombre = null,apellido=null,departamento=null,lenguaje=null;
        double salario = 0, bonoT=0;
        String fecha;
        int cantidadProyectos=0;
        boolean dato = false;
         System.out.print("----------------------------------");
        System.out.println("\nSeleccione una opcion disponible");
        System.out.println("\n1.Registro Gerente");
        System.out.println("\n2.Registro de Desarrollador");
        System.out.print("----------------------------------");
     int opcion =0;
     do
     { 
     try{
       String datoIngresado = 
               JOptionPane.showInputDialog(null,"Ingrese una opcion");
       
      
       
        opcion = Integer.parseInt(datoIngresado);
        if(opcion < 0 || opcion > 3)
        {
            JOptionPane.showMessageDialog(null,"Elija una opcion disponible de menu."
                        );   
        } 
        else{
        switch(opcion)
        {
            case 1 : 
                
        for(int i=0; i<cantidad.length;i++){
       
        Gerente gerente = new Gerente();
        

        datos = JOptionPane.showInputDialog(null,"ingrese el nombre: "+(i+1));
        nombre = datos.toString();
        

        datos = JOptionPane.showInputDialog(null,"Ingrese el apellido."+(i+1));
        apellido = datos.trim();
        
        
        datos = JOptionPane.showInputDialog(null,"Ingrese el departamento(contabilidad etc.)"+(i+1));
        departamento = datos.toLowerCase();
        
        datos = JOptionPane.showInputDialog(null,"salario del gerente."+(i+1));
        salario = Double.parseDouble(datos);
        
        datos = JOptionPane.showInputDialog(null,"fecha de contratacion,(yyyy-mmm-ddd):"+(i+1));
        fecha = datos;
        
        
        gerente.setNombre(nombre);
        gerente.setApellido(apellido);
        gerente.setDepartamento(departamento);
        gerente.setFechaContratacion(LocalDate.parse(fecha));
        gerente.setSalario(salario);
        gerente.bono();
        gerentes.add(gerente);
        
        }
        int k=0;
        for(Gerente gerentesActivos: gerentes)
        {
            System.out.println("--------------------------- ");
            System.out.println("\nGerente: "+(k+1)+"\nnombre: "+ gerentesActivos.getNombre()
            +"\napellido: "+ gerentesActivos.getApellido()
            +"\nDepartamento: "+ gerentesActivos.getDepartamento()
            +"\nfecha de contrato: "+gerentesActivos.getFechaContratacion()
            +"\nsalario: "+gerentesActivos.getSalario()
            +"\nbono: "+gerentesActivos.bono());
             
              
        }
       
                break;
            case 2: 
                
                 for(int i=0; i<cantidad.length;i++){
       
        Desarrollador desarrollador = new Desarrollador();
        
        datos = JOptionPane.showInputDialog(null,"ingrese el nombre del desarrollador: " +(i+1),
                "Desarrollador",JOptionPane.INFORMATION_MESSAGE);
        nombre = datos.toString();

        datos = JOptionPane.showInputDialog(null,"Ingrese el apellido de desarrollador. "+(i+1));
        apellido = datos.trim();
        
        
        datos = JOptionPane.showInputDialog(null,"Ingrese lenguaje de programacion(Ej.Java, C++ etc). )"+(i+1));
        lenguaje = datos.toLowerCase();
        
        datos = JOptionPane.showInputDialog(null,"salario del desarrollador . "+(i+1));
        salario = Double.parseDouble(datos);
        
        datos = JOptionPane.showInputDialog(null,"fecha de contratacion(yyyy-mmm-ddd): "+(i+1));
        fecha = datos;
        
        datos = JOptionPane.showInputDialog(null,"Ingrese la cantidad de proyectos realizados por desarrollador "+(i+1));
        cantidadProyectos = Integer.parseInt(datos);
        
        desarrollador.setNombre(nombre);
        desarrollador.setApellido(apellido);
        desarrollador.setCantidadProyectos(cantidadProyectos);
        desarrollador.setLengueProgramacion(lenguaje);
        desarrollador.setFechaContratacion(LocalDate.parse(fecha));
        desarrollador.setSalario(salario);
        desarrollador.bonoProyecto();
        desarrollo.add(desarrollador);
        
        }
        int p=0;
        for(Desarrollador desarrolladores: desarrollo)
        {
            System.out.println("--------------------------- ");
            System.out.println("\nGerente: "+(p+1));
             System.out.println("\nnombre: "+ desarrolladores.getNombre());
              System.out.println("\napellido: "+ desarrolladores.getApellido());
              System.out.println("\nLenguage de programacion: "+ desarrolladores.getLengueProgramacion());
              System.out.println("\nproyectos finalizados: "+desarrolladores.getCantidadProyectos());
               System.out.println("\nfecha de contrato: "+desarrolladores.getFechaContratacion());
                System.out.println("\nsalario: "+desarrolladores.getSalario());
                 System.out.println("\nbono: "+desarrolladores.bonoProyecto());
        }  
          break;
            default:
                JOptionPane.showMessageDialog(null,"OPcion no valida.",
                        "Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        }
       
      }
        catch(Exception e){
        JOptionPane.showMessageDialog(null,
            "solo se permiten numeros."+ e);}
        
        
     }
     while(opcion <=0);
        
    }
    public static boolean validacionTexto(String texto)
   {
       boolean validacion = true;
       
       if(texto.trim().length()==0||texto.matches("^[a-zA-Z ]+$"))
       {
           
           return false;
       }
       /**
        * if (fecha.matches("\\d{2}/\\d{2}/\\d{4}"))
        {
            try {
                // Convertimos la cadena de fecha a un objeto Date
                SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
                formatoEntrada.setLenient(false); // Evita fechas inválidas como 31/02/2021
                Date fechaDate = formatoEntrada.parse(fecha);

                // Verificamos si la fecha está en el pasado (no en el futuro)
                Date fechaActual = new Date();
                if (fechaDate.after(fechaActual))
                {
                    System.out.println("La fecha de contratacion no puede estar en el futuro.");
                }
                else 
                {
                    // Creamos un nuevo formato para la salida (día de mes de año)
                    SimpleDateFormat formatoSalida = new SimpleDateFormat("d 'de' MMMM 'del' yyyy");
                    String fechaFormateada = formatoSalida.format(fechaDate);

                    //System.out.println("Fecha valida: " + fechaFormateada);
                }
            }
            catch (Exception e)
            {
                System.out.println("Error al formatear o validar la fecha.");
            }
        } 
                        else {
                        System.out.println(
                                "Formato incorrecto. Inténtalo nuevamente (dd/mm/yyyy).");
                        }*/
       return validacion;
   }
    public static String no()
    {
          /* int filas, columnas;
        
        // Solicitar al usuario las dimensiones de la matriz
        try {
            filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas:"));
            columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
            return;
        }
        
        // Crear la matriz
        String[][] matriz = new String[filas][columnas];
        
        // Llenar la matriz con nombres
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre para la posición [" + i + "][" + j + "]:");
                matriz[i][j] = nombre;
            }
        }
        
        // Mostrar la matriz
        StringBuilder mensaje = new StringBuilder("Matriz de nombres:\n");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                mensaje.append(matriz[i][j]).append("\t");
            }
            mensaje.append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
        
        
        
        
  
      /*
        Desarrollador desarrolladorWed= new Desarrollador();
        desarrolladorWed.setNombre("maria");
        desarrolladorWed.setApellido("carranza");
        desarrolladorWed.setCantidadProyectos(6);
        desarrolladorWed.setLengueProgramacion("Phyton");
        desarrolladorWed.setSalario(800);
        desarrolladorWed.setFechaContratacion(LocalDate.parse("2009-01-12"));
        desarrolladorWed.bonoProyecto();

        Gerente gerente = new Gerente();
        gerente.setNombre("miguel");
        gerente.setApellido("alvarenga");
        gerente.setSalario(1300);
        gerente.setFechaContratacion(LocalDate.parse("2010-12-12"));
        gerente.setDepartamento("contabilidad");
        gerente.bono();
        
        Gerente gerente2 = new Gerente();
        gerente2.setNombre("rosa");
        gerente2.setApellido("clavel");
        gerente2.setSalario(1200);
        gerente2.setFechaContratacion(LocalDate.parse("2020-05-10"));
        gerente2.setDepartamento("informatica");
        gerente2.bono();
        
        Desarrollador desarrolladorWed2= new Desarrollador();
        desarrolladorWed2.setNombre("pepe");
        desarrolladorWed2.setApellido("gonzalez");
        desarrolladorWed2.setCantidadProyectos(9);
        desarrolladorWed2.setLengueProgramacion("Diamante");
        desarrolladorWed2.setSalario(800);
        desarrolladorWed2.setFechaContratacion(LocalDate.parse("2001-01-24"));
        desarrolladorWed2.bonoProyecto();
        
        
        gerente.add(gerente);
        gerentes.add(gerente2);
        desarrollo.add(desarrolladorWed);
        desarrollo.add(desarrolladorWed2);
        
        int l=0;
        for(Gerente empleado : gerentes)
        {
            System.out.println("--------------------------- ");
            System.out.println("\nGerente: "+(l+1));
             System.out.println("\nnombre: "+ empleado.getNombre());
              System.out.println("\napellido: "+ empleado.getApellido());
              System.out.println("\nDepartamento: "+ empleado.getDepartamento());
               System.out.println("\nfecha de contrato: "+empleado.getFechaContratacion());
                System.out.println("\nsalario: "+empleado.getSalario());
                 System.out.println("\nbono: "+empleado.bono());
                 
            l++;
        }
        int k =0;
                
        for(Desarrollador empleado : desarrollo)
        {
            System.out.println("-------------------------- ");
            System.out.println("\nDesarrollador: "+(k+1));
             System.out.println("\nnombre: "+ empleado.getNombre());
              System.out.println("\napellido: "+ empleado.getApellido());
              System.out.println("\nLenguage de Programacion: "+ empleado.getLengueProgramacion());
               System.out.println("\nfecha de contrato: "+empleado.getFechaContratacion());
                System.out.println("\nsalario: "+empleado.getSalario());
                System.out.println("\nProyectos teminados: "+empleado.getCantidadProyectos());
                 System.out.println("\nbono: "+empleado.bonoProyecto());
               
            k++;
        }
        
        //StringBuilder mensaje = new StringBuilder("Matriz de nombres:\n");
        
        
        
        

 */
        

       return null;
    }
    }


        
     