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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import java.util.*;
//import javax.swing.text.html.parser.Parser;
//import java.lang.reflect.Type;

public class Pharmacyy {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        
        linkedlist main = new linkedlist();
        load("Medicine.json", main);
        //printall(main);
        //printmedicinedata(main, 22548);
        //addnewmedicine(23456, 123, "hentrozine", "vitamin", "drawer2", "china", 14.0, "20/4/2021", main);
        //update(main, 15987);
        //delete(main, 22548);
        sortbyprice(main,0);
        //printall(main);
        //sortbyquantity(main);
        //sortbyexpdate(main, 0);
        //expatdate(main, "25/07/2024");
        //sell(main, 15987 , 6);
        //save(main);
        //exit(main);
        printall(main);
        //int i=main.lenght();
        //System.out.print(i);
    }

    public static void load(String FilePath, linkedlist list) throws Exception {
        JSONParser parser = new JSONParser();

        
        try {
            FileReader reader = new FileReader(FilePath);
            Object obj = parser.parse(reader);

            JSONArray MedicineList = (JSONArray) obj;
            for (int i = 0; i < MedicineList.size(); i++) {

                JSONObject user = (JSONObject) MedicineList.get(i);
                node n = new node();
                JSONObject Medicine = (JSONObject) user.get("Data");
                n.name = Medicine.get("name").toString();
                n.id = (int) Medicine.get("id").hashCode();
                n.quantity = (int) Medicine.get("quantity").hashCode();
                n.type = Medicine.get("type").toString();
                n.place = Medicine.get("place").toString();
                n.Manufacture = Medicine.get("Manufacture").toString();
                
                double price = (double) Medicine.get("price");
                
                n.price = price;
                String expdate = Medicine.get("expdate").toString();
                
                n.EXPdate = converttodate(expdate);

                list.add(n);

            }
            //System.out.println(MedicineList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static Date converttodate(String s) throws Exception {

        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = formatter1.parse(s);
        return d1;
    }
    public static String converttostring(Date d){
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        String date= formatter1.format(d);
        return date;
    }

    public static node creatnode(int id, int quantity, String name, String type, String place, String Manufacture, double price, Date EXPdate) {
        node n = new node();
        n.id = id;
        n.name = name;
        n.quantity = quantity;
        n.place = place;
        n.type = type;
        n.price = price;
        n.Manufacture = Manufacture;
        n.EXPdate = EXPdate;

        n.next = null;
        return n;
    }

    public static void addnewmedicine(int id, int quantity, String name, String type, String place, String Manufacture, double price, String expdate, linkedlist list) throws Exception {
        Date EXPdate = converttodate(expdate);
        node n = creatnode(id, quantity, name, type, place, Manufacture, price, EXPdate);
        if (n != null) {
            if (list.head == null) {
                list.head = n;
            } else {
                node temp = list.head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = n;
            }
        }
    }

    public static void printall(linkedlist list) {
        node temp = list.head;

        while (temp != null) {
            System.out.println(temp.id + " " + temp.name + " " + temp.quantity + " " + temp.place + " " + temp.price + " " + temp.type + " " + temp.Manufacture + " " + temp.EXPdate);
            temp = temp.next;

        }
    }

    public static void printmedicinedata(linkedlist list, int id) {
        node temp = list.head;
        if (temp != null) {
            while (temp.id != id){ 
            temp = temp.next;}
              System.out.println(temp.id + " " + temp.name + " " + temp.quantity + " " + temp.place + " " + temp.price + " " + temp.type + " " + temp.Manufacture + " " + temp.EXPdate);
        }
    }
    
    public static void delete(linkedlist list, int id) {
        if (list.head != null) {
            if (list.head.id == id) {
                list.head = list.head.next;
            } else {
                node temp = list.head;
                while (temp.next.id != id) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
            }
        }
    }


    public static void update(linkedlist list, int id) throws Exception {
        node temp = list.head;
        Scanner sc = new Scanner(System.in);
        System.out.println("choose update in :");
        System.out.println("1- id");
        System.out.println("2- name");
        System.out.println("3- quantity");
        System.out.println("4- place");
        System.out.println("5- price");
        System.out.println("6- type");
        System.out.println("7- Manufacture");
        System.out.println("8- EXPdate");
        int updatein = sc.nextInt();
        Scanner cs = new Scanner(System.in);
        System.out.println("new update is :");
        
        while (temp.id != id) 
            temp = temp.next;
        
        if (updatein == 1) {
                int newid = cs.nextInt();
                temp.id = newid;
            }
        
        if (updatein == 2) {
            String newname = cs.next();
            temp.name = newname;
        }
        if (updatein == 3) {
            int newquantity = cs.nextInt();
            temp.quantity = newquantity;
        }
        if (updatein == 4) {
            String newplace = cs.next();
            temp.place = newplace;
        }
        if (updatein == 5) {
            double newprice = cs.nextDouble();
            temp.price = newprice;
        }
        if (updatein == 6) {
            String newtype = cs.next();
            temp.type = newtype;
        }
        if (updatein == 7) {
            String newManufacture = cs.next();
            temp.Manufacture = newManufacture;
        }
        if (updatein == 8) {
            String newEXPdate1 = cs.next();
            Date newEXPdate = converttodate(newEXPdate1);
            temp.EXPdate = newEXPdate;
        }
        
    }
    public static void swap(node n1,node n2){
    node temp=n2.next;
    n2.next=n1;
    n1.next=temp;
    }

    public static void sortbyprice(linkedlist list,int order) {
        int n=list.lenght();
        if (order==0){
        node x=list.head;
        //node a=list.head;
        node y=x.next;
        for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
        node temp=null,temp2=null;
        //System.out.println(i+j);
        if(x.next.price>y.next.price){
        temp=y.next;
        y.next=y.next.next;
        temp2=x.next;
        x.next=temp;
        temp.next=temp2;
        }
        if(list!=null)
        y=y.next;
        }    
        x=x.next;
        y=x.next;
        }
        }
        /*for(node i=list.head;i.next!=null;i=i.next){
        for(node j=list.head;j.next!=null;j=j.next){
        if(i.price<j.price){
        node temp=null;
        temp=i;
        i=j;
        j=temp;
        }}}*/
        
        /*for(int i=0;i>n;i++){
            //node current=list.head;
        for(int j=0;j>n;j++){
            node next=list.head;    
        if(current.price<next.price){
        node temp=null;
        temp.next=next.next;
        next.next=temp;
        current.next=temp.next;
        next.next=current;
        }
        next=next.next;}
        current=current.next;}
        }*/
        }    
    

    public static void sortbyquantity(linkedlist list) {
       Scanner sc=new Scanner(System.in);
        System.out.println("choose 0 for ascending or 1 for descinding");
        int order=sc.nextInt();
        int n=list.lenght();
        if (order==0){ 
            node current=list.head;
            
        for(int i=0;i>n;i++){
            node next=list.head; 
            int swapped=0;
        for(int j=0;j>n;j++){
            node temp=list.head;
            node temp2=temp.next;
        if(temp.quantity>temp2.quantity){
        swap(temp,temp2);
        swapped=1;
        
        /*temp=current;
        current=next;
        next=temp;*/
        }
        //next=next.next;
        next=next.next;
        }
        //current=current.next;
        }
        }
            /*if (order==1) {
                 while (current!=null){
                    node next= current.next;
                
               while(next!=null){
                   if (current.quantity<next.quantity){
                       temp=current;
                       current=next;
                       next=temp;
                   }
                next=next.next;
                }
               current=current.next;
                }
            }*/
        }
    

    public static void sortbyexpdate(linkedlist list, int order) {
        /*if (list.head != null) {
            node temp = list.head;
            if (order==0) {
                while (temp.EXPdate.compareTo(temp.next.EXPdate) < 0) {
                    temp.next.next = temp;
                }
                temp.next = temp.next.next;
                temp = temp.next;
            }
            if (order==1) {
                while (temp.EXPdate.compareTo(temp.next.EXPdate) > 0) {
                    temp.next.next = temp;
                }
                temp.next = temp.next.next;
                temp = temp.next;
            } 
        }*/
        int n=list.lenght();
        for(int i=0;i>n;i++){
        node next=null;
        node current=list.head;
        node temp;
        while(current!=null||current.next!=null){
        if(current.EXPdate.compareTo(current.next.EXPdate)<0){
        if(next==null){
        temp=current.next;
        current.next=temp.next;
        temp.next=current;
        list.head=next=temp;}
        else{
        temp=current.next;
        next.next=temp;
        current.next=temp.next;
        temp.next=current;
        next=temp;
        }}
        else{
        temp=current.next;
        next=current;
        current=temp;}}
        }
    }

    public static void expatdate(linkedlist list, String exp) throws Exception {
        if (list.head != null) {
            node temp = list.head;
            Date DateEx = converttodate(exp);
            while (temp.EXPdate.compareTo(DateEx)> 0||temp.EXPdate.compareTo(DateEx)< 0) {
               
            temp = temp.next;              
            }
           System.out.println(temp.name);
        }
    }

    public static void save(linkedlist l) {
        node temp = l.head;
        JSONArray MedicineList = new JSONArray();
        while (temp != null) {
            JSONObject MedicineData = new JSONObject();
            MedicineData.put("name", temp.name);
            MedicineData.put("id", temp.id);
            MedicineData.put("type", temp.type);
            MedicineData.put("place", temp.place);
            MedicineData.put("price", temp.price);
            MedicineData.put("quantity", temp.quantity);
            String s=converttostring(temp.EXPdate);
            MedicineData.put("expdate", s);
            MedicineData.put("Manufacture", temp.Manufacture);
            JSONObject Medicine = new JSONObject();
            Medicine.put("Data", MedicineData);
            MedicineList.add(Medicine);
            temp = temp.next;
        }
        try (FileWriter file = new FileWriter("Medicine.json")) {

            file.write(MedicineList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exit(linkedlist l) {
        save(l);
        System.out.println("EXIT");
        System.exit(0);
    }

    public static void sell(linkedlist list, int id, int quantity) {
        node temp = list.head;
        double price;
        while (temp.id != id) {
            temp = temp.next;
        }
        price =temp.price * quantity;
        temp.quantity-=quantity;
      
        System.out.println("you sold medicines by a total price of "+price);
    }

}
