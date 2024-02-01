/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacyy;

/**
 *
 * @author Lenovo
 */
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class CreatJson {
    public static void main( String[] args )
    {
    JSONObject MedicineData1 = new JSONObject();
        MedicineData1.put("name", "Aprepitant");
        MedicineData1.put("id", 22548);
        MedicineData1.put("type", "Vitamin");
        MedicineData1.put("place", "Drawer15");
        MedicineData1.put("price", 15.0);
        MedicineData1.put("quantity", 125);
        MedicineData1.put("expdate", "15/05/2025");
        MedicineData1.put("Manufacture", "china");
    JSONObject Medicine1 = new JSONObject(); 
        Medicine1.put("Data", MedicineData1);
    JSONObject MedicineData2 = new JSONObject();
        MedicineData2.put("name", "Clindamycin");
        MedicineData2.put("id", 15987);
        MedicineData2.put("type", "Antibiotic");
        MedicineData2.put("place", "Drawer10");
        MedicineData2.put("price", 80.0);
        MedicineData2.put("quantity", 36);
        MedicineData2.put("expdate", "25/07/2024");
        MedicineData2.put("Manufacture", "egypt");
    JSONObject Medicine2 = new JSONObject(); 
        Medicine2.put("Data", MedicineData2);
    JSONObject MedicineData3 = new JSONObject();
        MedicineData3.put("name", "Dronabinol");
        MedicineData3.put("id", 75159);
        MedicineData3.put("type", "PainKiller");
        MedicineData3.put("place", "Drawer9");
        MedicineData3.put("price", 100.0);
        MedicineData3.put("quantity", 99);
        MedicineData3.put("expdate", "30/01/2026");
        MedicineData3.put("Manufacture", "america");
    JSONObject Medicine3 = new JSONObject(); 
        Medicine3.put("Data", MedicineData3);
    JSONObject MedicineData4 = new JSONObject();
        MedicineData4.put("name", "Eltrombopag");
        MedicineData4.put("id", 74378);
        MedicineData4.put("type", "Vitamin");
        MedicineData4.put("place", "Drawer7");
        MedicineData4.put("price", 250.0);
        MedicineData4.put("quantity", 18);
        MedicineData4.put("expdate", "07/04/2022");
        MedicineData4.put("Manufacture", "russia");
    JSONObject Medicine4 = new JSONObject(); 
        Medicine4.put("Data", MedicineData4); 
    JSONObject MedicineData5 = new JSONObject();
        MedicineData5.put("name", "Famciclovir");
        MedicineData5.put("id", 70091);
        MedicineData5.put("type", "Vitamin");
        MedicineData5.put("place", "Drawer5");
        MedicineData5.put("price", 40.0);
        MedicineData5.put("quantity", 70);
        MedicineData5.put("expdate", "05/02/2027");
        MedicineData5.put("Manufacture", "america");
    JSONObject Medicine5 = new JSONObject(); 
        Medicine5.put("Data", MedicineData5);  
    JSONObject MedicineData6 = new JSONObject();
        MedicineData6.put("name", "Gabapentin");
        MedicineData6.put("id", 89451);
        MedicineData6.put("type", "PainKiller");
        MedicineData6.put("place", "Drawer13");
        MedicineData6.put("price", 20.0);
        MedicineData6.put("quantity", 85);
        MedicineData6.put("expdate", "07/06/2024");
        MedicineData6.put("Manufacture", "china");
    JSONObject Medicine6 = new JSONObject(); 
        Medicine6.put("Data", MedicineData6);  
    JSONObject MedicineData7 = new JSONObject();
        MedicineData7.put("name", "Hydralazine");
        MedicineData7.put("id", 35782);
        MedicineData7.put("type", "Antibiotic");
        MedicineData7.put("place", "Drawer16");
        MedicineData7.put("price", 50.0);
        MedicineData7.put("quantity", 73);
        MedicineData7.put("expdate", "15/12/2026");
        MedicineData7.put("Manufacture", "russia");
    JSONObject Medicine7 = new JSONObject(); 
        Medicine7.put("Data", MedicineData7);  
    JSONObject MedicineData8 = new JSONObject();
        MedicineData8.put("name", "Imatinib");
        MedicineData8.put("id", 26487);
        MedicineData8.put("type", "Vitamin");
        MedicineData8.put("place", "Drawer6");
        MedicineData8.put("price", 30.0);
        MedicineData8.put("quantity", 38);
        MedicineData8.put("expdate", "18/07/2025");
        MedicineData8.put("Manufacture", "egypt");
    JSONObject Medicine8 = new JSONObject(); 
        Medicine8.put("Data", MedicineData8);
    JSONObject MedicineData9 = new JSONObject();
        MedicineData9.put("name", "Ketoconazole");
        MedicineData9.put("id", 35794);
        MedicineData9.put("type", "Vitamin");
        MedicineData9.put("place", "Drawer8");
        MedicineData9.put("price", 150.0);
        MedicineData9.put("quantity", 79);
        MedicineData9.put("expdate", "13/07/2023");
        MedicineData9.put("Manufacture", "russia");
    JSONObject Medicine9 = new JSONObject(); 
        Medicine9.put("Data", MedicineData9);
    JSONObject MedicineData10 = new JSONObject();
        MedicineData10.put("name", "Magnesium");
        MedicineData10.put("id", 60031);
        MedicineData10.put("type", "Vitamin");
        MedicineData10.put("place", "Drawer1");
        MedicineData10.put("price", 90.0);
        MedicineData10.put("quantity", 37);
        MedicineData10.put("expdate", "08/09/2022");
        MedicineData10.put("Manufacture", "america");
    JSONObject Medicine10 = new JSONObject(); 
        Medicine10.put("Data", MedicineData10);  
     JSONArray MedicineList = new JSONArray();
        MedicineList.add(Medicine1);
        MedicineList.add(Medicine2);
        MedicineList.add(Medicine3);
        MedicineList.add(Medicine4); 
        MedicineList.add(Medicine5);
        MedicineList.add(Medicine6); 
        MedicineList.add(Medicine7);
        MedicineList.add(Medicine8); 
        MedicineList.add(Medicine9);
        MedicineList.add(Medicine10); 
        try (FileWriter file = new FileWriter("Medicine.json")) {
            
            file.write(MedicineList.toJSONString()); 
            file.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
