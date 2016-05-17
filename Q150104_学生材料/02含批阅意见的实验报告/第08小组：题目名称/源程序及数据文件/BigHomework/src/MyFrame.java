import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	Vector patientList=new Vector();
	

	public MyFrame() throws HeadlessException {
		super("���˲�������ϵͳ");

		this.setTitle("���˲�������ϵͳ");
		this.setSize(700,360);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PatientPanel p1 = new PatientPanel();
		this.add(p1);
		this.setVisible(true);
	}
	void readPatFile(){
		try {
			FileInputStream fis;
			fis = new FileInputStream("Patient.txt");
			InputStreamReader dis=new InputStreamReader(fis);
			BufferedReader reader=new BufferedReader(dis);
			String s;
			while((s=reader.readLine())!=null)
			{
				Patient pat=new Patient();
				String[] temp=s.split(" ");
				pat.setPatientNo(temp[0]);
				pat.setPatientName(temp[1]);
				pat.setPatientSex(temp[2]);
				pat.setPatientAge(temp[3]);
				pat.setPatientCard(temp[4]);
				patientList.add(pat);
			}
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	void showPatientPanel(){
		PatientPanel patientPanel=new PatientPanel();
		patientPanel.patientList=this.patientList;
		this.add(patientPanel,BorderLayout.CENTER);
		patientPanel.showPatient(0);
		this.setVisible(true);
	}

}

class PatientPanel extends JPanel{
	Vector patientList=new Vector();
	
	private JTextField patientNo=new JTextField();											//ѧ��
	private JTextField patientName=new JTextField();										//����
	private JTextField patientSex=new JTextField();											//�Ա�
	private JTextField patientCard=new JTextField();
	private JTextField patientAge=new JTextField();
	private String[] btnStr={"��һ��","��һ��","��һ��","���һ��","���","�޸�","ɾ��"};
	private JButton[] btn= new JButton[btnStr.length];

	PatientPanel(){
		this.setLayout(null);
		//��ʾ���
		JLabel lb1=new JLabel("��ţ�");
		lb1.setBounds(30, 10, 100, 20);
		this.add(lb1);
		patientNo.setBounds(100,10, 100, 20);
		this.add(patientNo);
		//��ʾ����
		JLabel lb2=new JLabel("������");
		lb2.setBounds(30, 60, 100, 20);
		this.add(lb2);
		patientName.setBounds(100,60, 100, 20);
		this.add(patientName);
		//��ʾ�Ա�
		JLabel lb3=new JLabel("�Ա�");
		lb3.setBounds(30, 110, 100, 20);
		this.add(lb3);
		patientSex.setBounds(100,110, 100, 20);
		this.add(patientSex);
		//��ʾ����
		JLabel lb4=new JLabel("���䣺");
		lb4.setBounds(30, 160, 100, 20);
		this.add(lb4);
		patientAge.setBounds(100,160, 100, 20);
		this.add(patientAge);
		//��ʾ���֤��
		JLabel lb5=new JLabel("���֤�ţ�");
		lb5.setBounds(30,210, 100, 20);
		this.add(lb5);
		patientCard.setBounds(100,210, 100, 20);
		this.add(patientCard);
		for(int i=0;i<btn.length;i++){
			btn[i]=new JButton(btnStr[i]);
			btn[i].setBounds(30+i*90, 260, 90, 30);
			this.add(btn[i]);
		}
	}
	
	void showPatient(int offset){
		Patient pat=(Patient) patientList.get(offset);
		this.patientNo.setText(pat.getPatentNo());
		this.patientName.setText(pat.getPatientName());
		this.patientSex.setText(pat.getPatientSex());
		this.patientAge.setText(pat.getPatientAge());
		this.patientCard.setText(pat.getPatientCard());
	}
	
}
