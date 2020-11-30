package com;

import java.awt.event.*;
import javax.swing.*;
import java.io.File;		// io��������õ��Ŀ�
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


// �̳�������������������е������������
public class MenuBars extends Main{
	/**
	 * �˵�������������Ĺ��ܣ����е�ע�����������Ķ�
	 * 
	 * */
	// �����˵�ѡ��
	JMenu file = new JMenu("�ļ�(F)");
	JMenu edit = new JMenu("�༭(E)");
	JMenu format = new JMenu("��ʽ(O)");
	JMenu help = new JMenu("����(H)");
	// �ڱ༭��ѡ������Ӳ˵����
	JMenuItem newItem = new JMenuItem("�½�(N)");
	JMenuItem openItem = new JMenuItem("��(O)...");
	JMenuItem saveItem = new JMenuItem("����(S)");
	JMenuItem closeItem = new JMenuItem("�ر�(C)");
	JMenuItem exitItem = new JMenuItem("�˳�(X)");
	// �༭�˵�	
	JMenuItem copyItem = new JMenuItem("����(C)");
	JMenuItem poasteItem = new JMenuItem("ճ��(P)");
	JMenuItem findItem = new JMenuItem("����(F)");
	JMenuItem receItem = new JMenuItem("�滻(R)");
	// ��ʽ�˵�
	JCheckBoxMenuItem wline = new JCheckBoxMenuItem("�Զ�����(W)...");
	JMenuItem fontItem = new JMenuItem("����(F)...");
	// �����˵���
	JMenuItem aboutlItem = new JMenuItem("���ڼ��±�(A)");
	
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
	
	/**
	 * 1����װ���
	 * 2���¼��������ʹ����¼���ڣ���������������¼�
	 * 
	 * */
	public void mbs() {	
		// ���ļ��˵�����Ӳ˵����
		file.add(newItem);
		file.add(openItem);
		file.add(saveItem);
		file.add(closeItem);
		file.addSeparator();   // �ָ���
		file.add(exitItem);
		
		// ���༭��Ӳ˵����
		edit.add(copyItem);
		edit.add(poasteItem);
		edit.addSeparator();   // �ָ���
		edit.add(findItem);
		edit.add(receItem);
		
		// ����ʽ��Ӳ˵����
		format.add(wline);		
		format.addSeparator();   // �ָ���
		format.add(fontItem);
		// ��������Ӳ˵����
		help.add(aboutlItem);		
	
		// ���˵��ڴ�������ʾ
		mb.add(file);		// �˵���(�ļ�)
		mb.add(edit);		// �˵���(�༭)
		mb.add(format);		// �˵���(��ʽ)
		mb.add(help);		// �˵���(����)
		
		// �˵������¼�(�˳��¼�)
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// �˵������¼�(�����¼�)
		aboutlItem.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				Helps hs= new Helps(f); // �����Ӵ��ڶ���
				hs.setVisible(true);    // ��ʾ�Ӵ���			
			}
		});
		
		// �˵������¼�(��ť���ļ��¼�)
		openItem.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {		
				openfile.setVisible(true);	//  ��ʾ���ļ��ĶԻ���
				// ��ȡ�ļ�·�����ļ���
				File file = new File(openfile.getDirectory()+openfile.getFile());
			 try {  // ��׽�򿪶�ȡ�ļ�����
				 // �����ַ�������
				FileReader fr = new FileReader(file);
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
					e1.printStackTrace();
				}
			} catch (FileNotFoundException e1) {
				// Ҳ�����������������Ϣ
					
			   } 
			}
		});
		
		// �˵������¼�(��ť�����ļ��¼�)
		saveItem.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				// savefile ��һ������İ�ť
				savefile.setVisible(true);
				try {					
					FileWriter fw = new FileWriter(savefile.getDirectory()+savefile.getFile());  // �����
					// ���ı�����ļ�д�뵽�ļ�
					String sttr ;    // �ַ��������洢�ı�					
					sttr = ta.getText();  // ��ȡ�ı�������ݣ���ֵ��sttr					
					// System.out.println(sttr); // ��������Ƿ������������ı��������					
					fw.write(sttr);    // write д������					
					fw.close();		 // �ر��ļ�
					
				} catch (IOException e1) {
					
				}			
			}
		});
		  
		// �˵������¼�(�Զ������¼�)
		wline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
			// �жϸ�ѡ���Ƿ񱻹�ѡ
				if (wline.getState()) {
					ta.setLineWrap(true);           // Ϊ�棬�ı�������ݾ��Զ�����
					ta.setWrapStyleWord(true);      // ���е�������	
				} else {
					ta.setLineWrap(false);			// ȡ������
				}					
			}
		});
		
		// �˵������¼�(��ť�ر��ļ��¼�)
		closeItem.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				// ������ر��ļ�ʱ������ı��������
				ta.setText("");							
			}
		});
		// �˵������¼�(��ʽ��ť�¼�)
		 fontItem.addActionListener(new ActionListener() {				
			public void actionPerformed(ActionEvent e) {
				// ��������
				Formats formats = new Formats(f);
				// ��ʾ��ʽ�ĵ���
				formats.setVisible(true);			
			}
		});
	   
		// �˵������¼�(����/�滻��ť�¼�)
		findItem.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				Cat cat = new Cat(f);	// �����鿴��ť��������
				cat.setVisible(true);	// ��ʾ����			
			}
		});
		receItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cat cat = new Cat(f);	// ͬ��
				cat.setVisible(true);					
			}
		});
	
		// �˵������¼�(�½��ļ���ť�¼�)
		newItem.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
			NewFile newFile = new NewFile(f);
			newFile.setVisible(true);
				
			}
		});
		
		 // �˵������¼�(�����¼�)
	    copyItem.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				RightMenu rm = new RightMenu();
				rm.Cp();	// ���ø��Ʒ���			
			}
		});
	    // �˵������¼�(ճ���¼�)
	    poasteItem.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				RightMenu rm = new RightMenu();
				rm.Pa();	// ����ճ������		
			}
		});	
	  
	 // ����Ҽ��˵��¼�����������÷���
	RightMenu rightMenu = new RightMenu();
	rightMenu.init();	
	}
}
