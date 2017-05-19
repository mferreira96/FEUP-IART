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
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;

public class Launcher {
	private Solver solver;

	private JFrame frame;
	private JTable tableExams;
	private JTable tableStudents;
	private JTextField textField;

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
		solver = new Solver();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Exam Scheduler");
		frame.setResizable(false);
		frame.setBounds(100, 100, 651, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Makes the window appears at a centered position on the screen */
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		/* JComboBox for algorithm selection */
		JComboBox<String> algorithmSelect = new JComboBox<String>();
		algorithmSelect.setBounds(378, 168, 144, 20);
		algorithmSelect.addItem("Genetic Algorithm");
		algorithmSelect.addItem("Simulated Annealing");
		frame.getContentPane().add(algorithmSelect);			

		JButton btnStart = new JButton("Start");

		btnStart.setBounds(260, 122, 89, 23);
		frame.getContentPane().add(btnStart);

		JLabel lblSelectAlgorithm = new JLabel("Select algorithm:");
		lblSelectAlgorithm.setBounds(260, 170, 124, 16);
		frame.getContentPane().add(lblSelectAlgorithm);





		/* Date */
		UtilDateModel model = new UtilDateModel();

		Properties properties = new Properties();
		properties.put("text.today", "Today");
		properties.put("text.month", "Month");
		properties.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
		datePicker.getJFormattedTextField().setBackground(new Color(255, 255, 255));
		datePicker.setBounds(278, 227, 154, 30);

		frame.getContentPane().add(datePicker);	







		/* Students panel */
		JPanel panelStudents = new JPanel();
		panelStudents.setBounds(278, 286, 319, 154);
		frame.getContentPane().add(panelStudents);

		//Two arrays used for the table data
		String[] headerStudents = {"ID", "Name", "Current year", "Exams"};

		Object[][] bodyStudents = new Object[solver.getProblem().getStudents().size()][4];

		for (int i = 0; i < solver.getProblem().getStudents().size(); i++){
			bodyStudents[i][0] = solver.getProblem().getStudents().get(i).getId();
			bodyStudents[i][1] = solver.getProblem().getStudents().get(i).getName();
			bodyStudents[i][2] = solver.getProblem().getStudents().get(i).getCurrentYear();
			bodyStudents[i][3] = solver.getProblem().getStudents().get(i).getExams().size();
		}  

		tableStudents = new JTable(bodyStudents, headerStudents);
		tableStudents.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		panelStudents.setLayout(new BorderLayout(0, 0));
		tableStudents.setFillsViewportHeight(true); 


		JScrollPane tableScrollPaneStudents = new JScrollPane(tableStudents, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		tableStudents.setRowHeight(30);
		tableStudents.setShowGrid(false);

		panelStudents.add(tableScrollPaneStudents);



		/* Input for number of says */
		textField = new JTextField();
		textField.setText("32");
		textField.setBounds(513, 119, 122, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNumberOfDays = new JLabel("Number of days");
		lblNumberOfDays.setBounds(401, 125, 100, 16);
		frame.getContentPane().add(lblNumberOfDays);


		JScrollPane tableScrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tableScrollPane.setBounds(6, 122, 168, 153);
		frame.getContentPane().add(tableScrollPane);
		tableScrollPane.setBackground(new Color(255, 255, 255));

		JPanel panelExams = new JPanel();
		tableScrollPane.setColumnHeaderView(panelExams);
		panelExams.setLayout(new BorderLayout(0, 0));

		
		/* Menu bar */
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnRun = new JMenu("Run");
		menuBar.add(mnRun);

		JMenuItem mntmGeneticAlgorithm = new JMenuItem("Genetic Algorithm");
		mnRun.add(mntmGeneticAlgorithm);

		JMenuItem mntmSimulatedAnnealing = new JMenuItem("Simulated Annealing");
		mnRun.add(mntmSimulatedAnnealing);

		JMenu mnNewMenu = new JMenu("Students");
		menuBar.add(mnNewMenu);

		JMenuItem mntmAddStudent = new JMenuItem("Add");
		mnNewMenu.add(mntmAddStudent);

		JMenuItem mntmEdit = new JMenuItem("Edit");
		mnNewMenu.add(mntmEdit);

		JMenuItem mntmDelete = new JMenuItem("Delete");
		mnNewMenu.add(mntmDelete);

		JMenu mnNewMenu_1 = new JMenu("Preferences");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmGeneticAlgorithm_1 = new JMenuItem("Genetic Algorithm");
		mnNewMenu_1.add(mntmGeneticAlgorithm_1);

		JMenuItem mntmSimulatedAnnealing_1 = new JMenuItem("Simulated Annealing");
		mnNewMenu_1.add(mntmSimulatedAnnealing_1);

		/* Start button listener */
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	

				//TODO  Corrigir valores de entrada do algoritmo
				if(String.valueOf(algorithmSelect.getSelectedItem()).equals("Genetic Algorithm"))
					solver.geneticAlgorithm(Integer.parseInt(textField.getText()));
				else
					solver.simulatedAnnealing(Integer.parseInt(textField.getText()), 0.5, 20000, 0.95);




				//Two arrays used for the table data
				String[] headerExams = {"Exam", "Date"};

				Object[][] bodyExams = new Object[solver.getProblem().getExams().size()][2];

				for (int i = 0; i < solver.getProblem().getExams().size(); i++){
					bodyExams[i][0] = solver.getProblem().getExams().get(i).getName();
					bodyExams[i][1] = solver.getProblem().getExams().get(i).getDate();
				}     		       

				tableExams = new JTable(bodyExams, headerExams);
				tableExams.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

				JScrollPane tableScrollPaneExams = new JScrollPane(tableExams, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

				tableExams.setRowHeight(30);
				tableExams.setShowGrid(false);
				tableScrollPaneExams.setSize(170, 200);
				panelExams.removeAll();
				panelExams.add(tableScrollPaneExams);


				frame.revalidate();
				frame.repaint();
			}
		});

		mntmGeneticAlgorithm.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				solver.geneticAlgorithm(Integer.parseInt(textField.getText()));

				//Two arrays used for the table data
				String[] headerExams = {"Exam", "Date"};

				Object[][] bodyExams = new Object[solver.getProblem().getExams().size()][2];

				for (int i = 0; i < solver.getProblem().getExams().size(); i++){
					bodyExams[i][0] = solver.getProblem().getExams().get(i).getName();
					bodyExams[i][1] = solver.getProblem().getExams().get(i).getDate();
				}     		       

				tableExams = new JTable(bodyExams, headerExams);
				tableExams.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

				JScrollPane tableScrollPaneExams = new JScrollPane(tableExams, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

				tableExams.setRowHeight(30);
				tableExams.setShowGrid(false);
				tableScrollPaneExams.setSize(170, 200);
				panelExams.removeAll();
				panelExams.add(tableScrollPaneExams);

				frame.revalidate();
				frame.repaint();				
			}
		});
		
		mntmSimulatedAnnealing.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				solver.simulatedAnnealing(Integer.parseInt(textField.getText()), 0.5, 20000, 0.95);

				//Two arrays used for the table data
				String[] headerExams = {"Exam", "Date"};

				Object[][] bodyExams = new Object[solver.getProblem().getExams().size()][2];

				for (int i = 0; i < solver.getProblem().getExams().size(); i++){
					bodyExams[i][0] = solver.getProblem().getExams().get(i).getName();
					bodyExams[i][1] = solver.getProblem().getExams().get(i).getDate();
				}     		       

				tableExams = new JTable(bodyExams, headerExams);
				tableExams.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

				JScrollPane tableScrollPaneExams = new JScrollPane(tableExams, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

				tableExams.setRowHeight(30);
				tableExams.setShowGrid(false);
				tableScrollPaneExams.setSize(170, 200);
				panelExams.removeAll();
				panelExams.add(tableScrollPaneExams);

				frame.revalidate();
				frame.repaint();				
			}
		});

	}
}
