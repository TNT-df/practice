package com.df.Dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.df.network.protocol;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;

//UDP协议的窗口
public class UDPDialog extends JDialog {
	static protocol pro = new protocol();
	private final JPanel contentPanel = new JPanel();
	private JTextField scrport;
	private JTextField destport;
	private JTextField len;

	/**
	 * Create the dialog.
	 */
	public UDPDialog(protocol pro) {
		this.pro = pro;
		setTitle("UDP");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(SystemColor.desktop);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("源端口");
			lblNewLabel.setBounds(69, 45, 82, 39);
			contentPanel.add(lblNewLabel);
		}
		{
			scrport = new JTextField();
			scrport.setText(pro.udp.scr_port);
			scrport.setBounds(161, 54, 91, 21);
			contentPanel.add(scrport);
			scrport.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("目标端口");
			lblNewLabel_1.setBounds(69, 112, 54, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			destport = new JTextField();
			destport.setText(pro.udp.dest_port);
			destport.setBounds(163, 109, 91, 21);
			contentPanel.add(destport);
			destport.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("长度");
			lblNewLabel_2.setBounds(69, 165, 54, 15);
			contentPanel.add(lblNewLabel_2);
		}
		{
			len = new JTextField();
			len.setText(pro.udp.length);
			len.setBounds(161, 162, 66, 21);
			contentPanel.add(len);
			len.setColumns(10);
		}
	}

}
