package gui;

import java.awt.EventQueue;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import algorithm.Solver;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.BorderFactory;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Launcher {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Launcher window = new Launcher();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Launcher() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Exame Scheduler");
		frame.setResizable(false);
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		/* Makes the window appears at a centered position on the screen */
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		UtilDateModel model = new UtilDateModel();
		
		Properties properties = new Properties();
		properties.put("text.today", "Today");
		properties.put("text.month", "Month");
		properties.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
		datePicker.getJFormattedTextField().setBackground(new Color(255, 255, 255));
		datePicker.setBounds(328, 30, 154, 30);
		 
		frame.getContentPane().add(datePicker);	
		
		
		
		JComboBox<String> algorithmSelect = new JComboBox<String>();
		algorithmSelect.setBounds(328, 167, 144, 20);
		algorithmSelect.addItem("Genetic Algorithm");
		algorithmSelect.addItem("Simulated Annealing");
		frame.getContentPane().add(algorithmSelect);		
		
		
		JButton btnStart = new JButton("Start");
		
		btnStart.setBounds(326, 117, 89, 23);
		frame.getContentPane().add(btnStart);
		
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Solver solver = new Solver();					
				solver.geneticAlgorithm();
				
				//Two arrays used for the table data
		        String[] columnNames = {"Exam", "Date"};
		        
		        Object[][] data = {
		        		{"Português", "1/06/17"},
		        		{"Matemática", "2/06/17"},
		        		{"Química", "3/06/17"},
		        		{"Biologia", "5/06/17"},
		        		{"Física", "6/06/17"},
		        		{"Inglês", "7/06/17"}        		
		        };

				table = new JTable(data, columnNames);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				
				
				JScrollPane tableScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				table.setRowHeight(30);
				table.setShowGrid(false);
				tableScrollPane.setSize(170, 200);
				frame.getContentPane().add(tableScrollPane);				
				frame.revalidate();
				frame.repaint();
			}
		});
	
	}
}
