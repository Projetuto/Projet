        import java.io.*;
        import java.util.*;
        import java.lang.*;
        import java.nio.file.Files;
        import java.nio.file.Paths;
        import javax.swing.JComponent;
        import java.awt.*;

     
        public class GrilleCrea extends JComponent{

            private int[] tab = null;
            private int taille;
            private int nbrCases;
            private Image imgf,aide;
            private int quoiAfficher;
            private String txt = "Prochaine direction :";
            private String finis = "Finis !";
            private String aleatoire = "Tableau aleatoire";
            public  static int x,y;

            public GrilleCrea(int[] tab, int taille, int quoiAfficher){
                super();
                this.tab=tab;
                this.taille=taille;
                nbrCases=taille*taille;
                this.quoiAfficher=quoiAfficher;
                imgf = Toolkit.getDefaultToolkit().getImage("./Image/Finis.jpg");
                aide = Toolkit.getDefaultToolkit().getImage("./Image/Aide.png");
                
            }
            

            public void base(int i){
               
                if(tab[i]==0 ){
                    this.tab[i]=1;
                }else{
                    if(tab[i]==1){
                        this.tab[i]=0;
                    }else {
                        if(tab[i]==2){
                            this.tab[i]=0;
                           
                        }else {
                            if(tab[i]==3){
                                this.tab[i]=0;
                                
                            }
                        }
                    }
                }
            }
            public void entree(int i){

                if(tab[i]==0 ){
                    this.tab[i]=2;
                }else{
                    this.tab[i]=0;
                }      
            }
            public void sortie(int i){

                if(tab[i]==0 ){
                    this.tab[i]=3;
                }else{
                    this.tab[i]=0;
                }                
            }
            public void aleatoire(){

                Random random = new Random();
                int nb,i;

                for(i=0;i<(taille*taille);i++){
                    nb = random.nextInt(2);
                    tab[i]=nb;
                }
                
            }
            public void manuel0(int sauvx, int direction){
 
                int res = sauvx-1;
                this.tab[res]=this.tab[sauvx];
                this.tab[sauvx]=0;
                sauvx=res;

                if(direction==0){
                    txt = "Prochaine direction : NORD";
                }else{
                    if(direction==1){
                        txt = "Prochaine direction : SUD";
                    }else{
                        if(direction==2){
                            txt = "Prochaine direction : OUEST ";
                        }else{
                            if(direction==3){
                                txt = "Prochaine direction : EST ";
                            }
                        }
                    }
                }
                
            }
            public void manuel1(int sauvx , int direction){

                int res = sauvx + 1;
                this.tab[res]=this.tab[sauvx];
                this.tab[sauvx]=0;
                sauvx=res;

                if(direction==0){
                    txt = "Prochaine direction : NORD";
                }else{
                    if(direction==1){
                        txt = "Prochaine direction : SUD";
                    }else{
                        if(direction==2){
                            txt = "Prochaine direction : OUEST ";
                        }else{
                            if(direction==3){
                                txt = "Prochaine direction : EST ";
                            }
                        }
                    }
                }
         
                 
            }
            public void manuel2(int sauvx, int taille , int direction){

                int res=sauvx-taille;
                this.tab[res]=this.tab[sauvx];
                this.tab[sauvx]=0;
                sauvx=res;

                if(direction==0){
                    txt = "Prochaine direction : NORD";
                }else{
                    if(direction==1){
                        txt = "Prochaine direction : SUD";
                    }else{
                        if(direction==2){
                            txt = "Prochaine direction : OUEST ";
                        }else{
                            if(direction==3){
                                txt = "Prochaine direction : EST ";
                            }
                        }
                    }
                }
            
            }
            public void manuel3(int sauvx, int taille,int direction){
 
                int res=sauvx+taille;
                this.tab[res]=this.tab[sauvx];
                this.tab[sauvx]=0;
                sauvx=res;

                if(direction==0){
                    txt = "Prochaine direction : NORD";
                }else{
                    if(direction==1){
                        txt = "Prochaine direction : SUD";
                    }else{
                        if(direction==2){
                            txt = "Prochaine direction : OUEST ";
                        }else{
                            if(direction==3){
                                txt = "Prochaine direction : EST ";
                            }
                        }
                    }
                }
              
            }
            public void manuel4(int direction){
               if(direction==0){
                    txt = "Prochaine direction : NORD";
               }else{
                    if(direction==1){
                        txt = "Prochaine direction : SUD";
                    }else{
                        if(direction==2){
                            txt = "Prochaine direction : OUEST ";
                        }else{
                            if(direction==3){
                                txt = "Prochaine direction : EST ";
                            }
                        }
                    }
               }

            }
            
            @Override
            public void paintComponent(Graphics pinceau){
                Graphics secondPinceau = pinceau.create();
                secondPinceau.setColor(Color.white);
                x=this.getWidth();
                y=this.getHeight();
                //Observateur observ = new Observateur(x,y);
                secondPinceau.fillRect(0,0,this.getWidth(), this.getHeight());
                int large = 40;
                int nbr = 0;

                for(int j = 0 ; j < taille ;j=j+1){
            
                    for( int i = 0 ; i < taille ;i=i+1){
                    	 if(tab[nbr]==0){
                            secondPinceau.setColor(Color.white);
                            secondPinceau.fillRect(j*large,i*large,40,40);
                            secondPinceau.setColor(Color.black);
                            secondPinceau.drawRect(j*large,i*large,40,40);
                        }if(tab[nbr]==1){
                            secondPinceau.setColor(Color.black);
                            secondPinceau.fillRect(j*large,i*large,40,40);
                            secondPinceau.drawRect(j*large,i*large,40,40);
                        }if(tab[nbr]== 3){
                            secondPinceau.setColor(Color.green);
                            secondPinceau.fillRect(j*large,i*large,40,40);
                            secondPinceau.setColor(Color.black);
                            secondPinceau.drawRect(j*large,i*large,40,40);
                        } if(tab[nbr]==2){
                            secondPinceau.setColor(Color.red);
                            secondPinceau.fillRect(j*large,i*large,40,40);
                            secondPinceau.setColor(Color.black);
                            secondPinceau.drawRect(j*large,i*large,40,40);
                        }
                        /*if(tab[nbr]==0){
                            secondPinceau.setColor(Color.white);
                            secondPinceau.fillRect((this.getWidth()/-600)+large*j,(this.getHeight()/275)+large*i,40,40);
                            secondPinceau.setColor(Color.black);
                            secondPinceau.drawRect((this.getWidth()/2-600)+large*j,(this.getHeight()/275)+large*i,40,40);
                        }if(tab[nbr]==1){
                            secondPinceau.setColor(Color.black);
                            secondPinceau.fillRect((this.getWidth()/2-600)+large*j,(this.getHeight()/275)+large*i,40,40);
                            secondPinceau.drawRect((this.getWidth()/2-600)+large*j,(this.getHeight()/275)+large*i,40,40);
                        } if(tab[nbr]==2){
                            secondPinceau.setColor(Color.red);
                            secondPinceau.fillRect((this.getWidth()/2-600)+large*j,(this.getHeight()/275)+large*i,40,40);
                            secondPinceau.setColor(Color.black);
                            secondPinceau.drawRect((this.getWidth()/2-600)+large*j,(this.getHeight()/275)+large*i,40,40); 
                        }if(tab[nbr]== 3){
                            secondPinceau.setColor(Color.green);
                            secondPinceau.fillRect((this.getWidth()/2-600)+large*j,(this.getHeight()/275)+large*i,40,40);
                            secondPinceau.setColor(Color.black);
                            secondPinceau.drawRect((this.getWidth()/2-600)+large*j,(this.getHeight()/275)+large*i,40,40);
                            */
                       
                        nbr ++;
                    }

                }

            if(quoiAfficher!=0){
            	   if(taille%2==0){

                    secondPinceau.setColor(Color.red);
                    secondPinceau.fillRect((taille+1)*40,((taille-2)*40)/2,40,40);
                    secondPinceau.setColor(Color.black);
                    secondPinceau.drawRect((taille+1)*40,((taille-2)*40)/2,40,40);


                    secondPinceau.setColor(Color.green);
                    secondPinceau.fillRect((taille+2)*40,((taille-2)*40)/2,40,40);
                    secondPinceau.setColor(Color.black);
                    secondPinceau.drawRect((taille+2)*40,((taille-2)*40)/2,40,40);

                    secondPinceau.setColor(Color.blue);
                    secondPinceau.fillRect((taille+3)*40 +80,((taille-2)*40)/2,40,40);
                    secondPinceau.setColor(Color.black);
                    secondPinceau.drawRect((taille+3)*40 + 80,((taille-2)*40)/2,40,40);
                    
                    secondPinceau.drawImage(imgf,((taille+3)*40), (((taille-2)*40)/2), this);
                    secondPinceau.setColor(Color.black);
                    secondPinceau.drawRect((taille+3)*40,((taille-2)*40)/2,80,40);

                    secondPinceau.setColor(Color.orange);
                    secondPinceau.fillRect((taille+4)*40 +80,((taille-2)*40)/2,40,40);
                    secondPinceau.setColor(Color.black);
                    secondPinceau.drawRect((taille+4)*40 + 80,((taille-2)*40)/2,40,40);
                    secondPinceau.drawImage(aide,(taille*40)*2+30-50,(taille*40)-50, this);

              

                }else{
                    secondPinceau.setColor(Color.red);
                    secondPinceau.fillRect((taille+1)*40,((taille-3)*40)/2,40,40);
                    secondPinceau.setColor(Color.black);
                    secondPinceau.drawRect((taille+1)*40,((taille-3)*40)/2,40,40);

                    secondPinceau.setColor(Color.green);
                    secondPinceau.fillRect((taille+2)*40,((taille-3)*40)/2,40,40);
                    secondPinceau.setColor(Color.black);
                    secondPinceau.drawRect((taille+2)*40,((taille-3)*40)/2,40,40);

                    secondPinceau.setColor(Color.blue);
                    secondPinceau.fillRect((taille+5)*40,((taille-3)*40)/2,40,40);
                    secondPinceau.setColor(Color.black);
                    secondPinceau.drawRect((taille+5)*40,((taille-3)*40)/2,40,40); 
                    
                    secondPinceau.drawImage(imgf,(taille+3)*40, ((taille-3)*40)/2, this);
                    secondPinceau.setColor(Color.black);
                    secondPinceau.drawRect((taille+3)*40,((taille-3)*40)/2,80,40);

                    secondPinceau.setColor(Color.BLACK);
                    secondPinceau.setFont(new Font("",Font.BOLD,20));
                    secondPinceau.drawString(aleatoire ,(taille*40)*2-((taille*40)/2),500);

                    secondPinceau.setColor(Color.orange);
                    secondPinceau.fillRect((taille+4)*40 +80,((taille-3)*40)/2,40,40);
                    secondPinceau.setColor(Color.black);
                    secondPinceau.drawRect((taille+4)*40 + 80,((taille-3)*40)/2,40,40);
                    secondPinceau.drawImage(aide,(taille*40)*2+30-50,(taille*40)-50, this);

                   /* secondPinceau.setColor(Color.red);
                    secondPinceau.fillRect(this.getWidth()/2-120,this.getHeight()/2-50,40,40);
                    secondPinceau.setColor(Color.black);
                    secondPinceau.drawRect(this.getWidth()/2-120,this.getHeight()/2-50,40,40);

                    secondPinceau.setColor(Color.green);
                    secondPinceau.fillRect(this.getWidth()/2-80,this.getHeight()/2-50,40,40);
                    secondPinceau.setColor(Color.black);
                    secondPinceau.drawRect(this.getWidth()/2-80,this.getHeight()/2-50,40,40);

                    secondPinceau.setColor(Color.blue);
                    secondPinceau.fillRect(this.getWidth()/2+40,this.getHeight()/2-50,40,40);
                    secondPinceau.setColor(Color.black);
                    secondPinceau.drawRect(this.getWidth()/2+40,this.getHeight()/2-50,40,40);
                    
                    secondPinceau.drawImage(imgf,this.getWidth()/2-40,this.getHeight()/2-50, this);
                    secondPinceau.setColor(Color.black);
                    secondPinceau.drawRect(this.getWidth()/2-40,this.getHeight()/2-50,80,40);

                    secondPinceau.setColor(Color.orange);
                    secondPinceau.fillRect(this.getWidth()/2+80,this.getHeight()/2-50,40,40);
                    secondPinceau.setColor(Color.black);
                    secondPinceau.drawRect(this.getWidth()/2+80,this.getHeight()/2-50,40,40);
                    secondPinceau.drawImage(aide,this.getWidth()-50,this.getHeight()-50,this);*/
              
                }
             
            }else{
                secondPinceau.setColor(Color.BLACK);
                secondPinceau.setFont(new Font("",Font.BOLD,12));
                secondPinceau.drawString(txt ,(taille+1)*40,((taille+2)*40)/3);
            }
        }

    }



