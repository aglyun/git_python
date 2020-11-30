package com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Formats extends JDialog{	
	/**
	 * 
	 * ��ʽ�࣬������ɫ�ʹ�С������¼�
	 * ���е�ע�����������Ķ�
	 * 
	 * */
	// ������������ָ����Main�����е��ı���ta=�ı���
	protected static final Component ta = Main.ta;
	// ���ڹ�����
	public Formats(JFrame frame) {
		// ������������
		super(frame, "����", true);
		// ��ȡ��������
		Container c = getContentPane();
		
		// ���������ó�FlowLayout����(������)
		// c.setLayout(new FlowLayout(10, 20, 20));
		setLayout(null);
		// ��ӱ�ǩ
		JLabel l1 = new JLabel("������ɫ��");
		JLabel l2 = new JLabel("�����С��");
		JLabel l3 = new JLabel("������");
		// ����������б�
		String[] color = new String[] 
				{"��ɫ","��ɫ","��ɫ","��ɫ","��ɫ","��ɫ","��ɫ","��ɫ"};
		String[] size = new String[] {"�������","�����","���","�к�","С��"};
		String[] type = new String[] {"б��","��б��","����"};
		JComboBox<String> coch1 = new JComboBox<>(color);
		JComboBox<String> coch2 = new JComboBox<>(size);
		JComboBox<String> coch3 = new JComboBox<>(type);		
		// ���ȷ����ť	
		JButton b1 = new JButton("ȷ��");
		// ��������ľ��Բ���(��ǩ)
		l1.setBounds(35, 30, 80, 30);    // x,y,����
		l2.setBounds(35, 70, 80, 30);
		l3.setBounds(35, 110, 80, 30);
		// ������
		coch1.setBounds(115, 30, 60, 25);
		coch2.setBounds(115, 70, 60, 25);
		coch3.setBounds(115, 110, 60, 25);
		// ��ť
		b1.setBounds(75,160,60,30);
		// �����ú�λ�õ����׷�ӵ�����
		c.add(l1);			// 
		c.add(coch1);
		c.add(l2);
		c.add(coch2);
		c.add(l3);
		c.add(coch3);
		c.add(b1);
						
		setResizable(false);    	   // ���õ����Ƿ���Ըı��С
		setBounds(555,255,230,260);    // ���õ������ֵ�λ�úʹ�С		
		validate();					   // ˢ������
		
		// ����ʽ����ť�Ĵ����¼�������					
		// ���������ɫ�¼�		
		coch1.addItemListener(new ItemListener() {		
			public void itemStateChanged(ItemEvent e) {			
				int color = coch1.getSelectedIndex();			
				switch (color) {
				case 0:ta.setForeground(Color.red);break;
				case 1:ta.setForeground(Color.blue);break;
				case 2:ta.setForeground(Color.green);break;
				case 3:ta.setForeground(Color.yellow);break;
				case 4:ta.setForeground(Color.pink);break;
				case 5:ta.setForeground(Color.orange);break;
				case 6:ta.setForeground(Color.black);break;
				case 7:ta.setForeground(Color.white);break;
				default:break;}							
			}
		});
		
		 //����ֺŴ�С�¼�
		 coch2.addItemListener(new ItemListener() {						
			public void itemStateChanged(ItemEvent e) {
				int size = coch2.getSelectedIndex();	
				// ���������ִ�ж�Ӧ���¼�
				switch (size) {    
				case 0:ta.setFont(new Font("����",Font.BOLD,52));break;
				case 1:ta.setFont(new Font("����",Font.BOLD,42));break;
				case 2:ta.setFont(new Font("����",Font.BOLD,32));break;
				case 3:ta.setFont(new Font("����",Font.BOLD,22));break;
				case 4:ta.setFont(new Font("����",Font.BOLD,12));break;					
				default:break;}						
			}
		});

		 // ����������¼�
		 coch3.addItemListener(new ItemListener() {				
			public void itemStateChanged(ItemEvent e) {
				int type = coch3.getSelectedIndex();
				if (type == 0) {ta.setFont(new Font("б��",Font.LAYOUT_NO_START_CONTEXT,20));}					
				else if (type== 1) {ta.setFont(new Font("��б��",Font.BOLD+Font.ITALIC,20));}
				else if (type == 2) {ta.setFont(new Font("����",Font.BOLD,20));}
			}
		});	
		 
		 // ͬ�ϣ����嵯���а�ť���¼�
		 b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ����¼��ǵ����ȷ�ϰ�ťʱ�رյ���	
				
				setVisible(false);				
			}
		});	
		
		 
	}
}


