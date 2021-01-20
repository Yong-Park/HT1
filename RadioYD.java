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
        
    }
    //para mostrar las emisoras guardadas y dirigirse a ellas
    public void emisoras(){
        
    }


}
