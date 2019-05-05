    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.*;
    import java.io.*;
    import java.util.*;

        public class Observateur implements MouseListener{
            
                private int taille;
                private boolean save = true;
                private boolean gate = true;
                private int x,y;
                private GrilleCrea e;
                private int res,clique;
                private int nbrE=0,nbrS=0,sauvx,sauvy;
                private int PositionXNOIR,PositionYNOIR,PositionXROUGE,PositionYROUGE,PositionXVERT,PositionYVERT;
                private int compteur;
            
            public Observateur(GrilleCrea e, int taille ){
                this.e=e;
                this.taille=taille;

            }

            public void mouseClicked(MouseEvent e){

                int gx = e.getX();
                int gy = e.getY();

                if(clique<0 && (nbrE==1 || nbrS==1)){
                    if(clique==-1 && nbrE == 1){
                        if(gx<taille*40 && gy<taille*40){
                            PositionXROUGE=(e.getX()/40)+1;
                            PositionYROUGE=(e.getY()/40)+1;
                            res = ((PositionXROUGE-1)*taille+(PositionYROUGE-1));
                            sauvx=res;
                            this.e.entree(res);
                            this.e.repaint();
                            clique=1;
                            gate=false;
                        }
                    }
                    if(clique==-2 && nbrS == 1 ){
                        if(gx<taille*40 && gy<taille*40){
                            PositionXVERT=(e.getX()/40)+1;
                            PositionYVERT=(e.getY()/40)+1;
                            res =((PositionXVERT-1)*taille+(PositionYVERT-1));
                            this.e.sortie(res);
                            sauvy=res;
                            this.e.repaint();
                            clique=1;
                            save = false;
                        }
                    }
                }else{
                    if(gx<taille*40 && gy<taille*40){
                        PositionXNOIR=(e.getX()/40)+1;
                        PositionYNOIR=(e.getY()/40)+1;
                        compteur++;
                        TraducteurCaseNoir decode = new TraducteurCaseNoir(PositionXNOIR,PositionYNOIR);
                        res = ((PositionXNOIR-1)*taille+(PositionYNOIR-1));
                        if(res==sauvx){
                            nbrE=0;
                        }else{
                            if(res==sauvy){
                                nbrS=0;
                            }
                        }
                        this.e.base(res);
                        this.e.repaint();
                       
                    }
                }

                if(gx>(taille+1)*40 && gx<(taille+2)*40 && gy>((taille/2)-1)*40 && gy<(taille/2)*40){

                        clique=-1;
                        nbrE++;
                
                }

                if(gate==false){
                if(gx>(taille+2)*40 && gx<(taille+3)*40 && gy>((taille/2)-1)*40 && gy<(taille/2)*40){
                    
                        clique=-2;
                        nbrS++;
                }   
            }

                    if(save==false){
                    if(gx>((taille*40)*2+30)-80 && gx<(taille*40)*2+30 && gy>0 && gy<(taille*40)+30+80){ 
                         VueDossier vuedossier = new VueDossier();
                         Decode decodeRouge = new Decode(PositionXROUGE,PositionYROUGE);
                         Decode decodeVert = new Decode(PositionXVERT,PositionYVERT);
                         TraducteurCaseNoir decode = new TraducteurCaseNoir(compteur);

                    }
                }

        }
 
            public void mouseEntered(MouseEvent evenement){}       
            public void mouseExited(MouseEvent evenement){}       
            public void mousePressed(MouseEvent evenement){}
            public void mouseReleased(MouseEvent evenement){}
                
}   

     