        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;
        import java.io.*;
        import java.util.*;

    public class Sauvegarde {
        private String nomDossier;
        private String l;
        private String h;
        public Sauvegarde(String string){
            this.nomDossier = string;
            try{
                 BufferedWriter writer = new BufferedWriter(new FileWriter(new File(nomDossier)));
                writer.close(); 
            }catch (IOException e){
            System.out.println("Erreur ");
        }catch (NumberFormatException e){
            System.out.println("Erreur ");
        
        }
       

    }
  
    
    public int Sauvegarde(String largeur,String hauteur){
            this.l=largeur;
            this.h=hauteur;
    
} 

    	}

    