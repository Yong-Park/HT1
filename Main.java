//importar librerias
import java.util.Scanner;
public class Main{

    public static void main(String[] args){
        //atributos
        boolean ciclo=true;
        int opcion_numero=0;
        RadioYD radio = new RadioYD();
        final Scanner scanner = new Scanner(System.in);
        
        //mostrar el menu
        do{
            //mostrar caracteristicas
            System.out.println("_________________________________");
            if(radio.isON()==true){
                System.out.println("Radio: Encendida");
            }else{
                System.out.println("Radio: Apagada");
            }
            System.out.println("_________________________________");
            //menu
            System.out.println("1.Prender Radio");
            System.out.println("2.Cambiar de AM a FM a AM");
            System.out.println("3.Avanzar en el dia de las emisoras");
            System.out.println("4.Guardar emisora en unos de los 12 botones");
            System.out.println("5.Seleccionar una emisora guardada");
            System.out.println("6.Apagar Radio");
            System.out.println("7.Salir");
            //pedir el numero de opcion
            boolean ciclo_numero=true;
            do{
                try{
                    String opcion = scanner.next();
                    //verificar que sea una opcion adecuada
                    opcion_numero = Integer.parseInt(opcion);
                    if(opcion_numero>=1 && opcion_numero<=7){
                        ciclo_numero=false;
                    }else{
                        System.out.println("Porfavor ingresa 1 o 7");
                    }
                }catch(Exception e){
                    System.out.println("Ingersa solo datos numericos");
                }
            }while(ciclo_numero);
            
            //encender radio
            if(opcion_numero==1){
                radio.encender();
            }else if(opcion_numero>=2 && opcion_numero<=6){
                //verificar que la radio este prendido
                if(radio.isON()==true){
                    //cambiar el tipo de radio
                    if(opcion_numero==2){
                        radio.frecuencias();
                    //avanzar frecuencia
                    }else if(opcion_numero==3){
                        radio.incrementar();
                    //guardar emisora
                    }else if(opcion_numero==4){
                        radio.asignar();
                    //poner la emisora guardada y seleccionada
                    }else if(opcion_numero==5){
                        radio.emisoras();
                    //apagar la radio
                    }else if(opcion_numero==6){
                        radio.apagar();
                    }
                }else{
                    System.out.println("Porfavor encienda la radio");
                }
            //terminar el proceso
            }else if(opcion_numero==7){
                ciclo=false;
            //mostrar error y pedir que ingrese un numero del menu
            }else{
                System.out.println("Porfavor ingrese solo del 1-7");
            }

        }while(ciclo);
    }
}