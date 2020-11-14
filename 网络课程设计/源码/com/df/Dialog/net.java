package com.df.Dialog;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
import java.awt.SystemColor;
//网卡信息窗口
public class net extends JDialog {
	NetworkInterface[] devices = JpcapCaptor.getDeviceList();
	JTable table = null;
    DefaultTableModel defaultModel = null;
    private final JPanel contentPanel = new JPanel();
    public net() {
    	getContentPane().setForeground(SystemColor.desktop);
    	Container contain=this.getContentPane();
    	Object[][] values = new Object[devices.length][2];
    	for(int i = 0;i<devices.length;i++) {
    		values[i][0] = devices[i].description+" ";
    		values[i][1] = devices[i].name;
    	}
    	String[] n = { "网卡名", "描述" };
    	defaultModel = new DefaultTableModel(values,n);
    	table = new JTable(defaultModel);
    	table.setEnabled(false);
    	table.setPreferredScrollableViewportSize(new Dimension(400, 80));
        JScrollPane s = new JScrollPane(table);
        contain.add(s,BorderLayout.CENTER);
         this.pack();
        this.setVisible(true);              	
    }
    public static void main(String[] args) {
     net t=	new net();
     t.setSize(400,150);   
    }
}
