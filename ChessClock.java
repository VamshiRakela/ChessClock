# ChessClock
This project implements a software version of chess clock.

/*
 * Author : Vamshi Rakela
 * Dt: 6-January-2016
 * 
 */
package reverse111;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.*;

class Reverse111 implements ActionListener
{
    Font f;
    
    JFrame frame;
    JPanel panel;
    JLabel txta1,txta2;
    JTextField tf1,tf2,tf3,tf11,tf21,tf31;
    JButton b1,b2;
    Timer timer1,timer2;
    
    Reverse111()
    {
        f=new Font("Verdana",Font.BOLD,32);
        
        timer1=new Timer(1000,new TIMER1());
	timer2=new Timer(1000,new TIMER2());
        
        frame=new JFrame();
	panel=new JPanel();
        
        txta1=new JLabel();
        txta1.setText("00:00:00");
	txta2=new JLabel();
	txta2.setText("00:00:00");
        
        tf1=new JTextField(10);
	tf2=new JTextField(10);
	tf3=new JTextField(10);
        
        tf11=new JTextField(10);
	tf21=new JTextField(10);
	tf31=new JTextField(10);
        
        b1=new JButton("White");
	b2=new JButton("Black");
        
        txta1.setFont(f);
        txta2.setFont(f);
        
        
        txta1.setForeground(Color.BLUE);
        
        
        txta2.setForeground(Color.BLACK);
        
        panel.add(txta1);
	panel.add(tf1);
	panel.add(tf2);
	panel.add(tf3);
        
	panel.add(txta2);
	panel.add(tf11);
	panel.add(tf21);
	panel.add(tf31);
        
        panel.add(b1);
        panel.add(b2);
        
        frame.add(panel);   
        
        frame.setTitle("Countdown Timer");
	frame.pack();
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        b1.addActionListener((ActionListener) this);
	b2.addActionListener((ActionListener) this);
        
    }
    public static void main(String args[])
    {
        new Reverse111();
    }
    
    public void actionPerformed(ActionEvent ae)
    {	
        if(ae.getSource()==b1)
        {
            timer2.stop();
            timer1.start();
        }
        if(ae.getSource()==b2)
        {
            timer1.stop();
            timer2.start();
        }
        
    }
    class TIMER1 implements ActionListener
    {
         public void actionPerformed(ActionEvent ae)
        {
                tf1.setVisible(false);
		tf2.setVisible(false);
		tf3.setVisible(false);
				
		int hr=Integer.parseInt(tf1.getText());
		int min=Integer.parseInt(tf2.getText());
		int sec=Integer.parseInt(tf3.getText());

                int  totsec =hr*3600+min*60+sec;

		int HR;
		int MIN;
		int SEC;


               	System.out.println(totsec);		
		HR=totsec/3600;
		MIN=(totsec%3600)/60;
                SEC=(totsec%3600)%60;	
		String str=HR+":"+MIN+":"+SEC;
		String shr=""+HR;
		String smin=""+MIN;
		--SEC;
		String ssec=""+SEC;


		tf1.setText(shr);				
		tf2.setText(smin);				
		tf3.setText(ssec);	
		txta1.setText(str);
        }
    }
    class TIMER2 implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
                tf11.setVisible(false);
		tf21.setVisible(false);
		tf31.setVisible(false);
                int hr=Integer.parseInt(tf11.getText());
         	int min=Integer.parseInt(tf21.getText());
   		int sec=Integer.parseInt(tf31.getText());
                int  totsec =hr*3600+min*60+sec;
		int HR;
		int MIN;
                int SEC;
               	System.out.println(totsec);		
                HR=totsec/3600;
                MIN=(totsec%3600)/60;
                SEC=(totsec%3600)%60;	
		String str=HR+":"+MIN+":"+SEC;
                String shr=""+HR;
	
                String smin=""+MIN;
		--SEC;
                String ssec=""+SEC;


				tf11.setText(shr);				
				tf21.setText(smin);				
				tf31.setText(ssec);	
				txta2.setText(str);                
                
        }
    }
    
}
