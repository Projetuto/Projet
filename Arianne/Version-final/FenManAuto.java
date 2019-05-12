
 import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;
        import java.io.*;
        import java.util.*;
              
        public class FenManAuto extends JFrame implements ActionListener{
        	private JButton bouton1 = new JButton("Mode Manuel");
            private JButton bouton2 = new JButton("Mode Automatique");
        	private GridLayout gestionnaire ;
            private  JLabel texte = new JLabel(" ");
        	private JPanel panneau = new JPanel();
        	private int sauvx,sauvy,taille;
        	private int[] tab; 

           	public FenManAuto(int[] tab, int sauvx, int sauvy, int taille){
            	
				this.tab=tab;
				this.sauvx=sauvx;
				this.sauvy=sauvy;
				this.taille=taille;


                this.setSize(500,500);
                this.setLocation(500, 150);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                GridLayout gestionnaire = new GridLayout(3, 1);
                this.setLayout(gestionnaire);


                this.add(texte, BorderLayout.SOUTH);
                panneau.add(bouton1);
                panneau.add(bouton2);
                this.add(panneau, BorderLayout.SOUTH);
                this.setVisible(true);
                bouton1.addActionListener(this);

     		}

     			public void actionPerformed(ActionEvent arg0) {
    	            if(arg0.getSource() == bouton1){                       
                        Manuel algMan = new Manuel(tab,taille);
                        this.dispose();
    	        	}
                    if(arg0.getSource() == bouton2){
                        AlgoRand algAuto = new AlgoRand(tab,sauvx,sauvy,taille);
                        this.dispose();
                        

                    }

    	        }
            
        }
