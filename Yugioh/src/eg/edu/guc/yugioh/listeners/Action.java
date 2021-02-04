package eg.edu.guc.yugioh.listeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


	public class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			{	
				JFrame koko = new JFrame("deck");
				koko.setSize(500, 400);
				koko.setVisible(true);
				
			}			
		}


		
	}