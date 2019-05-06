import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;



public class Lecture  {
	public static void main(String[] args){
  try{ 

    FileInputStream grille = new FileInputStream(args[0]);
    DataInputStream dat = new DataInputStream(grille);
    String sortie,bit;
    String[] tab = new String[16];
    int i,j,taille;


   	for(i=0;i<(tab.length/2)-1;i++){
		sortie=Integer.toBinaryString(dat.read());

   		if(sortie.length()==3){
   			for(j=0;j<3;j++){
   			bit=sortie.substring(j,j+1);
   			tab[i]=bit;
   			System.out.println(bit);
   		}

   		}else if (sortie.length()==2){
   			for(j=0;j<2;j++){
   			bit=sortie.substring(j,j+1);
   			tab[i]=bit;
   			System.out.println(bit);
   		}

   		}else if(sortie.length()==1){
   			bit=sortie.substring(0,1);
   			tab[i]=bit;
   			System.out.println(bit);

   		}


   		
   }
   Arrays.toString(tab);

JFrame fenetre = new JFrame();
JPanel pannel = new JPanel ();
for(i=0;i<tab.length;i++){
      Arrays.toString(tab);
}
GridLayout gestionnaire = new GridLayout(3, 5);



   	}catch(IOException e){

   	}
   



}
}

