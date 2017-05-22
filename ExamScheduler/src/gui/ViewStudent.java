package gui;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import logic.Student;
@SuppressWarnings("serial")
public class ViewStudent extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Student student;
	private JTable tableStudent;

	/**
	 * Create the dialog.
	 */
	public ViewStudent(Student student) {		
		this.student = student;
		setResizable(false);
		this.setTitle("View Student");
		this.setModal(true);
		setBounds(100, 100, 413, 110);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		init();
	}
	
	public void init(){
		
		
		//Two arrays used for the table data
		String[] headerStudent = new String[3+student.getExams().size()];
		
		headerStudent[0] = "ID";
		headerStudent[1] = "Name";
		headerStudent[2] = "Year";
		
		for (int i = 0; i < student.getExams().size(); i++){
			headerStudent[3+i] = student.getExams().get(i).getName();
		}
		
		Object[][] bodyStudent = new Object[1][3+student.getExams().size()];
		
		bodyStudent[0][0] = student.getId();
		bodyStudent[0][1] = student.getName();
		bodyStudent[0][2] = student.getCurrentYear();
		
		for (int i = 0; i < student.getExams().size(); i++){
			bodyStudent[0][3+i] = student.getExams().get(i).getDate();
		}		       

		tableStudent = new JTable(bodyStudent, headerStudent);
		tableStudent.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		contentPanel.setLayout(new BorderLayout(0, 0));
		tableStudent.setFillsViewportHeight(true); 

		JScrollPane tableScrollPaneStudent = new JScrollPane(tableStudent, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		tableStudent.setRowHeight(30);
		tableStudent.setShowGrid(false);
		contentPanel.removeAll();
		contentPanel.add(tableScrollPaneStudent);		
	}

	public void closeDialog(){
		this.dispose();
	}

	public Student getStudent() {
		return student;
	}
	public JTable getTableStudent() {
		return tableStudent;
	}
}