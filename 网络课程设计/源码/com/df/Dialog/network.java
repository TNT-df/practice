package com.df.Dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import com.df.network.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.df.network.protocol;

import jpcap.NetworkInterfaceAddress;

import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JTextField;
import java.awt.SystemColor;
//当前所选网卡窗口
public class network extends JDialog {
	static protocol pro = new protocol();
	private JTextField ip1;
	private JTextField Mac;
	private JTextField zw1;
	private JTextField ip2;
	private JTextField zw2;
	private JTextField txtEthernet;
	
	/**
	 * Create the dialog.
	 */
	public network(int select) {
		getContentPane().setForeground(SystemColor.desktop);
		setTitle("当前网卡信息");
		this.getContentPane().setFont(new Font("宋体", Font.PLAIN, 14));
		setBounds(100, 100, 597, 418);
		this.getContentPane().setLayout(null);

		JLabel 网卡Mac = new JLabel("网卡Mac：");
		网卡Mac.setFont(new Font("宋体", Font.BOLD, 16));
		网卡Mac.setBounds(63, 39, 117, 42);
		this.getContentPane().add(网卡Mac);

		Mac = new JTextField();
		Mac.setFont(new Font("宋体", Font.PLAIN, 15));
		byte[] b = pro.devices[select].mac_address;
		Mac.setText(getMacadress(b));
		Mac.setBounds(232, 50, 176, 21);
		this.getContentPane().add(Mac);
		Mac.setColumns(30);

		JLabel 本机ip = new JLabel("本机IP地址(IPV6)：");
		本机ip.setFont(new Font("宋体", Font.BOLD, 16));
		本机ip.setBounds(63, 103, 159, 25);
		this.getContentPane().add(本机ip);

		JLabel lblipv = new JLabel("子网掩码(IPV6):");
		lblipv.setFont(new Font("宋体", Font.BOLD, 16));
		lblipv.setBounds(68, 162, 139, 15);
		this.getContentPane().add(lblipv);         
		NetworkInterfaceAddress[] k = pro.devices[select].addresses;
		ip1 = new JTextField();
		ip1.setText(k[0].address + "");
		ip1.setBounds(232, 105, 238, 21);
		this.getContentPane().add(ip1);
		ip1.setColumns(30);
		ip1.setFont(new Font("宋体", Font.PLAIN, 14));

		zw1 = new JTextField();
		zw1.setText(k[0].subnet + "");
		zw1.setFont(new Font("宋体", Font.PLAIN, 14));
		zw1.setBounds(232, 159, 161, 21);
		zw1.setColumns(10);
		this.getContentPane().add(zw1);
		JLabel lblip = new JLabel("本机ip:");
		lblip.setFont(new Font("宋体", Font.BOLD, 16));
		lblip.setBounds(63, 210, 77, 15);
		this.getContentPane().add(lblip);

		ip2 = new JTextField();
		ip2.setFont(new Font("宋体", Font.PLAIN, 14));
		ip2.setText(k[1].address + "");
		ip2.setBounds(231, 207, 239, 21);
		this.getContentPane().add(ip2);
		ip2.setColumns(30);

		JLabel label_1 = new JLabel("子网掩码：");
		label_1.setFont(new Font("宋体", Font.BOLD, 16));
		label_1.setBounds(63, 254, 88, 15);
		this.getContentPane().add(label_1);

		zw2 = new JTextField();
		zw2.setText(k[1].subnet + "");
		zw2.setFont(new Font("宋体", Font.PLAIN, 14));
		zw2.setColumns(30);
		zw2.setBounds(231, 251, 162, 21);
		this.getContentPane().add(zw2);

		JLabel lblNewLabel = new JLabel("网络连接类型:");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel.setBounds(63, 302, 130, 15);
		this.getContentPane().add(lblNewLabel);

		txtEthernet = new JTextField();
		txtEthernet.setFont(new Font("宋体", Font.PLAIN, 14));
		txtEthernet.setText(pro.devices[select].datalink_description);
		txtEthernet.setBounds(232, 299, 159, 21);
		this.getContentPane().add(txtEthernet);
		txtEthernet.setColumns(30);
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
