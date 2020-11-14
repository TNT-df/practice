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
import java.awt.Font;
import java.awt.SystemColor;

public class TCPDialog extends JDialog {
	static protocol pro = new protocol();
	private final JPanel contentPanel = new JPanel();
	private JTextField scr_port;
	private JTextField dst_port;
	private JTextField Sequebcebut;
	private JTextField Acknowledge_number;
	private JTextField URGText;
	private JTextField ACKtext;
	private JTextField PSHbut;
	private JTextField RSTtext;
	private JTextField SYNText;
	private JTextField FINtext;
	private JTextField windowtext;
	private JTextField urgentText;
	private JTextField optionText;

	/**
	 * Create the dialog.
	 */
	public TCPDialog(protocol pro) {
		setForeground(SystemColor.desktop);
		this.pro= pro;
		setTitle("TCP");
		setBounds(100, 100, 568, 295);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(SystemColor.desktop);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("源端口");
			label.setFont(new Font("宋体", Font.PLAIN, 16));
			label.setBounds(34, 10, 54, 15);
			contentPanel.add(label);
		}
		{
			scr_port = new JTextField();
			scr_port.setText(pro.tcp.src_port);
			scr_port.setBounds(98, 7, 66, 21);
			contentPanel.add(scr_port);
			scr_port.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("目标端口");
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
			lblNewLabel.setBounds(302, 10, 66, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			dst_port = new JTextField();
			dst_port.setText(pro.tcp.dst_port);
			dst_port.setBounds(394, 7, 66, 21);
			contentPanel.add(dst_port);
			dst_port.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("序号");
			lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(34, 58, 54, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			Sequebcebut = new JTextField();
			Sequebcebut.setText(pro.tcp.Sequebce_Nubmer);
			Sequebcebut.setBounds(98, 58, 98, 21);
			contentPanel.add(Sequebcebut);
			Sequebcebut.setColumns(10);
		}
		{
			JLabel Acknowledge = new JLabel("确认号");
			Acknowledge.setFont(new Font("宋体", Font.PLAIN, 16));
			Acknowledge.setBounds(300, 61, 84, 15);
			contentPanel.add(Acknowledge);
		}
		{
			Acknowledge_number = new JTextField();
			Acknowledge_number.setText(pro.tcp.Acknowledge_Number);
			Acknowledge_number.setBounds(394, 58, 103, 21);
			contentPanel.add(Acknowledge_number);
			Acknowledge_number.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("URG");
			lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
			lblNewLabel_2.setBounds(20, 110, 39, 15);
			contentPanel.add(lblNewLabel_2);
		}
		{
			URGText = new JTextField();
			URGText.setText(pd(pro.tcp.URG));
			URGText.setBounds(52, 107, 39, 21);
			contentPanel.add(URGText);
			URGText.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("ACK");
			lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
			lblNewLabel_3.setBounds(98, 110, 39, 15);
			contentPanel.add(lblNewLabel_3);
		}
		{
			ACKtext = new JTextField();
			ACKtext.setText(pd(pro.tcp.ACK));
			ACKtext.setBounds(130, 107, 39, 21);
			contentPanel.add(ACKtext);
			ACKtext.setColumns(10);
		}
		{
			JLabel PSHtext = new JLabel("PSH");
			PSHtext.setFont(new Font("宋体", Font.PLAIN, 16));
			PSHtext.setBounds(179, 110, 54, 15);
			contentPanel.add(PSHtext);
		}
		{
			PSHbut = new JTextField();
			PSHbut.setText(pd(pro.tcp.PSH));
			PSHbut.setBounds(211, 107, 39, 21);
			contentPanel.add(PSHbut);
			PSHbut.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("RST");
			lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 16));
			lblNewLabel_4.setBounds(260, 110, 54, 15);
			contentPanel.add(lblNewLabel_4);
		}
		{
			RSTtext = new JTextField();
			RSTtext.setText(pd(pro.tcp.RST));
			RSTtext.setBounds(302, 107, 39, 21);
			contentPanel.add(RSTtext);
			RSTtext.setColumns(10);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("SYN");
			lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 16));
			lblNewLabel_5.setBounds(351, 110, 54, 15);
			contentPanel.add(lblNewLabel_5);
		}
		{
			SYNText = new JTextField();
			SYNText.setText(pd(pro.tcp.SYN));
			SYNText.setBounds(380, 107, 39, 21);
			contentPanel.add(SYNText);
			SYNText.setColumns(10);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("FIN");
			lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 16));
			lblNewLabel_6.setBounds(429, 110, 54, 15);
			contentPanel.add(lblNewLabel_6);
		}
		{
			FINtext = new JTextField();
			FINtext.setText(pd(pro.tcp.FIN));
			FINtext.setBounds(458, 107, 39, 21);
			contentPanel.add(FINtext);
			FINtext.setColumns(10);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("窗口");
			lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 16));
			lblNewLabel_7.setBounds(34, 166, 68, 33);
			contentPanel.add(lblNewLabel_7);
		}
		{
			windowtext = new JTextField();
			windowtext.setText(pd(pro.tcp.window));
			windowtext.setBounds(98, 172, 66, 21);
			contentPanel.add(windowtext);
			windowtext.setColumns(10);
		}
		{
			JLabel lblNewLabel_8 = new JLabel("紧急指针");
			lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 16));
			lblNewLabel_8.setBounds(198, 170, 84, 24);
			contentPanel.add(lblNewLabel_8);
		}
		{
			urgentText = new JTextField();
			urgentText.setText(pro.tcp.Urgent_Pointer);
			urgentText.setBounds(292, 172, 66, 21);
			contentPanel.add(urgentText);
			urgentText.setColumns(10);
		}
		{
			JLabel lblNewLabel_9 = new JLabel("选项");
			lblNewLabel_9.setFont(new Font("宋体", Font.PLAIN, 16));
			lblNewLabel_9.setBounds(393, 175, 54, 15);
			contentPanel.add(lblNewLabel_9);
		}
		{
			optionText = new JTextField();
			optionText.setText(pro.tcp.Option);
			optionText.setBounds(446, 172, 66, 21);
			contentPanel.add(optionText);
			optionText.setColumns(10);
		}
	}
	public String pd(String str) {
		return str=="false"?"0":"1";
	}

}
