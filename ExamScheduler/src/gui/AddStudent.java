package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import algorithm.Solver;
import logic.Exam;
import logic.Student;

import javax.swing.JLabel;
import javax.swing.JTextField;
@SuppressWarnings("serial")
public class AddStudent extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableStudents;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JPanel panel;
	private JFrame frame;
	private Solver solver;
	private RowPopUp popUp;
	private JTextField studentName;
	private JTextField studentYear;
	private JLabel lblYear;
	private JTextField examName;
	private JTextField examYear;

	/**
	 * Create the dialog.
	 */
	public AddStudent(RowPopUp popUp, DefaultTableModel model, JFrame frame, JScrollPane scrollPane, JTable tableStudents, JPanel panel, Solver solver) {
		this.model = model;
		this.panel = panel;
		this.scrollPane = scrollPane;
		this.frame = frame;
		this.tableStudents = tableStudents;
		this.solver = solver;
		setResizable(false);
		this.setTitle("Add Student");
		this.setModal(true);
		setBounds(100, 100, 413, 339);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);		
		
		init();
	}
	
	public void init(){
		
		ArrayList<Exam> exams = new ArrayList<>();

		studentName = new JTextField();
		studentName.setBounds(109, 11, 184, 20);
		contentPanel.add(studentName);
		studentName.setColumns(10);
		
		studentYear = new JTextField();
		studentYear.setBounds(109, 66, 86, 20);
		contentPanel.add(studentYear);
		studentYear.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 14, 46, 14);
		contentPanel.add(lblName);
		
		lblYear = new JLabel("Year");
		lblYear.setBounds(10, 69, 46, 14);
		contentPanel.add(lblYear);
		
		JComboBox examesToDo = new JComboBox();
		examesToDo.setBounds(109, 223, 146, 20);
		contentPanel.add(examesToDo);
		
		JLabel lblExamsToDo = new JLabel("Exams to do");
		lblExamsToDo.setBounds(10, 226, 76, 14);
		contentPanel.add(lblExamsToDo);
		
		examName = new JTextField();
		examName.setBounds(110, 149, 86, 20);
		contentPanel.add(examName);
		examName.setColumns(10);
		
		examYear = new JTextField();
		examYear.setBounds(291, 149, 54, 20);
		contentPanel.add(examYear);
		examYear.setColumns(10);
		
		JLabel lblExamName = new JLabel("Exam Name");
		lblExamName.setBounds(10, 152, 90, 14);
		contentPanel.add(lblExamName);
		
		JLabel lblYear_1 = new JLabel("Year");
		lblYear_1.setBounds(232, 152, 46, 14);
		contentPanel.add(lblYear_1);
		
		JLabel lblStudentExams = new JLabel("Student Exams:");
		lblStudentExams.setBounds(10, 124, 126, 14);
		contentPanel.add(lblStudentExams);
		
		JButton btnAddExam = new JButton("Add Exam");
		btnAddExam.setBounds(109, 180, 126, 23);
		contentPanel.add(btnAddExam);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.setBounds(109, 276, 126, 23);
		contentPanel.add(btnAddStudent);
		
		btnAddExam.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				examesToDo.addItem(String.valueOf(examName.getText()));
				
				Exam exam = new Exam(solver.getProblem().getExams().size()+exams.size(), examName.getText(), Integer.parseInt(examYear.getText()));
				exams.add(exam);
				examName.setText("");
				examYear.setText("");
			}
		});
		
		btnAddStudent.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {	
				
				System.out.println(exams.size());
				Student student = new Student(solver.getProblem().getStudents().size(), studentName.getText(), Integer.parseInt(studentYear.getText()));	
				
				for (int i = 0; i < exams.size(); i++){
					boolean found = false;
					
					for (int j = 0; j < solver.getProblem().getExams().size(); j++){
						if (exams.get(i).getName().equals(solver.getProblem().getExams().get(j).getName())){
							student.addExam(solver.getProblem().getExams().get(j));
							solver.getProblem().getExams().get(j).addStudent(student);							
							
							found = true;
							break;
						}
					}
					
					if (!found){
						solver.getProblem().getExams().add(exams.get(i));
						student.addExam(exams.get(i));
					}					
					
					solver.getProblem().getStudents().add(student);
				}
				
				System.out.println(student.getExams().size());
				
				Object[][] bodyStudents = new Object[solver.getProblem().getStudents().size()][4];

				for (int i = 0; i < solver.getProblem().getStudents().size(); i++){
					bodyStudents[i][0] = solver.getProblem().getStudents().get(i).getId();
					bodyStudents[i][1] = solver.getProblem().getStudents().get(i).getName();
					bodyStudents[i][2] = solver.getProblem().getStudents().get(i).getCurrentYear();
					bodyStudents[i][3] = solver.getProblem().getStudents().get(i).getExams().size();
				}  

				model = new DefaultTableModel();
				model.addColumn("ID");
				model.addColumn("Name");
				model.addColumn("Year");
				model.addColumn("Exams");

				for(int i = 0; i < solver.getProblem().getStudents().size(); i++){
					model.addRow(bodyStudents[i]);
				}    

				tableStudents = new JTable(model);	
				popUp = new RowPopUp(frame, tableStudents, model, solver);
				
				tableStudents.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						popUp.show(e.getComponent(), e.getX(), e.getY());
					}
				});
				
				tableStudents.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				panel.setLayout(new BorderLayout(0, 0));
				tableStudents.setFillsViewportHeight(true);
				scrollPane = new JScrollPane(tableStudents, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

				tableStudents.setRowHeight(30);
				tableStudents.setShowGrid(false);
				
				closeDialog();
				panel.removeAll();
				panel.add(scrollPane);
				frame.revalidate();
				frame.repaint();
			}
		});
	}

	public void closeDialog(){
		this.dispose();
	}	
}