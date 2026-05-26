import java.util.ArrayList;
import java.util.Collections;
public class LinkedListApp{
    public static void main(String[] agrs){
     //Append Element
     System.out.println("Append Element");
     LinkedList<String>cores = new LinkedList<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println(cores);

        //Iterate LinkedList Elements:
        System.out.println("Iterate LinkedList Elements:");
        for(String cor : cores){
            System.out.println(cor);
        }


        //Iterate from Position:
        System.out.println("Iterate from Position:");
        int startPos = 2;
        for(int i = startPos; i < cores.size(); i++){
            System.out.println(cores.get(i));
        }



    }
}