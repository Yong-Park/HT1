public interface RadioGeneral {

    //sirve para regresar un true or false indicando si la radio esta encendido o no, y en caso que no esta encendio 
    //mandar el false al menu del main y no permitir realizar ninguna de las otras opciones hasta que se encienda
    boolean isON();
    //poner el boolean de su radio como true
    void encender();
    //poner el boolean de su radio como false
    void apagar();
    //aumentar la emisora, pero verificar primero el tipo de emisora si es am o fm
    void incrementar();
    //crea dos lista o arraylist donde uno es para el am y el otro para el fm
    void asignar();
    //mostrar la lista dependiendo el tipo de canal en el cual este si es am mostrar la lista de am
    //si es fm mostrar la lista de fm y luego que seleccione agarrar ese dato guardado y simplemente reemplazarlo por
    //su variable de frecuencia
    void emisoras();
    //para cambiar el am a fm a am
    void frecuencias();
}
