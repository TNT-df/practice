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
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//IP协议的窗口
public class IPDialog extends JDialog {
	static protocol pro = new protocol();
	private final JPanel contentPanel = new JPanel();
	private JTextField vesion;
	private final JLabel lblNewLabel = new JLabel("区分服务:");
	private final JTextField priprity = new JTextField();
	private final JLabel lblNewLabel_2 =  new JLabel("标识:");
	private final JTextField identification = new JTextField();
	private final JLabel lblDf = new JLabel("DF");
	private final JTextField DF = new JTextField();
	private final JLabel lblNewLabel_3 = new JLabel("MF");
	private final JTextField MF = new JTextField();
	private final JLabel lblNewLabel_4 = new JLabel("片偏移：");
	private final JTextField offset = new JTextField();
	private final JLabel lblNewLabel_5 = new JLabel("生存时间：");
	private final JTextField time_to_live = new JTextField();
	private final JLabel lblNewLabel_6 = new JLabel("协议：");
	private final JTextField protoclo = new JTextField();
	private final JLabel lblNewLabel_7 = new JLabel("源地址：");
	private final JTextField src_add = new JTextField();
	private final JLabel lblNewLabel_8 = new JLabel("目标地址：");
	private final JTextField dest_add = new JTextField();
	private final JLabel lblOptions = new JLabel("可选字段");
	private final JTextField options = new JTextField();
	private final JButton btnNewButton = new JButton("UDP");
	private final JButton btnNewButton_1 = new JButton("TCP");
	private final JLabel lblNewLabel_9 = new JLabel("传输层协议为");
	private final JTextField textField = new JTextField();
	private JTextField sbcd;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public IPDialog(protocol pro) {
		setTitle("IP");
		textField.setBounds(406, 286, 66, 21);
		textField.setColumns(10);
		this.pro =pro;
		options.setText(pro.ip.options);
		options.setBounds(389, 249, 66, 21);
		options.setColumns(10);
		dest_add.setText(pro.ip.dest_add);
		dest_add.setBounds(389, 207, 148, 21);
		dest_add.setColumns(10);
		src_add.setText(pro.ip.scr_add);
		src_add.setBounds(389, 165, 148, 21);
		src_add.setColumns(10);
		protoclo.setText(pro.ip.protoclo);
		protoclo.setBounds(389, 114, 66, 21);
		protoclo.setColumns(10);
		time_to_live.setText(pro.ip.time_to_live);
		time_to_live.setBounds(389, 62, 66, 21);
		time_to_live.setColumns(10);
		offset.setText(pro.ip.offset);
		offset.setBounds(389, 22, 66, 21);
		offset.setColumns(10);
		MF.setText(pd(pro.ip.MF));
		MF.setBounds(156, 227, 38, 21);
		MF.setColumns(10);
		DF.setText(pd(pro.ip.DF));
		DF.setBounds(54, 227, 38, 21);
		DF.setColumns(10);
		identification.setText(pro.ip.Identification);
		identification.setBounds(114, 162, 66, 21);
		identification.setColumns(10);

		priprity.setText(pro.ip.Priprity);
		priprity.setBounds(114, 72, 66, 21);
		priprity.setColumns(10);
		setBounds(100, 100, 632, 423);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("版本:");
			label.setBounds(38, 25, 54, 15);
			contentPanel.add(label);
		}
		{
			vesion = new JTextField();
			vesion.setText(pro.ip.version);
			vesion.setBounds(114, 22, 30, 21);
			contentPanel.add(vesion);
			vesion.setColumns(10);
		}
		{
			lblNewLabel.setBounds(38, 75, 54, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			contentPanel.add(priprity);
		}
		{
			lblNewLabel_2.setBounds(38, 165, 66, 15);
			contentPanel.add(lblNewLabel_2);
		}
		{
			contentPanel.add(identification);
		}
		{
			lblDf.setBounds(38, 230, 54, 15);
			contentPanel.add(lblDf);
		}
		{
			contentPanel.add(DF);
		}
		{
			lblNewLabel_3.setBounds(126, 230, 54, 15);
			contentPanel.add(lblNewLabel_3);
		}
		{
			contentPanel.add(MF);
		}
		{
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_4.setBounds(303, 25, 54, 15);
			contentPanel.add(lblNewLabel_4);
		}
		{
			contentPanel.add(offset);
		}
		{
			lblNewLabel_5.setBounds(303, 65, 76, 15);
			contentPanel.add(lblNewLabel_5);
		}
		{
			contentPanel.add(time_to_live);
		}
		{
			lblNewLabel_6.setBounds(303, 117, 54, 15);
			contentPanel.add(lblNewLabel_6);
		}
		{
			contentPanel.add(protoclo);
		}
		{
			lblNewLabel_7.setBounds(303, 168, 54, 15);
			contentPanel.add(lblNewLabel_7);
		}
		{
			contentPanel.add(src_add);
		}
		{
			lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_8.setBounds(292, 210, 76, 15);
			contentPanel.add(lblNewLabel_8);
		}
		{
			contentPanel.add(dest_add);
		}
		{
			lblOptions.setBounds(303, 252, 54, 15);
			contentPanel.add(lblOptions);
		}
		{
			contentPanel.add(options);
		}
		{
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UDPDialog udpDialog = new UDPDialog(pro);
					udpDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					udpDialog.setVisible(true);
				}
			});
			btnNewButton.setBounds(30, 327, 93, 23);
			contentPanel.add(btnNewButton);
		}
		{
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TCPDialog tcpDialog = new TCPDialog(pro);
					tcpDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tcpDialog.setVisible(true);
				}
			});
			btnNewButton_1.setBounds(137, 327, 93, 23);
			contentPanel.add(btnNewButton_1);
		}
		{
			lblNewLabel_9.setBounds(303, 289, 93, 15);
			contentPanel.add(lblNewLabel_9);
		}
		{
			String text = (pro.flag==3?"UDP":"TCP");
			textField.setText(text);
			contentPanel.add(textField);
		}
		
		JLabel lblNewLabel_10 = new JLabel("首部长度");
		lblNewLabel_10.setBounds(38, 117, 62, 15);
		contentPanel.add(lblNewLabel_10);
		
		sbcd = new JTextField();
		sbcd.setText(protocol.ip.header_length);
		sbcd.setBounds(114, 114, 66, 21);
		contentPanel.add(sbcd);
		sbcd.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("总长度");
		lblNewLabel_1.setBounds(38, 202, 54, 15);
		contentPanel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setText(protocol.ip.packet_len);
		textField_1.setBounds(114, 199, 66, 21);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
	}
	public String pd(String str) {
		return str=="false"?"0":"1";
	}
}
