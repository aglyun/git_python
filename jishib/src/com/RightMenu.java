package com;

import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.awt.event.*;
import javax.swing.*;


public class RightMenu extends MenuBars{
	/**
	  * �Ҽ��˵��࣬���е�ע�����������Ķ�
	 * 
	 * */	
    // Ҫʹ��ϵͳ�ļ��а壬��Ҫ�Ȼ�ȡ�������Ǽ��а������ĸƴ��(JQB)
	Clipboard JQB = Toolkit.getDefaultToolkit().getSystemClipboard();
	
	// ���Ʒ���(���¼�)	
	public void Cp() {
		StringSelection copys = new StringSelection(ta.getSelectedText());
		// �����а�ŵ�����Ķ�����
		JQB.setContents(copys, null);
		// �жϼ��а����Ƿ���StringFlavor������
		if (JQB.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
			// ��ճ���İ�ť�¼�����Ϊ�棬Ҳ���Ǵ��������¼�
			poasteItem.setEnabled(true);
		}	
	}
	
	// ճ������(���¼�)
	public void Pa() {
		// �ж��Ƿ�������
		if (JQB.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
			try {
				// ȡ�����а�����ݣ����Ҵ洢���ַ�����
				String str = (String)JQB.getData(DataFlavor.stringFlavor);
				// ���ı����е������滻��str�е�����
				ta.replaceRange(str, ta.getSelectionStart(),ta.getSelectionEnd());
				// setEnabled�����Ǽ�����¼���falseΪ�������¼�
				poasteItem.setEnabled(true);
			} 
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}	
	}
	
    // ���Զ����з���(���¼�) 
	public void Wline() {
		// �жϸ�ѡ���Ƿ񱻹�ѡ
		if (wline.getState()) {
			ta.setLineWrap(true);           // Ϊ�棬�ı�������ݾ��Զ�����
			ta.setWrapStyleWord(true);      // ���е�������	
		} else {
			ta.setLineWrap(false);			// ȡ������
		}					
	}
	 
	// ������̬�����������ļ�����������
    static JPanel Rp = new JPanel();   
	public void init() {
		pop.add(wline);			// �Զ�����
	    pop.addSeparator();		// �ָ���
	    pop.add(copyItem);		// ����
	    pop.add(poasteItem);	// ճ��
	    pop.addSeparator();  	
	    format.add(fontItem);	// ������͸�ʽ���
	    pop.add(format);        // ��Ӹ�ʽ	  
	      
	    // �Ҽ������¼�
	    fontItem.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				// ���������¼�
				Formats formats = new Formats(f);
				// ��ʾ��ʽ�ĵ���
				formats.setVisible(true);					
			}
		});	
	    
	    // �Ҽ����ư�ť����
	    copyItem.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				Cp();	// ���ø��Ʒ���			
			}
		});
	    // �Ҽ�ճ����ť����
	    poasteItem.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				Pa();	// ����ճ������		
			}
		});
	    
	    // �Ҽ��Զ������¼�
	    wline.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				Wline();  // �����Զ����з���				
			}
		});
	}		
}
