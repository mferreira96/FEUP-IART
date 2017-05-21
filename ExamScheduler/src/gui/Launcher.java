package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;


import algorithm.SimulatedAnnealing;
import algorithm.Solver;
import logic.Student;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Launcher {
	private Solver solver;
	
	/* Genetic Algorithm variables */
	int iterationsGA;
	int populationSizeGA;
	double mutationRateGA;
	double crossoverRateGA;
	int elitismCountGA;
	
	/* Simulated Annealing variables */
	private int maxIterationsSA;
	private int numRepetitionsSA;
	private double initialTemperatureSA;
	private double minimumTemperatureSA;
	private double coolingRateSA;	
	private SimulatedAnnealing.TypeOfDecrease typeOfDecreaseSA;

	private JFrame frame;
	private JTable tableExams;
	private JTable tableStudents;
	private JTextField textField;
	private PreferencesGeneticAlgorithm prefGA;
	private PreferencesSimulatedAnnealing prefSA;

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
		/* Genetic Algorithm initialization */
		iterationsGA = 200;
		populationSizeGA = 150;
		mutationRateGA = 0.02;
		crossoverRateGA = 0.7;
		elitismCountGA = 1;
		
		/* Simulated Annealing initialization */
		maxIterationsSA = 200;
		numRepetitionsSA = 5;
		initialTemperatureSA = 20;
		minimumTemperatureSA = 0.001;
		coolingRateSA = 0.95;
		
		typeOfDecreaseSA = SimulatedAnnealing.TypeOfDecrease.MULTIPLICATIVE;
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
		frame.setBounds(100, 100, 554, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Makes the window appears at a centered position on the screen */
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		/* JComboBox for algorithm selection */
		JComboBox<String> algorithmSelect = new JComboBox<String>();
		algorithmSelect.setBounds(181, 250, 144, 20);
		algorithmSelect.addItem("Genetic Algorithm");
		algorithmSelect.addItem("Simulated Annealing");
		frame.getContentPane().add(algorithmSelect);			

		JButton btnRun = new JButton("Run");

		btnRun.setBounds(68, 342, 144, 44);
		frame.getContentPane().add(btnRun);

		JLabel lblSelectAlgorithm = new JLabel("Select algorithm:");
		lblSelectAlgorithm.setBounds(6, 252, 124, 16);
		frame.getContentPane().add(lblSelectAlgorithm);

		/* Students panel */
		JPanel panelStudents = new JPanel();
		panelStudents.setBounds(6, 40, 319, 200);
		frame.getContentPane().add(panelStudents);

		//Two arrays used for the table data
		String[] headerStudents = {"ID", "Name", "Year", "Exams"};

		Object[][] bodyStudents = new Object[solver.getProblem().getStudents().size()][4];

		for (int i = 0; i < solver.getProblem().getStudents().size(); i++){
			bodyStudents[i][0] = solver.getProblem().getStudents().get(i).getId();
			bodyStudents[i][1] = solver.getProblem().getStudents().get(i).getName();
			bodyStudents[i][2] = solver.getProblem().getStudents().get(i).getCurrentYear();
			bodyStudents[i][3] = solver.getProblem().getStudents().get(i).getExams().size();
		}  

		tableStudents = new JTable(bodyStudents, headerStudents);
		tableStudents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tableStudents.getSelectedRow();
				TableModel tableModel = tableStudents.getModel();
				int idStudent = (int) tableModel.getValueAt(index, 0);
				
				Student student = null;
				
				for(int i = 0; i < solver.getProblem().getStudents().size(); i++){
					if (solver.getProblem().getStudents().get(i).getId() == idStudent) {
						student = solver.getProblem().getStudents().get(i);
						break;
					}
				}
				
				ViewStudent viewStudent = new ViewStudent(frame, student);
				viewStudent.setLocationRelativeTo(frame);
				viewStudent.setVisible(true);
			}
		});
		tableStudents.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		panelStudents.setLayout(new BorderLayout(0, 0));
		tableStudents.setFillsViewportHeight(true); 


		JScrollPane tableScrollPaneStudents = new JScrollPane(tableStudents, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		tableStudents.setRowHeight(30);
		tableStudents.setShowGrid(false);

		panelStudents.add(tableScrollPaneStudents);

		
		/* Exams panel */
		JPanel panelExams = new JPanel();
		panelExams.setBounds(369, 40, 171, 111);
		frame.getContentPane().add(panelExams);
		panelExams.setLayout(new BorderLayout(0, 0));
			
		/* Input for number of days */
		textField = new JTextField();
		textField.setText("32");
		textField.setBounds(181, 294, 89, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNumberOfDays = new JLabel("Duration of the period");
		lblNumberOfDays.setBounds(6, 300, 206, 16);
		frame.getContentPane().add(lblNumberOfDays);
		
		JLabel lblStudents = new JLabel("Students");
		lblStudents.setBounds(6, 6, 55, 16);
		frame.getContentPane().add(lblStudents);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setBounds(369, 6, 55, 16);
		frame.getContentPane().add(lblResults);
		
		JLabel lblTimeElapsed = new JLabel("");
		lblTimeElapsed.setBounds(369, 192, 171, 16);
		frame.getContentPane().add(lblTimeElapsed);
						
		/* Menu bar */
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu menuRun = new JMenu("Run");
		menuBar.add(menuRun);

		JMenuItem runGeneticAlgorithm = new JMenuItem("Genetic Algorithm");
		menuRun.add(runGeneticAlgorithm);

		JMenuItem runSimulatedAnnealing = new JMenuItem("Simulated Annealing");
		menuRun.add(runSimulatedAnnealing);

		JMenu menuStudents = new JMenu("Students");
		menuBar.add(menuStudents);

		JMenuItem menuAddStudent = new JMenuItem("Add");
		menuStudents.add(menuAddStudent);

		JMenuItem menuEdit = new JMenuItem("Edit");
		menuStudents.add(menuEdit);

		JMenuItem menuDelete = new JMenuItem("Delete");
		menuStudents.add(menuDelete);

		JMenu menuPreferences = new JMenu("Preferences");
		menuBar.add(menuPreferences);

		JMenuItem preferencesGeneticAlgorithm = new JMenuItem("Genetic Algorithm");
		menuPreferences.add(preferencesGeneticAlgorithm);

		JMenuItem preferencesSimulatedAnnealing = new JMenuItem("Simulated Annealing");
		menuPreferences.add(preferencesSimulatedAnnealing);	
		
		prefGA = new PreferencesGeneticAlgorithm(iterationsGA, populationSizeGA, mutationRateGA,
				crossoverRateGA, elitismCountGA);
		
		prefSA = new PreferencesSimulatedAnnealing(maxIterationsSA, numRepetitionsSA,
				initialTemperatureSA, minimumTemperatureSA, coolingRateSA, typeOfDecreaseSA);

		/* Menu run Genetic Algorithm */
		runGeneticAlgorithm.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				solver.geneticAlgorithm(Integer.parseInt(textField.getText()), prefGA.getIterations(), prefGA.getPopulationSize(), 
						prefGA.getMutationRate(), prefGA.getCrossoverRate(), prefGA.getElitismCount());
			
				//Two arrays used for the table data
				String[] headerExams = {"Exam", "Date"};

				Object[][] bodyExams = new Object[solver.getProblem().getExams().size()][2];

				for (int i = 0; i < solver.getProblem().getExams().size(); i++){
					bodyExams[i][0] = solver.getProblem().getExams().get(i).getName();
					bodyExams[i][1] = solver.getProblem().getExams().get(i).getDate();
				}     		       

				tableExams = new JTable(bodyExams, headerExams);
				tableExams.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				panelExams.setLayout(new BorderLayout(0, 0));
				tableStudents.setFillsViewportHeight(true); 

				JScrollPane tableScrollPaneExams = new JScrollPane(tableExams, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

				tableExams.setRowHeight(30);
				tableExams.setShowGrid(false);
				panelExams.removeAll();
				panelExams.add(tableScrollPaneExams);
				lblTimeElapsed.setText("Time elapsed: "+solver.getProblem().getDuration()+" ms");

				frame.revalidate();
				frame.repaint();				
			}
		});
		
		/* Menu run Simulated Annealing */
		runSimulatedAnnealing.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				solver.simulatedAnnealing(Integer.parseInt(textField.getText()), prefSA.getMaxIterations(), prefSA.getNumRepetions(), 
						prefSA.getInitialTemperature(), prefSA.getMinimumTemperature(), prefSA.getCoolingRate(), prefSA.getTypeOfDecrease());


				//Two arrays used for the table data
				String[] headerExams = {"Exam", "Date"};

				Object[][] bodyExams = new Object[solver.getProblem().getExams().size()][2];

				for (int i = 0; i < solver.getProblem().getExams().size(); i++){
					bodyExams[i][0] = solver.getProblem().getExams().get(i).getName();
					bodyExams[i][1] = solver.getProblem().getExams().get(i).getDate();
				}     		       

				tableExams = new JTable(bodyExams, headerExams);
				tableExams.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				panelExams.setLayout(new BorderLayout(0, 0));
				tableExams.setFillsViewportHeight(true); 

				JScrollPane tableScrollPaneExams = new JScrollPane(tableExams, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

				tableExams.setRowHeight(30);
				tableExams.setShowGrid(false);
				panelExams.removeAll();
				panelExams.add(tableScrollPaneExams);				
				lblTimeElapsed.setText("Time elapsed: "+solver.getProblem().getDuration()+" ms");

				frame.revalidate();
				frame.repaint();				
			}
		});
		
		preferencesGeneticAlgorithm.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				prefGA.setLocationRelativeTo(frame);
				prefGA.setVisible(true);				
			}
		});
		
		preferencesSimulatedAnnealing.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {				
				prefSA.setLocationRelativeTo(frame);
				prefSA.setVisible(true);				
			}
		});
		
		/* Start button listener */
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	

				//TODO  Corrigir valores de entrada do algoritmo
				if(String.valueOf(algorithmSelect.getSelectedItem()).equals("Genetic Algorithm"))
					solver.geneticAlgorithm(Integer.parseInt(textField.getText()), prefGA.getIterations(), prefGA.getPopulationSize(), 
							prefGA.getMutationRate(), prefGA.getCrossoverRate(), prefGA.getElitismCount());
				else
					solver.simulatedAnnealing(Integer.parseInt(textField.getText()), prefSA.getMaxIterations(), prefSA.getNumRepetions(), 
							prefSA.getInitialTemperature(), prefSA.getMinimumTemperature(), prefSA.getCoolingRate(), prefSA.getTypeOfDecrease());

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
				panelExams.removeAll();
				panelExams.add(tableScrollPaneExams);
				lblTimeElapsed.setText("Time elapsed: "+solver.getProblem().getDuration()+" ms");

				frame.revalidate();
				frame.repaint();
			}
		});

	}
}
