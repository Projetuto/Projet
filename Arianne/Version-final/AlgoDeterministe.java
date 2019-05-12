
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.lang.Math; 

    public class AlgoDeterministe {
        private int[] ts=null;
        private int[] ti=null;
        private int[] reconstruction=null;
        private int sauvx,sauvy,taille,fin=0,sauvegardedirection=0;
        private int casedei=0,cmp=0,resultat,directmp=0,i=1,posx;
        private Analyse e;

        public AlgoDeterministe(Analyse e, int sauvx, int sauvy, int taille){
            this.sauvx=sauvx;
            this.sauvy=sauvy;
            this.taille=taille;
            this.e=e;
            
            int[] ts = new int[taille*taille];
            int[] ti = new int[taille*taille];
            int[] reconstruction= new int[taille*taille];
            int[] directs = new int[taille*taille*taille];
                                    
            posx=sauvx;

            int s=0;
            int res=0;
            int compteur=0;
            reconstruction[sauvx]=sauvx;

            for(int i = 0 ; i!=-1 ; i++){
                compteur++;
                if(sauvx%taille != 0 && reconstruction[sauvx-1]!=1 && ts[sauvx-1]!=4 && directmp !=1 && s<1 ){
                    if(ts[sauvx-1]!=0){
                        s=1;
                        
                    }else{
                        if( this.e.AnalyseTab(sauvx,1) == 1){  
                            reconstruction[sauvx-1]=1;
                            s=1;   
                        }else{
                            if( this.e.AnalyseTab(sauvx,1) == 2){
                                ts[sauvx]=1;
                                reconstruction[sauvx-1]=0;
                                ti[cmp]=sauvx;
                                sauvx=sauvx-1;
                                directs[cmp]=3;
                                directmp=3;
                                cmp++;
                                s=0;
                                

                            }else{
                                if(this.e.AnalyseTab(sauvx,1) == 5){
                                  break;
                                    
                                }
                            }
                        }
                    }
                }else {
                    if( sauvx < taille*(taille-1) && reconstruction[sauvx+taille]!=1 && ts[sauvx+taille]!=4 && directmp!=2 && s<2 ){
                        if(ts[sauvx+taille]!=0  ){
                            s=2;
                            
                        }else{
                            if(this.e.AnalyseTab(sauvx,2) == 1){ 
                                reconstruction[sauvx+taille]=1; 
                                s=2;  

                            }else{
                                if(this.e.AnalyseTab(sauvx,2) == 2){
                                    ts[sauvx]=2;
                                    reconstruction[sauvx+taille]=0;
                                    ti[cmp]=sauvx;
                                    sauvx=sauvx+taille;
                                    directs[cmp]=4;
                                    directmp=4;
                                    cmp++;
                                    s=0;
                                  

                                }else{
                                    if(this.e.AnalyseTab(sauvx,2) == 5){
                                       
                                       break;
                                    }
                                }
                            }
                        }

                    }else{           

                        if((sauvx%taille) < (taille-1) && reconstruction[sauvx+1]!=1 && ts[sauvx+1]!=4 && directmp!=3 && s<3){

                            if(ts[sauvx+1]!=0){
                                s=3;
                               
                            }else{
                                
                                if(this.e.AnalyseTab(sauvx,3)== 1){ 
                                    reconstruction[sauvx+1]=1; 
                                    s=3;  
                                }else{
                                    if(this.e.AnalyseTab(sauvx,3) == 2){
                                        ts[sauvx]=3;
                                        reconstruction[sauvx+1]=0;
                                        ti[cmp]=sauvx;
                                        sauvx=sauvx+1;
                                        directs[cmp]=1;
                                        directmp=1;
                                        cmp++;
                                        s=0;
                                                     

                                    }else{
                                        if(this.e.AnalyseTab(sauvx,3) == 5){
                                             break;
                                            
                                        }
                                    }
                                }
                            } 

                        }else{
                            if( sauvx > taille-1 && reconstruction[sauvx-taille]!=1 && ts[sauvx-taille]!=4 && s<4){
                                if(directmp==4){
                                    s=4;
                                }else{
                                    if(ts[sauvx-taille]!=0){
                                        s=4;
                                        
                                    }else{
                                        if( this.e.AnalyseTab(sauvx,4) == 1){
                                            reconstruction[sauvx-taille]=1; 
                                            s=4;  
                                        }else{
                                            if(this.e.AnalyseTab(sauvx,4) == 2){
                                                ts[sauvx]=3;
                                                reconstruction[sauvx-taille]=0;
                                                ti[cmp]=sauvx;
                                                sauvx=sauvx-taille;
                                                directs[cmp]=2;
                                                directmp=2;
                                                cmp++;
                                                s=0;
                                                           

                                            }else{
                                                if(this.e.AnalyseTab(sauvx,4) == 5){
                                                    break;
                                                   
                                                }
                                            }
                                        } 
                                    }
                                }
                            }else {
                                        
                                    s=4;

                                    if(s==4 ){
 
                                        if(sauvx > taille - 1 && reconstruction[sauvx-taille]==posx){                                         
                                            cmp=0;
                                            s=0;
                                            directmp=ts[sauvx-taille];
                                            sauvx=posx;

                                        }else{
                                            if(sauvx < taille*(taille-1) && reconstruction[sauvx+1]==posx){
                                                cmp=0;
                                                s=0;
                                                directmp=ts[sauvx+1];
                                                sauvx=posx;
                                            } else{
                                                ts[sauvx]=directs[cmp-1];
                                           
                                                sauvx=ti[cmp-1];
                                                directmp=directs[cmp-2];
                                                
                                                s=0;
                                                cmp--;
                                        }

                                    }

                                    }
                                
                            }
                        }
                    }
                }
            }
            System.out.println("vous avez termine en : "+compteur+ "coups");
            CopieGrille cop = new CopieGrille(compteur,taille);
        }

    }
    

