package com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Cat extends JDialog{
	/**
	  * ���Һ��滻���ܵ��࣬���е�ע�����������Ķ�
	 * 
	 * */
	// ������������ָ����Main�����е��ı���ta=�ı���
	protected static final JTextArea ta = Main.ta;
	// ����������
	public Cat(JFrame frame) {
		super(frame,"����/�滻",true);  // Ϊ�棬��������������
		// ��ȡ����
		Container c = getContentPane();
		// ��������
		c.setLayout(null);				
		// �½������Ͱ�ť
		TextField t1s = new TextField(30);
		TextField t2s = new TextField(30);   
		JButton b1 = new JButton("����"),b2 = new JButton("�滻");
		
		// ��ӱ�ǩ		
		Label label1 = new Label();  // �����Ѿ��ҵ�������
		Label label2 = new Label();	 // ��ʾ�Ѿ��滻������
		// ���������λ�úʹ�С(����λ��)
		t1s.setBounds(10,30,170,30);  // x,y,��,��
		b1.setBounds(190,30,80,30);			
		t2s.setBounds(10,80,170,30);
		b2.setBounds(190,80,80,30);
		label1.setBounds(130, 150, 100, 30);
		label2.setBounds(130, 160, 300, 60);
		
		// �����ı����������ֵĴ�С
		t1s.setFont(new Font("����",Font.BOLD,20));
		t2s.setFont(new Font("����",Font.BOLD,20));
		
		// ������������
		c.add(t1s);
		c.add(b1);
		c.add(t2s);
		c.add(b2);
		c.add(label1);
		c.add(label2);
		
		setResizable(false);   		    // ���õ����Ƿ���Ըı��С
		setBounds(555,255,300,250);	 	// x,y,��,��			
		c.validate();					// ˢ������
		
		// �˵������¼�(���Ұ�ť�¼�)	
		b1.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {										
				// ta ���ı���tls �������
				String s1 = ta.getText();    // �����ַ���s1���������ı��������
				String s2 = t1s.getText();	 //  ͬ����s2�����洢�ı��������						
				// ����������ڼ���
				int a = 0;
				int b = 0;
				// �ж��ı����Ƿ�Ϊ��
				if (s2.length()!=0) {
					while ((a = s1.indexOf(s2,a))!=-1) {
						a = a+s2.length();
						b ++;}			
				}else {}
				// ��ʾ�ҵ����ַ�������
				label1.setText("�ҵ� "+b+" ���ַ�");					
			}
		});
		
		 // ����¼�
		b2.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				String tString1 = ta.getText();  // �����ı�������ݴ��浽�ַ���
				String tString2 = t1s.getText(); // �����ı�������ݲ��Ҵ��浽�ַ���
				String tString3 = t2s.getText(); // �����滻�ı����е����ݲ��Ҵ��浽�ַ���			
				// �����ַ������������滻�������
				String Th = "";
				// s1(���)���ı�������ݣ�����replace����������s2���ı��������滻��s3ָ�����ı�
				Th = tString1.replace(tString2, tString3);
				// ta �ı����������дΪTh������
				label2.setText("���滻��  "+tString3 +" �ַ�");
				// �ı������������滻
				ta.setText(Th);		
			}					    
		});		
	}
}
