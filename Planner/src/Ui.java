import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Ui implements ActionListener{


	
	JFrame frame;
	
	JTextField textField = new JTextField();
	
	JPanel panel;
	JPanel schedule;
	JPanel todoTitle;
	JPanel dailyTasks;
	

	JButton add = new JButton("ADD");
	
	
	
	JLabel[] hours = new JLabel[19];
	JTextField[] inputTasks = new JTextField[19];
	
	List<JButton> done = new ArrayList<>();
	List<JLabel> task = new ArrayList<>();
	
	JLabel toDo = new JLabel("Bella's To Do List:");
	JLabel bellaSchedule ;
	JLabel binder;
	JLabel bee;
	JLabel pooh;
	
	
	
	int count = 0;
	int index = 0;

	
	
	
	ImageIcon image = new ImageIcon("Icon.png");
	ImageIcon binderRings = new ImageIcon(this.getClass().getResource("binderRings-removebg-preview.png"));
	ImageIcon cuteBee = new ImageIcon(this.getClass().getResource("cuteBee-removebg-preview.png"));

	
	
	Font myFont = new Font("Ink Free", Font.BOLD, 30);
	Font toDoFont = new Font("Ink Free", Font.BOLD, 25);
	Font doneFont = new Font("Ink Free", Font.BOLD, 15);
	

	
	 public String dateTime() {
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yy");
		 LocalDateTime now = LocalDateTime.now();
		 return dtf.format(now);
	 }
	
	//constructor
	Ui() {
		
		bellaSchedule = new JLabel("Daily Schedule:  " + dateTime());
		bellaSchedule.setFont(myFont);
		
		binder = new JLabel(binderRings);
		binder.setBounds(10, 10, 50, 900);
		
		bee = new JLabel(cuteBee);
		bee.setBounds(600, 10, 325, 200);
		
	
		frame = new JFrame("Isabella's Planner");
		panel = new JPanel();
		schedule = new JPanel();
		todoTitle = new JPanel();
		dailyTasks = new JPanel();
		
		toDo.setBounds(0, 0, 400, 50);
		toDo.setFont(myFont);
		
		int time = 6;
		for(int i = 0; i < 19; i++) {
			if(time == 13) {
				time = 1;
			}
			
			if(i < 6 || i == 18) {
				hours[i] = new JLabel(time + ":00 am");
			} else {
				hours[i] = new JLabel(time + ":00 pm");
			}
			
			time++;
			
		}
		
		
		

		add.addActionListener(this);
		add.setFont(myFont);
		add.setFocusable(false);
		add.setBounds(1000, 850, 100, 30);
		
		
		//panel declarations
		panel.setBounds(925, 125, 300, 700);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(new Color(175,200,200));
		panel.add(toDo);
		
		todoTitle.setBounds(925, 75, 300, 50);
		todoTitle.setBackground(new Color(175,200,200));
		todoTitle.add(toDo);
		
		
		//schedule panel declarations
		schedule.setBounds(100, 125, 700, 700);
		schedule.setBackground(new Color(175,200,200));
		schedule.setLayout(new GridLayout(19, 2));
		schedule.setComponentZOrder(dailyTasks, 0);
		schedule.setVisible(true);
		
		dailyTasks.setBounds(100, 75, 700, 50);
		dailyTasks.setBackground(new Color(175,200,200));
		dailyTasks.add(bellaSchedule);
		dailyTasks.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		for(int i = 0; i < 19; i++) {
			inputTasks[i] = new JTextField();
			inputTasks[i].setBackground(new Color(175,200,200));
			inputTasks[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			inputTasks[i].setEditable(true);
			inputTasks[i].setFont(myFont);
			
			
			
			hours[i].setFont(myFont);
			hours[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			schedule.add(hours[i]);
			schedule.add(inputTasks[i]);
			
		}
	
		
		//frame control
		frame.setSize(1300, 950);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(150,200,175));
		frame.add(textField);
		frame.setIconImage(image.getImage());
		frame.add(panel);
		frame.add(schedule);
		frame.add(add);
		frame.add(todoTitle);
		frame.add(dailyTasks);
		frame.add(binder);
		frame.add(bee);


		
		//text field control
		textField.setBackground(new Color(175,200,200));
		textField.setBorder(BorderFactory.createEmptyBorder());
		textField.setBorder(BorderFactory.createLineBorder(new Color(175,200,200)));
		textField.setBounds(100, 850, 900, 30);
		textField.setFont(myFont);
		textField.setEditable(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			
		
		if(e.getSource() == add) {
			String element =  "-" + textField.getText();
			task.add(new JLabel(element));
			done.add(new JButton("DONEZO"));
			
			textField.setText("");
	
			done.get(count).addActionListener(this); 
			
			task.get(count).setFont(myFont);
			done.get(count).setFocusable(false);
		
			panel.add(task.get(count));
			panel.add(done.get(count));
			
			
			
			frame.revalidate();
			frame.repaint();
			
			count++;
			index = count - 1;
		}
		
		
		//all responsible for removal
		//initial if prevent out of bounds errors
		
		if(index >= 0) {
			if(e.getSource() == done.get(index)) {
				panel.remove(task.get(index));
				panel.remove(done.get(index));
			
				task.remove(index);
				done.remove(index);
			
				count--;
				index--;
			
			
				frame.revalidate();
				frame.repaint();
			} 
		}
			
		if(index >= 1) {
			if(e.getSource() == done.get(index - 1)) {
				panel.remove(task.get(index - 1));
				panel.remove(done.get(index - 1));
			
				task.remove(index - 1);
				done.remove(index - 1 );
			
				count--;
				index--;
			
			
				frame.revalidate();
				frame.repaint();
				
			} 
		}
		
		if(index >= 2) {	
			if(e.getSource() == done.get(index - 2)) {
				panel.remove(task.get(index - 2));
				panel.remove(done.get(index - 2));
			
				task.remove(index - 2);
				done.remove(index - 2);
			
				count--;
				index--;
			
			
				frame.revalidate();
				frame.repaint();
			}
		}
		
		if(index >= 3) {	
			if(e.getSource() == done.get(index - 3)) {
				panel.remove(task.get(index - 3));
				panel.remove(done.get(index - 3));
			
				task.remove(index - 3);
				done.remove(index - 3);
			
				count--;
				index--;
			
			
				frame.revalidate();
				frame.repaint();
			}
		}
		
		if(index >= 4) {	
			if(e.getSource() == done.get(index - 4)) {
				panel.remove(task.get(index - 4));
				panel.remove(done.get(index - 4));
			
				task.remove(index - 4);
				done.remove(index - 4);
			
				count--;
				index--;
			
			
				frame.revalidate();
				frame.repaint();
			}
		}
		
		if(index >= 5) {	
			if(e.getSource() == done.get(index - 5)) {
				panel.remove(task.get(index - 5));
				panel.remove(done.get(index - 5));
			
				task.remove(index - 5);
				done.remove(index - 5);
			
				count--;
				index--;
			
			
				frame.revalidate();
				frame.repaint();
			}
		}
		
		if(index >= 6) {	
			if(e.getSource() == done.get(index - 6)) {
				panel.remove(task.get(index - 6));
				panel.remove(done.get(index - 6));
			
				task.remove(index - 6);
				done.remove(index - 6);
			
				count--;
				index--;
			
			
				frame.revalidate();
				frame.repaint();
			}
		}
		
		if(index >= 7) {	
			if(e.getSource() == done.get(index - 7)) {
				panel.remove(task.get(index - 7));
				panel.remove(done.get(index - 7));
			
				task.remove(index - 7);
				done.remove(index - 7);
			
				count--;
				index--;
			
			
				frame.revalidate();
				frame.repaint();
			}
		}
		
		if(index >= 8) {	
			if(e.getSource() == done.get(index - 8)) {
				panel.remove(task.get(index - 8));
				panel.remove(done.get(index - 8));
			
				task.remove(index - 8);
				done.remove(index - 8);
			
				count--;
				index--;
			
			
				frame.revalidate();
				frame.repaint();
			}
		}
		
		if(index >= 9) {	
			if(e.getSource() == done.get(index - 9)) {
				panel.remove(task.get(index - 9));
				panel.remove(done.get(index - 9));
			
				task.remove(index - 9);
				done.remove(index - 9);
			
				count--;
				index--;
			
			
				frame.revalidate();
				frame.repaint();
			}
		}
		
		if(index >= 10) {	
			if(e.getSource() == done.get(index - 10)) {
				panel.remove(task.get(index - 10));
				panel.remove(done.get(index - 10));
			
				task.remove(index - 10);
				done.remove(index - 10);
			
				count--;
				index--;
			
			
				frame.revalidate();
				frame.repaint();
			}
		}
	}
}
