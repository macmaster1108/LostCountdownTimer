/*
 * Lost Countdown Timer
 * Code by Stephen Keller 3/1/13
 * Based on images and sounds from 'LOST' television show
 * Images made by Stephen Keller
 * Sounds from their respective owner on the internet
 */


package code;

import java.awt.image.BufferedImage;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Lost {
	PlaySound ps;
	String name;
	JFrame frame;
	JPanel panel;
	int slidenumber = 350;
	long t0,t1;
	long minute = 10;
	long second = 10;
	long halfsecond = 2;

	public Lost(){
		Scanner input = new Scanner(System.in);//Scanner initialization
		ps = new PlaySound();//So we can have sounds

		//Set up the counter frame for the first time
		frame = new JFrame("Countdown Timer:");
		//The panel
		panel = new JPanel();
		BufferedImage logopre = HelpfulImageMethods.loadImage("Images/Slide"+ slidenumber +".png");
		ImageIcon iconlogopost = new ImageIcon(logopre);
		JLabel logolabel = new JLabel(iconlogopost);
		panel.add(logolabel);
		frame.add(panel);
		frame.setBackground(java.awt.Color.RED);
		frame.setVisible(true);
		frame.setBounds(5,5,500,300);
		frame.setResizable(false);



		//SCANNER----------------------------------------------------
		while(slidenumber>001){

			if(slidenumber>246){//108:00-005:00
				t0=System.currentTimeMillis();
				do{
					t1=System.currentTimeMillis();
				}
				while (t1-t0<minute);
				slidenumber--;
				updater(slidenumber);
			}

			else if(slidenumber>066){//004:00-001:01
				t0=System.currentTimeMillis();
				do{
					t1=System.currentTimeMillis();
				}
				while (t1-t0<second);
				slidenumber--;
				updater(slidenumber);
				ps.PlaySounds("Sounds/scannerbeep.wav");
			}
			else if(slidenumber>016){//001:00-000:10
				t0=System.currentTimeMillis();
				do{
					t1=System.currentTimeMillis();
				}
				while (t1-t0<second);
				slidenumber--;
				updater(slidenumber);
				ps.PlaySounds("Sounds/seconds.wav");

			}
			else if(slidenumber>06){//000:10-000:00
				t0=System.currentTimeMillis();
				do{
					t1=System.currentTimeMillis();
				}
				while (t1-t0<halfsecond);
				slidenumber--;
				updater(slidenumber);
				ps.PlaySounds("Sounds/seconds.wav");

			}
			else{//000:00-hieroglyphs

			}



		}//the timer has reached the hieroglyphics
		for(int i = 0; i<20;i++){
			System.out.println("System Failure");
		}



		//		while (input.hasNext()) {
		//
		//
		//			if (name.equals("4 8 15 16 23 42")) {
		//				t0=System.currentTimeMillis();
		//				do{
		//					t1=System.currentTimeMillis();
		//				}
		//				while (t1-t0<900);
		//				ps.PlaySounds("Sounds/shuffling.wav");
		//				slidenumber = 350;
		//
		//			}
		//
		//		}
	}

	public void updater(int slidenumber){
		String picname;
		int length = String.valueOf(slidenumber).length();
		if (length == 3){
			picname = "Images/Slide"+ slidenumber +".png";
		}
		else if (length == 2){
			picname = "Images/Slide"+'0'+ slidenumber +".png";
		}else{
			picname = "Images/Slide"+'0'+'0'+ slidenumber +".png";
		}

		frame.remove(panel);
		panel = new JPanel();
		BufferedImage logopre = HelpfulImageMethods.loadImage(picname);
		ImageIcon iconlogopost = new ImageIcon(logopre);
		JLabel logolabel = new JLabel(iconlogopost);
		panel.add(logolabel);
		frame.add(panel);
		panel.repaint();
		frame.validate();
		frame.repaint();
		
		System.out.println(picname);
	}

}
