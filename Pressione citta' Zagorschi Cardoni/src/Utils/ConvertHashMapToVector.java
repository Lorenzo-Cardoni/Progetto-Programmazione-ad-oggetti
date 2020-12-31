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
        for(int i=0;i<pressures.size();i++){
            System.out.print(pressures.get(i).nameCity);
            System.out.print(pressures.get(i).date);
            System.out.print(pressures.get(i).time);
            System.out.print(pressures.get(i).value);
            System.out.print("\n");
        }
        /*
        Map<String, String> hashMap;
        hashMap=this.hashMap;
        String temp;
        for(int i=0;i<hashMap.size();i++){
            splitter = (new ArrayList<String>(hashMap.keySet())).get(i).split(";");
            pressureObject.nameCity=splitter[0];
            splitter = (new ArrayList<String>(hashMap.keySet())).get(i).split("T");
            temp=splitter[0];
            pressureObject.time=splitter[1];
            splitter = temp.split(";");
            pressureObject.date = splitter[1];
            splitter = (new ArrayList<String>(hashMap.values())).get(i).split("");
            //pressureObject.value = Float.parseFloat(hashMap.va()).get(i));
            pressures.add(pressureObject);
        }
        for(int i=0;i<pressures.size();i++){
            System.out.print(pressures.get(0).nameCity);
            System.out.print(pressures.get(0).date);
            System.out.print(pressures.get(0).time);
            System.out.print(pressures.get(0).value);
            System.out.print("\n");
        }
        */
        return pressures;
    }
}
