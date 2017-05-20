package gui;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;

import algorithm.SimulatedAnnealing;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class PreferencesGeneticAlgorithm extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JTextField valueIterations;
	private JTextField valueMutationRate;
	private JTextField valueElitismCount;
	private JTextField valueCrossoverRate;
	private JTextField valuePopulationSize;
	
	private int iterations;
	private int populationSize;
	private double mutationRate;
	private double crossoverRate;
	private double elitismCount;	

	/**
	 * Create the dialog.
	 */
	public PreferencesGeneticAlgorithm(int iterationsGA, int populationSizeGA, double mutationRateGA,
			double crossoverRateGA, double elitismCountGA) {
		
		/* Initializing variables */
		iterations = iterationsGA;
		populationSize = populationSizeGA;
		mutationRate = mutationRateGA;
		crossoverRate = crossoverRateGA;
		elitismCount = elitismCountGA;		
		
		setResizable(false);
		this.setTitle("Preferences");
		this.setModal(true);
		setBounds(100, 100, 489, 302);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel labeIterations = new JLabel("Iterations");
		labeIterations.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labeIterations.setBounds(10, 21, 125, 14);
		contentPanel.add(labeIterations);

		JLabel labelMutationRate = new JLabel("Mutation rate");
		labelMutationRate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelMutationRate.setBounds(10, 99, 109, 14);
		contentPanel.add(labelMutationRate);
		
		valueIterations = new JTextField();
		valueIterations.setText(Integer.toString(iterations));
		valueIterations.setBounds(145, 18, 86, 20);
		contentPanel.add(valueIterations);
		valueIterations.setColumns(10);
		
		JLabel lblPopulationSize = new JLabel("Population size");
		lblPopulationSize.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPopulationSize.setBounds(10, 60, 125, 14);
		contentPanel.add(lblPopulationSize);
		
		valuePopulationSize = new JTextField();
		valuePopulationSize.setText(Integer.toString(populationSize));
		valuePopulationSize.setBounds(145, 57, 86, 20);
		contentPanel.add(valuePopulationSize);
		valuePopulationSize.setColumns(10);
		
		valueMutationRate = new JTextField();
		valueMutationRate.setText(Double.toString(mutationRate));
		valueMutationRate.setBounds(145, 96, 86, 20);
		contentPanel.add(valueMutationRate);
		valueMutationRate.setColumns(10);
		
		JLabel lblCrossoverRate = new JLabel("Crossover rate");
		lblCrossoverRate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCrossoverRate.setBounds(10, 138, 125, 14);
		contentPanel.add(lblCrossoverRate);
		
		valueCrossoverRate = new JTextField();
		valueCrossoverRate.setText(Double.toString(crossoverRate));
		valueCrossoverRate.setBounds(145, 135, 86, 20);
		contentPanel.add(valueCrossoverRate);
		valueCrossoverRate.setColumns(10);
		
		JLabel lblElitismCount = new JLabel("Elitism count");
		lblElitismCount.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblElitismCount.setBounds(10, 177, 123, 14);
		contentPanel.add(lblElitismCount);
		
		valueElitismCount = new JTextField();
		valueElitismCount.setText(Double.toString(elitismCount));
		valueElitismCount.setBounds(145, 174, 86, 20);
		contentPanel.add(valueElitismCount);
		valueElitismCount.setColumns(10);		
		
		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				iterations = Integer.parseInt(valueIterations.getText());
				populationSize = Integer.parseInt(valuePopulationSize.getText());
				mutationRate = Double.parseDouble(valueMutationRate.getText());
				crossoverRate = Double.parseDouble(valueCrossoverRate.getText());
				elitismCount = Double.parseDouble(valueElitismCount.getText());	
				
				closeDialog();							
			}
		});
		btnApply.setBounds(10, 241, 89, 23);
		contentPanel.add(btnApply);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				valueIterations.setText(Integer.toString(iterations));
				valuePopulationSize.setText(Integer.toString(populationSize));
				valueMutationRate.setText(Double.toString(mutationRate));
				valueCrossoverRate.setText(Double.toString(crossoverRate));
				valueElitismCount.setText(Double.toString(elitismCount));
				
				closeDialog();
			}
		});
		btnBack.setBounds(384, 241, 89, 23);
		contentPanel.add(btnBack);		
	}

	public void closeDialog(){
		this.dispose();
	}
	
	public int getIterations(){
		return iterations;
	}
	
	public int getPopulationSize(){
		return populationSize;
	}
	
	public double getMutationRate(){
		return mutationRate;
	}
	
	public double getCrossoverRate(){
		return crossoverRate;
	}
	
	public double getElitismCount() {
		return elitismCount;
	}
}