# Number-Guessing-Game-1-100-

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;


public class Guessme
{

		
		     JFrame frame;
		     int randomnum;
		     int tries;
		     JLabel label;
		     JTextField Enter;
		     JButton button;
		     JLabel infoLabel;

		     Guessme() 
		    {
		        frame = new JFrame("Number Guessing Game");
		        frame.setSize(400, 300);
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setResizable(false);
		        frame.setLayout(new BorderLayout(0,0));
		        frame.setLocationRelativeTo(null);
		    

		        randomnum = new Random().nextInt(100);
		        tries = 5;
		        
		        JPanel p1=new JPanel();
		        p1.setBackground(Color.red);
		        p1.setPreferredSize(new Dimension(100,100));
		        frame.add(p1,BorderLayout.NORTH);

		        label = new JLabel("Guess the number:");
		        label.setBounds(140, 10, 150, 50);
		        frame.add(label);

		        Enter = new JTextField();
		        Enter.setBounds(100, 50, 200,20);
		        frame.add(Enter);

		       button= new JButton("Guess");
		       button.setBounds(140, 75, 100, 30);
		       button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                checkGuess();
		            }
		        }
		       );
		       
		        frame.add(button);

		        infoLabel = new JLabel("*You have 5 tries remaining*");
		        infoLabel.setBounds(10, 120, 350, 100);
		        frame.add(infoLabel);

		        frame.setLayout(new BorderLayout(10,10));
		        frame.setVisible(true);
		    }

		    public void checkGuess() 
		    {
		        try {
		            int guess = Integer.parseInt(Enter.getText());
		            tries--;
		            
		            

		            
		            if (guess == randomnum)
		            {
		                JOptionPane.showMessageDialog(frame, "Congratulations !!!, you guessed correctly in " + (5 - tries) + " tries!");
		                frame.dispose();
		            } 
		            else 
		            {
		                String result = (guess > randomnum) ? "*Too High*" : "*Too Low*";

		                if (tries > 0) 
		                {
		                    infoLabel.setText("The number is " + result + " ,You have " +tries+ " tries remaining");
		                } 
		                else 
		                {
		                    JOptionPane.showMessageDialog(frame, "Game Over! The random number was:" + randomnum);
		                    frame.dispose();
		                }

		                Enter.setText("");
		            }
		        } 
		        catch (NumberFormatException e)
		        {
		            JOptionPane.showMessageDialog(frame,"Enter a valid number","ERROR",JOptionPane.ERROR_MESSAGE);
		        }
		    }

		    public static void main(String[] args) 
		    {
		    	
		        SwingUtilities.invokeLater(new Runnable() 
		        {
		            public void run()
		            {
		                new Guessme();
		            }
		        });
    }
		


	}


