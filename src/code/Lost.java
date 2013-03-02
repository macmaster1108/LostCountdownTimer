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
	long minute = 50;//6000
	long second = 300;//300
	long realsecond = 999;
	long halfsecond = 50;

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
		while(slidenumber>000){
			//System.out.println(slidenumber);

			if(slidenumber>246){//108:00-005:00
				t0=System.currentTimeMillis();
				do{
					t1=System.currentTimeMillis();
				}
				while (t1-t0<minute);
				updater(slidenumber);
				slidenumber--;

			}

			else if(slidenumber>65){//004:00-001:01   066 = 1:00
				if(slidenumber%4 == 0){
					t0=System.currentTimeMillis();
					do{
						t1=System.currentTimeMillis();
					}
					while (t1-t0<second);
					ps.PlaySounds("Sounds/scannerbeep.wav");
					updater(slidenumber);
					slidenumber--;

				}
				else{
					t0=System.currentTimeMillis();
					do{
						t1=System.currentTimeMillis();
					}
					while (t1-t0<realsecond);
					updater(slidenumber);
					slidenumber--;
				}
			}
			else if(slidenumber>16){//001:00-000:11   016 = 0:10
				if((slidenumber-2)%3 == 0){
				t0=System.currentTimeMillis();
				do{
					t1=System.currentTimeMillis();
				}
				while (t1-t0<second);
				ps.PlaySounds("Sounds/seconds.wav");
				updater(slidenumber);
				slidenumber--;

				}
				else{
					t0=System.currentTimeMillis();
					do{
						t1=System.currentTimeMillis();
					}
					while (t1-t0<realsecond);
					updater(slidenumber);
					slidenumber--;
					
				}

			}
			else if(slidenumber>6){//000:10-000:00
				t0=System.currentTimeMillis();
				do{
					t1=System.currentTimeMillis();
				}
				while (t1-t0<halfsecond);
				ps.PlaySounds("Sounds/seconds.wav");
				updater(slidenumber);
				slidenumber--;


			}
			else if(slidenumber>000){//000:00-hieroglyphs
				t0=System.currentTimeMillis();
				do{
					t1=System.currentTimeMillis();
				}
				while (t1-t0<minute);
				updater(slidenumber);
				slidenumber--;

			}else{
				slidenumber--;
			}



		}//the timer has reached the hieroglyphics
		for(int i = 0; i<10;i++){
			System.out.println("System Failure");
			t0=System.currentTimeMillis();
			do{
				t1=System.currentTimeMillis();
			}
			while (t1-t0<realsecond);
		}
		ps.PlaySounds("Sounds/WarpUp.wav");



				while (input.hasNext()) {
		
		
					if (name.equals("4 8 15 16 23 42")) {
						t0=System.currentTimeMillis();
						do{
							t1=System.currentTimeMillis();
						}
						while (t1-t0<900);
						ps.PlaySounds("Sounds/shuffling.wav");
						slidenumber = 350;
		
					}
		
				}
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

	}

}
