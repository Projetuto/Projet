    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.*;
    import java.io.*;
    import java.util.*;
          
    public class Lecture  {
        private int sauvx,taille,sauvy;
        public Lecture(String f) {
        
            System.out.println(f);
            
            /*this.setSize(500,500);
            this.setLocation(100, 100);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
            
            try {
                FileInputStream image = new FileInputStream(f);           
                int[] details = new int[5];
                
                for(int i = 0 ; i < 5 ; i++ ){
                    details[i] = image.read(); 
                }

                int taille = details[0]*details[0];
                int grille = details[0];
                int[] tab = new int[taille];
                int i=0,et;
                int s=1;
                double[] ava = new double[image.available()/8];

                int dispo = image.available();
                int cmp = 0;

                for( int j = 0 ; j < dispo ; j++){
                      
                    int l1 = image.read();

                    for( et = 128 ; et != 0 ; et=et/2){
                       
                        int res = l1 & et;           
                            
                        if(cmp < taille){   
                            if( res != 0){                                                                                                                                      
                                tab[i]=1;
                            }else{                  
                                tab[i]=0;
                            }
                        }
                        i++;
                        cmp++;
                    }
                }

               System.out.println(Arrays.toString(details));
                System.out.println(Arrays.toString(tab));
                taille = details[0];
                System.out.println("taille = " + taille);
                sauvx=details[2]*taille+details[1];
                tab[sauvx]=2;
                System.out.println("sauvx : " +sauvx);
                sauvy=details[4]*taille+details[3];
                tab[sauvy]=3;
                System.out.println("sauvy : "+sauvy);

                System.out.println(Arrays.toString(details));
                System.out.println(Arrays.toString(tab));

                GrilleTest fen = new GrilleTest(tab,taille,sauvx,sauvy);
                /*this.add(fen);

                this.setVisible(true);*/
                

            }catch(IOException e){
              System.err.println("Probleme de lecture");
            }
            
        }
    }