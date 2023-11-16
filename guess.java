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

		
		     JFrame f;
		     int randomnum;
		     int tries;
		     JLabel label;
		     JTextField entryyy;
		     JButton button;
		     JLabel infoLabel;

		     Guessme() 
		    {
		        f = new JFrame("Number Guessing Game");
		        f.setSize(400, 250);
		        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        f.setResizable(false);
		        f.setLayout(new BorderLayout(0,0));
		        f.setLocationRelativeTo(null);
		        
		        //getContentPane().setBackground(Color.BLUE);
		        // Set background color of the panel
		       // panel.setBackground(Color.RED);

		        // Add the panel to the content pane
		        //getContentPane().add(panel);

		        // Other components can be added to the panel

		       
		        

		        randomnum = new Random().nextInt(100);
		        tries = 5;
		        
		        JPanel p1=new JPanel();
		        p1.setBackground(Color.red);
		        p1.setPreferredSize(new Dimension(100,100));
		        f.add(p1,BorderLayout.NORTH);

		        label = new JLabel("Guess the number:");
		        label.setBounds(140, 10, 150, 50);
		        f.add(label);
		        

		        entryyy = new JTextField();
		        entryyy.setBounds(100, 50, 200,20);
		        entryyy.setBackground(Color.black);
		        entryyy.setFont(new Font("Areial",Font.PLAIN,18));
		        entryyy.setForeground(Color.red);
		        entryyy.setCaretColor(Color.green);
		        f.add(entryyy);

		       button= new JButton("Guess");
		       button.setBounds(140, 75, 100, 30);
		       button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                checkGuess();
		            }
		        }
		       );
		       
		        f.add(button);

		        infoLabel = new JLabel("*You have 5 tries remaining*");
		        infoLabel.setBounds(10, 120, 350, 100);
		        f.add(infoLabel);

		        f.setLayout(new BorderLayout(10,10));
		        f.setVisible(true);
		    }

		    public void checkGuess() 
		    {
		        try {
		            int guess = Integer.parseInt(entryyy.getText());
		            tries--;
		            
		            

		            
		            if (guess == randomnum)
		            {
		                JOptionPane.showMessageDialog(f, "Congratulations !!!, you guessed correctly in " + (5 - tries) + " tries!");
		                f.dispose();
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
		                    JOptionPane.showMessageDialog(f, "Game Over! The random number was:" + randomnum);
		                    f.dispose();
		                }

		                entryyy.setText("");
		            }
		        } 
		        catch (NumberFormatException e)
		        {
		            JOptionPane.showMessageDialog(f,"Enter a valid number","ERROR",JOptionPane.ERROR_MESSAGE);
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


