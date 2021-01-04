package Utils;

import Model.Pressure;

import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class ConvertHashMapToVector {
    /**
     * ConvertHashMapToVector() Costruttore vuoto
     */
    public ConvertHashMapToVector(){}

    /**
     * convertHashMapToVector(Map tempHashMap) converte un Hashmap in un vettore di oggetti Pressure
     * @param tempHashMap
     * @return Vettore oggetti Pressure
     */
    public Vector<Pressure> convertHashMapToVector (Map tempHashMap){
        Map<String, String> hashMap = tempHashMap; //Popola hashMap
        Set<String> keys = hashMap.keySet(); //Popola keys con le chiavi dell'hashmap, la collezione Set contiene oggetti univoci, i valori non possono quindi ripetersi
        String[] array = keys.toArray(new String[keys.size()]); //Crea un array di tipo String, di grandezza uguale al numero di chiavi, contenente le chiavi
        Pressure pressureObject;
        Vector<Pressure> pressures = new Vector<Pressure>();
        String[] splitter;
        for(int i=0;i<array.length;i++){
            pressureObject = new Pressure(); //L'ggetto pressureObject viene "resettato" ad ogni iterazione del ciclo for
            splitter=array[i].split(";"); //Il vettore splitter viene popolato da tre stringhe contenenti rispettivamente: nome citta', data, valore pressione
            pressureObject.nameCity=splitter[0];
            splitter=splitter[1].split("T"); //Splitter splitta ulteriormente la data in modo da ricavare separatamente l'orario e il giorno
            pressureObject.date=splitter[0];
            pressureObject.time=splitter[1];
            pressureObject.value= Float.parseFloat((hashMap.get(array[i].toString()))); //Il valore della pressione viene ricavato direttamente dall'hashmap utilizzando come chiave il contenuto di array in posizione i
            pressures.add(pressureObject);
        }
        return pressures;
    }
}
