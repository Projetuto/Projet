        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;
        import java.io.*;
        import java.util.*;


        public class Ecriture{
        private  String nom;
        private int x,y,taille;
        private int[] grandeur;




public  Ecriture(String nomDossier,int[] tab,int sauvx,int sauvy,int taille){
        this.nom=nomDossier;
        this.x=sauvx;
        this.y=sauvy;
        this.taille=taille;
        this.grandeur=tab;

        try{
            FileOutputStream d = new FileOutputStream(nom);
            d.write(taille);
            int absx=(x/taille);
            int ordx=x%taille; 

            d.write(absx);
            d.write(ordx);

            System.out.println(absx);
            System.out.println(ordx);

            int absy = y/taille;
            int ordy = y%taille;
            d.write(absy);
            d.write(ordy);

            System.out.println(absy);
            System.out.println(ordy);

            d.close();

            for(int i=0;i<grandeur.length;i++){
                if(grandeur[i]==2 || grandeur[i]==3){
                  grandeur[i]=0;
                }

            }


        }catch (IOException e){
            System.err.println("Pb IO");
        }

  

}
}

  
    
/*
              
public class Ecriture {
            
    private int[] tab = null;
    private int sauvx,taille,sauvy,cmp,i,et;
    private String ec="";

    public Ecriture(int taille, int sauvx,int sauvy,int[] tab)  { 
        this.taille=taille;
        this.sauvx=sauvx;
        this.sauvy=sauvy;
        this.tab=tab;

        try{
            FileOutputStream d = new FileOutputStream("Sauvegarde.lab");
            d.write(taille);

            /*int absx= sauvx/taille;
            int ordx=sauvx%taille;

            d.write(absx);
            d.write(ordx);

            System.out.println(absx);
            System.out.println(ordx);

            int absy = sauvy/taille;
            int ordy = sauvy%taille;

            d.write(absy);
            d.write(ordy);

            System.out.println(absy);
            System.out.println(ordy);

            d.close();
        }catch (FileNotFoundException e){
            System.err.println("file not found ");
        }catch (IOException e){
            System.err.println("Pb IO");
        }
}
}



    
*/
              
