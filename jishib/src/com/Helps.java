package com;

import javax.swing.*;


public class Helps extends JDialog {
	/**
	 * 
	 * ���ڱʼǱ��࣬��űʼǱ��������й����
	 * ���е�ע�����������Ķ�
	 * 
	 * */
	public Helps(JFrame frame) {
		// ������������
		super(frame, "���ڼ��±�", true);
		// ��ȡ���ֵ�����
		getContentPane();         
		setLayout(null);    // ʹ�þ��Բ���
		// ������ǩ
		JLabel L1 = new JLabel("���±�");		
		JLabel L2 = new JLabel("1��ĳĳĳ");
		JLabel L3 = new JLabel("1��ĳĳĳ");
		JLabel L4 = new JLabel("1��ĳĳĳ");
		// ���������λ�úʹ�С
		L1.setBounds(75,10,40,40); 	// x,y,��,��
		L2.setBounds(55,45,80,40);
		L3.setBounds(55,65,80,40);
		L4.setBounds(55,85,80,40);
		// �������ӵ�����
		add(L1);
		add(L2);	
		add(L3);
		add(L4);
	
		setBounds(300,300,200,200);    // ��������ʹ�С
		setResizable(false);		   // ���õ������ɸ��Ĵ�С
		// ˢ������
		validate();	
	
	}

}
