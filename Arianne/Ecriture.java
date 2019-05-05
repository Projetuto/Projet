        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;
        import java.io.*;
        import java.util.*;
        import java.nio.file.*;


    public class Ecriture{
        private String hauteur;	
        private String largeur;
        private String nomDossier;



public  Ecriture(String dossier){
this.nomDossier = dossier;
File source = new File(System.getProperty("user.dir")+File.separator+"sauvegarde"+File.separator+"temporaire");
File destination = new File(System.getProperty("user.dir")+File.separator+"sauvegarde"+File.separator+this.nomDossier);
source.renameTo(destination);
if(source.exists()  && !source.isDirectory()){
            source.delete();
}
}



public  Ecriture(String x, String y){
             this.largeur=x;
             this.hauteur=y;
       try { 
      String content1=this.largeur;
      System.out.println(content1);
      String content2=this.hauteur;
      System.out.println(content2);
      FileWriter fw = new FileWriter(System.getProperty("user.dir")+File.separator+"sauvegarde"+File.separator+"temporaire",true);
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(" "+content1 + " " + content2);
      bw.close();


  } catch (IOException e) {
System.out.println("Erreur");

    }
}



    public  Ecriture(int x){
             this.largeur=Integer.toBinaryString(x);
       try { 
      String content1=this.largeur;
      System.out.println(content1);
      FileWriter fw = new FileWriter(System.getProperty("user.dir")+File.separator+"sauvegarde"+File.separator+"temporaire",true);
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(content1);
      bw.close();


  } catch (IOException e) {
System.out.println("Erreur");

    }


}

  }
    
