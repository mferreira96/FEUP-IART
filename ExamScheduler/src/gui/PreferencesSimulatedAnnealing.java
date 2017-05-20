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
public class PreferencesSimulatedAnnealing extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JSlider sliderNumRepetions;

	private JTextField valueMaxIterations;
	private JTextField valueInitialTemperature;
	private JTextField valueTemperatureDecrease;
	private JTextField valueMinimumTemperature;
	
	private int maxIterations;
	private int numRepetitions;
	private double initialTemperature;
	private double minimumTemperature;
	private double coolingRate;
	private SimulatedAnnealing.TypeOfDecrease typeOfDecrease;	

	/**
	 * Create the dialog.
	 */
	public PreferencesSimulatedAnnealing(int maxIterationsSA, int numRepetitionsSA, double initialTemperatureSA, 
			double minimumTemperatureSA, double coolingRateSA, SimulatedAnnealing.TypeOfDecrease typeOfDecreaseSA) {
		
		/* Initializing variables */
		maxIterations = maxIterationsSA;
		numRepetitions = numRepetitionsSA;
		initialTemperature = initialTemperatureSA;
		minimumTemperature = minimumTemperatureSA;
		coolingRate = coolingRateSA;
		typeOfDecrease = typeOfDecreaseSA;		
		
		setResizable(false);
		this.setTitle("Preferences");
		this.setModal(true);
		setBounds(100, 100, 489, 355);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel labelMaxIterations = new JLabel("Maximum Iterations");
		labelMaxIterations.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelMaxIterations.setBounds(10, 21, 125, 14);
		contentPanel.add(labelMaxIterations);

		JLabel labelNumRepetions = new JLabel("Number of Repetitions");
		labelNumRepetions.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelNumRepetions.setBounds(10, 46, 125, 14);
		contentPanel.add(labelNumRepetions);

		JLabel labelInitialTemperature = new JLabel("Initial Temperature");
		labelInitialTemperature.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelInitialTemperature.setBounds(10, 110, 109, 14);
		contentPanel.add(labelInitialTemperature);

		sliderNumRepetions = new JSlider(1, 20, numRepetitions);
		sliderNumRepetions.setFont(new Font("Tahoma", Font.PLAIN, 11));
		sliderNumRepetions.setMajorTickSpacing(1);
		sliderNumRepetions.setSnapToTicks(true);
		sliderNumRepetions.setPaintTicks(true);
		sliderNumRepetions.setPaintLabels(true);
		sliderNumRepetions.setMinorTickSpacing(1);
		sliderNumRepetions.setBounds(145, 46, 328, 51);
		contentPanel.add(sliderNumRepetions);
		
		valueMaxIterations = new JTextField();
		valueMaxIterations.setText(Integer.toString(maxIterations));
		valueMaxIterations.setBounds(145, 18, 86, 20);
		contentPanel.add(valueMaxIterations);
		valueMaxIterations.setColumns(10);
		
		valueInitialTemperature = new JTextField();
		valueInitialTemperature.setText(Double.toString(initialTemperature));
		valueInitialTemperature.setBounds(145, 110, 86, 20);
		contentPanel.add(valueInitialTemperature);
		valueInitialTemperature.setColumns(10);
		
		JLabel lblMinimumTemperature = new JLabel("Minimum Temperature");
		lblMinimumTemperature.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMinimumTemperature.setBounds(10, 152, 125, 14);
		contentPanel.add(lblMinimumTemperature);
		
		valueMinimumTemperature = new JTextField();
		valueMinimumTemperature.setText(Double.toString(minimumTemperature));
		valueMinimumTemperature.setBounds(145, 149, 86, 20);
		contentPanel.add(valueMinimumTemperature);
		valueMinimumTemperature.setColumns(10);
		
		JLabel lblCoolingRate = new JLabel("Cooling rate");
		lblCoolingRate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCoolingRate.setBounds(10, 192, 123, 14);
		contentPanel.add(lblCoolingRate);
		
		valueTemperatureDecrease = new JTextField();
		valueTemperatureDecrease.setText(Double.toString(coolingRate));
		valueTemperatureDecrease.setBounds(145, 192, 86, 20);
		contentPanel.add(valueTemperatureDecrease);
		valueTemperatureDecrease.setColumns(10);
		
		JRadioButton rdbtnMultiplicative = new JRadioButton("Multiplicative");
		rdbtnMultiplicative.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnMultiplicative.setBounds(27, 251, 109, 23);
		contentPanel.add(rdbtnMultiplicative);
		
		JRadioButton rdbtnSubtractive = new JRadioButton("Subtractive");
		rdbtnSubtractive.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnSubtractive.setBounds(174, 251, 109, 23);
		contentPanel.add(rdbtnSubtractive);
		
		if(typeOfDecrease.equals(SimulatedAnnealing.TypeOfDecrease.MULTIPLICATIVE)){
			rdbtnMultiplicative.setSelected(true);
			rdbtnSubtractive.setSelected(false);
		} else {
			rdbtnMultiplicative.setSelected(false);
			rdbtnSubtractive.setSelected(true);
		}		
		
		ButtonGroup groupTemperature = new ButtonGroup();
		groupTemperature.add(rdbtnMultiplicative);
		groupTemperature.add(rdbtnSubtractive);
		
		JLabel lblTypeOfTemperature = new JLabel("Type of Temperature decrease:");
		lblTypeOfTemperature.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTypeOfTemperature.setBounds(10, 230, 174, 14);
		contentPanel.add(lblTypeOfTemperature);

		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				maxIterations = Integer.parseInt(valueMaxIterations.getText());
				numRepetitions = sliderNumRepetions.getValue();
				initialTemperature = Double.parseDouble(valueInitialTemperature.getText());
				minimumTemperature = Double.parseDouble(valueMinimumTemperature.getText());
				coolingRate = Double.parseDouble(valueTemperatureDecrease.getText());
				
				if(rdbtnMultiplicative.isSelected())
					typeOfDecrease = SimulatedAnnealing.TypeOfDecrease.MULTIPLICATIVE;
				else
					typeOfDecrease = SimulatedAnnealing.TypeOfDecrease.SUBTRACTIVE;
				
				closeDialog();							
			}
		});
		btnApply.setBounds(10, 292, 89, 23);
		contentPanel.add(btnApply);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				valueMaxIterations.setText(Integer.toString(maxIterations));
				sliderNumRepetions.setValue(numRepetitions);
				valueInitialTemperature.setText(Double.toString(initialTemperature));
				valueMinimumTemperature.setText(Double.toString(minimumTemperature));
				valueTemperatureDecrease.setText(Double.toString(coolingRate));
				
				if(typeOfDecrease.equals(SimulatedAnnealing.TypeOfDecrease.MULTIPLICATIVE)){
					rdbtnMultiplicative.setSelected(true);
					rdbtnSubtractive.setSelected(false);
				} else {
					rdbtnMultiplicative.setSelected(false);
					rdbtnSubtractive.setSelected(true);
				}

				closeDialog();
			}
		});
		btnBack.setBounds(384, 292, 89, 23);
		contentPanel.add(btnBack);			
		
		JLabel lblC = new JLabel("\u00BA C");
		lblC.setBounds(237, 110, 46, 14);
		contentPanel.add(lblC);
		
		JLabel lblC_1 = new JLabel("\u00BA C");
		lblC_1.setBounds(237, 149, 46, 14);
		contentPanel.add(lblC_1);
	}

	public void closeDialog(){
		this.dispose();
	}
	

	
	public int getMaxIterations(){
		return maxIterations;
	}
	
	public int getNumRepetions(){
		return numRepetitions;
	}
	
	public double getInitialTemperature(){
		return initialTemperature;
	}
	
	public double getMinimumTemperature(){
		return minimumTemperature;
	}
	
	public double getCoolingRate(){
		return coolingRate;
	}
	
	public SimulatedAnnealing.TypeOfDecrease getTypeOfDecrease() {
		return typeOfDecrease;
	}
}