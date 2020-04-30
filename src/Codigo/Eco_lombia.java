<<<<<<< HEAD
package Codigo;



import Interface.Inicio;
import Interface.Ventana;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Eco_lombia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException  {
        // TODO code application logic here
    //Ventana prueba = new Ventana ();
    //----------------------------------------------------------------------------------------
    
        System.out.println("\tECO-LOMBIA\n");
        System.out.println("Escoja con lo que desea trabajar");
        System.out.println("1.Usuarios by Linked-List");
        System.out.println("2.Usuarios by DynamicArray");
        System.out.println("3.Flora, faura y ecoparques by linkedList");
        System.out.println("4.Flora, faura y ecoparques by DynamicArray");
        System.out.println("5.Paginador - Flora, faura y ecoparques by DynamicArray");
        
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader console = new BufferedReader (isr);
        String Vwork=null;
        try {
                 Vwork= console.readLine();
            } catch (IOException ex) {
                ex.getMessage();
            }
        
    //----------------------------------------------------------------------------------------
    //prueba usuario LinkedList   
    if(Vwork.equals("1")){
        LinkedList<UsuarioRegistrado> usuarios=new LinkedList<>();
  
        String opcion=null;
        String[] datos={"Correo","Contraseña","Institucion","Profesión","Nombres","Apellidos","ID"};
        boolean ciclo=true;
        long inicio;
        long fin;
       while(ciclo){
               System.out.println("    Escoja la acción que desea realizar\n");
               System.out.print("1.Insertar un numero de datos\n"
                       + "2.insertar un dato\n"
                       + "3.cambiar contraseña de un usuario por su id\n"
                       + "4.Buscar un dato por su id \n"
                       + "5.Entregar los nombres de los datos\n"
                       + "6.Salir\n");
            try {
                opcion= console.readLine();
            } catch (IOException ex) {
                ex.getMessage();
            }
                       switch(opcion){
                           case "1":
                               //for(int i=0;i<10;i++){
                               inicio = System.currentTimeMillis();
                             try{
                                   String separador=System.getProperty("file.separator");
                                   File f = new File("data"+separador+"Usuario10000.txt");
                                   FileReader lectorArchivo=new FileReader(f);
                                   BufferedReader br = new BufferedReader(lectorArchivo);
                                   String l="";
                                   String aux="";

                                   while(true){
                                       aux=br.readLine();
                                       if(aux==null){
                                           break;
                                       }
                                       String[] atributos=aux.split(",");
                                       usuarios.add(new UsuarioRegistrado(atributos[0]
                                           ,atributos[1],atributos[2],atributos[3],atributos[4],
                                           atributos[5],atributos[6]));      
                                       
                                   } 
                                   br.close();
                                   lectorArchivo.close();
                               }catch(Exception e){
                                   System.out.println("error  "+e );
                                   System.out.println(e.getMessage());
                               }fin = System.currentTimeMillis();
                                System.out.println(fin - inicio);
                                  break;  

                           case "2":
                               try {
                                   String[] info=new String[7];
                                   
                               for(int i=0;i<7;i++){
                                   System.out.println("Ingrese el "+datos[i]+" de el usuario");
                                   info[i]= console.readLine();
                               }
                               inicio = System.currentTimeMillis();
                               usuarios.add(new UsuarioRegistrado(info[0],info[1],info[2],info[3],info[4],info[5],info[6]));
                               fin = System.currentTimeMillis();
                               System.out.println(fin - inicio);
                                  } catch (IOException ex) {
                                   Logger.getLogger(Eco_lombia.class.getName()).log(Level.SEVERE, null, ex);
                               }break;

                           case "3":
                               try {
                                   inicio = System.currentTimeMillis();
                                   System.out.println("Ingrese el id del usuario al que desea cambiarle la contraseña");
                                   String id=console.readLine();
                                    
                                   Node temporal= usuarios.getNodeAt(0);
                                   UsuarioRegistrado Ucambio=(UsuarioRegistrado) temporal.key;
                                   while((temporal.next)!=null){            
                                        if(Ucambio.getId().equals(id)){
               
                                        break;} 
                                        temporal= temporal.next;
                                        Ucambio=(UsuarioRegistrado) temporal.key;
                                    }
                                   
                                   System.out.println("Ingrese la contraseña actual del usuario");
                                   String passwordact=console.readLine();

                                   if(Ucambio.getPassword().equals(passwordact)){
                                       String newPassowrd="";
                                       String newPassword2=".";
                                       while(!newPassowrd.equals(newPassword2)){
                                       System.out.println("Ingrese la nueva contraseña");
                                       newPassowrd=console.readLine();
                                       System.out.println("Ingrese la contraseña nuevamnte");
                                       newPassword2=console.readLine();
                                       }
                                       Ucambio.setPassword(newPassowrd);
                                       System.out.println("Contraseña cambiada");
                                   }else{
                                       System.out.println("La contraseña no es correcta");
                                   }fin = System.currentTimeMillis();
                                    System.out.println(fin - inicio);
                               } catch (IOException ex) {
                                   Logger.getLogger(Eco_lombia.class.getName()).log(Level.SEVERE, null, ex);
                               }break;

                           case "4":

                               try {
                                   System.out.println("Ingrese el id del usuario De quien desea visualizar su nombre");
                                   String id; 
                                   id = console.readLine(); 
                                   inicio = System.currentTimeMillis();
                                   Node temporal= usuarios.getNodeAt(0);
                                   UsuarioRegistrado Ucambio=(UsuarioRegistrado) temporal.key;
                                   while((temporal.next)!=null){            
                                        if(Ucambio.getId().equals(id)){
               
                                        break;} 
                                        temporal= temporal.next;
                                        Ucambio=(UsuarioRegistrado) temporal.key;
                                    }
                                   System.out.println("el nombre del usuario con cc: "+id+" es "+Ucambio.getNombres());
                                    fin = System.currentTimeMillis();
                                    System.out.println(fin - inicio);
                              } catch (IOException ex) {
                                   Logger.getLogger(Eco_lombia.class.getName()).log(Level.SEVERE, null, ex);
                               }break;

                           case "5":
                                    inicio = System.currentTimeMillis();
                                    Node temporal= usuarios.getNodeAt(0);
                                    UsuarioRegistrado Ucambio=(UsuarioRegistrado) temporal.key;
                                    while((temporal.next)!=null){            
                                        Ucambio.getNombres(); 
                                        temporal= temporal.next;
                                        Ucambio=(UsuarioRegistrado) temporal.key;
                                    }
                                    Ucambio.getNombres(); 
                                    fin = System.currentTimeMillis();
                                    System.out.println(fin - inicio);
                                    break;

                           case "6":
                               inicio = System.currentTimeMillis();
                               OutputStream       outputStream;
                                if(!usuarios.isEmpty()){
                               try {
                                    Node salida= usuarios.getNodeAt(0);
                                    UsuarioRegistrado Usalida=(UsuarioRegistrado) salida.key;
                                    String separador=System.getProperty("file.separator");
                                    File f = new File("data"+separador+"Salida.txt");
                                    outputStream = new FileOutputStream(f.getAbsolutePath());
                                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                                    
                                   while((salida.next)!=null){            
                                    outputStreamWriter.write(Usalida.getCorreo()+","+Usalida.getPassword()+","
                                    +Usalida.getInstitucion()+","+Usalida.getProfesion()+","+Usalida.getNombres()
                                    +","+Usalida.getApellidos()+","+Usalida.getId()+"\n");
                                        salida= salida.next;
                                        Usalida=(UsuarioRegistrado) salida.key;
                                    }
                                   outputStreamWriter.write(Usalida.getCorreo()+","+Usalida.getPassword()+","
                                    +Usalida.getInstitucion()+","+Usalida.getProfesion()+","+Usalida.getNombres()
                                    +","+Usalida.getApellidos()+","+Usalida.getId()+"\n");

                                    outputStreamWriter.close();
                                } catch (Exception ex) {
                                    Logger.getLogger(Eco_lombia.class.getName()).log(Level.SEVERE, null, ex);
                                }}
                               ciclo=false;
                                  fin = System.currentTimeMillis();
                                  JOptionPane.showMessageDialog(null,fin-inicio);
                               break;
                                
                           default:
                               System.out.println("El valor ingresado no esta entre las opciones");
                       }

       } 
    }else if(Vwork.equals("2")){
//----------------------------------------------------------------------------------------
//

//       // prueba usuario arrayDinamico




        DynamicArray<UsuarioRegistrado> usuarios=new DynamicArray<>(10);
        String opcion=null;
        String[] datos={"Correo","Contraseña","Institucion","Profesión","Nombres","Apellidos","ID"};
        boolean ciclo=true;
        long inicio;
        long fin;

       while(ciclo){
                    System.out.println("    Escoja la acción que desea realizar\n");
               System.out.print("1.Insertar un numero de datos\n"
                       + "2.insertar un dato\n"
                       + "3.cambiar contraseña de un usuario por su id\n"
                       + "4.Buscar un dato por su id \n"
                       + "5.Entregar los nombres de los datos\n"
                       + "6.Salir\n");
            try {
                opcion= console.readLine();
            } catch (IOException ex) {
                ex.getMessage();
            }
                       switch(opcion){
                           case "1":
                               inicio = System.currentTimeMillis();
                                //for(int i=0;i<2;i++){
                             try{
                                   String separador=System.getProperty("file.separator");
                                   File f = new File("data"+separador+"Usuario3000000.txt");;
                                   FileReader lectorArchivo=new FileReader(f);
                                   BufferedReader br = new BufferedReader(lectorArchivo);
                                   String l="";
                                   String aux="";

                                   while(true){
                                       aux=br.readLine();
                                       if(aux==null){
                                           break;
                                       }
                                       String[] atributos=aux.split(",");
                                       usuarios.push(new UsuarioRegistrado(atributos[0]
                                           ,atributos[1],atributos[2],atributos[3],atributos[4],
                                           atributos[5],atributos[6]));      
                                   } 
                                   br.close();
                                   lectorArchivo.close();
                               }catch(Exception e){
                                   System.out.println("error  "+e );
                                   System.out.println(e.getMessage());
                                   
                               }//}
                                fin = System.currentTimeMillis();
                                System.out.println(fin - inicio);
                                
                                break;  
                           case "2":
                               
                               try {
                                   String[] info=new String[7];
                               for(int i=0;i<7;i++){
                                   System.out.println("Ingrese el "+datos[i]+" de el usuario");
                                   info[i]= console.readLine();
                               } 
                               inicio = System.currentTimeMillis();
                               usuarios.push(new UsuarioRegistrado(info[0],info[1],info[2],info[3],info[4],info[5],info[6]));
                               fin = System.currentTimeMillis();
                               System.out.println(fin - inicio);
                               } catch (IOException ex) {
                                   Logger.getLogger(Eco_lombia.class.getName()).log(Level.SEVERE, null, ex);
                               }
                               break;

                           case "3":
                               try {
                                   System.out.println("Ingrese el id del usuario al que desea cambiarle la contraseña");
                                   String id=console.readLine();
                                   if(usuarios.isEmpty()){
                                        System.out.println("Estructura vacia...");
                                        break;
                                   }
                                   int position=0;
                                   UsuarioRegistrado Ucambio=(UsuarioRegistrado) usuarios.value(0);
                                   for(int i =1;i<usuarios.size;i++){
                                        if(Ucambio.getId().equals(id)){
                                            break;
                                        }
                                        position++;
                                        Ucambio=(UsuarioRegistrado) usuarios.value(i);
                                   }
            
                                   System.out.println("Ingrese la contraseña actual del usuario");
                                   String passwordact=console.readLine();
                                   inicio = System.currentTimeMillis();
                                   if(Ucambio.getPassword().equals(passwordact)){
                                       String newPassowrd="";
                                       String newPassword2=".";
                                       while(!newPassowrd.equals(newPassword2)){
                                       System.out.println("Ingrese la nueva contraseña");
                                       newPassowrd=console.readLine();
                                       System.out.println("Ingrese la contraseña nuevamente");
                                       newPassword2=console.readLine();
                                       }
                                       
                                       Ucambio.setPassword(newPassowrd);
                                       usuarios.set(position, Ucambio);
                                       System.out.println("Contraseña cambiada");
                                   }else{
                                       System.out.println("La contraseña no es correcta");
                                   }
                                   fin = System.currentTimeMillis();
                                    System.out.println(fin - inicio);
                               } catch (IOException ex) {
                                   Logger.getLogger(Eco_lombia.class.getName()).log(Level.SEVERE, null, ex);
                               }
                               break;

                           case "4":
                               
                               try {
                                   System.out.println("Ingrese el id del usuario De quien desea visualizar su nombre");
                                   
                                   String id; 
                                   id = console.readLine(); 
                                   inicio = System.currentTimeMillis();
                                   if(usuarios.isEmpty()){
                                        System.out.println("Estructura vacia...");
                                        break;
                                   }
                                   int position=0;
                                   UsuarioRegistrado Utemporal=(UsuarioRegistrado) usuarios.value(0);
                                   for(int i =1;i<usuarios.size;i++){
                                        if(Utemporal.getId().equals(id)){
                                            break;
                                        }
                                        position++;
                                        Utemporal=(UsuarioRegistrado) usuarios.value(i);
                                   }
                                   System.out.println("el nombre del usuario con cc: "+id+" es "+Utemporal.getNombres());
                                   fin = System.currentTimeMillis();
                                   System.out.println(fin - inicio);
                               } catch (IOException ex) {
                                   Logger.getLogger(Eco_lombia.class.getName()).log(Level.SEVERE, null, ex);
                               }
                               break;

                           case "5":
                               inicio = System.currentTimeMillis();
                                for(int i =0;i<usuarios.size;i++){
                                UsuarioRegistrado Utemporal= (UsuarioRegistrado) usuarios.value(i);
                                Utemporal.getNombres();
                                }
                                fin = System.currentTimeMillis();
                                System.out.println(fin - inicio);
                               break;

                           case "6":
                               inicio = System.currentTimeMillis();
                                    if(!usuarios.isEmpty()){
                               try{
                                    String separador=System.getProperty("file.separator");
                                    File f = new File("data"+separador+"Salida.txt");
                                    OutputStream outputStream = new FileOutputStream(f.getAbsolutePath());
                                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                                    
                                   for(int i =0;i<usuarios.size;i++){
                                        UsuarioRegistrado Usalida=(UsuarioRegistrado) usuarios.value(i);
        
                                        outputStreamWriter.write(Usalida.getCorreo()+","+Usalida.getPassword()+","
                                        +Usalida.getInstitucion()+","+Usalida.getProfesion()+","+Usalida.getNombres()
                                        +","+Usalida.getApellidos()+","+Usalida.getId()+"\n");
                                        
                                    }
                                    outputStreamWriter.close();
                                } catch (Exception ex) {
                                    Logger.getLogger(Eco_lombia.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                    }

                               ciclo=false;
                                fin = System.currentTimeMillis();
                                JOptionPane.showMessageDialog(null,fin-inicio);
                               break;
                           default:
                               System.out.println("El valor ingresado no esta entre las opciones");
                       }

       }
    }else if(Vwork.equals("3")){
//------------------------------------------------------------------------------------------------------------------
    //Pueba Flora LinkedList
 

        Scanner input = new Scanner(System.in);
        String objeto;
        boolean menu = true;
        String opcion="";
        boolean ciclo=true;
        boolean exist=false;
        long start;
        long end;
        Node temp;
        int index;
        while(menu){
        System.out.println("Indique sobre que elemento quiere actuar\n"
                + "1.Flora\n"
                + "2.Fauna\n"
                + "3.Ecoparques\n"
                + "4.Salir");
        objeto=input.nextLine();
        ciclo=true;
        switch (objeto){
            case ("1"):
            LinkedList<Flora> flora = new LinkedList<>();
            Flora consulta_flora;
            while(ciclo){
                System.out.println("\tECO-LOMBIA\nEscoja la accion que desea realizar\n");
                System.out.println("1.Insertar un numero de datos\n"+
                        "2.Insertar un dato\n"+
                        "3.Buscar un dato\n"+
                        "4.Actualizar un dato\n"+
                        "5.Eliminar un dato\n"
                        + "6.Salir");
                try{
                    opcion= console.readLine();
                }catch(IOException ex){
                    ex.getMessage();
                }
                switch(opcion){
                    case "1":
                        start=System.currentTimeMillis();
                        try{
                            String separador =System.getProperty("file.separator");
                            File f = new File("data"+separador+"Flora_1millon.txt");
                            FileReader lectorArchivo=new FileReader(f);
                            BufferedReader br = new BufferedReader(lectorArchivo);
                            //String l="";
                            String aux="";
                            while(true){
                                aux=br.readLine();
                                if(aux==null)break;
                                String[] atributos=aux.split(";");
                                flora.add(new Flora(atributos[0]
                                         ,atributos[1],atributos[2],atributos[3],atributos[4],
                                          atributos[5],atributos[6],atributos[7],atributos[8],atributos[9]));                                             
                                } 
                            br.close();
                            lectorArchivo.close();
                        }
                        catch(Exception e){
                        System.out.println("error  "+e );
                        System.out.println(e.getMessage());
                        }end = System.currentTimeMillis();
                        System.out.println(end - start);
                        break;
                    case("2"):
                        String[] datos= new String[10];
                        System.out.println("Inserte los datos con el orden de:\n"
                                + "Nombre Cientifico, Nombre comun, Ubicacion, Ecosistema, Filo, Clase, Orden, Familia, Genero y Especie\n"
                                + "En caso de desconocer algun dato, escriba la palabra 'null'");
                        for (int i =0;i<datos.length;i++){
                            datos[i]=input.nextLine();
                        }
                        start=System.currentTimeMillis();
                        flora.add(new Flora(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],
                                            datos[6],datos[7],datos[8],datos[9]));
                        end=System.currentTimeMillis();
                        System.out.println(end-start);
                        break;
                    case("3"):
                        System.out.println("Indique el criterio de busqueda que desea utilizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n");
                        String busqueda=input.nextLine();
                        switch(busqueda){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a buscar");
                                String nombre_cientifico=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for(int i = 0;i<flora.size();i++){
                                    if(consulta_flora.getNombre_cientifico().equals(nombre_cientifico)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre comun a buscar");
                                String nombre_comun=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getNombre_comun().equals(nombre_comun)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a buscar");
                                String ubicacion=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getUbicacion().equals(ubicacion)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a buscar");
                                String ecosistema=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getEcosistema().equals(ecosistema)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a buscar");
                                String filo=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getFilo().equals(filo)){
                                        System.out.println(consulta_flora);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca la clase a buscar");
                                String clase=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getClase().equals(clase)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a buscar");
                                String orden=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getOrden().equals(orden)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a buscar");
                                String familia=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getFamilia().equals(familia)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a buscar");
                                String genero=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getGenero().equals(genero)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a buscar");
                                String especie=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getEspecie().equals(especie)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("4"):
                        System.out.println("Indique el criterio que desea actualizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n");
                        String actualizar=input.nextLine();
                        switch(actualizar){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a actualizar");
                                String nombre_cientifico=input.nextLine();
                                System.out.println("Introduzca el nombre cientifico nuevo");
                                String nuevo_nombre_cientifico=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getNombre_cientifico().equals(nombre_cientifico)){
                                        consulta_flora.setNombre_cientifico(nuevo_nombre_cientifico);
                                        System.out.println("El nombre cientifico de: "+nombre_cientifico+" fue actualizado a "+nuevo_nombre_cientifico);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre comun a actualizar");
                                String nombre_comun=input.nextLine();
                                System.out.println("Introduzca el nombre comun nuevo");
                                String nuevo_nombre_comun=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getNombre_comun().equals(nombre_comun)){
                                        consulta_flora.setNombre_comun(nuevo_nombre_comun);
                                        System.out.println("El nombre comun de: "+nombre_comun+" fue actualizado a "+nuevo_nombre_comun);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a actualizar");
                                String ubicacion=input.nextLine();
                                System.out.println("Introduzca la ubicacion nueva");
                                String nueva_ubicacion=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getUbicacion().equals(ubicacion)){
                                        consulta_flora.setUbicacion(nueva_ubicacion);
                                        System.out.println("La ubicacion de: "+ubicacion+" fue actualizada a "+nueva_ubicacion);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a actualizar");
                                String ecosistema=input.nextLine();
                                System.out.println("Introduzca el ecosistema nuevo");
                                String nuevo_ecosistema=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getEcosistema().equals(ecosistema)){
                                        consulta_flora.setEcosistema(nuevo_ecosistema);
                                        System.out.println("El ecosistema de: "+ecosistema+" fue actualizado a "+nuevo_ecosistema);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a actualizar");
                                String filo=input.nextLine();
                                System.out.println("Introduzca el filo nuevo");
                                String nuevo_filo=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getFilo().equals(filo)){
                                        consulta_flora.setFilo(nuevo_filo);
                                        System.out.println("El filo de: "+filo+" fue actualizado a "+nuevo_filo);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca la clase a actualizar");
                                String clase=input.nextLine();
                                System.out.println("Introduzca la clase nueva nuevo");
                                String nueva_clase=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getClase().equals(clase)){
                                        consulta_flora.setClase(nueva_clase);
                                        System.out.println("La clase de: "+clase+" fue actualizada a "+nueva_clase);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a actualizar");
                                String orden=input.nextLine();
                                System.out.println("Introduzca el orden nuevo");
                                String nuevo_orden=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getOrden().equals(orden)){
                                        consulta_flora.setOrden(nuevo_orden);
                                        System.out.println("El orden de: "+orden+" fue actualizado a "+nuevo_orden);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a actualizar");
                                String familia=input.nextLine();
                                System.out.println("Introduzca la familia nueva");
                                String nueva_familia=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getFamilia().equals(familia)){
                                        consulta_flora.setFamilia(nueva_familia);
                                        System.out.println("La familia de: "+familia+" fue actualizada a "+nueva_familia);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a actualizar");
                                String genero=input.nextLine();
                                System.out.println("Introduzca el genero nuevo");
                                String nuevo_genero=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getGenero().equals(genero)){
                                        consulta_flora.setGenero(nuevo_genero);
                                        System.out.println("El genero de: "+genero+" fue actualizado a "+nuevo_genero);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a actualizar");
                                String especie=input.nextLine();
                                System.out.println("Introduzca la especie nueva");
                                String nueva_especie=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getEspecie().equals(especie)){
                                        consulta_flora.setEspecie(nueva_especie);
                                        System.out.println("La especie de: "+especie+" fue actualizada a "+nueva_especie);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            }
                        break;                    
                    case("5"):
                        System.out.println("Indique el criterio de eliminación que desea utilizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n");
                        String eliminacion=input.nextLine();
                        switch(eliminacion){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a eliminar");
                                String nombre_cientifico=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getNombre_cientifico().equals(nombre_cientifico)){
                                        flora.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre comun a eliminar");
                                String nombre_comun=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getNombre_comun().equals(nombre_comun)){
                                        flora.delete(index);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a eliminar");
                                String ubicacion=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getUbicacion().equals(ubicacion)){
                                        flora.delete(index);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a eliminar");
                                String ecosistema=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getEcosistema().equals(ecosistema)){
                                        flora.delete(index);
                                        exist=true;
                                        System.out.println("La eliminacion se ha completado con exito");
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a eliminar");
                                String filo=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getFilo().equals(filo)){
                                        flora.delete(index);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca la clase a eliminar");
                                String clase=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getClase().equals(clase)){
                                        flora.delete(index);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a eliminar");
                                String orden=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getOrden().equals(orden)){
                                        flora.delete(index);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a eliminar");
                                String familia=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getFamilia().equals(familia)){
                                        flora.delete(index);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a eliminar");
                                String genero=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getGenero().equals(genero)){
                                        flora.delete(index);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a eliminar");
                                String especie=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getEspecie().equals(especie)){
                                        flora.delete(index);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("6"):
                       start=System.currentTimeMillis();
                       OutputStream       outputStream;
                       if(!flora.isEmpty()){
                           try{
                            Node salida=flora.getNodeAt(0);
                            Flora flora_salida=(Flora) salida.key;
                            String separador =System.getProperty("file.separator");
                            File f = new File("data"+separador+"salida_flora.txt");
                            outputStream= new FileOutputStream(f.getAbsolutePath());
                            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                            for (int i=0;i<flora.size();i++){
                                outputStreamWriter.write(flora_salida.getNombre_cientifico()+","+flora_salida.getNombre_comun()+","
                                    +flora_salida.getUbicacion()+","+flora_salida.getEcosistema()+","+flora_salida.getFilo()
                                    +","+flora_salida.getClase()+","+flora_salida.getOrden()+","+flora_salida.getFamilia()+","
                                        +flora_salida.getGenero()+","+flora_salida.getEspecie()+"\n");
                                        salida= salida.next;
                                    if(salida!=null){
                                    flora_salida= (Flora) salida.key;
                                    }                            }
                            outputStreamWriter.close();
                           }catch(Exception e){
                               System.out.println("Error"+e);
                            }
                       }
                       ciclo=false;
                       end=System.currentTimeMillis();
                        System.out.println(end-start);
                        break;
                    default:
                        System.out.println("El valor ingresado no corresponde a ninguna de las opciones");
                }
            }
            break;
            case ("3"):
            LinkedList<Ecoparque> ecoparque = new LinkedList<>();
            Ecoparque consulta_ecoparque;
            while(ciclo){
                System.out.println("\tECO-LOMBIA\nEscoja la accion que desea realizar en Ecoparques\n");
                System.out.println("1.Insertar un numero de datos\n"+
                        "2.Insertar un dato\n"+
                        "3.Buscar un dato\n"+
                        "4.Actualizar un dato\n"+
                        "5.Eliminar un dato\n"
                        + "6.Salir");
                try{
                    opcion= console.readLine();
                }catch(IOException ex){
                    ex.getMessage();
                }
                switch(opcion){
                    case "1":
                        start=System.currentTimeMillis();
                        try{
                            String separador =System.getProperty("file.separator");
                            File f = new File("data"+separador+"Ecoparques_500mil.txt");
                            FileReader lectorArchivo=new FileReader(f);
                            BufferedReader br = new BufferedReader(lectorArchivo);
                            //String l="";
                            String aux="";
                            while(true){
                                aux=br.readLine();
                                if(aux==null)break;
                                String[] atributos=aux.split(";");
                                ecoparque.add(new Ecoparque(atributos[0]
                                         ,atributos[1],atributos[2],atributos[3]));                                             
                                } 
                            br.close();
                            lectorArchivo.close();
                        }
                        catch(Exception e){
                        System.out.println("error  "+e );
                        System.out.println(e.getMessage());
                        }end = System.currentTimeMillis();
                        System.out.println(end - start);
                        break;
                    case("2"):
                        String[] datos= new String[4];
                        System.out.println("Inserte los datos con el orden de:\n"
                                + "Nombre, Ubicaion, Ecosistema, Interes\n"
                                + "En caso de desconocer algun dato, escriba la palabra 'null'");
                        for (int i =0;i<datos.length;i++){
                            datos[i]=input.nextLine();
                        }
                        start=System.currentTimeMillis();
                        ecoparque.add(new Ecoparque(datos[0],datos[1],datos[2],datos[3]));
                        end=System.currentTimeMillis();
                        System.out.println(end-start);
                        break;
                    case("3"):
                        System.out.println("Indique el criterio de busqueda que desa utilizar\n"
                                + "1.Nombre\n"
                                + "2.Ubicacion\n"
                                + "3.Ecosistema\n"
                                + "4.Interes\n");
                        String busqueda=input.nextLine();
                        switch(busqueda){
                            case("1"):
                                System.out.println("Introduzca el nombre a buscar");
                                String nombre=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                for(int i = 0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getNombre().equals(nombre)){
                                        System.out.println(consulta_ecoparque.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca la ubicacion a buscar");
                                String ubicacion=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getUbicacion().equals(ubicacion)){
                                        System.out.println(consulta_ecoparque.toString());
                                        exist=true;
                                        
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca el ecosistema actualizar");
                                String ecosistema=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getUbicacion().equals(ecosistema)){
                                        System.out.println(consulta_ecoparque.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el interes a buscar");
                                String interes=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getInteres().equals(interes)){
                                        System.out.println(consulta_ecoparque.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("4"):
                        System.out.println("Indique el criterio de busqueda que desea utilizar\n"
                                + "1.Nombre\n"
                                + "2.Ubicacion\n"
                                + "3.Ecosistema\n"
                                + "4.Interes\n");
                        String actualizar=input.nextLine();
                        switch(actualizar){
                            case("1"):
                                System.out.println("Introduzca el nombre a actualizar");
                                String nombre=input.nextLine();
                                System.out.println("Introduzca el nombre nuevo");
                                String nuevo_nombre=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getNombre().equals(nombre)){
                                        consulta_ecoparque.setNombre(nuevo_nombre);
                                        System.out.println("El nombre de: "+nombre+" fue actualizado a "+nuevo_nombre);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca la ubicacion a actualizar");
                                String ubicacion=input.nextLine();
                                System.out.println("Introduzca la ubicacion nueva");
                                String nueva_ubicacion=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getUbicacion().equals(ubicacion)){
                                        consulta_ecoparque.setUbicacion(nueva_ubicacion);
                                        System.out.println("La ubicacion de: "+ubicacion+" fue actualizada a "+nueva_ubicacion);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca el ecosistema a actualizar");
                                String ecosistema=input.nextLine();
                                System.out.println("Introduzca el ecosistema nuevo");
                                String nuevo_ecosistema=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getUbicacion().equals(ecosistema)){
                                        consulta_ecoparque.setUbicacion(nuevo_ecosistema);
                                        System.out.println("El ecosistema de: "+ecosistema+" fue actualizado a "+nuevo_ecosistema);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el interes a actualizar");
                                String interes=input.nextLine();
                                System.out.println("Introduzca el interes nuevo");
                                String nuevo_interes=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getInteres().equals(interes)){
                                        consulta_ecoparque.setInteres(nuevo_interes);
                                        System.out.println("El interes de: "+interes+" fue actualizado a "+nuevo_interes);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            }
                        break;                    
                    case("5"):
                        System.out.println("Indique el criterio de busqueda que desea utilizar\n"
                                + "1.Nombre\n"
                                + "2.Ubicacion\n"
                                + "3.Ecosistema\n"
                                + "4.Interes\n");
                        String eliminacion=input.nextLine();
                        switch(eliminacion){
                            case("1"):
                                System.out.println("Introduzca el nombre a eliminar");
                                String nombre=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getNombre().equals(nombre)){
                                        ecoparque.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca la ubicacion a eliminar");
                                String ubicacion=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getUbicacion().equals(ubicacion)){
                                        ecoparque.delete(index);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ecosistema a eliminar");
                                String ecosistema=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getEcosistema().equals(ecosistema)){
                                        ecoparque.delete(index);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el interes a eliminar");
                                String interes=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getInteres().equals(interes)){
                                        ecoparque.delete(index);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("6"):
                       start=System.currentTimeMillis();
                       OutputStream       outputStream;
                       if(!ecoparque.isEmpty()){
                           try{
                            Node salida=ecoparque.getNodeAt(0);
                            Ecoparque ecoparque_salida=(Ecoparque) salida.key;
                            String separador =System.getProperty("file.separator");
                            File f = new File("data"+separador+"salida_ecoparque.txt");
                            outputStream= new FileOutputStream(f.getAbsolutePath());
                            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                            for (int i=0;i<ecoparque.size();i++){
                                outputStreamWriter.write(ecoparque_salida.getNombre()+","+ecoparque_salida.getUbicacion()+","
                                    +ecoparque_salida.getEcosistema()+","+ecoparque_salida.getInteres()+"\n");
                                        salida= salida.next;
                                    if(salida!=null){
                                    ecoparque_salida= (Ecoparque) salida.key;
                                    }                            }
                            outputStreamWriter.close();
                           }catch(Exception e){
                               System.out.println("Error"+e);
                            }
                       }
                       ciclo=false;
                       end=System.currentTimeMillis();
                        System.out.println(end-start);
                        break;
                    default:
                        System.out.println("El valor ingresado no corresponde a ninguna de las opciones");
                }
                
            }
            break;
            case("2"):
            LinkedList<Fauna> fauna = new LinkedList<>();
            Fauna consulta_fauna;
            while(ciclo){
                System.out.println("\tECO-LOMBIA\nEscoja la accion que desea realizar\n");
                System.out.println("1.Insertar un numero de datos\n"+
                        "2.Insertar un dato\n"+
                        "3.Buscar un dato\n"+
                        "4.Actualizar un dato\n"+
                        "5.Eliminar un dato\n"
                        + "6.Salir");
                try{
                    opcion= console.readLine();
                }catch(IOException ex){
                    ex.getMessage();
                }
                switch(opcion){
                    case "1":
                        start=System.currentTimeMillis();
                        try{
                            String separador =System.getProperty("file.separator");
                            File f = new File("data"+separador+"Flora_10mil.txt");
                            FileReader lectorArchivo=new FileReader(f);
                            BufferedReader br = new BufferedReader(lectorArchivo);
                            //String l="";
                            String aux="";
                            while(true){
                                aux=br.readLine();
                                if(aux==null)break;
                                String[] atributos=aux.split(";");
                                fauna.add(new Fauna(atributos[0]
                                         ,atributos[1],atributos[2],atributos[3],atributos[4],
                                          atributos[5],atributos[6],atributos[7],atributos[8],atributos[9],
                                            atributos[10],atributos[11]));                                             
                                } 
                            br.close();
                            lectorArchivo.close();
                        }
                        catch(Exception e){
                        System.out.println("error  "+e );
                        System.out.println(e.getMessage());
                        }end = System.currentTimeMillis();
                        System.out.println(end - start);
                        break;
                    case("2"):
                        String[] datos= new String[12];
                        System.out.println("Inserte los datos con el orden de:\n"
                                + "Nombre Cientifico, Nombre comun, Ubicacion, Ecosistema, Filo, Clase\n"
                                + ", Orden, Familia, Genero Alimentacion Depredador y Especie\n"
                                + "Si desconocer algun dato, escriba la palabra 'null'");
                        for (int i =0;i<datos.length;i++){
                            datos[i]=input.nextLine();
                        }
                        start=System.currentTimeMillis();
                        fauna.add(new Fauna(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],
                                            datos[6],datos[7],datos[8],datos[9],datos[10],datos[11]));
                        end=System.currentTimeMillis();
                        System.out.println(end-start);
                        break;
                    case("3"):
                        System.out.println("Indique el criterio de busqueda que desea utilizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n"
                                + "11.Alimentacion\n"
                                + "12.Depredador");
                        String busqueda=input.nextLine();
                        switch(busqueda){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a buscar");
                                String nombre_cientifico=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for(int i = 0;i<fauna.size();i++){
                                    if(consulta_fauna.getNombre_cientifico().equals(nombre_cientifico)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre comun a buscar");
                                String nombre_comun=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getNombre_comun().equals(nombre_comun)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a buscar");
                                String ubicacion=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getUbicacion().equals(ubicacion)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a buscar");
                                String ecosistema=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getEcosistema().equals(ecosistema)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a buscar");
                                String filo=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getFilo().equals(filo)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca el clase a buscar");
                                String clase=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getClase().equals(clase)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    consulta_fauna= (Fauna) temp.key;
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a buscar");
                                String orden=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getOrden().equals(orden)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a buscar");
                                String familia=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getFamilia().equals(familia)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a buscar");
                                String genero=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getGenero().equals(genero)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a buscar");
                                String especie=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getEspecie().equals(especie)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("11"):
                                System.out.println("Introduzca la alimentacion a buscar");
                                String alimentacion=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getAlimentacion().equals(alimentacion)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("12"):
                                System.out.println("Introduzca el depredador a buscar");
                                String depredador=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getDepredador().equals(depredador)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("4"):
                        System.out.println("Indique el criterio que desea actualizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n"
                                + "11.Alimentacion\n"
                                + "12.Depredador");
                        String actualizar=input.nextLine();
                        switch(actualizar){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a actualizar");
                                String nombre_cientifico=input.nextLine();
                                System.out.println("Introduzca el nombre cientifico nuevo");
                                String nuevo_nombre_cientifico=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getNombre_cientifico().equals(nombre_cientifico)){
                                        consulta_fauna.setNombre_cientifico(nuevo_nombre_cientifico);
                                        System.out.println("El nombre cientifico de: "+nombre_cientifico+" fue actualizado a "+nuevo_nombre_cientifico);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre a actualizar");
                                String nombre=input.nextLine();
                                System.out.println("Introduzca el nombre nuevo");
                                String nuevo_nombre=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getNombre_comun().equals(nombre)){
                                        consulta_fauna.setNombre_comun(nuevo_nombre);
                                        System.out.println("El nombre de: "+nombre+" fue actualizado a "+nuevo_nombre);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a actualizar");
                                String ubicacion=input.nextLine();
                                System.out.println("Introduzca la ubicacion nueva");
                                String nueva_ubicacion=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getUbicacion().equals(ubicacion)){
                                        consulta_fauna.setUbicacion(nueva_ubicacion);
                                        System.out.println("La ubicacion de: "+ubicacion+" fue actualizada a "+nueva_ubicacion);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }consulta_fauna= (Fauna) temp.key;
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a actualizar");
                                String ecosistema=input.nextLine();
                                System.out.println("Introduzca el ecosistema nuevo");
                                String nuevo_ecosistema=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getEcosistema().equals(ecosistema)){
                                        consulta_fauna.setEcosistema(nuevo_ecosistema);
                                        System.out.println("El ecosistema de: "+ecosistema+" fue actualizado a "+nuevo_ecosistema);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a actualizar");
                                String filo=input.nextLine();
                                System.out.println("Introduzca el filo nuevo");
                                String nuevo_filo=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getFilo().equals(filo)){
                                        consulta_fauna.setFilo(nuevo_filo);
                                        System.out.println("El filo de: "+filo+" fue actualizado a "+nuevo_filo);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca la clase a actualizar");
                                String clase=input.nextLine();
                                System.out.println("Introduzca la clase nueva");
                                String nueva_clase=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getClase().equals(clase)){
                                        consulta_fauna.setClase(nueva_clase);
                                        System.out.println("La clase de: "+clase+" fue actualizada a "+nueva_clase);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a actualizar");
                                String orden=input.nextLine();
                                System.out.println("Introduzca el orden nuevo");
                                String nuevo_orden=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getOrden().equals(orden)){
                                        consulta_fauna.setOrden(nuevo_orden);
                                        System.out.println("El orden de: "+orden+" fue actualizado a "+nuevo_orden);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a actualizar");
                                String familia=input.nextLine();
                                System.out.println("Introduzca la familia nueva");
                                String nueva_familia=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getFamilia().equals(familia)){
                                        consulta_fauna.setFamilia(nueva_familia);
                                        System.out.println("La familia de: "+familia+" fue actualizada a "+nueva_familia);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a actualizar");
                                String genero=input.nextLine();
                                System.out.println("Introduzca el genero nuevo");
                                String nuevo_genero=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getGenero().equals(genero)){
                                        consulta_fauna.setGenero(nuevo_genero);
                                        System.out.println("El genero de: "+genero+" fue actualizado a "+nuevo_genero);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a actualizar");
                                String especie=input.nextLine();
                                System.out.println("Introduzca la especie nueva");
                                String nueva_especie=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getEspecie().equals(especie)){
                                        consulta_fauna.setEspecie(nueva_especie);
                                        System.out.println("La especie de: "+especie+" fue actualizada a "+nueva_especie);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("11"):
                                System.out.println("Introduzca la alimentacion a actualizar");
                                String alimentacion=input.nextLine();
                                System.out.println("Introduzca la alimentacion nueva");
                                String nueva_alimentacion=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getAlimentacion().equals(alimentacion)){
                                        consulta_fauna.setAlimentacion(nueva_alimentacion);
                                        System.out.println("La alimentacion de: "+alimentacion+" fue actualizada a "+nueva_alimentacion);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                             case("12"):
                                System.out.println("Introduzca el depredador a actualizar");
                                String depredador=input.nextLine();
                                System.out.println("Introduzca el depredador nuevo");
                                String nuevo_depredador=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getDepredador().equals(depredador)){
                                        consulta_fauna.setDepredador(nuevo_depredador);
                                        System.out.println("El depredador de: "+depredador+" fue actualizado a "+nuevo_depredador);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            }
                        break;                    
                    case("5"):
                        System.out.println("Indique el criterio de eliminación que desea utilizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n");
                        String eliminacion=input.nextLine();
                        switch(eliminacion){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a eliminar");
                                String nombre_cientifico=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getNombre_cientifico().equals(nombre_cientifico)){
                                        fauna.delete(index);
                                         System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                               if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre a eliminar");
                                String nombre=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getNombre_comun().equals(nombre)){
                                        fauna.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a eliminar");
                                String ubicacion=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getUbicacion().equals(ubicacion)){
                                        fauna.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a eliminar");
                                String ecosistema=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getEcosistema().equals(ecosistema)){
                                        fauna.delete(index);
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                System.out.println("La eliminación se ha completado con exito");
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a eliminar");
                                String filo=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getFilo().equals(filo)){
                                        fauna.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca la clase a eliminar");
                                String clase=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getNombre_cientifico().equals(clase)){
                                        fauna.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a eliminar");
                                String orden=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getOrden().equals(orden)){
                                        fauna.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a eliminar");
                                String familia=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getFamilia().equals(familia)){
                                        fauna.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a eliminar");
                                String genero=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getGenero().equals(genero)){
                                        fauna.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a eliminar");
                                String especie=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getEspecie().equals(especie)){
                                        fauna.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("11"):
                                System.out.println("Introduzca la alimentacion a eliminar");
                                String alimentacion=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getAlimentacion().equals(alimentacion)){
                                        fauna.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("12"):
                                System.out.println("Introduzca el depredador a eliminar");
                                String depredador=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getDepredador().equals(depredador)){
                                        fauna.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("6"):
                       start=System.currentTimeMillis();
                       OutputStream       outputStream;
                       if(!fauna.isEmpty()){
                           try{
                            Node salida=fauna.getNodeAt(0);
                            Fauna fauna_salida=(Fauna) salida.key;
                            String separador =System.getProperty("file.separator");
                            File f = new File("data"+separador+"salida_fauna.txt");
                            outputStream= new FileOutputStream(f.getAbsolutePath());
                            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                            for (int i=0;i<fauna.size();i++){
                                outputStreamWriter.write(fauna_salida.getNombre_cientifico()+","+fauna_salida.getNombre_comun()+","
                                    +fauna_salida.getUbicacion()+","+fauna_salida.getEcosistema()+","+fauna_salida.getFilo()
                                    +","+fauna_salida.getClase()+","+fauna_salida.getOrden()+","+fauna_salida.getFamilia()+","
                                        +fauna_salida.getGenero()+","+fauna_salida.getAlimentacion()+","+fauna_salida.getDepredador()+","
                                        +fauna_salida.getEspecie()+"\n");
                                        salida= salida.next;
                                        if(salida!=null){
                                        fauna_salida= (Fauna) salida.key;
                                    }
                            }
                            outputStreamWriter.close();
                           }catch(Exception e){
                               System.out.println("Error"+e);
                            }
                       }
                       ciclo=false;
                       end=System.currentTimeMillis();
                        System.out.println(end-start);
                        break;
                    default:
                        System.out.println("El valor ingresado no corresponde a ninguna de las opciones");
                }
            }
            break;
            case ("4"):
                menu= false;
                break;
        }
        }
        //*/
       
 /////////////////////////////////////////////////////////////////////////////////////////////////////////    
       }else if(Vwork.equals("4")){ 
          
/******************************************---Implementacion con DynamicArray---********************************************/
///*

        Scanner input = new Scanner(System.in);
        String objeto;
        boolean menu = true;
        String opcion="";
        boolean ciclo=true;
        long start;
        long end;
        boolean exist = false;
        while(menu){
        System.out.println("Indique sobre que elemento quiere actuar\n"
                + "1.Flora\n"
                + "2.Fauna\n"
                + "3.Ecoparques\n"
                + "4.Salir");
        ciclo=true;
        objeto=input.nextLine();
        switch (objeto){
            case ("1"):
            DynamicArray<Flora> flora = new DynamicArray<>(10);
            Flora consulta_flora;
            while(ciclo){
                System.out.println("\tECO-LOMBIA\nEscoja la accion que desea realizar en Flora\n");
                System.out.println("1.Insertar un numero de datos\n"+
                        "2.Insertar un dato\n"+
                        "3.Buscar un dato\n"+
                        "4.Actualizar un dato\n"+
                        "5.Eliminar un dato\n"
                        + "6.Salir");
                try{
                    opcion= console.readLine();
                }catch(IOException ex){
                    ex.getMessage();
                }
                switch(opcion){
                    case "1":
                        start=System.currentTimeMillis();
                        try{
                            String separador =System.getProperty("file.separator");
                            File f = new File("data"+separador+"Flora_10mil.txt");
                            FileReader lectorArchivo=new FileReader(f);
                            BufferedReader br = new BufferedReader(lectorArchivo);
                            //String l="";
                            String aux="";
                            while(true){
                                aux=br.readLine();
                                if(aux==null)break;
                                String[] atributos=aux.split(";");
                                flora.push(new Flora(atributos[0]
                                         ,atributos[1],atributos[2],atributos[3],atributos[4],
                                          atributos[5],atributos[6],atributos[7],atributos[8],atributos[9]));                                             
                                } 
                            br.close();
                            lectorArchivo.close();
                        }
                        catch(Exception e){
                        System.out.println("error  "+e );
                        System.out.println(e.getMessage());
                        }end = System.currentTimeMillis();
                        System.out.println(end - start);
                        break;
                    case("2"):
                        String[] datos= new String[10];
                        System.out.println("Inserte los datos con el orden de:\n"
                                + "Nombre Cientifico, Nombre comun, Ubicacion, Ecosistema, Filo, Clase, Orden, Familia, Genero y Especie\n"
                                + "En caso de no conocer algun dato, escriba la palabra 'null'");
                        for (int i =0;i<datos.length;i++){
                            datos[i]=input.nextLine();
                        }
                        start=System.currentTimeMillis();
                        flora.push(new Flora(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],
                                            datos[6],datos[7],datos[8],datos[9]));
                        end=System.currentTimeMillis();
                        System.out.println(end-start);
                        break;
                    case("3"):
                        System.out.println("Indique el criterio de busqueda que desea utilizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n");
                        String busqueda=input.nextLine();
                        switch(busqueda){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a buscar");
                                String nombre_cientifico=input.nextLine();
                                start=System.currentTimeMillis();
                                for(int i = 0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getNombre_cientifico().equals(nombre_cientifico)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre comun a buscar");
                                String nombre_comun=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getNombre_comun().equals(nombre_comun)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a buscar");
                                String ubicacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getUbicacion().equals(ubicacion)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a buscar");
                                String ecosistema=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getEcosistema().equals(ecosistema)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a buscar");
                                String filo=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getFilo().equals(filo)){
                                        System.out.println(consulta_flora);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca la clase a buscar");
                                String clase=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getClase().equals(clase)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a buscar");
                                String orden=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getOrden().equals(orden)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a buscar");
                                String familia=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getFamilia().equals(familia)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a buscar");
                                String genero=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getGenero().equals(genero)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a buscar");
                                String especie=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getEspecie().equals(especie)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("4"):
                        System.out.println("Indique el criterio que desea actualizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n");
                        String actualizar=input.nextLine();
                        switch(actualizar){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a actualizar");
                                String nombre_cientifico=input.nextLine();
                                System.out.println("Introduzca el nombre cientifico nuevo");
                                String nuevo_nombre_cientifico=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getNombre_cientifico().equals(nombre_cientifico)){
                                        consulta_flora.setNombre_cientifico(nuevo_nombre_cientifico);
                                        System.out.println("El nombre cientifico de: "+nombre_cientifico+" fue actualizado a "+nuevo_nombre_cientifico);
                                        exist=true;        
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre comun a actualizar");
                                String nombre_comun=input.nextLine();
                                System.out.println("Introduzca el nombre comun nuevo");
                                String nuevo_nombre_comun=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getNombre_comun().equals(nombre_comun)){
                                        consulta_flora.setNombre_comun(nuevo_nombre_comun);
                                        System.out.println("El nombre comun de: "+nombre_comun+" fue actualizado a "+nuevo_nombre_comun);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a actualizar");
                                String ubicacion=input.nextLine();
                                System.out.println("Introduzca la ubicacion nueva");
                                String nueva_ubicacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getUbicacion().equals(ubicacion)){
                                        consulta_flora.setUbicacion(nueva_ubicacion);
                                        System.out.println("La ubicacion de: "+ubicacion+" fue actualizada a "+nueva_ubicacion);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a actualizar");
                                String ecosistema=input.nextLine();
                                System.out.println("Introduzca el ecosistema nuevo");
                                String nuevo_ecosistema=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getEcosistema().equals(ecosistema)){
                                        consulta_flora.setEcosistema(nuevo_ecosistema);
                                        System.out.println("El ecosistema de: "+ecosistema+" fue actualizado a "+nuevo_ecosistema);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a actualizar");
                                String filo=input.nextLine();
                                System.out.println("Introduzca el filo nuevo");
                                String nuevo_filo=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getFilo().equals(filo)){
                                        consulta_flora.setFilo(nuevo_filo);
                                        System.out.println("El filo de: "+filo+" fue actualizado a "+nuevo_filo);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca la clase a actualizar");
                                String clase=input.nextLine();
                                System.out.println("Introduzca la clase nueva nuevo");
                                String nueva_clase=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getClase().equals(clase)){
                                        consulta_flora.setClase(nueva_clase);
                                        System.out.println("La clase de: "+clase+" fue actualizada a "+nueva_clase);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a actualizar");
                                String orden=input.nextLine();
                                System.out.println("Introduzca el orden nuevo");
                                String nuevo_orden=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getOrden().equals(orden)){
                                        consulta_flora.setOrden(nuevo_orden);
                                        System.out.println("El orden de: "+orden+" fue actualizado a "+nuevo_orden);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a actualizar");
                                String familia=input.nextLine();
                                System.out.println("Introduzca la familia nueva");
                                String nueva_familia=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getFamilia().equals(familia)){
                                        consulta_flora.setFamilia(nueva_familia);
                                        System.out.println("La familia de: "+familia+" fue actualizada a "+nueva_familia);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a actualizar");
                                String genero=input.nextLine();
                                System.out.println("Introduzca el genero nuevo");
                                String nuevo_genero=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getGenero().equals(genero)){
                                        consulta_flora.setGenero(nuevo_genero);
                                        System.out.println("El genero de: "+genero+" fue actualizado a "+nuevo_genero);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a actualizar");
                                String especie=input.nextLine();
                                System.out.println("Introduzca la especie nueva");
                                String nueva_especie=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getEspecie().equals(especie)){
                                        consulta_flora.setEspecie(nueva_especie);
                                        System.out.println("La especie de: "+especie+" fue actualizada a "+nueva_especie);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            }
                        break;                    
                    case("5"):
                        System.out.println("Indique el criterio de eliminación que desea utilizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n");
                        String eliminacion=input.nextLine();
                        switch(eliminacion){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a eliminar");
                                String nombre_cientifico=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getNombre_cientifico().equals(nombre_cientifico)){
                                        flora.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre comun a eliminar");
                                String nombre_comun=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getNombre_comun().equals(nombre_comun)){
                                        flora.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a eliminar");
                                String ubicacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getUbicacion().equals(ubicacion)){
                                        flora.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a eliminar");
                                String ecosistema=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getEcosistema().equals(ecosistema)){
                                        flora.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a eliminar");
                                String filo=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getFilo().equals(filo)){
                                        flora.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca la clase a eliminar");
                                String clase=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getClase().equals(clase)){
                                        flora.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a eliminar");
                                String orden=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getOrden().equals(orden)){
                                        flora.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a eliminar");
                                String familia=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getFamilia().equals(familia)){
                                        flora.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a eliminar");
                                String genero=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getGenero().equals(genero)){
                                        flora.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a eliminar");
                                String especie=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getEspecie().equals(especie)){
                                        flora.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("6"):
                       start=System.currentTimeMillis();
                       OutputStream       outputStream;
                       if(!flora.isEmpty()){
                           try{
                            String separador =System.getProperty("file.separator");
                            File f = new File("data"+separador+"salida_flora.txt");
                            outputStream= new FileOutputStream(f.getAbsolutePath());
                            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                            for (int i=0;i<flora.size();i++){
                                Flora flora_salida=(Flora) flora.value(i);
                                
                                outputStreamWriter.write(flora_salida.getNombre_cientifico()+","+flora_salida.getNombre_comun()+","
                                    +flora_salida.getUbicacion()+","+flora_salida.getEcosistema()+","+flora_salida.getFilo()
                                    +","+flora_salida.getClase()+","+flora_salida.getOrden()+","+flora_salida.getFamilia()+","
                                        +flora_salida.getGenero()+","+flora_salida.getEspecie()+"\n");
                                  }
                            outputStreamWriter.close();
                           }catch(Exception e){
                               System.out.println("Error"+e);
                            }
                       }
                       ciclo=false;
                       end=System.currentTimeMillis();
                        System.out.println(end-start);
                        break;
                    default:
                        System.out.println("El valor ingresado no corresponde a ninguna de las opciones");
                }
            }
            break;
            case ("3"):
            DynamicArray<Ecoparque> ecoparque = new DynamicArray<>(10);
            Ecoparque consulta_ecoparque;
            while(ciclo){
                System.out.println("\tECO-LOMBIA\nEscoja la accion que desea realizar en Ecoparques\n");
                System.out.println("1.Insertar un numero de datos\n"+
                        "2.Insertar un dato\n"+
                        "3.Buscar un dato\n"+
                        "4.Actualizar un dato\n"+
                        "5.Eliminar un dato\n"
                        + "6.Salir");
                try{
                    opcion= console.readLine();
                }catch(IOException ex){
                    ex.getMessage();
                }
                switch(opcion){
                    case "1":
                        start=System.currentTimeMillis();
                        try{
                            String separador =System.getProperty("file.separator");
                            File f = new File("data"+separador+"Ecoparques_1millon.txt");
                            FileReader lectorArchivo=new FileReader(f);
                            BufferedReader br = new BufferedReader(lectorArchivo);
                            //String l="";
                            String aux="";
                            while(true){
                                aux=br.readLine();
                                if(aux==null)break;
                                String[] atributos=aux.split(";");
                                ecoparque.push(new Ecoparque(atributos[0]
                                         ,atributos[1],atributos[2],atributos[3]));                                             
                                } 
                            br.close();
                            lectorArchivo.close();
                        }
                        catch(Exception e){
                        System.out.println("error  "+e );
                        System.out.println(e.getMessage());
                        }end = System.currentTimeMillis();
                        System.out.println(end - start);
                        break;
                    case("2"):
                        String[] datos= new String[4];
                        System.out.println("Inserte los datos con el orden de:\n"
                                + "Nombre, Ubicacion, Ecosistema, Interes\n"
                                + "En caso de no conocer algun dato, escriba la palabra 'null'");
                        for (int i =0;i<datos.length;i++){
                            datos[i]=input.nextLine();
                        }
                        start=System.currentTimeMillis();
                        ecoparque.push(new Ecoparque(datos[0],datos[1],datos[2],datos[3]));
                        end=System.currentTimeMillis();
                        System.out.println(end-start);
                        break;
                    case("3"):
                        System.out.println("Indique el criterio de busqueda que desea utilizar\n"
                                + "1.Nombre\n"
                                + "2.Ubicacion\n"
                                + "3.Ecosistema\n"
                                + "4.Interes\n");
                        String busqueda=input.nextLine();
                        switch(busqueda){
                            case("1"):
                                System.out.println("Introduzca el nombre a buscar");
                                String nombre=input.nextLine();
                                start=System.currentTimeMillis();
                                for(int i = 0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getNombre().equals(nombre)){
                                        System.out.println(consulta_ecoparque.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca la ubicacion a buscar");
                                String ubicacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getUbicacion().equals(ubicacion)){
                                        System.out.println(consulta_ecoparque.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca el ecosistema actualizar");
                                String ecosistema=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getUbicacion().equals(ecosistema)){
                                        System.out.println(consulta_ecoparque.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el interes a buscar");
                                String interes=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getInteres().equals(interes)){
                                        System.out.println(consulta_ecoparque.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("4"):
                        System.out.println("Indique el criterio de busqueda que desea utilizar\n"
                                + "1.Nombre\n"
                                + "2.Ubicacion\n"
                                + "3.Ecosistema\n"
                                + "4.Interes\n");
                        String actualizar=input.nextLine();
                        switch(actualizar){
                            case("1"):
                                System.out.println("Introduzca el nombre a actualizar");
                                String nombre=input.nextLine();
                                System.out.println("Introduzca el nombre nuevo");
                                String nuevo_nombre=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getNombre().equals(nombre)){
                                        consulta_ecoparque.setNombre(nuevo_nombre);
                                        System.out.println("El nombre de: "+nombre+" fue actualizado a "+nuevo_nombre);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca la ubicacion a actualizar");
                                String ubicacion=input.nextLine();
                                System.out.println("Introduzca la ubicacion nueva");
                                String nueva_ubicacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getUbicacion().equals(ubicacion)){
                                        consulta_ecoparque.setUbicacion(nueva_ubicacion);
                                        System.out.println("La ubicacion de: "+ubicacion+" fue actualizada a "+nueva_ubicacion);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca el ecosistema a actualizar");
                                String ecosistema=input.nextLine();
                                System.out.println("Introduzca el ecosistema nuevo");
                                String nuevo_ecosistema=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getUbicacion().equals(ecosistema)){
                                        consulta_ecoparque.setUbicacion(nuevo_ecosistema);
                                        System.out.println("El ecosistema de: "+ecosistema+" fue actualizado a "+nuevo_ecosistema);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el interes a actualizar");
                                String interes=input.nextLine();
                                System.out.println("Introduzca el interes nuevo");
                                String nuevo_interes=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getInteres().equals(interes)){
                                        consulta_ecoparque.setInteres(nuevo_interes);
                                        System.out.println("El interes de: "+interes+" fue actualizado a "+nuevo_interes);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            }
                        break;                    
                    case("5"):
                        System.out.println("Indique el criterio de eliminacion que desea utilizar\n"
                                + "1.Nombre\n"
                                + "2.Ubicacion\n"
                                + "3.Ecosistema\n"
                                + "4.Interes\n");
                        String eliminacion=input.nextLine();
                        switch(eliminacion){
                            case("1"):
                                System.out.println("Introduzca el nombre a eliminar");
                                String nombre=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getNombre().equals(nombre)){
                                        ecoparque.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca la ubicacion a eliminar");
                                String ubicacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getUbicacion().equals(ubicacion)){
                                        ecoparque.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ecosistema a eliminar");
                                String ecosistema=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getEcosistema().equals(ecosistema)){
                                        ecoparque.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el interes a eliminar");
                                String interes=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getInteres().equals(interes)){
                                        ecoparque.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("6"):
                       start=System.currentTimeMillis();
                       OutputStream       outputStream;
                       if(!ecoparque.isEmpty()){
                           try{
                            String separador =System.getProperty("file.separator");
                            File f = new File("data"+separador+"salida_ecoparque.txt");
                            outputStream= new FileOutputStream(f.getAbsolutePath());
                            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                            for (int i=0;i<ecoparque.size();i++){
                                Ecoparque ecoparque_salida=(Ecoparque) ecoparque.value(i);
                                outputStreamWriter.write(ecoparque_salida.getNombre()+","+ecoparque_salida.getUbicacion()+","
                                    +ecoparque_salida.getEcosistema()+","+ecoparque_salida.getInteres()+"\n");
                               }
                            outputStreamWriter.close();
                           }catch(Exception e){
                               System.out.println("Error"+e);
                            }
                       }
                       ciclo=false;
                       end=System.currentTimeMillis();
                        System.out.println(end-start);
                        break;
                    default:
                        System.out.println("El valor ingresado no corresponde a ninguna de las opciones");
                }
                
            }
            break;
            case("2"):
            DynamicArray<Fauna> fauna = new DynamicArray<>(10);
            Fauna consulta_fauna;
            while(ciclo){
                System.out.println("\tECO-LOMBIA\nEscoja la accion que desea realizar en Fauna\n");
                System.out.println("1.Insertar un numero de datos\n"+
                        "2.Insertar un dato\n"+
                        "3.Buscar un dato\n"+
                        "4.Actualizar un dato\n"+
                        "5.Eliminar un dato\n"
                        + "6.Salir");
                try{
                    opcion= console.readLine();
                }catch(IOException ex){
                    ex.getMessage();
                }
                switch(opcion){
                    case "1":
                        start=System.currentTimeMillis();
                        try{
                            String separador =System.getProperty("file.separator");
                            File f = new File("data"+separador+"Fauna_10mil.txt");
                            FileReader lectorArchivo=new FileReader(f);
                            BufferedReader br = new BufferedReader(lectorArchivo);
                            //String l="";
                            String aux="";
                            while(true){
                                aux=br.readLine();
                                if(aux==null)break;
                                String []atributos=aux.split(";");
                                fauna.push(new Fauna(atributos[0]
                                         ,atributos[1],atributos[2],atributos[3],atributos[4],
                                          atributos[5],atributos[6],atributos[7],atributos[8],atributos[9],
                                            atributos[10],atributos[11]));                                             
                                } 
                            br.close();
                            lectorArchivo.close();
                        }
                        catch(Exception e){
                        System.out.println("error  "+e );
                        System.out.println(e.getMessage());
                        }end = System.currentTimeMillis();
                        System.out.println(end - start);
                        break;
                    case("2"):
                        String[] datos= new String[12];
                        System.out.println("Inserte los datos con el orden de:\n"
                                + "Nombre Cientifico, Nombre comun, Ubicacion, Ecosistema, Filo, Clase\n"
                                + ", Orden, Familia, Genero, Alimentacion, Depredador y Especie\n"
                                + "En caso de conocer no algun dato, escriba la palabra 'null'");
                        for (int i =0;i<datos.length;i++){
                            datos[i]=input.nextLine();
                        }
                        start=System.currentTimeMillis();
                        fauna.push(new Fauna(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],
                                            datos[6],datos[7],datos[8],datos[9],datos[10],datos[11]));
                        end=System.currentTimeMillis();
                        System.out.println(end-start);
                        break;
                    case("3"):
                        System.out.println("Indique el criterio de busqueda que desea utilizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n"
                                + "11.Alimentacion\n"
                                + "12.Depredador");
                        String busqueda=input.nextLine();
                        switch(busqueda){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a buscar");
                                String nombre_cientifico=input.nextLine();
                                start=System.currentTimeMillis();
                                for(int i = 0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getNombre_cientifico().equals(nombre_cientifico)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre comun a buscar");
                                String nombre_comun=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getNombre_comun().equals(nombre_comun)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a buscar");
                                String ubicacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getUbicacion().equals(ubicacion)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a buscar");
                                String ecosistema=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getEcosistema().equals(ecosistema)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a buscar");
                                String filo=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getFilo().equals(filo)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca el clase a buscar");
                                String clase=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getClase().equals(clase)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a buscar");
                                String orden=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getOrden().equals(orden)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a buscar");
                                String familia=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getFamilia().equals(familia)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a buscar");
                                String genero=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getGenero().equals(genero)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a buscar");
                                String especie=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getEspecie().equals(especie)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("11"):
                                System.out.println("Introduzca la alimentacion a buscar");
                                String alimentacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getAlimentacion().equals(alimentacion)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("12"):
                                System.out.println("Introduzca el depredador a buscar");
                                String depredador=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getDepredador().equals(depredador)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("4"):
                        System.out.println("Indique el criterio que desea actualizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n"
                                + "11.Alimentacion\n"
                                + "12.Depredador");
                        String actualizar=input.nextLine();
                        switch(actualizar){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a actualizar");
                                String nombre_cientifico=input.nextLine();
                                System.out.println("Introduzca el nombre cientifico nuevo");
                                String nuevo_nombre_cientifico=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getNombre_cientifico().equals(nombre_cientifico)){
                                        consulta_fauna.setNombre_cientifico(nuevo_nombre_cientifico);
                                        System.out.println("El nombre cientifico de: "+nombre_cientifico+" fue actualizado a "+nuevo_nombre_cientifico);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre a actualizar");
                                String nombre=input.nextLine();
                                System.out.println("Introduzca el nombre nuevo");
                                String nuevo_nombre=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getNombre_comun().equals(nombre)){
                                        consulta_fauna.setNombre_comun(nuevo_nombre);
                                        System.out.println("El nombre de: "+nombre+" fue actualizado a "+nuevo_nombre);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a actualizar");
                                String ubicacion=input.nextLine();
                                System.out.println("Introduzca la ubicacion nueva");
                                String nueva_ubicacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getUbicacion().equals(ubicacion)){
                                        consulta_fauna.setUbicacion(nueva_ubicacion);
                                        System.out.println("La ubicacion de: "+ubicacion+" fue actualizada a "+nueva_ubicacion);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a actualizar");
                                String ecosistema=input.nextLine();
                                System.out.println("Introduzca el ecosistema nuevo");
                                String nuevo_ecosistema=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getEcosistema().equals(ecosistema)){
                                        consulta_fauna.setEcosistema(nuevo_ecosistema);
                                        System.out.println("El ecosistema de: "+ecosistema+" fue actualizado a "+nuevo_ecosistema);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a actualizar");
                                String filo=input.nextLine();
                                System.out.println("Introduzca el filo nuevo");
                                String nuevo_filo=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getFilo().equals(filo)){
                                        consulta_fauna.setFilo(nuevo_filo);
                                        System.out.println("El filo de: "+filo+" fue actualizado a "+nuevo_filo);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca la clase a actualizar");
                                String clase=input.nextLine();
                                System.out.println("Introduzca la clase nueva");
                                String nueva_clase=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getClase().equals(clase)){
                                        consulta_fauna.setClase(nueva_clase);
                                        System.out.println("La clase de: "+clase+" fue actualizada a "+nueva_clase);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a actualizar");
                                String orden=input.nextLine();
                                System.out.println("Introduzca el orden nuevo");
                                String nuevo_orden=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getOrden().equals(orden)){
                                        consulta_fauna.setOrden(nuevo_orden);
                                        System.out.println("El orden de: "+orden+" fue actualizado a "+nuevo_orden);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a actualizar");
                                String familia=input.nextLine();
                                System.out.println("Introduzca la familia nueva");
                                String nueva_familia=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getFamilia().equals(familia)){
                                        consulta_fauna.setFamilia(nueva_familia);
                                        System.out.println("La familia de: "+familia+" fue actualizada a "+nueva_familia);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a actualizar");
                                String genero=input.nextLine();
                                System.out.println("Introduzca el genero nuevo");
                                String nuevo_genero=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getGenero().equals(genero)){
                                        consulta_fauna.setGenero(nuevo_genero);
                                        System.out.println("El genero de: "+genero+" fue actualizado a "+nuevo_genero);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a actualizar");
                                String especie=input.nextLine();
                                System.out.println("Introduzca la especie nueva");
                                String nueva_especie=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getEspecie().equals(especie)){
                                        consulta_fauna.setEspecie(nueva_especie);
                                        System.out.println("La especie de: "+especie+" fue actualizada a "+nueva_especie);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("11"):
                                System.out.println("Introduzca la alimentacion a actualizar");
                                String alimentacion=input.nextLine();
                                System.out.println("Introduzca la alimentacion nueva");
                                String nueva_alimentacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getAlimentacion().equals(alimentacion)){
                                        consulta_fauna.setAlimentacion(nueva_alimentacion);
                                        System.out.println("La alimentacion de: "+alimentacion+" fue actualizada a "+nueva_alimentacion);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                             case("12"):
                                System.out.println("Introduzca el depredador a actualizar");
                                String depredador=input.nextLine();
                                System.out.println("Introduzca el depredador nuevo");
                                String nuevo_depredador=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getDepredador().equals(depredador)){
                                        consulta_fauna.setDepredador(nuevo_depredador);
                                        System.out.println("El depredador de: "+depredador+" fue actualizado a "+nuevo_depredador);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            }
                        break;                    
                    case("5"):
                        System.out.println("Indique el criterio de eliminación que desea utilizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n");
                        String eliminacion=input.nextLine();
                        switch(eliminacion){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a eliminar");
                                String nombre_cientifico=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getNombre_cientifico().equals(nombre_cientifico)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre a eliminar");
                                String nombre=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getNombre_comun().equals(nombre)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a eliminar");
                                String ubicacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getUbicacion().equals(ubicacion)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a eliminar");
                                String ecosistema=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getEcosistema().equals(ecosistema)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a eliminar");
                                String filo=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getFilo().equals(filo)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca la clase a eliminar");
                                String clase=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getNombre_cientifico().equals(clase)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a eliminar");
                                String orden=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getOrden().equals(orden)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a eliminar");
                                String familia=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getFamilia().equals(familia)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a eliminar");
                                String genero=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getGenero().equals(genero)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a eliminar");
                                String especie=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getEspecie().equals(especie)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("11"):
                                System.out.println("Introduzca la alimentacion a eliminar");
                                String alimentacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getAlimentacion().equals(alimentacion)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("12"):
                                System.out.println("Introduzca el depredador a eliminar");
                                String depredador=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getDepredador().equals(depredador)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("6"):
                       start=System.currentTimeMillis();
                       OutputStream       outputStream;
                       if(!fauna.isEmpty()){
                           try{
                            String separador =System.getProperty("file.separator");
                            File f = new File("data"+separador+"salida_fauna.txt");
                            outputStream= new FileOutputStream(f.getAbsolutePath());
                            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                            for (int i=0;i<fauna.size();i++){
                                Fauna fauna_salida= (Fauna)fauna.value(i);
                                outputStreamWriter.write(fauna_salida.getNombre_cientifico()+","+fauna_salida.getNombre_comun()+","
                                    +fauna_salida.getUbicacion()+","+fauna_salida.getEcosistema()+","+fauna_salida.getFilo()
                                    +","+fauna_salida.getClase()+","+fauna_salida.getOrden()+","+fauna_salida.getFamilia()+","
                                        +fauna_salida.getGenero()+","+fauna_salida.getAlimentacion()+","+fauna_salida.getDepredador()+","
                                        +fauna_salida.getEspecie()+"\n");
                            }
                            outputStreamWriter.close();
                           }catch(Exception e){
                               System.out.println("Error"+e);
                            }
                       }
                       ciclo=false;
                       end=System.currentTimeMillis();
                        System.out.println(end-start);
                        break;
                    default:
                        System.out.println("El valor ingresado no corresponde a ninguna de las opciones");
                }
            }
            break;
            case ("4"):
                menu= false;
                break;
        }
        }            
//////////////////////////////////////////////////////////////////////////////////////
        }else if(Vwork.equals("5")){
    int pagenum, resperpage;
        pagenum=1;
        resperpage=10;
        boolean flor, faun, ecop;
        flor=faun=ecop=false;
        DynamicArray<DBFlora>  resultados = new DynamicArray<>(7);
        DynamicArray<DBFauna>  rFauna = new DynamicArray<>(7);
        DynamicArray<DBEcoparks>  rEcoparks = new DynamicArray<>(7);
//        DatosBusqueda ab= new DatosBusqueda(a,b,c,d,e,f,g);
//        resultados.push(h);
//        System.out.println(resultados.ar<reglo[0].getEspecie());
        InputStreamReader isr1 = new InputStreamReader(System.in);
        BufferedReader console1 = new BufferedReader(isr1);
        String opcion=null;
        boolean ciclo=true;
        long inicio;
        long fin;
        String separador=System.getProperty("file.separator");
                                   File f = new File("data"+separador+"Flora_500mil.txt");;
                                   FileReader lectorArchivo=new FileReader(f);
                                   BufferedReader br = new BufferedReader(lectorArchivo);
        String aux;
                                   File g = new File("data"+separador+"Fauna_500mil.txt");;
                                   FileReader lectorArchivo1=new FileReader(g);
                                   BufferedReader br1 = new BufferedReader(lectorArchivo1);
        String aux1;
                                   File h = new File("data"+separador+"Ecoparques_500mil.txt");;
                                   FileReader lectorArchivo2=new FileReader(h);
                                   BufferedReader br2 = new BufferedReader(lectorArchivo2);
        String aux2;

        while (true) {
            aux = br.readLine();
            if (aux == null) {
                break;
            }
            String[] atributos = aux.split(";");
            DBFlora a = new DBFlora(atributos[0], atributos[1], atributos[2], atributos[3], atributos[4], atributos[5], atributos[6], atributos[7], atributos[8], atributos[9]);
            resultados.push(a);
            
            aux1 = br1.readLine();
            if (aux1 == null) {
                break;
            }
            String[] atributos1 = aux1.split(";");
            DBFauna b = new DBFauna(atributos1[0], atributos1[1], atributos1[2], atributos1[3], atributos1[4], atributos1[5], atributos1[6], atributos1[7], atributos1[8], atributos1[9], atributos1[10]);
            rFauna.push(b);
            
            aux2 = br2.readLine();
            if (aux2 == null) {
                break;
            }
            String[] atributos2 = aux2.split(";");
            DBEcoparks c = new DBEcoparks(atributos2[0], atributos2[1], atributos2[2], atributos2[3]);
            rEcoparks.push(c);
            
//            System.out.println(resultados.value(0).toString());
            
            //System.out.println(a.getClasses());
        }
        System.out.println("# de resultados Flora:  "+resultados.size);
        System.out.println("# de resultados Fauna:  "+rFauna.size);
        System.out.println("# de resultados Eco-parques:  "+rEcoparks.size);
       while(ciclo){
               System.out.println("\tECO-LOMBIA\nEscoja la acción que desea realizar\n");
               System.out.print("1.Resultados Flora\n"
                       + "2.Resultados Fauna\n"
                       + "3.Resultados Ecoparques\n"
                       + "4.Avanzar Página\n"
                       + "5.Retroceder Página\n"
                       + "6.10 resultados por página\n"
                       + "7.20 resultados por página \n"
                       + "8.50 resultados por página\n"
                       + "9.Salir\n");
            try {
                opcion= console1.readLine();
            } catch (IOException ex) {
                ex.getMessage();
            }
                       switch(opcion){
                           case "1":
                           flor=true;
                           faun=false;
                           ecop=false;
                           pagenum=1;
                           break;
                           case "2":
                           flor=false;
                           faun=true;
                           ecop=false;
                           pagenum=1;
                           break;
                           case "3":
                           flor=false;
                           faun=false;
                           ecop=true;
                           pagenum=1;
                           break;
                           case "4":
                           pagenum ++;
                           break;
                           case "5":
                           pagenum --;
                         
                           if(pagenum<1){
                               pagenum=1;
                           }
                           break;
                           case "6":
                           resperpage=10;
                           break;
                           case "7":
                           resperpage=20;
                           break;
                           case "8":
                           resperpage=50;
                           break;
                           case "9":
                           flor=false;
                           faun=false;
                           ecop=false;
                           pagenum=0;
                           break;
                       }
       System.out.println("Página: "+pagenum);
       if(flor==true){
       for(int i=0;i<resultados.size;i++){
        if(i<pagenum*resperpage&&i>=(pagenum-1)*resperpage){
            
            System.out.println((i+1)+". "+resultados.value(i).toString());
        }
       }
        }
       else if(faun==true){
       for(int i=0;i<rFauna.size;i++){
        if(i<pagenum*resperpage&&i>=(pagenum-1)*resperpage){
            
            System.out.println((i+1)+". "+rFauna.value(i).toString());
        }
       }
       }
       
       if(ecop==true){
       for(int i=0;i<rEcoparks.size;i++){
        if(i<pagenum*resperpage&&i>=(pagenum-1)*resperpage){
            
            System.out.println((i+1)+". "+ rEcoparks.value(i).toString());
        }
       }
        }

        
        //br.close();
        //lectorArchivo.close();
        //String a= resultados.array[0].getClasses();
        
        
        }
       
       
    }  
    }
}
=======
package Codigo;



import Interface.Inicio;
import Interface.Ventana;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Eco_lombia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException  {
        // TODO code application logic here
    //Ventana prueba = new Ventana ();
    //----------------------------------------------------------------------------------------
    
        System.out.println("\tECO-LOMBIA\n");
        System.out.println("Escoja con lo que desea trabajar");
        System.out.println("1.Usuarios by Linked-List");
        System.out.println("2.Usuarios by DynamicArray");
        System.out.println("3.Flora, faura y ecoparques by linkedList");
        System.out.println("4.Flora, faura y ecoparques by DynamicArray");
        System.out.println("5.Paginador - Flora, faura y ecoparques by DynamicArray");
        
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader console = new BufferedReader (isr);
        String Vwork=null;
        try {
                 Vwork= console.readLine();
            } catch (IOException ex) {
                ex.getMessage();
            }
        
    //----------------------------------------------------------------------------------------
    //prueba usuario LinkedList   
    if(Vwork.equals("1")){
        LinkedList<UsuarioRegistrado> usuarios=new LinkedList<>();
  
        String opcion=null;
        String[] datos={"Correo","Contraseña","Institucion","Profesión","Nombres","Apellidos","ID"};
        boolean ciclo=true;
        long inicio;
        long fin;
       while(ciclo){
               System.out.println("    Escoja la acción que desea realizar\n");
               System.out.print("1.Insertar un numero de datos\n"
                       + "2.insertar un dato\n"
                       + "3.cambiar contraseña de un usuario por su id\n"
                       + "4.Buscar un dato por su id \n"
                       + "5.Entregar los nombres de los datos\n"
                       + "6.Salir\n");
            try {
                opcion= console.readLine();
            } catch (IOException ex) {
                ex.getMessage();
            }
                       switch(opcion){
                           case "1":
                               //for(int i=0;i<10;i++){
                               inicio = System.currentTimeMillis();
                             try{
                                   String separador=System.getProperty("file.separator");
                                   File f = new File("data"+separador+"Usuario10000.txt");
                                   FileReader lectorArchivo=new FileReader(f);
                                   BufferedReader br = new BufferedReader(lectorArchivo);
                                   String l="";
                                   String aux="";

                                   while(true){
                                       aux=br.readLine();
                                       if(aux==null){
                                           break;
                                       }
                                       String[] atributos=aux.split(",");
                                       usuarios.add(new UsuarioRegistrado(atributos[0]
                                           ,atributos[1],atributos[2],atributos[3],atributos[4],
                                           atributos[5],atributos[6]));      
                                       
                                   } 
                                   br.close();
                                   lectorArchivo.close();
                               }catch(Exception e){
                                   System.out.println("error  "+e );
                                   System.out.println(e.getMessage());
                               }fin = System.currentTimeMillis();
                                System.out.println(fin - inicio);
                                  break;  

                           case "2":
                               try {
                                   String[] info=new String[7];
                                   
                               for(int i=0;i<7;i++){
                                   System.out.println("Ingrese el "+datos[i]+" de el usuario");
                                   info[i]= console.readLine();
                               }
                               inicio = System.currentTimeMillis();
                               usuarios.add(new UsuarioRegistrado(info[0],info[1],info[2],info[3],info[4],info[5],info[6]));
                               fin = System.currentTimeMillis();
                               System.out.println(fin - inicio);
                                  } catch (IOException ex) {
                                   Logger.getLogger(Eco_lombia.class.getName()).log(Level.SEVERE, null, ex);
                               }break;

                           case "3":
                               try {
                                   inicio = System.currentTimeMillis();
                                   System.out.println("Ingrese el id del usuario al que desea cambiarle la contraseña");
                                   String id=console.readLine();
                                    
                                   Node temporal= usuarios.getNodeAt(0);
                                   UsuarioRegistrado Ucambio=(UsuarioRegistrado) temporal.key;
                                   while((temporal.next)!=null){            
                                        if(Ucambio.getId().equals(id)){
               
                                        break;} 
                                        temporal= temporal.next;
                                        Ucambio=(UsuarioRegistrado) temporal.key;
                                    }
                                   
                                   System.out.println("Ingrese la contraseña actual del usuario");
                                   String passwordact=console.readLine();

                                   if(Ucambio.getPassword().equals(passwordact)){
                                       String newPassowrd="";
                                       String newPassword2=".";
                                       while(!newPassowrd.equals(newPassword2)){
                                       System.out.println("Ingrese la nueva contraseña");
                                       newPassowrd=console.readLine();
                                       System.out.println("Ingrese la contraseña nuevamnte");
                                       newPassword2=console.readLine();
                                       }
                                       Ucambio.setPassword(newPassowrd);
                                       System.out.println("Contraseña cambiada");
                                   }else{
                                       System.out.println("La contraseña no es correcta");
                                   }fin = System.currentTimeMillis();
                                    System.out.println(fin - inicio);
                               } catch (IOException ex) {
                                   Logger.getLogger(Eco_lombia.class.getName()).log(Level.SEVERE, null, ex);
                               }break;

                           case "4":

                               try {
                                   System.out.println("Ingrese el id del usuario De quien desea visualizar su nombre");
                                   String id; 
                                   id = console.readLine(); 
                                   inicio = System.currentTimeMillis();
                                   Node temporal= usuarios.getNodeAt(0);
                                   UsuarioRegistrado Ucambio=(UsuarioRegistrado) temporal.key;
                                   while((temporal.next)!=null){            
                                        if(Ucambio.getId().equals(id)){
               
                                        break;} 
                                        temporal= temporal.next;
                                        Ucambio=(UsuarioRegistrado) temporal.key;
                                    }
                                   System.out.println("el nombre del usuario con cc: "+id+" es "+Ucambio.getNombres());
                                    fin = System.currentTimeMillis();
                                    System.out.println(fin - inicio);
                              } catch (IOException ex) {
                                   Logger.getLogger(Eco_lombia.class.getName()).log(Level.SEVERE, null, ex);
                               }break;

                           case "5":
                                    inicio = System.currentTimeMillis();
                                    Node temporal= usuarios.getNodeAt(0);
                                    UsuarioRegistrado Ucambio=(UsuarioRegistrado) temporal.key;
                                    while((temporal.next)!=null){            
                                        Ucambio.getNombres(); 
                                        temporal= temporal.next;
                                        Ucambio=(UsuarioRegistrado) temporal.key;
                                    }
                                    Ucambio.getNombres(); 
                                    fin = System.currentTimeMillis();
                                    System.out.println(fin - inicio);
                                    break;

                           case "6":
                               inicio = System.currentTimeMillis();
                               OutputStream       outputStream;
                                if(!usuarios.isEmpty()){
                               try {
                                    Node salida= usuarios.getNodeAt(0);
                                    UsuarioRegistrado Usalida=(UsuarioRegistrado) salida.key;
                                    String separador=System.getProperty("file.separator");
                                    File f = new File("data"+separador+"Salida.txt");
                                    outputStream = new FileOutputStream(f.getAbsolutePath());
                                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                                    
                                   while((salida.next)!=null){            
                                    outputStreamWriter.write(Usalida.getCorreo()+","+Usalida.getPassword()+","
                                    +Usalida.getInstitucion()+","+Usalida.getProfesion()+","+Usalida.getNombres()
                                    +","+Usalida.getApellidos()+","+Usalida.getId()+"\n");
                                        salida= salida.next;
                                        Usalida=(UsuarioRegistrado) salida.key;
                                    }
                                   outputStreamWriter.write(Usalida.getCorreo()+","+Usalida.getPassword()+","
                                    +Usalida.getInstitucion()+","+Usalida.getProfesion()+","+Usalida.getNombres()
                                    +","+Usalida.getApellidos()+","+Usalida.getId()+"\n");

                                    outputStreamWriter.close();
                                } catch (Exception ex) {
                                    Logger.getLogger(Eco_lombia.class.getName()).log(Level.SEVERE, null, ex);
                                }}
                               ciclo=false;
                                  fin = System.currentTimeMillis();
                                  JOptionPane.showMessageDialog(null,fin-inicio);
                               break;
                                
                           default:
                               System.out.println("El valor ingresado no esta entre las opciones");
                       }

       } 
    }else if(Vwork.equals("2")){
//----------------------------------------------------------------------------------------
//

//       // prueba usuario arrayDinamico




        DynamicArray<UsuarioRegistrado> usuarios=new DynamicArray<>(10);
        String opcion=null;
        String[] datos={"Correo","Contraseña","Institucion","Profesión","Nombres","Apellidos","ID"};
        boolean ciclo=true;
        long inicio;
        long fin;

       while(ciclo){
                    System.out.println("    Escoja la acción que desea realizar\n");
               System.out.print("1.Insertar un numero de datos\n"
                       + "2.insertar un dato\n"
                       + "3.cambiar contraseña de un usuario por su id\n"
                       + "4.Buscar un dato por su id \n"
                       + "5.Entregar los nombres de los datos\n"
                       + "6.Salir\n");
            try {
                opcion= console.readLine();
            } catch (IOException ex) {
                ex.getMessage();
            }
                       switch(opcion){
                           case "1":
                               inicio = System.currentTimeMillis();
                                //for(int i=0;i<2;i++){
                             try{
                                   String separador=System.getProperty("file.separator");
                                   File f = new File("data"+separador+"Usuario3000000.txt");;
                                   FileReader lectorArchivo=new FileReader(f);
                                   BufferedReader br = new BufferedReader(lectorArchivo);
                                   String l="";
                                   String aux="";

                                   while(true){
                                       aux=br.readLine();
                                       if(aux==null){
                                           break;
                                       }
                                       String[] atributos=aux.split(",");
                                       usuarios.push(new UsuarioRegistrado(atributos[0]
                                           ,atributos[1],atributos[2],atributos[3],atributos[4],
                                           atributos[5],atributos[6]));      
                                   } 
                                   br.close();
                                   lectorArchivo.close();
                               }catch(Exception e){
                                   System.out.println("error  "+e );
                                   System.out.println(e.getMessage());
                                   
                               }//}
                                fin = System.currentTimeMillis();
                                System.out.println(fin - inicio);
                                
                                break;  
                           case "2":
                               
                               try {
                                   String[] info=new String[7];
                               for(int i=0;i<7;i++){
                                   System.out.println("Ingrese el "+datos[i]+" de el usuario");
                                   info[i]= console.readLine();
                               } 
                               inicio = System.currentTimeMillis();
                               usuarios.push(new UsuarioRegistrado(info[0],info[1],info[2],info[3],info[4],info[5],info[6]));
                               fin = System.currentTimeMillis();
                               System.out.println(fin - inicio);
                               } catch (IOException ex) {
                                   Logger.getLogger(Eco_lombia.class.getName()).log(Level.SEVERE, null, ex);
                               }
                               break;

                           case "3":
                               try {
                                   System.out.println("Ingrese el id del usuario al que desea cambiarle la contraseña");
                                   String id=console.readLine();
                                   if(usuarios.isEmpty()){
                                        System.out.println("Estructura vacia...");
                                        break;
                                   }
                                   int position=0;
                                   UsuarioRegistrado Ucambio=(UsuarioRegistrado) usuarios.value(0);
                                   for(int i =1;i<usuarios.size;i++){
                                        if(Ucambio.getId().equals(id)){
                                            break;
                                        }
                                        position++;
                                        Ucambio=(UsuarioRegistrado) usuarios.value(i);
                                   }
            
                                   System.out.println("Ingrese la contraseña actual del usuario");
                                   String passwordact=console.readLine();
                                   inicio = System.currentTimeMillis();
                                   if(Ucambio.getPassword().equals(passwordact)){
                                       String newPassowrd="";
                                       String newPassword2=".";
                                       while(!newPassowrd.equals(newPassword2)){
                                       System.out.println("Ingrese la nueva contraseña");
                                       newPassowrd=console.readLine();
                                       System.out.println("Ingrese la contraseña nuevamente");
                                       newPassword2=console.readLine();
                                       }
                                       
                                       Ucambio.setPassword(newPassowrd);
                                       usuarios.set(position, Ucambio);
                                       System.out.println("Contraseña cambiada");
                                   }else{
                                       System.out.println("La contraseña no es correcta");
                                   }
                                   fin = System.currentTimeMillis();
                                    System.out.println(fin - inicio);
                               } catch (IOException ex) {
                                   Logger.getLogger(Eco_lombia.class.getName()).log(Level.SEVERE, null, ex);
                               }
                               break;

                           case "4":
                               
                               try {
                                   System.out.println("Ingrese el id del usuario De quien desea visualizar su nombre");
                                   
                                   String id; 
                                   id = console.readLine(); 
                                   inicio = System.currentTimeMillis();
                                   if(usuarios.isEmpty()){
                                        System.out.println("Estructura vacia...");
                                        break;
                                   }
                                   int position=0;
                                   UsuarioRegistrado Utemporal=(UsuarioRegistrado) usuarios.value(0);
                                   for(int i =1;i<usuarios.size;i++){
                                        if(Utemporal.getId().equals(id)){
                                            break;
                                        }
                                        position++;
                                        Utemporal=(UsuarioRegistrado) usuarios.value(i);
                                   }
                                   System.out.println("el nombre del usuario con cc: "+id+" es "+Utemporal.getNombres());
                                   fin = System.currentTimeMillis();
                                   System.out.println(fin - inicio);
                               } catch (IOException ex) {
                                   Logger.getLogger(Eco_lombia.class.getName()).log(Level.SEVERE, null, ex);
                               }
                               break;

                           case "5":
                               inicio = System.currentTimeMillis();
                                for(int i =0;i<usuarios.size;i++){
                                UsuarioRegistrado Utemporal= (UsuarioRegistrado) usuarios.value(i);
                                Utemporal.getNombres();
                                }
                                fin = System.currentTimeMillis();
                                System.out.println(fin - inicio);
                               break;

                           case "6":
                               inicio = System.currentTimeMillis();
                                    if(!usuarios.isEmpty()){
                               try{
                                    String separador=System.getProperty("file.separator");
                                    File f = new File("data"+separador+"Salida.txt");
                                    OutputStream outputStream = new FileOutputStream(f.getAbsolutePath());
                                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                                    
                                   for(int i =0;i<usuarios.size;i++){
                                        UsuarioRegistrado Usalida=(UsuarioRegistrado) usuarios.value(i);
        
                                        outputStreamWriter.write(Usalida.getCorreo()+","+Usalida.getPassword()+","
                                        +Usalida.getInstitucion()+","+Usalida.getProfesion()+","+Usalida.getNombres()
                                        +","+Usalida.getApellidos()+","+Usalida.getId()+"\n");
                                        
                                    }
                                    outputStreamWriter.close();
                                } catch (Exception ex) {
                                    Logger.getLogger(Eco_lombia.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                    }

                               ciclo=false;
                                fin = System.currentTimeMillis();
                                JOptionPane.showMessageDialog(null,fin-inicio);
                               break;
                           default:
                               System.out.println("El valor ingresado no esta entre las opciones");
                       }

       }
    }else if(Vwork.equals("3")){
//------------------------------------------------------------------------------------------------------------------
    //Pueba Flora LinkedList
        
       
        //Pueba Flora LinkedList
        
        Scanner input = new Scanner(System.in);
        String objeto;
        boolean menu = true;
        String opcion="";
        boolean ciclo=true;
        boolean exist=false;
        long start;
        long end;
        Node temp;
        int index;
        while(menu){
        System.out.println("Indique sobre que elemento quiere actuar\n"
                + "1.Flora\n"
                + "2.Fauna\n"
                + "3.Ecoparques\n"
                + "4.Salir");
        objeto=input.nextLine();
        ciclo=true;
        switch (objeto){
            case ("1"):
            LinkedList<Flora> flora = new LinkedList<>();
            Flora consulta_flora;
            while(ciclo){
                System.out.println("\tECO-LOMBIA\nEscoja la accion que desea realizar\n");
                System.out.println("1.Insertar un numero de datos\n"+
                        "2.Insertar un dato\n"+
                        "3.Buscar un dato\n"+
                        "4.Actualizar un dato\n"+
                        "5.Eliminar un dato\n"
                        + "6.Salir");
                try{
                    opcion= console.readLine();
                }catch(IOException ex){
                    ex.getMessage();
                }
                switch(opcion){
                    case "1":
                        start=System.currentTimeMillis();
                        try{
                            String separador =System.getProperty("file.separator");
                            File f = new File("data"+separador+"Flora_1millon.txt");
                            FileReader lectorArchivo=new FileReader(f);
                            BufferedReader br = new BufferedReader(lectorArchivo);
                            //String l="";
                            String aux="";
                            while(true){
                                aux=br.readLine();
                                if(aux==null)break;
                                String[] atributos=aux.split(";");
                                flora.add(new Flora(atributos[0]
                                         ,atributos[1],atributos[2],atributos[3],atributos[4],
                                          atributos[5],atributos[6],atributos[7],atributos[8],atributos[9]));                                             
                                } 
                            br.close();
                            lectorArchivo.close();
                        }
                        catch(Exception e){
                        System.out.println("error  "+e );
                        System.out.println(e.getMessage());
                        }end = System.currentTimeMillis();
                        System.out.println(end - start);
                        break;
                    case("2"):
                        String[] datos= new String[10];
                        System.out.println("Inserte los datos con el orden de:\n"
                                + "Nombre Cientifico, Nombre comun, Ubicacion, Ecosistema, Filo, Clase, Orden, Familia, Genero y Especie\n"
                                + "En caso de desconocer algun dato, escriba la palabra 'null'");
                        for (int i =0;i<datos.length;i++){
                            datos[i]=input.nextLine();
                        }
                        start=System.currentTimeMillis();
                        flora.add(new Flora(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],
                                            datos[6],datos[7],datos[8],datos[9]));
                        end=System.currentTimeMillis();
                        System.out.println(end-start);
                        break;
                    case("3"):
                        System.out.println("Indique el criterio de busqueda que desea utilizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n");
                        String busqueda=input.nextLine();
                        switch(busqueda){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a buscar");
                                String nombre_cientifico=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for(int i = 0;i<flora.size();i++){
                                    if(consulta_flora.getNombre_cientifico().equals(nombre_cientifico)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre comun a buscar");
                                String nombre_comun=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getNombre_comun().equals(nombre_comun)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a buscar");
                                String ubicacion=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getUbicacion().equals(ubicacion)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a buscar");
                                String ecosistema=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getEcosistema().equals(ecosistema)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a buscar");
                                String filo=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getFilo().equals(filo)){
                                        System.out.println(consulta_flora);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca la clase a buscar");
                                String clase=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getClase().equals(clase)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a buscar");
                                String orden=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getOrden().equals(orden)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a buscar");
                                String familia=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getFamilia().equals(familia)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a buscar");
                                String genero=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getGenero().equals(genero)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a buscar");
                                String especie=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getEspecie().equals(especie)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("4"):
                        System.out.println("Indique el criterio que desea actualizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n");
                        String actualizar=input.nextLine();
                        switch(actualizar){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a actualizar");
                                String nombre_cientifico=input.nextLine();
                                System.out.println("Introduzca el nombre cientifico nuevo");
                                String nuevo_nombre_cientifico=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getNombre_cientifico().equals(nombre_cientifico)){
                                        consulta_flora.setNombre_cientifico(nuevo_nombre_cientifico);
                                        System.out.println("El nombre cientifico de: "+nombre_cientifico+" fue actualizado a "+nuevo_nombre_cientifico);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre comun a actualizar");
                                String nombre_comun=input.nextLine();
                                System.out.println("Introduzca el nombre comun nuevo");
                                String nuevo_nombre_comun=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getNombre_comun().equals(nombre_comun)){
                                        consulta_flora.setNombre_comun(nuevo_nombre_comun);
                                        System.out.println("El nombre comun de: "+nombre_comun+" fue actualizado a "+nuevo_nombre_comun);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a actualizar");
                                String ubicacion=input.nextLine();
                                System.out.println("Introduzca la ubicacion nueva");
                                String nueva_ubicacion=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getUbicacion().equals(ubicacion)){
                                        consulta_flora.setUbicacion(nueva_ubicacion);
                                        System.out.println("La ubicacion de: "+ubicacion+" fue actualizada a "+nueva_ubicacion);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a actualizar");
                                String ecosistema=input.nextLine();
                                System.out.println("Introduzca el ecosistema nuevo");
                                String nuevo_ecosistema=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getEcosistema().equals(ecosistema)){
                                        consulta_flora.setEcosistema(nuevo_ecosistema);
                                        System.out.println("El ecosistema de: "+ecosistema+" fue actualizado a "+nuevo_ecosistema);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a actualizar");
                                String filo=input.nextLine();
                                System.out.println("Introduzca el filo nuevo");
                                String nuevo_filo=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getFilo().equals(filo)){
                                        consulta_flora.setFilo(nuevo_filo);
                                        System.out.println("El filo de: "+filo+" fue actualizado a "+nuevo_filo);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca la clase a actualizar");
                                String clase=input.nextLine();
                                System.out.println("Introduzca la clase nueva nuevo");
                                String nueva_clase=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getClase().equals(clase)){
                                        consulta_flora.setClase(nueva_clase);
                                        System.out.println("La clase de: "+clase+" fue actualizada a "+nueva_clase);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a actualizar");
                                String orden=input.nextLine();
                                System.out.println("Introduzca el orden nuevo");
                                String nuevo_orden=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getOrden().equals(orden)){
                                        consulta_flora.setOrden(nuevo_orden);
                                        System.out.println("El orden de: "+orden+" fue actualizado a "+nuevo_orden);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a actualizar");
                                String familia=input.nextLine();
                                System.out.println("Introduzca la familia nueva");
                                String nueva_familia=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getFamilia().equals(familia)){
                                        consulta_flora.setFamilia(nueva_familia);
                                        System.out.println("La familia de: "+familia+" fue actualizada a "+nueva_familia);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a actualizar");
                                String genero=input.nextLine();
                                System.out.println("Introduzca el genero nuevo");
                                String nuevo_genero=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getGenero().equals(genero)){
                                        consulta_flora.setGenero(nuevo_genero);
                                        System.out.println("El genero de: "+genero+" fue actualizado a "+nuevo_genero);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a actualizar");
                                String especie=input.nextLine();
                                System.out.println("Introduzca la especie nueva");
                                String nueva_especie=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getEspecie().equals(especie)){
                                        consulta_flora.setEspecie(nueva_especie);
                                        System.out.println("La especie de: "+especie+" fue actualizada a "+nueva_especie);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            }
                        break;                    
                    case("5"):
                        System.out.println("Indique el criterio de eliminación que desea utilizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n");
                        String eliminacion=input.nextLine();
                        switch(eliminacion){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a eliminar");
                                String nombre_cientifico=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getNombre_cientifico().equals(nombre_cientifico)){
                                        flora.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre comun a eliminar");
                                String nombre_comun=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getNombre_comun().equals(nombre_comun)){
                                        flora.delete(index);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a eliminar");
                                String ubicacion=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getUbicacion().equals(ubicacion)){
                                        flora.delete(index);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a eliminar");
                                String ecosistema=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getEcosistema().equals(ecosistema)){
                                        flora.delete(index);
                                        exist=true;
                                        System.out.println("La eliminacion se ha completado con exito");
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a eliminar");
                                String filo=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getFilo().equals(filo)){
                                        flora.delete(index);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca la clase a eliminar");
                                String clase=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getClase().equals(clase)){
                                        flora.delete(index);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a eliminar");
                                String orden=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getOrden().equals(orden)){
                                        flora.delete(index);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a eliminar");
                                String familia=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getFamilia().equals(familia)){
                                        flora.delete(index);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a eliminar");
                                String genero=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getGenero().equals(genero)){
                                        flora.delete(index);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a eliminar");
                                String especie=input.nextLine();
                                temp= flora.getNodeAt(0);
                                consulta_flora=(Flora) flora.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<flora.size();i++){
                                    if(consulta_flora.getEspecie().equals(especie)){
                                        flora.delete(index);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_flora= (Flora) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("6"):
                       ciclo=false;
                       break;
                }
            }
            break;
            case ("3"):
            LinkedList<Ecoparque> ecoparque = new LinkedList<>();
            Ecoparque consulta_ecoparque;
            while(ciclo){
                System.out.println("\tECO-LOMBIA\nEscoja la accion que desea realizar en Ecoparques\n");
                System.out.println("1.Insertar un numero de datos\n"+
                        "2.Insertar un dato\n"+
                        "3.Buscar un dato\n"+
                        "4.Actualizar un dato\n"+
                        "5.Eliminar un dato\n"
                        + "6.Salir");
                try{
                    opcion= console.readLine();
                }catch(IOException ex){
                    ex.getMessage();
                }
                switch(opcion){
                    case "1":
                        start=System.currentTimeMillis();
                        try{
                            String separador =System.getProperty("file.separator");
                            File f = new File("data"+separador+"Ecoparques_500mil.txt");
                            FileReader lectorArchivo=new FileReader(f);
                            BufferedReader br = new BufferedReader(lectorArchivo);
                            //String l="";
                            String aux="";
                            while(true){
                                aux=br.readLine();
                                if(aux==null)break;
                                String[] atributos=aux.split(";");
                                ecoparque.add(new Ecoparque(atributos[0]
                                         ,atributos[1],atributos[2],atributos[3]));                                             
                                } 
                            br.close();
                            lectorArchivo.close();
                        }
                        catch(Exception e){
                        System.out.println("error  "+e );
                        System.out.println(e.getMessage());
                        }end = System.currentTimeMillis();
                        System.out.println(end - start);
                        break;
                    case("2"):
                        String[] datos= new String[4];
                        System.out.println("Inserte los datos con el orden de:\n"
                                + "Nombre, Ubicaion, Ecosistema, Interes\n"
                                + "En caso de desconocer algun dato, escriba la palabra 'null'");
                        for (int i =0;i<datos.length;i++){
                            datos[i]=input.nextLine();
                        }
                        start=System.currentTimeMillis();
                        ecoparque.add(new Ecoparque(datos[0],datos[1],datos[2],datos[3]));
                        end=System.currentTimeMillis();
                        System.out.println(end-start);
                        break;
                    case("3"):
                        System.out.println("Indique el criterio de busqueda que desa utilizar\n"
                                + "1.Nombre\n"
                                + "2.Ubicacion\n"
                                + "3.Ecosistema\n"
                                + "4.Interes\n");
                        String busqueda=input.nextLine();
                        switch(busqueda){
                            case("1"):
                                System.out.println("Introduzca el nombre a buscar");
                                String nombre=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                for(int i = 0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getNombre().equals(nombre)){
                                        System.out.println(consulta_ecoparque.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca la ubicacion a buscar");
                                String ubicacion=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getUbicacion().equals(ubicacion)){
                                        System.out.println(consulta_ecoparque.toString());
                                        exist=true;
                                        
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca el ecosistema actualizar");
                                String ecosistema=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getUbicacion().equals(ecosistema)){
                                        System.out.println(consulta_ecoparque.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el interes a buscar");
                                String interes=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getInteres().equals(interes)){
                                        System.out.println(consulta_ecoparque.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("4"):
                        System.out.println("Indique el criterio de busqueda que desea utilizar\n"
                                + "1.Nombre\n"
                                + "2.Ubicacion\n"
                                + "3.Ecosistema\n"
                                + "4.Interes\n");
                        String actualizar=input.nextLine();
                        switch(actualizar){
                            case("1"):
                                System.out.println("Introduzca el nombre a actualizar");
                                String nombre=input.nextLine();
                                System.out.println("Introduzca el nombre nuevo");
                                String nuevo_nombre=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getNombre().equals(nombre)){
                                        consulta_ecoparque.setNombre(nuevo_nombre);
                                        System.out.println("El nombre de: "+nombre+" fue actualizado a "+nuevo_nombre);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca la ubicacion a actualizar");
                                String ubicacion=input.nextLine();
                                System.out.println("Introduzca la ubicacion nueva");
                                String nueva_ubicacion=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getUbicacion().equals(ubicacion)){
                                        consulta_ecoparque.setUbicacion(nueva_ubicacion);
                                        System.out.println("La ubicacion de: "+ubicacion+" fue actualizada a "+nueva_ubicacion);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca el ecosistema a actualizar");
                                String ecosistema=input.nextLine();
                                System.out.println("Introduzca el ecosistema nuevo");
                                String nuevo_ecosistema=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getUbicacion().equals(ecosistema)){
                                        consulta_ecoparque.setUbicacion(nuevo_ecosistema);
                                        System.out.println("El ecosistema de: "+ecosistema+" fue actualizado a "+nuevo_ecosistema);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el interes a actualizar");
                                String interes=input.nextLine();
                                System.out.println("Introduzca el interes nuevo");
                                String nuevo_interes=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getInteres().equals(interes)){
                                        consulta_ecoparque.setInteres(nuevo_interes);
                                        System.out.println("El interes de: "+interes+" fue actualizado a "+nuevo_interes);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            }
                        break;                    
                    case("5"):
                        System.out.println("Indique el criterio de busqueda que desea utilizar\n"
                                + "1.Nombre\n"
                                + "2.Ubicacion\n"
                                + "3.Ecosistema\n"
                                + "4.Interes\n");
                        String eliminacion=input.nextLine();
                        switch(eliminacion){
                            case("1"):
                                System.out.println("Introduzca el nombre a eliminar");
                                String nombre=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getNombre().equals(nombre)){
                                        ecoparque.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca la ubicacion a eliminar");
                                String ubicacion=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getUbicacion().equals(ubicacion)){
                                        ecoparque.delete(index);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ecosistema a eliminar");
                                String ecosistema=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getEcosistema().equals(ecosistema)){
                                        ecoparque.delete(index);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el interes a eliminar");
                                String interes=input.nextLine();
                                temp= ecoparque.getNodeAt(0);
                                consulta_ecoparque=(Ecoparque) ecoparque.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<ecoparque.size();i++){
                                    if(consulta_ecoparque.getInteres().equals(interes)){
                                        ecoparque.delete(index);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_ecoparque= (Ecoparque) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("6"):
                       ciclo=false;
                       break;
                }
                
            }
            break;
            case("2"):
            LinkedList<Fauna> fauna = new LinkedList<>();
            Fauna consulta_fauna;
            while(ciclo){
                System.out.println("\tECO-LOMBIA\nEscoja la accion que desea realizar\n");
                System.out.println("1.Insertar un numero de datos\n"+
                        "2.Insertar un dato\n"+
                        "3.Buscar un dato\n"+
                        "4.Actualizar un dato\n"+
                        "5.Eliminar un dato\n"
                        + "6.Salir");
                try{
                    opcion= console.readLine();
                }catch(IOException ex){
                    ex.getMessage();
                }
                switch(opcion){
                    case "1":
                        start=System.currentTimeMillis();
                        try{
                            String separador =System.getProperty("file.separator");
                            File f = new File("data"+separador+"Flora_10mil.txt");
                            FileReader lectorArchivo=new FileReader(f);
                            BufferedReader br = new BufferedReader(lectorArchivo);
                            //String l="";
                            String aux="";
                            while(true){
                                aux=br.readLine();
                                if(aux==null)break;
                                String[] atributos=aux.split(";");
                                fauna.add(new Fauna(atributos[0]
                                         ,atributos[1],atributos[2],atributos[3],atributos[4],
                                          atributos[5],atributos[6],atributos[7],atributos[8],atributos[9],
                                            atributos[10],atributos[11]));                                             
                                } 
                            br.close();
                            lectorArchivo.close();
                        }
                        catch(Exception e){
                        System.out.println("error  "+e );
                        System.out.println(e.getMessage());
                        }end = System.currentTimeMillis();
                        System.out.println(end - start);
                        break;
                    case("2"):
                        String[] datos= new String[12];
                        System.out.println("Inserte los datos con el orden de:\n"
                                + "Nombre Cientifico, Nombre comun, Ubicacion, Ecosistema, Filo, Clase\n"
                                + ", Orden, Familia, Genero Alimentacion Depredador y Especie\n"
                                + "Si desconocer algun dato, escriba la palabra 'null'");
                        for (int i =0;i<datos.length;i++){
                            datos[i]=input.nextLine();
                        }
                        start=System.currentTimeMillis();
                        fauna.add(new Fauna(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],
                                            datos[6],datos[7],datos[8],datos[9],datos[10],datos[11]));
                        end=System.currentTimeMillis();
                        System.out.println(end-start);
                        break;
                    case("3"):
                        System.out.println("Indique el criterio de busqueda que desea utilizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n"
                                + "11.Alimentacion\n"
                                + "12.Depredador");
                        String busqueda=input.nextLine();
                        switch(busqueda){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a buscar");
                                String nombre_cientifico=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for(int i = 0;i<fauna.size();i++){
                                    if(consulta_fauna.getNombre_cientifico().equals(nombre_cientifico)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre comun a buscar");
                                String nombre_comun=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getNombre_comun().equals(nombre_comun)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a buscar");
                                String ubicacion=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getUbicacion().equals(ubicacion)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a buscar");
                                String ecosistema=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getEcosistema().equals(ecosistema)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a buscar");
                                String filo=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getFilo().equals(filo)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca el clase a buscar");
                                String clase=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getClase().equals(clase)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    consulta_fauna= (Fauna) temp.key;
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a buscar");
                                String orden=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getOrden().equals(orden)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a buscar");
                                String familia=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getFamilia().equals(familia)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a buscar");
                                String genero=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getGenero().equals(genero)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a buscar");
                                String especie=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getEspecie().equals(especie)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("11"):
                                System.out.println("Introduzca la alimentacion a buscar");
                                String alimentacion=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getAlimentacion().equals(alimentacion)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("12"):
                                System.out.println("Introduzca el depredador a buscar");
                                String depredador=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getDepredador().equals(depredador)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("4"):
                        System.out.println("Indique el criterio que desea actualizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n"
                                + "11.Alimentacion\n"
                                + "12.Depredador");
                        String actualizar=input.nextLine();
                        switch(actualizar){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a actualizar");
                                String nombre_cientifico=input.nextLine();
                                System.out.println("Introduzca el nombre cientifico nuevo");
                                String nuevo_nombre_cientifico=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getNombre_cientifico().equals(nombre_cientifico)){
                                        consulta_fauna.setNombre_cientifico(nuevo_nombre_cientifico);
                                        System.out.println("El nombre cientifico de: "+nombre_cientifico+" fue actualizado a "+nuevo_nombre_cientifico);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre a actualizar");
                                String nombre=input.nextLine();
                                System.out.println("Introduzca el nombre nuevo");
                                String nuevo_nombre=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getNombre_comun().equals(nombre)){
                                        consulta_fauna.setNombre_comun(nuevo_nombre);
                                        System.out.println("El nombre de: "+nombre+" fue actualizado a "+nuevo_nombre);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a actualizar");
                                String ubicacion=input.nextLine();
                                System.out.println("Introduzca la ubicacion nueva");
                                String nueva_ubicacion=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getUbicacion().equals(ubicacion)){
                                        consulta_fauna.setUbicacion(nueva_ubicacion);
                                        System.out.println("La ubicacion de: "+ubicacion+" fue actualizada a "+nueva_ubicacion);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }consulta_fauna= (Fauna) temp.key;
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a actualizar");
                                String ecosistema=input.nextLine();
                                System.out.println("Introduzca el ecosistema nuevo");
                                String nuevo_ecosistema=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getEcosistema().equals(ecosistema)){
                                        consulta_fauna.setEcosistema(nuevo_ecosistema);
                                        System.out.println("El ecosistema de: "+ecosistema+" fue actualizado a "+nuevo_ecosistema);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a actualizar");
                                String filo=input.nextLine();
                                System.out.println("Introduzca el filo nuevo");
                                String nuevo_filo=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getFilo().equals(filo)){
                                        consulta_fauna.setFilo(nuevo_filo);
                                        System.out.println("El filo de: "+filo+" fue actualizado a "+nuevo_filo);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca la clase a actualizar");
                                String clase=input.nextLine();
                                System.out.println("Introduzca la clase nueva");
                                String nueva_clase=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getClase().equals(clase)){
                                        consulta_fauna.setClase(nueva_clase);
                                        System.out.println("La clase de: "+clase+" fue actualizada a "+nueva_clase);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a actualizar");
                                String orden=input.nextLine();
                                System.out.println("Introduzca el orden nuevo");
                                String nuevo_orden=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getOrden().equals(orden)){
                                        consulta_fauna.setOrden(nuevo_orden);
                                        System.out.println("El orden de: "+orden+" fue actualizado a "+nuevo_orden);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a actualizar");
                                String familia=input.nextLine();
                                System.out.println("Introduzca la familia nueva");
                                String nueva_familia=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getFamilia().equals(familia)){
                                        consulta_fauna.setFamilia(nueva_familia);
                                        System.out.println("La familia de: "+familia+" fue actualizada a "+nueva_familia);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a actualizar");
                                String genero=input.nextLine();
                                System.out.println("Introduzca el genero nuevo");
                                String nuevo_genero=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getGenero().equals(genero)){
                                        consulta_fauna.setGenero(nuevo_genero);
                                        System.out.println("El genero de: "+genero+" fue actualizado a "+nuevo_genero);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a actualizar");
                                String especie=input.nextLine();
                                System.out.println("Introduzca la especie nueva");
                                String nueva_especie=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getEspecie().equals(especie)){
                                        consulta_fauna.setEspecie(nueva_especie);
                                        System.out.println("La especie de: "+especie+" fue actualizada a "+nueva_especie);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("11"):
                                System.out.println("Introduzca la alimentacion a actualizar");
                                String alimentacion=input.nextLine();
                                System.out.println("Introduzca la alimentacion nueva");
                                String nueva_alimentacion=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getAlimentacion().equals(alimentacion)){
                                        consulta_fauna.setAlimentacion(nueva_alimentacion);
                                        System.out.println("La alimentacion de: "+alimentacion+" fue actualizada a "+nueva_alimentacion);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                             case("12"):
                                System.out.println("Introduzca el depredador a actualizar");
                                String depredador=input.nextLine();
                                System.out.println("Introduzca el depredador nuevo");
                                String nuevo_depredador=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getDepredador().equals(depredador)){
                                        consulta_fauna.setDepredador(nuevo_depredador);
                                        System.out.println("El depredador de: "+depredador+" fue actualizado a "+nuevo_depredador);
                                        exist=true;
                                        break;
                                    }
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            }
                        break;                    
                    case("5"):
                        System.out.println("Indique el criterio de eliminación que desea utilizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n");
                        String eliminacion=input.nextLine();
                        switch(eliminacion){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a eliminar");
                                String nombre_cientifico=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getNombre_cientifico().equals(nombre_cientifico)){
                                        fauna.delete(index);
                                         System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                               if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre a eliminar");
                                String nombre=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getNombre_comun().equals(nombre)){
                                        fauna.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a eliminar");
                                String ubicacion=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getUbicacion().equals(ubicacion)){
                                        fauna.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a eliminar");
                                String ecosistema=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getEcosistema().equals(ecosistema)){
                                        fauna.delete(index);
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                System.out.println("La eliminación se ha completado con exito");
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a eliminar");
                                String filo=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getFilo().equals(filo)){
                                        fauna.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca la clase a eliminar");
                                String clase=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getNombre_cientifico().equals(clase)){
                                        fauna.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a eliminar");
                                String orden=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getOrden().equals(orden)){
                                        fauna.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a eliminar");
                                String familia=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getFamilia().equals(familia)){
                                        fauna.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a eliminar");
                                String genero=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getGenero().equals(genero)){
                                        fauna.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a eliminar");
                                String especie=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getEspecie().equals(especie)){
                                        fauna.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("11"):
                                System.out.println("Introduzca la alimentacion a eliminar");
                                String alimentacion=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getAlimentacion().equals(alimentacion)){
                                        fauna.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("12"):
                                System.out.println("Introduzca el depredador a eliminar");
                                String depredador=input.nextLine();
                                temp= fauna.getNodeAt(0);
                                consulta_fauna=(Fauna) fauna.getValueOF(0);
                                start=System.currentTimeMillis();
                                index=0;
                                for (int i=0;i<fauna.size();i++){
                                    if(consulta_fauna.getDepredador().equals(depredador)){
                                        fauna.delete(index);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                    index++;
                                    temp=temp.next;
                                    if(temp!=null){
                                    consulta_fauna= (Fauna) temp.key;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("6"):
                       ciclo=false;
                       break;
                }
            }
            break;
            case ("4"):
                menu= false;
                break;
        }
        }
        

    }else if(Vwork.equals("4")){
  
        Scanner input = new Scanner(System.in);
        String objeto;
        boolean menu = true;
        String opcion="";
        boolean ciclo=true;
        long start;
        long end;
        boolean exist = false;
        while(menu){
        System.out.println("Indique sobre que elemento quiere actuar\n"
                + "1.Flora\n"
                + "2.Fauna\n"
                + "3.Ecoparques\n"
                + "4.Salir");
        ciclo=true;
        objeto=input.nextLine();
        switch (objeto){
            case ("1"):
            DynamicArray<Flora> flora = new DynamicArray<>(10);
            Flora consulta_flora;
            while(ciclo){
                System.out.println("\tECO-LOMBIA\nEscoja la accion que desea realizar en Flora\n");
                System.out.println("1.Insertar un numero de datos\n"+
                        "2.Insertar un dato\n"+
                        "3.Buscar un dato\n"+
                        "4.Actualizar un dato\n"+
                        "5.Eliminar un dato\n"
                        + "6.Salir");
                try{
                    opcion= console.readLine();
                }catch(IOException ex){
                    ex.getMessage();
                }
                switch(opcion){
                    case "1":
                        start=System.currentTimeMillis();
                        try{
                            String separador =System.getProperty("file.separator");
                            File f = new File("data"+separador+"Flora_10mil.txt");
                            FileReader lectorArchivo=new FileReader(f);
                            BufferedReader br = new BufferedReader(lectorArchivo);
                            //String l="";
                            String aux="";
                            while(true){
                                aux=br.readLine();
                                if(aux==null)break;
                                String[] atributos=aux.split(";");
                                flora.push(new Flora(atributos[0]
                                         ,atributos[1],atributos[2],atributos[3],atributos[4],
                                          atributos[5],atributos[6],atributos[7],atributos[8],atributos[9]));                                             
                                } 
                            br.close();
                            lectorArchivo.close();
                        }
                        catch(Exception e){
                        System.out.println("error  "+e );
                        System.out.println(e.getMessage());
                        }end = System.currentTimeMillis();
                        System.out.println(end - start);
                        break;
                    case("2"):
                        String[] datos= new String[10];
                        System.out.println("Inserte los datos con el orden de:\n"
                                + "Nombre Cientifico, Nombre comun, Ubicacion, Ecosistema, Filo, Clase, Orden, Familia, Genero y Especie\n"
                                + "En caso de no conocer algun dato, escriba la palabra 'null'");
                        for (int i =0;i<datos.length;i++){
                            datos[i]=input.nextLine();
                        }
                        start=System.currentTimeMillis();
                        flora.push(new Flora(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],
                                            datos[6],datos[7],datos[8],datos[9]));
                        end=System.currentTimeMillis();
                        System.out.println(end-start);
                        break;
                    case("3"):
                        System.out.println("Indique el criterio de busqueda que desea utilizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n");
                        String busqueda=input.nextLine();
                        switch(busqueda){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a buscar");
                                String nombre_cientifico=input.nextLine();
                                start=System.currentTimeMillis();
                                for(int i = 0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getNombre_cientifico().equals(nombre_cientifico)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre comun a buscar");
                                String nombre_comun=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getNombre_comun().equals(nombre_comun)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a buscar");
                                String ubicacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getUbicacion().equals(ubicacion)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a buscar");
                                String ecosistema=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getEcosistema().equals(ecosistema)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a buscar");
                                String filo=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getFilo().equals(filo)){
                                        System.out.println(consulta_flora);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca la clase a buscar");
                                String clase=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getClase().equals(clase)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a buscar");
                                String orden=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getOrden().equals(orden)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a buscar");
                                String familia=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getFamilia().equals(familia)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a buscar");
                                String genero=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getGenero().equals(genero)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a buscar");
                                String especie=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getEspecie().equals(especie)){
                                        System.out.println(consulta_flora.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("4"):
                        System.out.println("Indique el criterio que desea actualizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n");
                        String actualizar=input.nextLine();
                        switch(actualizar){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a actualizar");
                                String nombre_cientifico=input.nextLine();
                                System.out.println("Introduzca el nombre cientifico nuevo");
                                String nuevo_nombre_cientifico=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getNombre_cientifico().equals(nombre_cientifico)){
                                        consulta_flora.setNombre_cientifico(nuevo_nombre_cientifico);
                                        System.out.println("El nombre cientifico de: "+nombre_cientifico+" fue actualizado a "+nuevo_nombre_cientifico);
                                        exist=true;        
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre comun a actualizar");
                                String nombre_comun=input.nextLine();
                                System.out.println("Introduzca el nombre comun nuevo");
                                String nuevo_nombre_comun=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getNombre_comun().equals(nombre_comun)){
                                        consulta_flora.setNombre_comun(nuevo_nombre_comun);
                                        System.out.println("El nombre comun de: "+nombre_comun+" fue actualizado a "+nuevo_nombre_comun);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a actualizar");
                                String ubicacion=input.nextLine();
                                System.out.println("Introduzca la ubicacion nueva");
                                String nueva_ubicacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getUbicacion().equals(ubicacion)){
                                        consulta_flora.setUbicacion(nueva_ubicacion);
                                        System.out.println("La ubicacion de: "+ubicacion+" fue actualizada a "+nueva_ubicacion);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a actualizar");
                                String ecosistema=input.nextLine();
                                System.out.println("Introduzca el ecosistema nuevo");
                                String nuevo_ecosistema=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getEcosistema().equals(ecosistema)){
                                        consulta_flora.setEcosistema(nuevo_ecosistema);
                                        System.out.println("El ecosistema de: "+ecosistema+" fue actualizado a "+nuevo_ecosistema);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a actualizar");
                                String filo=input.nextLine();
                                System.out.println("Introduzca el filo nuevo");
                                String nuevo_filo=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getFilo().equals(filo)){
                                        consulta_flora.setFilo(nuevo_filo);
                                        System.out.println("El filo de: "+filo+" fue actualizado a "+nuevo_filo);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca la clase a actualizar");
                                String clase=input.nextLine();
                                System.out.println("Introduzca la clase nueva nuevo");
                                String nueva_clase=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getClase().equals(clase)){
                                        consulta_flora.setClase(nueva_clase);
                                        System.out.println("La clase de: "+clase+" fue actualizada a "+nueva_clase);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a actualizar");
                                String orden=input.nextLine();
                                System.out.println("Introduzca el orden nuevo");
                                String nuevo_orden=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getOrden().equals(orden)){
                                        consulta_flora.setOrden(nuevo_orden);
                                        System.out.println("El orden de: "+orden+" fue actualizado a "+nuevo_orden);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a actualizar");
                                String familia=input.nextLine();
                                System.out.println("Introduzca la familia nueva");
                                String nueva_familia=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getFamilia().equals(familia)){
                                        consulta_flora.setFamilia(nueva_familia);
                                        System.out.println("La familia de: "+familia+" fue actualizada a "+nueva_familia);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a actualizar");
                                String genero=input.nextLine();
                                System.out.println("Introduzca el genero nuevo");
                                String nuevo_genero=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getGenero().equals(genero)){
                                        consulta_flora.setGenero(nuevo_genero);
                                        System.out.println("El genero de: "+genero+" fue actualizado a "+nuevo_genero);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a actualizar");
                                String especie=input.nextLine();
                                System.out.println("Introduzca la especie nueva");
                                String nueva_especie=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getEspecie().equals(especie)){
                                        consulta_flora.setEspecie(nueva_especie);
                                        System.out.println("La especie de: "+especie+" fue actualizada a "+nueva_especie);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            }
                        break;                    
                    case("5"):
                        System.out.println("Indique el criterio de eliminación que desea utilizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n");
                        String eliminacion=input.nextLine();
                        switch(eliminacion){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a eliminar");
                                String nombre_cientifico=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getNombre_cientifico().equals(nombre_cientifico)){
                                        flora.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre comun a eliminar");
                                String nombre_comun=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getNombre_comun().equals(nombre_comun)){
                                        flora.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a eliminar");
                                String ubicacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getUbicacion().equals(ubicacion)){
                                        flora.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a eliminar");
                                String ecosistema=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getEcosistema().equals(ecosistema)){
                                        flora.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a eliminar");
                                String filo=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getFilo().equals(filo)){
                                        flora.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca la clase a eliminar");
                                String clase=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getClase().equals(clase)){
                                        flora.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a eliminar");
                                String orden=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getOrden().equals(orden)){
                                        flora.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a eliminar");
                                String familia=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getFamilia().equals(familia)){
                                        flora.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a eliminar");
                                String genero=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getGenero().equals(genero)){
                                        flora.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a eliminar");
                                String especie=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<flora.size();i++){
                                    consulta_flora= (Flora) flora.value(i);
                                    if(consulta_flora.getEspecie().equals(especie)){
                                        flora.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("6"):
                       ciclo=false;
                       break;
                }
            }
            break;
            case ("3"):
            DynamicArray<Ecoparque> ecoparque = new DynamicArray<>(10);
            Ecoparque consulta_ecoparque;
            while(ciclo){
                System.out.println("\tECO-LOMBIA\nEscoja la accion que desea realizar en Ecoparques\n");
                System.out.println("1.Insertar un numero de datos\n"+
                        "2.Insertar un dato\n"+
                        "3.Buscar un dato\n"+
                        "4.Actualizar un dato\n"+
                        "5.Eliminar un dato\n"
                        + "6.Salir");
                try{
                    opcion= console.readLine();
                }catch(IOException ex){
                    ex.getMessage();
                }
                switch(opcion){
                    case "1":
                        start=System.currentTimeMillis();
                        try{
                            String separador =System.getProperty("file.separator");
                            File f = new File("data"+separador+"Ecoparques_10mil.txt");
                            FileReader lectorArchivo=new FileReader(f);
                            BufferedReader br = new BufferedReader(lectorArchivo);
                            //String l="";
                            String aux="";
                            while(true){
                                aux=br.readLine();
                                if(aux==null)break;
                                String[] atributos=aux.split(";");
                                ecoparque.push(new Ecoparque(atributos[0]
                                         ,atributos[1],atributos[2],atributos[3]));                                             
                                } 
                            br.close();
                            lectorArchivo.close();
                        }
                        catch(Exception e){
                        System.out.println("error  "+e );
                        System.out.println(e.getMessage());
                        }end = System.currentTimeMillis();
                        System.out.println(end - start);
                        break;
                    case("2"):
                        String[] datos= new String[4];
                        System.out.println("Inserte los datos con el orden de:\n"
                                + "Nombre, Ubicacion, Ecosistema, Interes\n"
                                + "En caso de no conocer algun dato, escriba la palabra 'null'");
                        for (int i =0;i<datos.length;i++){
                            datos[i]=input.nextLine();
                        }
                        start=System.currentTimeMillis();
                        ecoparque.push(new Ecoparque(datos[0],datos[1],datos[2],datos[3]));
                        end=System.currentTimeMillis();
                        System.out.println(end-start);
                        break;
                    case("3"):
                        System.out.println("Indique el criterio de busqueda que desea utilizar\n"
                                + "1.Nombre\n"
                                + "2.Ubicacion\n"
                                + "3.Ecosistema\n"
                                + "4.Interes\n");
                        String busqueda=input.nextLine();
                        switch(busqueda){
                            case("1"):
                                System.out.println("Introduzca el nombre a buscar");
                                String nombre=input.nextLine();
                                start=System.currentTimeMillis();
                                for(int i = 0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getNombre().equals(nombre)){
                                        System.out.println(consulta_ecoparque.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca la ubicacion a buscar");
                                String ubicacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getUbicacion().equals(ubicacion)){
                                        System.out.println(consulta_ecoparque.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca el ecosistema actualizar");
                                String ecosistema=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getUbicacion().equals(ecosistema)){
                                        System.out.println(consulta_ecoparque.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el interes a buscar");
                                String interes=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getInteres().equals(interes)){
                                        System.out.println(consulta_ecoparque.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("4"):
                        System.out.println("Indique el criterio de busqueda que desea utilizar\n"
                                + "1.Nombre\n"
                                + "2.Ubicacion\n"
                                + "3.Ecosistema\n"
                                + "4.Interes\n");
                        String actualizar=input.nextLine();
                        switch(actualizar){
                            case("1"):
                                System.out.println("Introduzca el nombre a actualizar");
                                String nombre=input.nextLine();
                                System.out.println("Introduzca el nombre nuevo");
                                String nuevo_nombre=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getNombre().equals(nombre)){
                                        consulta_ecoparque.setNombre(nuevo_nombre);
                                        System.out.println("El nombre de: "+nombre+" fue actualizado a "+nuevo_nombre);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca la ubicacion a actualizar");
                                String ubicacion=input.nextLine();
                                System.out.println("Introduzca la ubicacion nueva");
                                String nueva_ubicacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getUbicacion().equals(ubicacion)){
                                        consulta_ecoparque.setUbicacion(nueva_ubicacion);
                                        System.out.println("La ubicacion de: "+ubicacion+" fue actualizada a "+nueva_ubicacion);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca el ecosistema a actualizar");
                                String ecosistema=input.nextLine();
                                System.out.println("Introduzca el ecosistema nuevo");
                                String nuevo_ecosistema=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getUbicacion().equals(ecosistema)){
                                        consulta_ecoparque.setUbicacion(nuevo_ecosistema);
                                        System.out.println("El ecosistema de: "+ecosistema+" fue actualizado a "+nuevo_ecosistema);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el interes a actualizar");
                                String interes=input.nextLine();
                                System.out.println("Introduzca el interes nuevo");
                                String nuevo_interes=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getInteres().equals(interes)){
                                        consulta_ecoparque.setInteres(nuevo_interes);
                                        System.out.println("El interes de: "+interes+" fue actualizado a "+nuevo_interes);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            }
                        break;                    
                    case("5"):
                        System.out.println("Indique el criterio de eliminacion que desea utilizar\n"
                                + "1.Nombre\n"
                                + "2.Ubicacion\n"
                                + "3.Ecosistema\n"
                                + "4.Interes\n");
                        String eliminacion=input.nextLine();
                        switch(eliminacion){
                            case("1"):
                                System.out.println("Introduzca el nombre a eliminar");
                                String nombre=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getNombre().equals(nombre)){
                                        ecoparque.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca la ubicacion a eliminar");
                                String ubicacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getUbicacion().equals(ubicacion)){
                                        ecoparque.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ecosistema a eliminar");
                                String ecosistema=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getEcosistema().equals(ecosistema)){
                                        ecoparque.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el interes a eliminar");
                                String interes=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<ecoparque.size();i++){
                                    consulta_ecoparque= (Ecoparque) ecoparque.value(i);
                                    if(consulta_ecoparque.getInteres().equals(interes)){
                                        ecoparque.delete(i);
                                        System.out.println("La eliminacion se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("6"):
                       ciclo=false;
                       break;
                }
                
            }
            break;
            case("2"):
            DynamicArray<Fauna> fauna = new DynamicArray<>(10);
            Fauna consulta_fauna;
            while(ciclo){
                System.out.println("\tECO-LOMBIA\nEscoja la accion que desea realizar en Fauna\n");
                System.out.println("1.Insertar un numero de datos\n"+
                        "2.Insertar un dato\n"+
                        "3.Buscar un dato\n"+
                        "4.Actualizar un dato\n"+
                        "5.Eliminar un dato\n"
                        + "6.Salir");
                try{
                    opcion= console.readLine();
                }catch(IOException ex){
                    ex.getMessage();
                }
                switch(opcion){
                    case "1":
                        start=System.currentTimeMillis();
                        try{
                            String separador =System.getProperty("file.separator");
                            File f = new File("data"+separador+"Fauna_10mil.txt");
                            FileReader lectorArchivo=new FileReader(f);
                            BufferedReader br = new BufferedReader(lectorArchivo);
                            //String l="";
                            String aux="";
                            while(true){
                                aux=br.readLine();
                                if(aux==null)break;
                                String []atributos=aux.split(";");
                                fauna.push(new Fauna(atributos[0]
                                         ,atributos[1],atributos[2],atributos[3],atributos[4],
                                          atributos[5],atributos[6],atributos[7],atributos[8],atributos[9],
                                            atributos[10],atributos[11]));                                             
                                } 
                            br.close();
                            lectorArchivo.close();
                        }
                        catch(Exception e){
                        System.out.println("error  "+e );
                        System.out.println(e.getMessage());
                        }end = System.currentTimeMillis();
                        System.out.println(end - start);
                        break;
                    case("2"):
                        String[] datos= new String[12];
                        System.out.println("Inserte los datos con el orden de:\n"
                                + "Nombre Cientifico, Nombre comun, Ubicacion, Ecosistema, Filo, Clase\n"
                                + ", Orden, Familia, Genero, Alimentacion, Depredador y Especie\n"
                                + "En caso de conocer no algun dato, escriba la palabra 'null'");
                        for (int i =0;i<datos.length;i++){
                            datos[i]=input.nextLine();
                        }
                        start=System.currentTimeMillis();
                        fauna.push(new Fauna(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],
                                            datos[6],datos[7],datos[8],datos[9],datos[10],datos[11]));
                        end=System.currentTimeMillis();
                        System.out.println(end-start);
                        break;
                    case("3"):
                        System.out.println("Indique el criterio de busqueda que desea utilizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n"
                                + "11.Alimentacion\n"
                                + "12.Depredador");
                        String busqueda=input.nextLine();
                        switch(busqueda){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a buscar");
                                String nombre_cientifico=input.nextLine();
                                start=System.currentTimeMillis();
                                for(int i = 0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getNombre_cientifico().equals(nombre_cientifico)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre comun a buscar");
                                String nombre_comun=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getNombre_comun().equals(nombre_comun)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a buscar");
                                String ubicacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getUbicacion().equals(ubicacion)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a buscar");
                                String ecosistema=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getEcosistema().equals(ecosistema)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a buscar");
                                String filo=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getFilo().equals(filo)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca el clase a buscar");
                                String clase=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getClase().equals(clase)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a buscar");
                                String orden=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getOrden().equals(orden)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a buscar");
                                String familia=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getFamilia().equals(familia)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a buscar");
                                String genero=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getGenero().equals(genero)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a buscar");
                                String especie=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getEspecie().equals(especie)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("11"):
                                System.out.println("Introduzca la alimentacion a buscar");
                                String alimentacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getAlimentacion().equals(alimentacion)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("12"):
                                System.out.println("Introduzca el depredador a buscar");
                                String depredador=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getDepredador().equals(depredador)){
                                        System.out.println(consulta_fauna.toString());
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("4"):
                        System.out.println("Indique el criterio que desea actualizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n"
                                + "11.Alimentacion\n"
                                + "12.Depredador");
                        String actualizar=input.nextLine();
                        switch(actualizar){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a actualizar");
                                String nombre_cientifico=input.nextLine();
                                System.out.println("Introduzca el nombre cientifico nuevo");
                                String nuevo_nombre_cientifico=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getNombre_cientifico().equals(nombre_cientifico)){
                                        consulta_fauna.setNombre_cientifico(nuevo_nombre_cientifico);
                                        System.out.println("El nombre cientifico de: "+nombre_cientifico+" fue actualizado a "+nuevo_nombre_cientifico);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre a actualizar");
                                String nombre=input.nextLine();
                                System.out.println("Introduzca el nombre nuevo");
                                String nuevo_nombre=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getNombre_comun().equals(nombre)){
                                        consulta_fauna.setNombre_comun(nuevo_nombre);
                                        System.out.println("El nombre de: "+nombre+" fue actualizado a "+nuevo_nombre);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a actualizar");
                                String ubicacion=input.nextLine();
                                System.out.println("Introduzca la ubicacion nueva");
                                String nueva_ubicacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getUbicacion().equals(ubicacion)){
                                        consulta_fauna.setUbicacion(nueva_ubicacion);
                                        System.out.println("La ubicacion de: "+ubicacion+" fue actualizada a "+nueva_ubicacion);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a actualizar");
                                String ecosistema=input.nextLine();
                                System.out.println("Introduzca el ecosistema nuevo");
                                String nuevo_ecosistema=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getEcosistema().equals(ecosistema)){
                                        consulta_fauna.setEcosistema(nuevo_ecosistema);
                                        System.out.println("El ecosistema de: "+ecosistema+" fue actualizado a "+nuevo_ecosistema);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a actualizar");
                                String filo=input.nextLine();
                                System.out.println("Introduzca el filo nuevo");
                                String nuevo_filo=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getFilo().equals(filo)){
                                        consulta_fauna.setFilo(nuevo_filo);
                                        System.out.println("El filo de: "+filo+" fue actualizado a "+nuevo_filo);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca la clase a actualizar");
                                String clase=input.nextLine();
                                System.out.println("Introduzca la clase nueva");
                                String nueva_clase=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getClase().equals(clase)){
                                        consulta_fauna.setClase(nueva_clase);
                                        System.out.println("La clase de: "+clase+" fue actualizada a "+nueva_clase);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a actualizar");
                                String orden=input.nextLine();
                                System.out.println("Introduzca el orden nuevo");
                                String nuevo_orden=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getOrden().equals(orden)){
                                        consulta_fauna.setOrden(nuevo_orden);
                                        System.out.println("El orden de: "+orden+" fue actualizado a "+nuevo_orden);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a actualizar");
                                String familia=input.nextLine();
                                System.out.println("Introduzca la familia nueva");
                                String nueva_familia=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getFamilia().equals(familia)){
                                        consulta_fauna.setFamilia(nueva_familia);
                                        System.out.println("La familia de: "+familia+" fue actualizada a "+nueva_familia);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a actualizar");
                                String genero=input.nextLine();
                                System.out.println("Introduzca el genero nuevo");
                                String nuevo_genero=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getGenero().equals(genero)){
                                        consulta_fauna.setGenero(nuevo_genero);
                                        System.out.println("El genero de: "+genero+" fue actualizado a "+nuevo_genero);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a actualizar");
                                String especie=input.nextLine();
                                System.out.println("Introduzca la especie nueva");
                                String nueva_especie=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getEspecie().equals(especie)){
                                        consulta_fauna.setEspecie(nueva_especie);
                                        System.out.println("La especie de: "+especie+" fue actualizada a "+nueva_especie);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("11"):
                                System.out.println("Introduzca la alimentacion a actualizar");
                                String alimentacion=input.nextLine();
                                System.out.println("Introduzca la alimentacion nueva");
                                String nueva_alimentacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getAlimentacion().equals(alimentacion)){
                                        consulta_fauna.setAlimentacion(nueva_alimentacion);
                                        System.out.println("La alimentacion de: "+alimentacion+" fue actualizada a "+nueva_alimentacion);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                             case("12"):
                                System.out.println("Introduzca el depredador a actualizar");
                                String depredador=input.nextLine();
                                System.out.println("Introduzca el depredador nuevo");
                                String nuevo_depredador=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getDepredador().equals(depredador)){
                                        consulta_fauna.setDepredador(nuevo_depredador);
                                        System.out.println("El depredador de: "+depredador+" fue actualizado a "+nuevo_depredador);
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            }
                        break;                    
                    case("5"):
                        System.out.println("Indique el criterio de eliminación que desea utilizar\n"
                                + "1.Nombre Cientifico\n"
                                + "2.Nombre comun\n"
                                + "3.Ubicacion\n"
                                + "4.Ecosistema\n"
                                + "5.Filo\n"
                                + "6.Clase\n"
                                + "7.Orden\n"
                                + "8.Familia\n"
                                + "9.Genero\n"
                                + "10.Especie\n");
                        String eliminacion=input.nextLine();
                        switch(eliminacion){
                            case("1"):
                                System.out.println("Introduzca el nombre cientifico a eliminar");
                                String nombre_cientifico=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getNombre_cientifico().equals(nombre_cientifico)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("2"):
                                System.out.println("Introduzca el nombre a eliminar");
                                String nombre=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getNombre_comun().equals(nombre)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("3"):
                                System.out.println("Introduzca la ubicacion a eliminar");
                                String ubicacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getUbicacion().equals(ubicacion)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("4"):
                                System.out.println("Introduzca el ecosistema a eliminar");
                                String ecosistema=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getEcosistema().equals(ecosistema)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("5"):
                                System.out.println("Introduzca el filo a eliminar");
                                String filo=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getFilo().equals(filo)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("6"):
                                System.out.println("Introduzca la clase a eliminar");
                                String clase=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getNombre_cientifico().equals(clase)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("7"):
                                System.out.println("Introduzca el orden a eliminar");
                                String orden=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getOrden().equals(orden)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("8"):
                                System.out.println("Introduzca la familia a eliminar");
                                String familia=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getFamilia().equals(familia)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("9"):
                                System.out.println("Introduzca el genero a eliminar");
                                String genero=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getGenero().equals(genero)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("10"):
                                System.out.println("Introduzca la especie a eliminar");
                                String especie=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getEspecie().equals(especie)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("11"):
                                System.out.println("Introduzca la alimentacion a eliminar");
                                String alimentacion=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getAlimentacion().equals(alimentacion)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                            case("12"):
                                System.out.println("Introduzca el depredador a eliminar");
                                String depredador=input.nextLine();
                                start=System.currentTimeMillis();
                                for (int i=0;i<fauna.size();i++){
                                    consulta_fauna= (Fauna) fauna.value(i);
                                    if(consulta_fauna.getDepredador().equals(depredador)){
                                        fauna.delete(i);
                                        System.out.println("La eliminación se ha completado con exito");
                                        exist=true;
                                        break;
                                    }
                                }
                                if (! exist){
                                    System.out.println("El elemento indicado no fue encontrado");
                                }
                                exist=false;
                                end=System.currentTimeMillis();
                                System.out.println(end-start);
                                break;
                        }
                        break;
                    case("6"):
                       ciclo=false;
                       break;
                }
            }
            break;
            case ("4"):
                menu= false;
                break;
        }
        }
     
        
//////////////////////////////////////////////////////////////////////////////////////
        }else if(Vwork.equals("5")){
    int pagenum, resperpage;
        pagenum=1;
        resperpage=10;
        boolean flor, faun, ecop;
        flor=faun=ecop=false;
        DynamicArray<DBFlora>  resultados = new DynamicArray<>(7);
        DynamicArray<DBFauna>  rFauna = new DynamicArray<>(7);
        DynamicArray<DBEcoparks>  rEcoparks = new DynamicArray<>(7);
//        DatosBusqueda ab= new DatosBusqueda(a,b,c,d,e,f,g);
//        resultados.push(h);
//        System.out.println(resultados.ar<reglo[0].getEspecie());
        InputStreamReader isr1 = new InputStreamReader(System.in);
        BufferedReader console1 = new BufferedReader(isr1);
        String opcion=null;
        boolean ciclo=true;
        long inicio;
        long fin;
        String separador=System.getProperty("file.separator");
                                   File f = new File("data"+separador+"Flora_500mil.txt");;
                                   FileReader lectorArchivo=new FileReader(f);
                                   BufferedReader br = new BufferedReader(lectorArchivo);
        String aux;
                                   File g = new File("data"+separador+"Fauna_500mil.txt");;
                                   FileReader lectorArchivo1=new FileReader(g);
                                   BufferedReader br1 = new BufferedReader(lectorArchivo1);
        String aux1;
                                   File h = new File("data"+separador+"Ecoparques_500mil.txt");;
                                   FileReader lectorArchivo2=new FileReader(h);
                                   BufferedReader br2 = new BufferedReader(lectorArchivo2);
        String aux2;

        while (true) {
            aux = br.readLine();
            if (aux == null) {
                break;
            }
            String[] atributos = aux.split(";");
            DBFlora a = new DBFlora(atributos[0], atributos[1], atributos[2], atributos[3], atributos[4], atributos[5], atributos[6], atributos[7], atributos[8], atributos[9]);
            resultados.push(a);
            
            aux1 = br1.readLine();
            if (aux1 == null) {
                break;
            }
            String[] atributos1 = aux1.split(";");
            DBFauna b = new DBFauna(atributos1[0], atributos1[1], atributos1[2], atributos1[3], atributos1[4], atributos1[5], atributos1[6], atributos1[7], atributos1[8], atributos1[9], atributos1[10]);
            rFauna.push(b);
            
            aux2 = br2.readLine();
            if (aux2 == null) {
                break;
            }
            String[] atributos2 = aux2.split(";");
            DBEcoparks c = new DBEcoparks(atributos2[0], atributos2[1], atributos2[2], atributos2[3]);
            rEcoparks.push(c);
            
//            System.out.println(resultados.value(0).toString());
            
            //System.out.println(a.getClasses());
        }
        System.out.println("# de resultados Flora:  "+resultados.size);
        System.out.println("# de resultados Fauna:  "+rFauna.size);
        System.out.println("# de resultados Eco-parques:  "+rEcoparks.size);
       while(ciclo){
               System.out.println("\tECO-LOMBIA\nEscoja la acción que desea realizar\n");
               System.out.print("1.Resultados Flora\n"
                       + "2.Resultados Fauna\n"
                       + "3.Resultados Ecoparques\n"
                       + "4.Avanzar Página\n"
                       + "5.Retroceder Página\n"
                       + "6.10 resultados por página\n"
                       + "7.20 resultados por página \n"
                       + "8.50 resultados por página\n"
                       + "9.Salir\n");
            try {
                opcion= console1.readLine();
            } catch (IOException ex) {
                ex.getMessage();
            }
                       switch(opcion){
                           case "1":
                           flor=true;
                           faun=false;
                           ecop=false;
                           pagenum=1;
                           break;
                           case "2":
                           flor=false;
                           faun=true;
                           ecop=false;
                           pagenum=1;
                           break;
                           case "3":
                           flor=false;
                           faun=false;
                           ecop=true;
                           pagenum=1;
                           break;
                           case "4":
                           pagenum ++;
                           break;
                           case "5":
                           pagenum --;
                         
                           if(pagenum<1){
                               pagenum=1;
                           }
                           break;
                           case "6":
                           resperpage=10;
                           break;
                           case "7":
                           resperpage=20;
                           break;
                           case "8":
                           resperpage=50;
                           break;
                           case "9":
                           flor=false;
                           faun=false;
                           ecop=false;
                           pagenum=0;
                           break;
                       }
       System.out.println("Página: "+pagenum);
       if(flor==true){
       for(int i=0;i<resultados.size;i++){
        if(i<pagenum*resperpage&&i>=(pagenum-1)*resperpage){
            
            System.out.println((i+1)+". "+resultados.value(i).toString());
        }
       }
        }
       else if(faun==true){
       for(int i=0;i<rFauna.size;i++){
        if(i<pagenum*resperpage&&i>=(pagenum-1)*resperpage){
            
            System.out.println((i+1)+". "+rFauna.value(i).toString());
        }
       }
       }
       
       if(ecop==true){
       for(int i=0;i<rEcoparks.size;i++){
        if(i<pagenum*resperpage&&i>=(pagenum-1)*resperpage){
            
            System.out.println((i+1)+". "+ rEcoparks.value(i).toString());
        }
       }
        }

        
        //br.close();
        //lectorArchivo.close();
        //String a= resultados.array[0].getClasses();
        
        
        }
       
       
    }  
    }
}
 
    

>>>>>>> f92f7fb4e4ac9d1a659a2ffea2fb90eccfbac6c4
