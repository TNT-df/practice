package com.df.Dialog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import com.df.network.protocol;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import com.df.Dialog.*;
import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.SystemColor;
//首页窗口
public class MainJFrame extends JFrame  implements ActionListener{
	protocol pro = new protocol();
	NetworkInterface[] devices = JpcapCaptor.getDeviceList();
	private JPanel contentPane;
	public static int select;
	JComboBox comboxBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainJFrame frame = new MainJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws InterruptedException
	 */
	public MainJFrame() throws InterruptedException {
		setTitle("TNT-df");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 397);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("网络协议分析");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 26));
		lblNewLabel.setBounds(193, 10, 219, 56);
		contentPane.add(lblNewLabel);

		JButton btn1 = new JButton("查看已选择网卡信息");
		btn1.setFont(new Font("宋体", Font.BOLD, 16));
		btn1.setBounds(155, 187, 214, 56);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				network dialog = new network(select);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		contentPane.add(btn1);

		JButton btnNewButton = new JButton("抓包并协议分析");
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					MainDialog dialog01;
					try {
						dialog01 = new MainDialog(select);
						dialog01.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog01.setVisible(true);
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}

				
			}
		});
		btnNewButton.setBounds(155, 270, 214, 56);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("显示全部网卡信息");
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				net t = new net();
			}
		});
		btnNewButton_1.setBounds(155, 103, 214, 56);
		contentPane.add(btnNewButton_1);

		comboxBox = new JComboBox();
		for (int i = 0; i < devices.length; i++) {
			comboxBox.addItem(i + 1);
		}
		comboxBox.addActionListener(this);
         comboxBox.setBounds(428, 173, 32, 21);
		contentPane.add(comboxBox);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 select =comboxBox.getSelectedIndex();
	}
}
