        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;
        import java.io.*;
        import java.util.*;

    public class Sauvegarde {
        public String nomDossier;

        public  Sauvegarde(String string){
            this.nomDossier = string;
            File f = new File(System.getProperty("user.dir")+File.separator+"sauvegarde"+File.separator+nomDossier);
            if(f.exists()  && !f.isDirectory()){
            System.out.println("Le fichier existe déjà ,les valeurs sont écrasées automatiquement");
            Ecriture sauv = new Ecriture(nomDossier);
            }else{
             System.out.println("Creation du fichier effectué avec succès");
             Ecriture sauv = new Ecriture(nomDossier);
         } 		 	    
    
}



}
  
    
