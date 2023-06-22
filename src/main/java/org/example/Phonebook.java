package org.example;

import java.util.*;

public class Phonebook {
    private static HashMap <String, ArrayList> phonebook=new HashMap<>();
    public static void main(String[] args) {
        addContact("Кобзев Евгений", "+7-928-605-42-76");
        addContact("Кобзев Евгений", "+7-949-452-73-78");
        addContact("Шилко Марина", "+7-988-605-90-30");
        addContact("Шилко Марина", "+7-955-605-70-31");
        addContact("Шилко Марина", "+7-948-605-90-32");
        addContact("Кривко Владимир", "7-934-111-45-67");
        printPhonebook();
    }
    public static void addContact(String name, String phoneNumber) {
        if (phonebook.containsKey(name)){
            ArrayList phone =phonebook.get(name);
            phone.add(phoneNumber);
            phonebook.put(name, phone);
        }
        else {
            ArrayList phone =new ArrayList();
            phone.add(phoneNumber);
            phonebook.put(name, phone);
        }
    }
    public static  void printPhonebook(){
        ArrayList<Map.Entry<String,ArrayList>> list =new  ArrayList(phonebook.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, ArrayList>>(){
            @Override
            public int compare(Map.Entry<String, ArrayList> o1, Map.Entry<String, ArrayList> o2) {
                return o2.getValue().size()-o1.getValue().size();
            }
        });
        for (Map.Entry<String,ArrayList> entry: list){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}