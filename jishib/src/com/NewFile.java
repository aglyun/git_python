package com;

import java.awt.*;    			// �����
import java.awt.event.*;		// �¼���
import java.io.*;				// �ļ���������
import javax.swing.*;			// swing�����
import javax.swing.text.JTextComponent;


public class NewFile extends JDialog{	
	/**
	 * �½��ļ�������������¼������е�ע�����������Ķ�
	 * 
	 * */
	// ������������ָ����Main�����е��ı���ta=�ı���
	protected static final JTextComponent ta = Main.ta;
	// ����������
	public NewFile(JFrame frame) {
		super(frame,"�½��ļ�",true);
		Container c = getContentPane();		// ��ȡ����
		// ���������Ĳ���
		c.setLayout(null);
		JLabel L1 = new JLabel("�����ļ�����");		// ��ʾ��ǩ
		JTextField jt = new JTextField(15);		// �����ı������������ļ���			
		JButton button = new JButton("ȷ��");		// ȷ����ť
		
		// ���ñ�ǩ���ı��򡢰�ť�ľ���λ��
		L1.setBounds(30,12,100,30);
		jt.setBounds(30,42,200,30);				// x,y,��,��
		button.setBounds(255,42,60,30);			
		// �ѱ�ǩ���ı��򡢰�ť׷�ӵ�����	
		add(L1);
		add(jt);
		add(button);
			
		// ���ô���λ�úʹ�С
		setBounds(300,200,355,150);		
		setResizable(false);    				// ���õ����Ƿ���Ըı��С
		
		// ȷ����ť�¼�
		button.addActionListener(new ActionListener() {				
			public void actionPerformed(ActionEvent e) {
				// �½��ļ�����ȡ�ļ�·�����ļ���
				File newfile = new File(jt.getText()+"");			  				
				try {	// ��׽��ʼ
					// �����ļ�	
					newfile.createNewFile();																
					// �����ɹ������ı���򿪸��ļ�
					try {  // ��׽�򿪶�ȡ�ļ�����
						// �����ַ�������
						FileReader fr = new FileReader(newfile);
						// ���ı�����ʾ��Ϣ
						ta.setText("\n - ����ı��������½��ļ��ɹ������ʾ \n - ���ļ�����������Ŀ�ĸ�Ŀ¼�£�����ļ���"
								+ "�ظ���Ĭ�ϴ򿪸��ļ���\n"
								+ " - ��Ҫ�޸���ʾ��ʾ���뵽��Ŀ�µġ�NewFile.java���ļ���53-55�д�������޸�");
						// �������飬����Ϊ999...
						char[] sttr = new char[999999];   
						// ���α��������ڶ�ȡ�����ַ���
						int a = 0;						
						try {  // ��׽��ȡ�ַ�����
							// ѭ����ȡ�ַ�����
							while ((a = fr.read(sttr)) > 0 ) {
								// ȡ�������е��ַ���Ȼ��ת�����ַ������ַ����ı�����ʾ
								ta.setText(new String(sttr,0,a));  // ta���ı���Ķ���
							}
						} catch (IOException e1) {
							// ������ڲ���׽�쳣�ķ�֧
						}
					} catch (FileNotFoundException e1) {
						// �ⲿ��׽�쳣��֧							
					   } 
				} catch (IOException e1) {		
					// ����㲶׽�쳣��֧
				}	
				// �رյ���
				setVisible(false);
			}   
		});	// ����̫�಻�����	
	}	
}
