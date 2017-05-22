package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import javax.swing.JLabel;
@SuppressWarnings("serial")
public class RemoveStudent extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableStudents;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JPanel panel;
	private JFrame frame;
	private Solver solver;
	private RowPopUp popUp;

	/**
	 * Create the dialog.
	 */
	public RemoveStudent(RowPopUp popUp, DefaultTableModel model, JFrame frame, JScrollPane scrollPane, JTable tableStudents, JPanel panel, Solver solver) {
		this.model = model;
		this.panel = panel;
		this.scrollPane = scrollPane;
		this.frame = frame;
		this.tableStudents = tableStudents;
		this.solver = solver;
		setResizable(false);
		this.setTitle("Remove Student");
		this.setModal(true);
		setBounds(100, 100, 413, 110);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		init();
	}
	
	public void init(){
		
		JComboBox<String> students = new JComboBox<String>();		
		students.setBounds(21, 36, 217, 20);
		
		
		for (int i = 0; i < solver.getProblem().getStudents().size(); i++)
			students.addItem(solver.getProblem().getStudents().get(i).getId() + " - " + solver.getProblem().getStudents().get(i).getName());
		
		contentPanel.add(students);			

		JButton btnDelete = new JButton("Delete");

		btnDelete.setBounds(266, 36, 105, 20);
		contentPanel.add(btnDelete);	
		
		JLabel lblSelectAStudent = new JLabel("Select a student to delete:");
		lblSelectAStudent.setBounds(21, 11, 144, 14);
		contentPanel.add(lblSelectAStudent);
		
		btnDelete.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String segments[] = String.valueOf(students.getSelectedItem()).split(" - ");				
				
				for (int i = 0; i < solver.getProblem().getStudents().size(); i++){
					if (solver.getProblem().getStudents().get(i).getId() == Integer.parseInt(segments[0])){
						solver.getProblem().getStudents().remove(i);
						
						for (int j = 0; j < solver.getProblem().getExams().size(); j++){
							for (int k = 0; k < solver.getProblem().getExams().get(j).getStudents().size(); k++){
								if(solver.getProblem().getExams().get(j).getStudents().get(k).getId() == Integer.parseInt(segments[0])){
									solver.getProblem().getExams().get(j).getStudents().remove(k);
									break;
								}
							}							
						}
						
						break;
					}
				}
				
				
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