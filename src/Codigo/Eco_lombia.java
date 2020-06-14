package Codigo;

import Interface.Ventana;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;




public class Eco_lombia {

 //////////////////////////////////////////////////   
    public static void InsetUsuarios(AVLUsuarios Usuarios){
        long inicio = System.currentTimeMillis();

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
                                       Usuarios.root=Usuarios.insert(Usuarios.root,new UsuarioRegistrado(atributos[0]
                                           ,atributos[1],atributos[2],atributos[3],atributos[4],
                                           atributos[5],atributos[6]));      
                                       //System.out.println(atributos[0]);
                                   } 
                                   br.close();
                                   lectorArchivo.close();
                               }catch(Exception e){
                                   System.out.println("error  "+e );
                                   System.out.println(e.getMessage());
                               }
                                long fin = System.currentTimeMillis();
                                System.out.println("Inserción masiva"+(fin - inicio));
        
    }
    
    public static void insertar(AVLUsuarios Usuarios,UsuarioRegistrado U){

                                    long inicio = System.currentTimeMillis();
                                    Usuarios.root=Usuarios.insert(Usuarios.root,U);
                                    long fin = System.currentTimeMillis();
                                     System.out.println("Inserción de un dato"+(fin - inicio));
        
    }
    
    public static void contraseñaCambio(AVLUsuarios Usuarios,String C1,String id){
                                        long inicio = System.currentTimeMillis();
                                        
                                        UsuarioRegistrado Ucambio=new UsuarioRegistrado(null
                                            ,null,null,null,null,
                                            null,id);
                                        Ucambio=Usuarios.Find(Usuarios.root, Ucambio).key;
                                        if(Ucambio==null){
                                            System.out.println("Usuario No encontrado");
                                        }else{
                                            Ucambio.setPassword(C1);
                                            System.out.println("Contraseña cambiada");
                                            }
                                            long fin = System.currentTimeMillis();
                                             System.out.println("Actualización"+(fin - inicio));
                                        
                                   
    }
    
    public static UsuarioRegistrado buscarXid(AVLUsuarios Usuarios,String id){
                         
                long inicio = System.currentTimeMillis();
                UsuarioRegistrado Ucambio=new UsuarioRegistrado(null
                    ,null,null,null,null,
                    null,id);
                Ucambio=Usuarios.Find(Usuarios.root, Ucambio).key;
                if(Ucambio==null){
                    JOptionPane.showMessageDialog(null,"Usuario No encontrado");
                }else{
                    long fin = System.currentTimeMillis();
                     System.out.println("busqueda "+(fin - inicio));;
                }
                return Ucambio;

    }
    
    public static void SalirUsuarios(AVLUsuarios Usuarios){
        long inicio = System.currentTimeMillis();
         OutputStream       outputStream;
                               if(!(Usuarios.root==null)){
                                    try {
                                        String separador=System.getProperty("file.separator");
                                        File f = new File("data"+separador+"Salida.txt");
                                        outputStream = new FileOutputStream(f.getAbsolutePath());
                                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                                        Usuarios.preOrderOutput(Usuarios.root,outputStreamWriter);
          
                                        outputStreamWriter.close();
                                    } catch (Exception ex) {
                                        Logger.getLogger(Eco_lombia.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                               }
                               long fin = System.currentTimeMillis();
                               long result=fin-inicio;
                                System.out.println("Almacenado masiva"+(result));
    }
    //ESPECIES    
 ////////////////////////////////////////////////////////////////
    public static void insertarFlora(DynamicArray flora, String info){
        long end;
        long start;
        int id;
        Flora_Node result;
        Flora temp;
        AVL_Flora avlf = new AVL_Flora();
        try{
            String[] datos= info.split("/");
            start=System.currentTimeMillis();
            id=Integer.parseInt(datos[0]);
            temp= new Flora(id,null,null,null,null,null,null,null,null,null,null);
            for(int i=0;i<flora.size();i++){
                avlf.root=avlf.insert(avlf.root,(Flora)flora.value(i));
            }
            result = avlf.Find(avlf.root,temp);
            if(result!=null){
               JOptionPane.showMessageDialog(null,"El id ingresado ya existe");
            }else{
                flora.push(new Flora(id,datos[1],datos[2],datos[3],datos[4],datos[5],
                                datos[6],datos[7],datos[8],datos[9],datos[10]));
                JOptionPane.showMessageDialog(null,"Flora añadido correctamente");
            }
            end=System.currentTimeMillis();
            System.out.println(end-start);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error no se pudo realizar el aporte");
            System.out.println(e);
        }
    }
  
    
    
    public static DynamicArray buscarIdFlora(DynamicArray flora, int idb){
        long start;
        long end;
        AVL_Flora avlf = new AVL_Flora();
        
        start=System.currentTimeMillis();
        Flora aux= new Flora(idb,null,null,null,null,null,null,null,null,null,null);
        for(int i=0;i<flora.size();i++){
            avlf.root=avlf.insert(avlf.root,(Flora)flora.value(i));
        }
        Flora_Node result = avlf.Find(avlf.root,aux);
           
        if(result==null){
            JOptionPane.showMessageDialog(null, "Id no encontrado");
        }
        result.key.busquedas++;
        DynamicArray finds= new DynamicArray(10);
        finds.push((Flora)result.key);
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }

    
    
    public static DynamicArray buscarNombreCientificoFlora(DynamicArray flora, String nombre_cientifico){
        long start;
        long end;
        Flora consulta_flora;
        boolean exist = false;
        DynamicArray finds = new DynamicArray(10);
        System.out.println("Introduzca el nombre cientifico a buscar");
            start=System.currentTimeMillis();
            for(int i = 0;i<flora.size();i++){
                consulta_flora= (Flora) flora.value(i);
                if(consulta_flora.getNombre_cientifico().equals(nombre_cientifico)){
                    //System.out.println(consulta_flora.toString());
                    consulta_flora.busquedas++;
                    exist=true;
                    finds.push((Flora)consulta_flora);
                }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedaNombreComunFlora(DynamicArray flora, String nombre_comun){
        long start;
        long end;
        Flora consulta_flora;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        System.out.println("Introduzca el nombre comun a buscar");
        start=System.currentTimeMillis();
        for (int i=0;i<flora.size();i++){
            consulta_flora= (Flora) flora.value(i);
            if(consulta_flora.getNombre_comun().equals(nombre_comun)){
                //System.out.println(consulta_flora.toString());
                exist=true;
                consulta_flora.busquedas++;
                finds.push((Flora)consulta_flora);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedaUbicacionFlora(DynamicArray flora, String ubicacion){
        long start;
        long end;
        Flora consulta_flora;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        System.out.println("Introduzca la ubicacion a buscar");
        start=System.currentTimeMillis();
        for (int i=0;i<flora.size();i++){
            consulta_flora= (Flora) flora.value(i);
            if(consulta_flora.getUbicacion().equals(ubicacion)){
                //System.out.println(consulta_flora.toString());
                exist=true;
                consulta_flora.busquedas++;
                finds.push((Flora)consulta_flora);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedaEcosistemaFlora(DynamicArray flora, String ecosistema){
        long start;
        long end;
        Flora consulta_flora;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        System.out.println("Introduzca el ecosistema a buscar");
        start=System.currentTimeMillis();
        for (int i=0;i<flora.size();i++){
            consulta_flora= (Flora) flora.value(i);
            if(consulta_flora.getEcosistema().equals(ecosistema)){
                //System.out.println(consulta_flora.toString());
                exist=true;
                consulta_flora.busquedas++;
                finds.push((Flora)consulta_flora);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedaFiloFlora(DynamicArray flora, String filo){
        long start;
        long end;
        Flora consulta_flora;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        System.out.println("Introduzca el filo a buscar");
        start=System.currentTimeMillis();
        for (int i=0;i<flora.size();i++){
            consulta_flora= (Flora) flora.value(i);
            if(consulta_flora.getFilo().equals(filo)){
               // System.out.println(consulta_flora);
                exist=true;
                consulta_flora.busquedas++;
                finds.push((Flora)consulta_flora);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedaClaseFlora(DynamicArray flora, String clase){
        long start;
        long end;
        Flora consulta_flora;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        System.out.println("Introduzca la clase a buscar");
        start=System.currentTimeMillis();
        for (int i=0;i<flora.size();i++){
            consulta_flora= (Flora) flora.value(i);
            if(consulta_flora.getClase().equals(clase)){
               // System.out.println(consulta_flora.toString());
                exist=true;
                consulta_flora.busquedas++;
                finds.push((Flora)consulta_flora);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedaOrdenFlora(DynamicArray flora, String orden){
        long start;
        long end;
        Flora consulta_flora;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        System.out.println("Introduzca el orden a buscar");
        start=System.currentTimeMillis();
        for (int i=0;i<flora.size();i++){
            consulta_flora= (Flora) flora.value(i);
            if(consulta_flora.getOrden().equals(orden)){
                //System.out.println(consulta_flora.toString());
                exist=true;
                consulta_flora.busquedas++;
                finds.push((Flora)consulta_flora);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedaFamiliaFlora (DynamicArray flora, String familia){
        long start;
        long end;
        Flora consulta_flora;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        System.out.println("Introduzca la familia a buscar");
        start=System.currentTimeMillis();
        for (int i=0;i<flora.size();i++){
            consulta_flora= (Flora) flora.value(i);
            if(consulta_flora.getFamilia().equals(familia)){
                //System.out.println(consulta_flora.toString());
                exist=true;
                consulta_flora.busquedas++;
                finds.push((Flora)consulta_flora);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        return finds;
    }
    public static DynamicArray busquedaGeneroFlora(DynamicArray flora, String genero){
        long start;
        long end;
        Flora consulta_flora;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        System.out.println("Introduzca el genero a buscar");
        start=System.currentTimeMillis();
        for (int i=0;i<flora.size();i++){
            consulta_flora= (Flora) flora.value(i);
            if(consulta_flora.getGenero().equals(genero)){
               // System.out.println(consulta_flora.toString());
                exist=true;
                consulta_flora.busquedas++;
                finds.push((Flora)consulta_flora);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedaEspecieFlora(DynamicArray flora, String especie){
        long start;
        long end;
        Flora consulta_flora;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        System.out.println("Introduzca la especie a buscar");
        start=System.currentTimeMillis();
        for (int i=0;i<flora.size();i++){
            consulta_flora= (Flora) flora.value(i);
            if(consulta_flora.getEspecie().equals(especie)){
                //System.out.println(consulta_flora.toString());
                exist=true;
                consulta_flora.busquedas++;
                finds.push((Flora)consulta_flora);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static void actualizarFlora(DynamicArray flora, int id,String info){
        long start;
        long end;
        Flora consulta_flora;
        boolean exist=false;
        start=System.currentTimeMillis();
        String[] datos= info.split(" ");
        for (int i=0;i<flora.size();i++){
            consulta_flora= (Flora) flora.value(i);
            if(consulta_flora.id==id){
                consulta_flora.setNombre_cientifico(datos[0]);
                consulta_flora.setNombre_comun(datos[1]);
                consulta_flora.setUbicacion(datos[2]);
                consulta_flora.setEcosistema(datos[3]);
                consulta_flora.setFilo(datos[4]);
                consulta_flora.setClase(datos[5]);
                consulta_flora.setOrden(datos[6]);
                consulta_flora.setFamilia(datos[7]);
                consulta_flora.setGenero(datos[8]);
                consulta_flora.setEspecie(datos[9]);
                exist=true;        
                break;
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
    }
    public static void borrarFloraId(DynamicArray flora, int id){
        long start;
        long end;
        Flora consulta_flora;
        boolean exist=false;
        start=System.currentTimeMillis();
        for (int i=0;i<flora.size();i++){
            consulta_flora= (Flora) flora.value(i);
            if(consulta_flora.id==id){
                flora.delete(i);
                System.out.println("La eliminación se ha completado con exito");
                exist=true;
                break;
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
    }
    public static DynamicArray busquedaIdEcoparque(DynamicArray ecoparque, int id){
        long start;
        long end;
        DynamicArray finds = new DynamicArray(10);
        AVL_Ecoparques avle = new AVL_Ecoparques();
        System.out.println("Introduzca el Id a buscar");
        Ecoparque aux=new Ecoparque(id,null,null,null,null);
        start=System.currentTimeMillis();
        for(int i=0;i<ecoparque.size();i++){
            avle.root=avle.insert(avle.root, (Ecoparque)ecoparque.value(i));
        }
        Ecoparque_Node result = avle.Find(avle.root,aux);
        if(result!=null){
            finds.push((Ecoparque)result.key);
        }else{
            System.out.println("Id no encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedaNombreEcoparque(DynamicArray ecoparque, String nombre){
        long start;
        long end;
        Ecoparque consulta_ecoparque;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        System.out.println("Introduzca el nombre a buscar");
        start=System.currentTimeMillis();
        for(int i = 0;i<ecoparque.size();i++){
            consulta_ecoparque= (Ecoparque) ecoparque.value(i);
            if(consulta_ecoparque.getNombre().equals(nombre)){
                System.out.println(consulta_ecoparque.toString());
                exist=true;
                consulta_ecoparque.busquedas++;
                finds.push((Ecoparque)consulta_ecoparque);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedaUbicacionEcoparque(DynamicArray ecoparque,String ubicacion){
        long start;
        long end;
        Ecoparque consulta_ecoparque;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        System.out.println("Introduzca la ubicacion a buscar");
        start=System.currentTimeMillis();
        for (int i=0;i<ecoparque.size();i++){
            consulta_ecoparque= (Ecoparque) ecoparque.value(i);
            if(consulta_ecoparque.getUbicacion().equals(ubicacion)){
                System.out.println(consulta_ecoparque.toString());
                exist=true;
                consulta_ecoparque.busquedas++;
                finds.push((Ecoparque)consulta_ecoparque);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedaEcosistemaEcoparque(DynamicArray ecoparque, String ecosistema){
        long start;
        long end;
        Ecoparque consulta_ecoparque;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        System.out.println("Introduzca el ecosistema actualizar");
        start=System.currentTimeMillis();
        for (int i=0;i<ecoparque.size();i++){
            consulta_ecoparque= (Ecoparque) ecoparque.value(i);
            if(consulta_ecoparque.getUbicacion().equals(ecosistema)){
                System.out.println(consulta_ecoparque.toString());
                exist=true;
                consulta_ecoparque.busquedas++;
                finds.push((Ecoparque)consulta_ecoparque);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedaInteresEcoparque(DynamicArray ecoparque,String interes){
        long start;
        long end;
        Ecoparque consulta_ecoparque;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        System.out.println("Introduzca el interes a buscar");
        start=System.currentTimeMillis();
        for (int i=0;i<ecoparque.size();i++){
            consulta_ecoparque= (Ecoparque) ecoparque.value(i);
            if(consulta_ecoparque.getInteres().equals(interes)){
                System.out.println(consulta_ecoparque.toString());
                exist=true;
                consulta_ecoparque.busquedas++;
                ecoparque.push((Ecoparque)consulta_ecoparque);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static void actualizarEcoparque(DynamicArray ecoparque, int id,String info){
        long start;
        long end;
        Ecoparque consulta_ecoparque;
        boolean exist=false;
        String[] datos=info.split(" ");
        start=System.currentTimeMillis();
        for (int i=0;i<ecoparque.size();i++){
            consulta_ecoparque= (Ecoparque) ecoparque.value(i);
            if(consulta_ecoparque.id==id){
                consulta_ecoparque.setNombre(datos[0]);
                consulta_ecoparque.setUbicacion(datos[1]);
                consulta_ecoparque.setEcosistema(datos[2]);
                consulta_ecoparque.setInteres(datos[3]);
                exist=true;
                break;
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
    }
    public static void borrarEcoparqueId(DynamicArray ecoparque, int id){
        long start;
        long end;
        Ecoparque consulta_ecoparque;
        boolean exist=false;
        System.out.println("Introduzca el nombre a eliminar");
        start=System.currentTimeMillis();
        for (int i=0;i<ecoparque.size();i++){
            consulta_ecoparque= (Ecoparque) ecoparque.value(i);
            if(consulta_ecoparque.id==id){
                ecoparque.delete(i);
                System.out.println("La eliminación se ha completado con exito");
                exist=true;
                break;
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
    }
    public static void insertarEcoparque(DynamicArray ecoparque, String info){
        long start;
        long end;
        int id;
        Ecoparque tempeco;
        Ecoparque_Node result_eco;
        AVL_Ecoparques avle = new AVL_Ecoparques();
        try{
      
        String[] datos=info.split("/"); 
        start=System.currentTimeMillis();
        id=Integer.parseInt(datos[0]);;
        tempeco=new Ecoparque(id,null,null,null,null);
        for(int i=0;i<ecoparque.size();i++){
            avle.root=avle.insert(avle.root, (Ecoparque)ecoparque.value(i));
        }
        result_eco = avle.Find(avle.root,tempeco);
        if(result_eco!=null){
            JOptionPane.showMessageDialog(null,"El id indicado ya se encuentra registrado");
        }else{
            ecoparque.push(new Ecoparque(id,datos[1],datos[2],datos[3],datos[4]));
            JOptionPane.showMessageDialog(null,"Aporte realizado correctamente");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Error no se pudo realizar el aporte");
        }
    }
    public static DynamicArray busquedaFaunaId(DynamicArray fauna, int id){
        long start;
        long end;
        DynamicArray finds = new DynamicArray(10);
        AVL_Fauna avlfauna= new AVL_Fauna();
        System.out.println("Introduzca el Id a buscar");
        Fauna aux=new Fauna (id,null,null,null,null,null,null,null,null,null,null,null,null);
        start=System.currentTimeMillis();
        for(int i=0;i<fauna.size();i++){
            avlfauna.root=avlfauna.insert(avlfauna.root, (Fauna)fauna.value(i));
        }
        Fauna_Node result = avlfauna.Find(avlfauna.root,aux);
        if(result!=null){
            finds.push((Fauna)result.key);
        }else{
            System.out.println("Id no encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedaNombreCientificoFauna(DynamicArray fauna , String nombre_cientifico){
        long start;
        long end;
        Fauna consulta_fauna;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        System.out.println("Introduzca el nombre cientifico a buscar");
        start=System.currentTimeMillis();
        for(int i = 0;i<fauna.size();i++){
            consulta_fauna= (Fauna) fauna.value(i);
            if(consulta_fauna.getNombre_cientifico().equals(nombre_cientifico)){
                System.out.println(consulta_fauna.toString());
                exist=true;
                consulta_fauna.busquedas++;
                finds.push((Fauna)consulta_fauna);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedaNombreComunFauna(DynamicArray fauna, String nombre_comun){
        long start;
        long end;
        Fauna consulta_fauna;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        start=System.currentTimeMillis();
        for (int i=0;i<fauna.size();i++){
            consulta_fauna= (Fauna) fauna.value(i);
            if(consulta_fauna.getNombre_comun().equals(nombre_comun)){
                System.out.println(consulta_fauna.toString());
                exist=true;
                consulta_fauna.busquedas++;
                finds.push((Fauna)consulta_fauna);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedaUbicacionFauna(DynamicArray fauna, String ubicacion){
        long start;
        long end;
        Fauna consulta_fauna;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        start=System.currentTimeMillis();
        for (int i=0;i<fauna.size();i++){
            consulta_fauna= (Fauna) fauna.value(i);
            if(consulta_fauna.getUbicacion().equals(ubicacion)){
                System.out.println(consulta_fauna.toString());
                exist=true;
                consulta_fauna.busquedas++;
                finds.push((Fauna)consulta_fauna);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedaEcosistemaFauna(DynamicArray fauna, String ecosistema){
        long start;
        long end;
        Fauna consulta_fauna;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        start=System.currentTimeMillis();
        for (int i=0;i<fauna.size();i++){
            consulta_fauna= (Fauna) fauna.value(i);
            if(consulta_fauna.getEcosistema().equals(ecosistema)){
                System.out.println(consulta_fauna.toString());
                exist=true;
                consulta_fauna.busquedas++;
                finds.push((Fauna)consulta_fauna);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedasFiloFauna(DynamicArray fauna,String filo){
        long start;
        long end;
        Fauna consulta_fauna;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        start=System.currentTimeMillis();
        for (int i=0;i<fauna.size();i++){
            consulta_fauna= (Fauna) fauna.value(i);
            if(consulta_fauna.getFilo().equals(filo)){
                System.out.println(consulta_fauna.toString());
                exist=true;
                consulta_fauna.busquedas++;
                finds.push((Fauna)consulta_fauna);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedasClaseFauna(DynamicArray fauna,String clase){
        long start;
        long end;
        Fauna consulta_fauna;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        start=System.currentTimeMillis();
        for (int i=0;i<fauna.size();i++){
            consulta_fauna= (Fauna) fauna.value(i);
            if(consulta_fauna.getClase().equals(clase)){
                System.out.println(consulta_fauna.toString());
                exist=true;
                consulta_fauna.busquedas++;
                finds.push((Fauna)consulta_fauna);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedasOrdenFauna(DynamicArray fauna,String orden){
        long start;
        long end;
        Fauna consulta_fauna;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        start=System.currentTimeMillis();
        for (int i=0;i<fauna.size();i++){
            consulta_fauna= (Fauna) fauna.value(i);
            if(consulta_fauna.getOrden().equals(orden)){
                System.out.println(consulta_fauna.toString());
                exist=true;
                consulta_fauna.busquedas++;
                finds.push((Fauna)consulta_fauna);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedasFamiliaFauna(DynamicArray fauna,String familia){
        long start;
        long end;
        Fauna consulta_fauna;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        start=System.currentTimeMillis();
        for (int i=0;i<fauna.size();i++){
            consulta_fauna= (Fauna) fauna.value(i);
            if(consulta_fauna.getFamilia().equals(familia)){
                System.out.println(consulta_fauna.toString());
                exist=true;
                consulta_fauna.busquedas++;
                finds.push((Fauna)consulta_fauna);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedasGeneroFauna(DynamicArray fauna,String genero){
        long start;
        long end;
        Fauna consulta_fauna;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        start=System.currentTimeMillis();
        for (int i=0;i<fauna.size();i++){
            consulta_fauna= (Fauna) fauna.value(i);
            if(consulta_fauna.getGenero().equals(genero)){
                System.out.println(consulta_fauna.toString());
                exist=true;
                consulta_fauna.busquedas++;
                finds.push((Fauna)consulta_fauna);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedasEspecieFauna(DynamicArray fauna,String especie){
        long start;
        long end;
        Fauna consulta_fauna;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        start=System.currentTimeMillis();
        for (int i=0;i<fauna.size();i++){
            consulta_fauna= (Fauna) fauna.value(i);
            if(consulta_fauna.getEspecie().equals(especie)){
                System.out.println(consulta_fauna.toString());
                exist=true;
                consulta_fauna.busquedas++;
                finds.push((Fauna)consulta_fauna);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedasAlimentacionFauna(DynamicArray fauna,String alimentacion){
        long start;
        long end;
        Fauna consulta_fauna;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        start=System.currentTimeMillis();
        for (int i=0;i<fauna.size();i++){
            consulta_fauna= (Fauna) fauna.value(i);
            if(consulta_fauna.getAlimentacion().equals(alimentacion)){
                System.out.println(consulta_fauna.toString());
                exist=true;
                consulta_fauna.busquedas++;
                finds.push((Fauna)consulta_fauna);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static DynamicArray busquedasDepredadorFauna(DynamicArray fauna,String depredador){
        long start;
        long end;
        Fauna consulta_fauna;
        boolean exist=false;
        DynamicArray finds = new DynamicArray(10);
        start=System.currentTimeMillis();
        for (int i=0;i<fauna.size();i++){
            consulta_fauna= (Fauna) fauna.value(i);
            if(consulta_fauna.getDepredador().equals(depredador)){
                System.out.println(consulta_fauna.toString());
                exist=true;
                consulta_fauna.busquedas++;
                finds.push((Fauna)consulta_fauna);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        return finds;
    }
    public static void insertarFauna(DynamicArray fauna, String info){
        long start;
        long end;
        int id;
        Fauna tempfauna;
        AVL_Fauna avlfauna = new AVL_Fauna();
        Fauna_Node result_fauna;
        try{
        String[] datos= info.split("/");
        
        id=Integer.parseInt(datos[0]);
        tempfauna=new Fauna (id,null,null,null,null,null,null,null,null,null,null,null,null);
        start=System.currentTimeMillis();
        for(int i=0;i<fauna.size();i++){
            avlfauna.root=avlfauna.insert(avlfauna.root, (Fauna)fauna.value(i));
        }
        result_fauna = avlfauna.Find(avlfauna.root,tempfauna);
        if(result_fauna!=null){
            JOptionPane.showMessageDialog(null,"El id ingresado ya se encuentra registrado");
        }else{
            fauna.push(new Fauna(id,datos[1],datos[2],datos[3],datos[4],datos[5],
                            datos[6],datos[7],datos[8],datos[9],datos[10],datos[11],datos[12]));
            JOptionPane.showMessageDialog(null,"Se realizo el aporte correctamente");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Error no se pudo realizar el aporte");
        }
    }
    public static void borrarFaunaId(DynamicArray fauna,int id){
        long start;
        long end;
        Fauna consulta_fauna;
        boolean exist=false;
        start=System.currentTimeMillis();
        for (int i=0;i<fauna.size();i++){
            consulta_fauna= (Fauna) fauna.value(i);
            if(consulta_fauna.id==id){
                fauna.delete(i);
                System.out.println("La eliminación se ha completado con exito");
                exist=true;
                break;
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);

    }
    public static void actualizarFauna(DynamicArray fauna, int id, String info){
        long start;
        long end;
        Fauna consulta_fauna;
        boolean exist=false;
        start=System.currentTimeMillis();
        String[] datos = info.split(" ");
        for (int i=0;i<fauna.size();i++){
            consulta_fauna= (Fauna) fauna.value(i);
            if(consulta_fauna.id==id){
                consulta_fauna.setNombre_cientifico(datos[0]);
                consulta_fauna.setNombre_comun(datos[1]);
                consulta_fauna.setUbicacion(datos[2]);
                consulta_fauna.setEcosistema(datos[3]);
                consulta_fauna.setFilo(datos[4]);
                consulta_fauna.setClase(datos[5]);
                consulta_fauna.setOrden(datos[6]);
                consulta_fauna.setFamilia(datos[7]);
                consulta_fauna.setGenero(datos[8]);
                consulta_fauna.setEspecie(datos[9]);
                consulta_fauna.setAlimentacion(datos[10]);
                consulta_fauna.setDepredador(datos[11]);
            }
        }
        if (! exist){
            System.out.println("El elemento indicado no fue encontrado");
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
    }
    public static void insertarFloras(DynamicArray flora){
        long start;
        long end;
        start=System.currentTimeMillis();
        try{
            String separador =System.getProperty("file.separator");
            File f = new File("data"+separador+"Flora_10mil.txt");
            FileReader lectorArchivo=new FileReader(f);
            BufferedReader br = new BufferedReader(lectorArchivo);
            String aux="";
            while(true){
                aux=br.readLine();
                if(aux==null)break;
                String[] atributos=aux.split(";");
                int id=Integer.parseInt(atributos[0]);
                flora.push(new Flora(id ,atributos[1],atributos[2],atributos[3],atributos[4],
                          atributos[5],atributos[6],atributos[7],atributos[8],atributos[9],atributos[10]));                                             
                } 
            br.close();
            lectorArchivo.close();
        }
        catch(Exception e){
        System.out.println("error  "+e );
        System.out.println(e.getMessage());
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    public static void insertarEcoparques(DynamicArray ecoparque){
        long end;
        long start;
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
                                int id=Integer.parseInt(atributos[0]);
                                ecoparque.push(new Ecoparque(id,atributos[1],atributos[2],atributos[3],atributos[4]));                                             
                                } 
                            br.close();
                            lectorArchivo.close();
                        }
                        catch(Exception e){
                        System.out.println("error  "+e );
                        System.out.println(e.getMessage());
                        }end = System.currentTimeMillis();
                        System.out.println(end - start);
    }
    public static void insertarFaunas(DynamicArray fauna){
        long end;
        long start;
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
                    int id= Integer.parseInt(atributos[0]);
                    fauna.push(new Fauna(id,atributos[1],atributos[2],atributos[3],atributos[4],
                              atributos[5],atributos[6],atributos[7],atributos[8],atributos[9],
                                atributos[10],atributos[11], atributos[12]));                                             
                    } 
                br.close();
                lectorArchivo.close();
            }
            catch(Exception e){
            System.out.println("error  "+e );
            System.out.println(e.getMessage());
            }end = System.currentTimeMillis();
            System.out.println(end - start);
    }
    public static void exit(DynamicArray flora,DynamicArray ecoparque,DynamicArray fauna){
        long start;
        long end;
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
        end=System.currentTimeMillis();
        System.out.println(end-start);
    }
    public static DynamicArray HeapSortFlora(DynamicArray flora)   {
        DynamicArray<Flora> aux =new DynamicArray<Flora>(flora.size());
        MaxHeapFlora mhf= new MaxHeapFlora(flora.size());
        for(int i=0;i<flora.size();i++){
            mhf.insert((Flora)flora.value(i));
        }
        for(int i=0;i<flora.size();i++){
            aux.push((Flora)mhf.extractMax());
        }
        return aux;
    }
    public static DynamicArray HeapSortFauna(DynamicArray fauna)   {
        DynamicArray<Fauna> aux =new DynamicArray<Fauna>(fauna.size());
        MaxHeapFauna mhf= new MaxHeapFauna(fauna.size());
        for(int i=0;i<fauna.size();i++){
            mhf.insert((Fauna)fauna.value(i));
        }
        for(int i=0;i<fauna.size();i++){
            aux.push((Fauna)mhf.extractMax());
        }
        return aux;
    }
    public static DynamicArray HeapSortEcoparque(DynamicArray ecoparque)   {
        DynamicArray<Ecoparque> aux =new DynamicArray<Ecoparque>(ecoparque.size());
        MaxHeapEcoparque mhf= new MaxHeapEcoparque(ecoparque.size());
        for(int i=0;i<ecoparque.size();i++){
            mhf.insert((Ecoparque)ecoparque.value(i));
        }
        for(int i=0;i<ecoparque.size();i++){
            aux.push((Ecoparque)mhf.extractMax());
        }
        return aux;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException  {
    // TODO code application logic here

    //----------------------------------------------------------------------------------------
    
        System.out.println("\tECO-LOMBIA\n");
   
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader console = new BufferedReader (isr);

        AVLUsuarios Usuarios = new AVLUsuarios();
        NewsSection noticias=new NewsSection();
        
        DynamicArray<Flora> flora = new DynamicArray<>(10);
        DynamicArray<Fauna> fauna = new DynamicArray<>(10);
        DynamicArray<Ecoparque> Ecoparque = new DynamicArray<>(10);
        
        
        
                News rechanfle = new News("","","New5.jpeg");
                News rechanfle1 = new News("","","New1.jpeg");
                News rechanfle2 = new News("","","New2.jpeg");
                News rechanfle3 = new News("","","New3.jpeg");
                News rechanfle4 = new News("","","New4.jpeg");
                //News rechanfle5 = new News(" ","","News5.jpeg");
                noticias.addNew(rechanfle);
                noticias.addNew(rechanfle1);
                noticias.addNew(rechanfle2);
                noticias.addNew(rechanfle3);
                noticias.addNew(rechanfle4);
            
            
            
            
        String opcion=null;
        boolean ciclo=true;
        long inicio;
        long fin;
        Ventana prueba = new Ventana (Usuarios,noticias,flora,fauna,Ecoparque);

    }

    
}