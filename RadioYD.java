//importar librerias
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.Test;

public class RadioYD implements RadioGeneral{
    //arrays
    private ArrayList<Integer> AM_Guardado=new ArrayList<Integer>();
    private ArrayList<Double> FM_Guardado=new ArrayList<Double>();
    private boolean encendido=false;
    private String Tipo_canal= "AM";
    private int AM = 530;
    private double FM = 87.9;
    private Scanner scanner = new Scanner(System.in);

    //constructor
    public RadioYD(){
        for(int i=0;i<12;i++){
            AM_Guardado.add(0);
            FM_Guardado.add(0.0);
        }
    }
    
    //cambiar el canal de AM a FM a AM
    public void frecuencia(){
        if(Tipo_canal.equals("AM")){
            System.out.println("Canal: FM");
            Tipo_canal="FM";
        }else{
            System.out.println("Canal: AM");
            Tipo_canal="AM";
        }
    }

    //para verificar si esta encendido o apagado la radio
    public boolean isON(){
        return encendido;
    }
    //para encender la radio
    public void encender(){
        encendido=true;
    }
    //para apagar la radio
    public void apagar(){
        encendido=false;
    }
    //Para cambiar de emisora
    public void incrementar(){
        if(Tipo_canal.equals("AM")){
            System.out.println("Emisora: " + AM);
            AM+=10;
            if(AM>1610){
                AM=530;
            }
        }else{
            System.out.println("Emisora: " + FM);
            FM+=0.2;
            if(FM>108){
                FM=87.9;
            }
        }
    }
    
    //para guardar una emisora
    public boolean asignar(int num){
        boolean ciclo=true;
        num=0;

        if(Tipo_canal.equals("AM")){
            System.out.println("Emisora: " + AM);
            System.out.println("Seleccione en donde lo piensa guardar");
            for(int i=0;i<12;i++){
                System.out.println((i+1) + ". " + AM_Guardado.get(i));
            }
            do{
                try{
                    String opcion = scanner.next();
                    num = Integer.parseInt(opcion);
                    if(num>=1 && num<=12){
                        ciclo=false;
                    }else{
                        System.out.println("Porfavor ingresa 1 o 12");
                    }
                }catch(Exception e){
                    System.out.println("Ingersa solo datos numericos");
                }
            }while(ciclo);
            
            num--;

            AM_Guardado.set(num, AM);
        }else{
            System.out.println("Emisora: " + FM);
            System.out.println("Seleccione en donde lo piensa guardar");
            for(int i=0;i<12;i++){
                System.out.println((i+1) + ". " + FM_Guardado.get(i));
            }
            do{
                try{
                    String opcion = scanner.next();
                    num = Integer.parseInt(opcion);
                    if(num>=1 && num<=12){
                        ciclo=false;
                    }else{
                        System.out.println("Porfavor ingresa 1 o 12");
                    }
                }catch(Exception e){
                    System.out.println("Ingersa solo datos numericos");
                }
            }while(ciclo);
            
            num--;

            FM_Guardado.set(num, FM);
        }
        return true;
    }
    //para mostrar las emisoras guardadas y dirigirse a ellas
    public boolean emisora(int num){
        boolean ciclo=true;
        num=0;

        if(Tipo_canal.equals("AM")){
            System.out.println("Emisora: " + AM);
            for(int i=0;i<12;i++){
                if(AM_Guardado.get(i)!=0){
                    System.out.println((i+1) +". " + AM_Guardado.get(i));
                }
            }
            System.out.println("Seleccione una");
            do{
                try{
                    String opcion = scanner.next();
                    num = Integer.parseInt(opcion);
                    if(num>=1 && num<=12){
                        ciclo=false;
                    }else{
                        System.out.println("Porfavor ingresa 1 o 12");
                    }
                }catch(Exception e){
                    System.out.println("Ingersa solo datos numericos");
                }
            }while(ciclo);
            num--;
            AM=AM_Guardado.get(num);

        }else{
            System.out.println("Emisora: " + FM);
            for(int i=0;i<12;i++){
                if(FM_Guardado.get(i)!=0){
                    System.out.println((i+1) +". " + FM_Guardado.get(i));
                }
            }
            System.out.println("Seleccione una");
            do{
                try{
                    String opcion = scanner.next();
                    num = Integer.parseInt(opcion);
                    if(num>=1 && num<=12){
                        ciclo=false;
                    }else{
                        System.out.println("Porfavor ingresa 1 o 12");
                    }
                }catch(Exception e){
                    System.out.println("Ingersa solo datos numericos");
                }
            }while(ciclo);
            num--;
            FM=FM_Guardado.get(num);
        }
        return true;
    }
    
    @Test
    public boolean isONTest(){
        boolean respuesta=true;
        if(encendido==true){
            respuesta=true;
        }else{
            respuesta=false;
        }
        return respuesta;
    }

    @Test
    public boolean asignarTest(int num){
        boolean respuesta;
        num = 7;
        int opcion_numero=num;

        opcion_numero=2;
        AM_Guardado.set(opcion_numero, AM);
        System.out.println(AM_Guardado);
        if(AM_Guardado.get(num)==AM){
            respuesta=true;
        }else{
            respuesta=false;
        }
        return respuesta;
    }

    @Test
    public boolean emisorasTest(int num){
        boolean respuesta;
        num = 7;
        int opcion_numero=num;
        AM_Guardado.set(opcion_numero, AM);
        opcion_numero=num;
        AM=AM_Guardado.get(opcion_numero);
        System.out.println(AM);
        if(AM==AM_Guardado.get(opcion_numero)){
            respuesta=true;
        }else{
            respuesta=false;
        }
        return respuesta;
    }


}
