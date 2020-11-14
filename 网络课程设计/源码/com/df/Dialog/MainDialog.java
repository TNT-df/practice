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
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
//数据链路层窗口
public class MainDialog extends JDialog {
	static protocol pro = new protocol();

	private final JPanel contentPanel = new JPanel();
	private JTextField caputer_length;
	private JTextField packet_length;
	private JTextField head_data;
	private JTextField data;
	private JTextField data_length;
	private JTextField head_length;
	private JTextField bh;
	private JTextField scrMAC;
	private JTextField destMac;
	public static int select;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 * @throws IOException 
	 */
	public MainDialog(int select) throws IOException {
		this.select=select;
		getinfo();
		
			setTitle("数据链路层");
			setBounds(100, 100, 552, 383);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("实际捕获长度");
				lblNewLabel.setBounds(35, 25, 80, 15);
				contentPanel.add(lblNewLabel);
			}
			
			caputer_length = new JTextField();
			caputer_length.setText(pro.pkt1.caplen);
			caputer_length.setBounds(125, 22, 66, 21);
			contentPanel.add(caputer_length);
			caputer_length.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("包长度");
			lblNewLabel_1.setBounds(35, 62, 54, 15);
			contentPanel.add(lblNewLabel_1);
			
			packet_length = new JTextField();
			packet_length.setText(pro.pkt1.len);
			packet_length.setBounds(125, 59, 66, 21);
			contentPanel.add(packet_length);
			packet_length.setColumns(10);
			

			
			JButton ARP_button = new JButton("ARP");
			ARP_button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ARPDialog arpDialog= new ARPDialog(pro);
					arpDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					arpDialog.setVisible(true);				
				}
			});
			ARP_button.setBounds(59, 253, 114, 47);
			contentPanel.add(ARP_button);
			
			JButton IP_but = new JButton("IP");
			IP_but.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IPDialog ipdialog = new IPDialog(pro);
					ipdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					ipdialog.setVisible(true);
				}
			});
			IP_but.setBounds(352, 253, 101, 47);
			contentPanel.add(IP_but);
//			
//			JLabel label_1 = new JLabel("数据包头部长度");
//			label_1.setBounds(10, 140, 92, 15);
//			contentPanel.add(label_1);
//			
//			head_length = new JTextField();
//			head_length.setText(pro.pkt1.head_length);
//			head_length.setBounds(101, 137, 66, 21);
//			contentPanel.add(head_length);
//			head_length.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("网络层协议");
			lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 16));
			lblNewLabel_4.setBounds(297, 25, 101, 29);
			contentPanel.add(lblNewLabel_4);
			String TEXT=(pro.flag ==1?"ARP":"IP");
			bh = new JTextField();
			bh.setText(TEXT);
			bh.setBounds(408, 30, 66, 21);
			contentPanel.add(bh);
			bh.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("源Mac地址");
			lblNewLabel_2.setBounds(35, 109, 54, 15);
			contentPanel.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("目标Mac地址");
			lblNewLabel_3.setBounds(35, 164, 66, 15);
			contentPanel.add(lblNewLabel_3);
			
			scrMAC = new JTextField();
			scrMAC.setText(pro.getMacadress(pro.srcMacDa));
			scrMAC.setBounds(125, 109, 182, 21);
			contentPanel.add(scrMAC);
			scrMAC.setColumns(10);
			
			destMac = new JTextField();
			destMac.setText(pro.getMacadress(pro.desMacDa));
			destMac.setBounds(125, 161, 182, 21);
			contentPanel.add(destMac);
			destMac.setColumns(10);
		
		
	}
	public void getinfo() throws IOException {
		pro.index=select;
		pro.beginCatch();
		
		
//		  System.out.print(pro.udp.toString());
	}
}
