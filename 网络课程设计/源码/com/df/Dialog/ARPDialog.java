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
//ARP协议的窗口
public class ARPDialog extends JDialog {
	protocol pro = new protocol();

	private final JPanel contentPanel = new JPanel();
	private JTextField hardtype;
	private JTextField prototype;
	private JTextField hlen;
	private JTextField plen;
	private JTextField sender_hardaddr;
	private JTextField sender_protoaddr;
	private JTextField target_hardaddr;
	private JTextField target_protoaddr;
	private JTextField opetationText;

	public ARPDialog(protocol pro) {
		this.pro=pro;
		setTitle("ARP");
		setBounds(100, 100, 552, 421);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("硬件类型：");
			label.setBounds(34, 27, 66, 31);
			contentPanel.add(label);
		}
		
		{
			hardtype = new JTextField();
			hardtype.setText(pro.arp.hardtype);
			hardtype.setBounds(131, 32, 66, 21);
			contentPanel.add(hardtype);
			hardtype.setColumns(10);
		}
		
		{
			JLabel lblNewLabel = new JLabel("协议类型");
			lblNewLabel.setBounds(34, 82, 54, 15);
			contentPanel.add(lblNewLabel);
		}
		
		{
			prototype = new JTextField();
			prototype.setText(pro.arp.prototype);
			prototype.setBounds(131, 79, 66, 21);
			contentPanel.add(prototype);
			prototype.setColumns(10);
		}
		{
			JLabel lblWuli = new JLabel("物理地址长度");
			lblWuli.setBounds(34, 117, 77, 21);
			contentPanel.add(lblWuli);
		}
		{
			hlen = new JTextField();
			hlen.setText(pro.arp.hlen);
			hlen.setBounds(131, 117, 66, 21);
			contentPanel.add(hlen);
			hlen.setColumns(10);
		}
		{
			JLabel label = new JLabel("协议地址长度");
			label.setBounds(34, 161, 77, 15);
			contentPanel.add(label);
		}
		{
			plen = new JTextField();
			plen.setText(pro.arp.plen);
			plen.setBounds(131, 158, 66, 21);
			contentPanel.add(plen);
			plen.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("operation");
			lblNewLabel_4.setBounds(279, 161, 54, 15);
			contentPanel.add(lblNewLabel_4);
		}
		{
			opetationText = new JTextField();
			opetationText.setText(pro.arp.operatipn);
			opetationText.setBounds(375, 158, 66, 21);
			contentPanel.add(opetationText);
			opetationText.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("源MAC");
			lblNewLabel_1.setBounds(34, 206, 66, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			sender_hardaddr = new JTextField();
			sender_hardaddr.setText(getMacadress(pro.srcMacDa));
			sender_hardaddr.setBounds(131, 203, 202, 21);
			contentPanel.add(sender_hardaddr);
			sender_hardaddr.setColumns(10);
		}
		{
			JLabel lblip = new JLabel("源ip");
			lblip.setBounds(34, 244, 54, 15);
			contentPanel.add(lblip);
		}
		{
			sender_protoaddr = new JTextField();
			sender_protoaddr.setText(pro.arp.sender_protoaddr);
			sender_protoaddr.setBounds(131, 241, 202, 21);
			contentPanel.add(sender_protoaddr);
			sender_protoaddr.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("目标Mac");
			lblNewLabel_2.setBounds(34, 283, 54, 15);
			contentPanel.add(lblNewLabel_2);
		}
		{
			target_hardaddr = new JTextField();
			target_hardaddr.setText(getMacadress(pro.desMacDa));
			target_hardaddr.setBounds(131, 280, 202, 21);
			contentPanel.add(target_hardaddr);
			target_hardaddr.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("目标ip");
			lblNewLabel_3.setBounds(34, 318, 54, 15);
			contentPanel.add(lblNewLabel_3);
		}
		{
			target_protoaddr = new JTextField();
			target_protoaddr.setText(pro.arp.target_protoaddr);
			target_protoaddr.setBounds(131, 311, 202, 21);
			contentPanel.add(target_protoaddr);
			target_protoaddr.setColumns(10);
		}
	}
	public String getMacadress(byte b[]) {
		String str = " ";
		int a = 0;
		for (int j = 0; j < b.length; j++) {
			// byte变成int时，根据最高位进行填充，如1100 1100变成1111...1100 1100,即cc变成-52
			a = b[j];
			a = a << 24;
			a = a >>> 24;
			if (j != b.length-1) {
				str += Integer.toHexString(a)+"-";
			} else {
				str += Integer.toHexString(a);
			}
		}
		return str;
	}

}
