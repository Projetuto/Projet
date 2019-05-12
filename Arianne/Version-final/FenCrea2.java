 import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;
        import java.io.*;
        import java.util.*;
    public class FenCrea2 extends JFrame implements ActionListener{
        	private JButton bouton1 = new JButton("A.Aleatoire");
            private JButton bouton2 = new JButton("A.Deterministe");
        	private GridLayout gestionnaire;
        	private JPanel panneau = new JPanel();
            private int tab[]=null;
            private  JLabel texte = new JLabel(" ");
            private static String nomduFichier;

           	public FenCrea2(String nom){
            	FenCrea2.nomduFichier=nom;

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
                        Lecture lec = new Lecture(nomduFichier,1);
                           this.dispose();
    	        	}
                    if(arg0.getSource() == bouton2){

                         Lecture lec = new Lecture(nomduFichier,2);
                            this.dispose();
                        

                    }

    	        }
            
        }
