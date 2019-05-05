        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;
        import java.io.*;
        import java.util.*;
public class TraducteurCaseNoir{
	private int i,z,longueur,largeur;
	private static int compt;
	private static Boolean temps = true;
	
	public TraducteurCaseNoir(int x,int y){
		this.longueur=x;
		this.largeur=y;
		if(temps==false){ 
			System.out.println("popo");
		Arrays.toString(Sauv(this.longueur,this.largeur,Enregistrement(compt)));
	}
	
}

public TraducteurCaseNoir(int compteur){
		this.compt=compteur;
		Enregistrer(this.compt);
		
	
}

public int[] Sauv(int x,int y,int[] tab){
for(i=0,z=1;i<tab.length;i++,z++){
			tab[i]=x;
			tab[z]=y;

	}
	Arrays.toString(tab);
	System.out.println("poo");
	return tab;
}

public static void Enregistrer(int compteur){
TraducteurCaseNoir.compt=compteur;
TraducteurCaseNoir.temps=false;
}


public int[] Enregistrement(int compteur){
this.compt=compteur;
int[] tab = new int[compteur];
	return tab;
}
}


