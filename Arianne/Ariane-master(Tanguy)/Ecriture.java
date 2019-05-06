
  
    
        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;
        import java.io.*;
        import java.util.*;


        public class Ecriture{
        private  String nom;
        private int x,y,taille,d,i,a;
        private int[] grandeur;
        private String ec="";




public  Ecriture(String nomDossier,int[] tab,int sauvx,int sauvy,int t){
        this.nom=nomDossier;
        this.x=sauvx;
        this.y=sauvy;
        this.taille=t;
        this.grandeur=tab;

        try{
            FileOutputStream ecriture = new FileOutputStream(System.getProperty("user.dir")+File.separator+"sauvegarde"+File.separator+nom);
            int absx=x/taille;
            int ordx=x%taille;

            ecriture.write(taille);
            
            ecriture.write(absx);
            ecriture.write(ordx);

            System.out.println(absx);
            System.out.println(ordx);

            int absy = y/taille;
            int ordy = y%taille;
             ecriture.write(absy);
             ecriture.write(ordy);

            System.out.println(absy);
            System.out.println(ordy);


                    int capacite = taille*taille;
                    int dbt,bcl;
                    int y=8;
                    int fin = capacite -(capacite % 8);

                    for(bcl = 0 ; bcl < fin ; bcl=bcl+8 ){
                        for(dbt = a ; dbt < y ; dbt ++){
                            if(tab[dbt]==1){
                                ec = ec + "1";
                            }else{
                                ec = ec + "0";

                            }
                        }

                        System.out.println(ec);
                        ecriture.write(Integer.parseInt(ec,2));
                        ec="";
                        a=a+8;
                        y=y+8;

                    }

                    for( d = 0 ; d==-1;i++){
                        for( int complement = 0 ; complement < capacite % 8 ; complement ++){

                                if(tab[fin+complement]==1){
                                    ec = ec + "1";
                                }else{
                                    ec = ec + "0";

                                }
                        }
                        System.out.println(ec);
                        ecriture.write(Integer.parseInt(ec,2));
                        ec="";
                        d=-1;
                    }
                    
                    ecriture.close();


        }catch (IOException e){
            System.err.println("Pb IO");
        }

  

}
}

  
    




              
