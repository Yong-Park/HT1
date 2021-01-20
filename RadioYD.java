//importar librerias
import java.util.ArrayList;
import java.util.Scanner;


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
    public void frecuencias(){
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
    public void asignar(){
        boolean ciclo=true;
        int opcion_numero=0;

        if(Tipo_canal.equals("AM")){
            System.out.println("Emisora: " + AM);
            System.out.println("Seleccione en donde lo piensa guardar");
            for(int i=0;i<12;i++){
                System.out.println((i+1) + ". " + AM_Guardado.get(i));
            }
            do{
                try{
                    String opcion = scanner.next();
                    opcion_numero = Integer.parseInt(opcion);
                    if(opcion_numero>=1 && opcion_numero<=12){
                        ciclo=false;
                    }else{
                        System.out.println("Porfavor ingresa 1 o 12");
                    }
                }catch(Exception e){
                    System.out.println("Ingersa solo datos numericos");
                }
            }while(ciclo);
            
            opcion_numero--;

            AM_Guardado.set(opcion_numero, AM);
        }else{
            System.out.println("Emisora: " + FM);
            System.out.println("Seleccione en donde lo piensa guardar");
            for(int i=0;i<12;i++){
                System.out.println((i+1) + ". " + FM_Guardado.get(i));
            }
            do{
                try{
                    String opcion = scanner.next();
                    opcion_numero = Integer.parseInt(opcion);
                    if(opcion_numero>=1 && opcion_numero<=12){
                        ciclo=false;
                    }else{
                        System.out.println("Porfavor ingresa 1 o 12");
                    }
                }catch(Exception e){
                    System.out.println("Ingersa solo datos numericos");
                }
            }while(ciclo);
            
            opcion_numero--;

            FM_Guardado.set(opcion_numero, FM);
        }
    }
    //para mostrar las emisoras guardadas y dirigirse a ellas
    public void emisoras(){
        boolean ciclo=true;
        int opcion_numero=0;

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
                    opcion_numero = Integer.parseInt(opcion);
                    if(opcion_numero>=1 && opcion_numero<=12){
                        ciclo=false;
                    }else{
                        System.out.println("Porfavor ingresa 1 o 12");
                    }
                }catch(Exception e){
                    System.out.println("Ingersa solo datos numericos");
                }
            }while(ciclo);
            opcion_numero--;
            AM=AM_Guardado.get(opcion_numero);

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
                    opcion_numero = Integer.parseInt(opcion);
                    if(opcion_numero>=1 && opcion_numero<=12){
                        ciclo=false;
                    }else{
                        System.out.println("Porfavor ingresa 1 o 12");
                    }
                }catch(Exception e){
                    System.out.println("Ingersa solo datos numericos");
                }
            }while(ciclo);
            opcion_numero--;
            FM=FM_Guardado.get(opcion_numero);
        }
    }
    
}
