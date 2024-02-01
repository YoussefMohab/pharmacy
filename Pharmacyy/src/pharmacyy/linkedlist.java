/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacyy;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class linkedlist {
    node head = null;
public void add(node n){
    node temp=head;
    if (head==null){
    head = n;}
    else {
    while(temp.next!=null){
    temp=temp.next;}
    temp.next=n;}
    }
   
public int lenght(){
int count=0;
node temp=head;        
while(temp!=null){
count++;
temp=temp.next;}
return count;
}  
}
