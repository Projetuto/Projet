        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;
        import java.io.*;
        import java.util.*;

    public class VueDossier extends JFrame implements ActionListener{
          private JButton bouton1 = new JButton("OK");
          private JButton bouton2 = new JButton("annuler");
          private JTextField champ = new JTextField();  
          private JPanel panneau = new JPanel();
           private JPanel panneau2 = new JPanel();
          private JLabel texte = new JLabel("Créer le dossier : ");


          public VueDossier(){        
            this.setSize(400, 250);
            this.setLocation(100, 100);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            panneau2.add(texte);
            champ.setPreferredSize(new Dimension(100, 20));
            panneau2.add(champ);
            this.add(panneau2,BorderLayout.CENTER);
            panneau.add(bouton1);
            panneau.add(bouton2);
            bouton1.addActionListener(this);
            bouton2.addActionListener(this);
            champ.addActionListener(this);
            this.add(panneau,BorderLayout.SOUTH);          
            this.setVisible(true);
          }


            public void actionPerformed(ActionEvent arg0) {
                      String dossier= champ.getText();
                      String test;
                      Boolean a=true;
                      int i;
                         if(arg0.getSource() == bouton1){
                          test = dossier.substring(0,dossier.length());
                          if(test.contains(".")){
                            String verif = dossier.substring(dossier.length()-3,dossier.length());
                    if(!verif.equals("lab")){ 
                       this.champ.setText("");
                        System.out.println("erreur l'extension doit être .lab");
                    }else{
                           Sauvegarde sauvegarde = new Sauvegarde(dossier);
                           this.setVisible(false);           
                               
                    }
                    
                      
                          }else{
                              this.champ.setText("");
                        	  System.out.println("erreur l'extension doit être .lab");
                          }
                      }
                    

                    if(arg0.getSource() == bouton2){
                        this.setVisible(false);                        
                    }

              

        

}
}

        