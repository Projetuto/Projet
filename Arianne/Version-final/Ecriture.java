import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
              
        public class Ecriture {
        
            private int[] tab = null;
            private int sauvx,taille,sauvy,cmp,i,et;
            private String ec="";
            private String dossier;

            public Ecriture(String dossier, int[] tab, int sauvx,int sauvy,int taille)  { 
                this.taille=taille;
                this.sauvx=sauvx;
                this.sauvy=sauvy;
                this.tab=tab;
                this.dossier=dossier;

                try{

                    FileOutputStream ecriture = new FileOutputStream(System.getProperty("user.dir")+File.separator+"sauvegarde"+File.separator+dossier);

                    ecriture.write(taille);

                    int absx= sauvx/taille;
                    int ordx=sauvx%taille;

                    ecriture.write(absx);
                    ecriture.write(ordx);

                    int absy = sauvy/taille;
                    int ordy = sauvy%taille;

                    ecriture.write(absy);
                    ecriture.write(ordy);


                    int capacite = taille*taille;
                    int x =0;
                    int dbt,bcl;
                    int y=8;
                    int fin = capacite -(capacite % 8);

                    for(bcl = 0 ; bcl < fin ; bcl=bcl+8 ){
                        for(dbt = x ; dbt < y ; dbt ++){
                            if(tab[dbt]==1){
                                ec = ec + "1";
                            }else{
                                ec = ec + "0";

                            }
                        }
                        ecriture.write(Integer.parseInt(ec,2));
                        ec="";
                        x=x+8;
                        y=y+8;

                    }
                if(capacite % 8 != 0){
                    for( int complement = 0 ; complement < capacite % 8 ; complement ++){

                        if(tab[fin+complement]==1){
                            ec = ec + "1";
                        }else{
                            ec = ec + "0";
                        }
                    }   

                    for(int z = 0 ; z < 8-(capacite%8);z++){
                        ec = ec + "1";
                    }
                    int ecr = Integer.parseInt(ec,2);
                    ec="";

                }
                    
                    ecriture.close();
                } catch (FileNotFoundException e){
                         System.err.println("file not found ");
                }catch (IOException e){
                        System.err.println("Pb IO");
                    }
                    
            }



}