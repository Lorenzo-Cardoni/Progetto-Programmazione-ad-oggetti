package Utils;

import Model.Pressure;

import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class ConvertHashMapToVector {
    public ConvertHashMapToVector(){}
    public Vector<Pressure> convertHashMapToVector (Map tempHashMap){
        Map<String, String> hashMap = tempHashMap;
        Set<String> keys = hashMap.keySet();
        String[] array = keys.toArray(new String[keys.size()]);
        Pressure pressureObject;
        Vector<Pressure> pressures = new Vector<Pressure>();
        String[] splitter;
        for(int i=0;i<array.length;i++){
            pressureObject = new Pressure();
            splitter=array[i].split(";");
            pressureObject.nameCity=splitter[0];
            splitter=splitter[1].split("T");
            pressureObject.date=splitter[0];
            pressureObject.time=splitter[1];
            pressureObject.value= Float.parseFloat((hashMap.get(array[i].toString())));
            pressures.add(pressureObject);
        }
        return pressures;
    }
}
