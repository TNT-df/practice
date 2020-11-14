package com.df.network;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Arrays;

import javax.swing.JDialog;


import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
import jpcap.NetworkInterfaceAddress;
import jpcap.PacketReceiver;
import jpcap.packet.ARPPacket;
import jpcap.packet.ICMPPacket;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;

public class protocol implements PacketReceiver {
	public int cnt = 0;
	public static int flag = 1; //用于判断协议类型
	public NetworkInterface[] devices = JpcapCaptor.getDeviceList(); //获得网卡接口
	public int length;
	public static byte[] desMacDa = new byte[6]; // 目标地址
	public static byte[] srcMacDa = new byte[6];// 源地址
	public static byte[] type = new byte[2]; // 类型
	public String kind;
	public static pkt pkt1 = new pkt();
	public static ARP arp = new ARP();
	public static IP ip = new IP();
	public static UDP udp = new UDP();
	public static TCP tcp = new TCP();
	public static Packet packet; 
	public static int index; 
	public static String sTmp;

	public void receivePacket(Packet packet) {

		this.packet = packet;
		byte[] b = packet.header; // 数据帧头部
		length = b.length * 8;

		System.arraycopy(b, 0, desMacDa, 0, desMacDa.length);

		System.arraycopy(b, 6, srcMacDa, 0, srcMacDa.length);

		System.arraycopy(b, 12, type, 0, type.length);

		this.pkt1 = new pkt(packet.caplen + "", packet.len + "", packet.header + "", packet.header.length + "",
				packet.data + "", packet.data.length + "");
		if (packet instanceof ARPPacket) {
			ARPPacket aPacket = (ARPPacket) packet;

			srcMacDa = aPacket.sender_hardaddr;
			desMacDa = aPacket.target_hardaddr;

			this.arp = new ARP(aPacket.hardtype + "", aPacket.prototype + "", aPacket.hlen + "", aPacket.plen + "",
					aPacket.operation + "", aPacket.sender_hardaddr + "", aPacket.getSenderProtocolAddress() + "",
					aPacket.target_hardaddr + "", aPacket.getTargetProtocolAddress() + "");
		}
		if (packet instanceof IPPacket) {
             
			IPPacket iPacket = (IPPacket) packet;
			
			flag = 2;
			// 分析IPv4协议
			if (iPacket.version == 4) {
				String  head_length="";
           head_length= (bytesToHexString(iPacket.header).substring(43, 44));
				
				this.ip = new IP(iPacket.version + "", iPacket.priority + "", iPacket.length + "", iPacket.ident + "",
						iPacket.dont_frag + "", iPacket.more_frag + "", iPacket.offset + "", iPacket.hop_limit + "",
						iPacket.protocol + "", iPacket.src_ip.toString(), iPacket.dst_ip.toString(),
						iPacket.option + "",head_length+"");
			}
		}
		if (packet instanceof UDPPacket) {
			flag = 3;
			UDPPacket uPacket = (UDPPacket) packet;
			this.udp = new UDP(uPacket.src_port + "", uPacket.dst_port + "", uPacket.length + "");
		}
		if (packet instanceof TCPPacket) {

			TCPPacket tPacket = (TCPPacket) packet;

			this.tcp = new TCP(tPacket.src_port + "", tPacket.dst_port + "", tPacket.sequence + "",
					tPacket.ack_num + "", tPacket.urg + "", tPacket.ack + "", tPacket.psh + "", tPacket.rst + "",
					tPacket.syn + "", tPacket.fin + "", tPacket.window + "", tPacket.urgent_pointer + "",
					tPacket.option + "");
		}
	}

	public void beginCatch() throws IOException {
		int a = 0;
		/* 本地网络信息 */
		byte[] b = devices[index].mac_address; // 网卡物理地址
		String str = getMacadress(b);

		NetworkInterfaceAddress[] k = devices[index].addresses;

		NetworkInterface deviceName = devices[index];
		/* 将网卡设为混杂模式下用网络设备3，设置抓取数据包的最大长度2000字节，混杂模式选否，超时值20 */
		JpcapCaptor jpcap = JpcapCaptor.openDevice(deviceName, 2000, false, 20); // openDevice(deviceName,1028,false,1);
		// 调用loopPacket方法处理数据包，-1代表捕获的最大包数没有限制，1代表一次只抓一个包
		jpcap.loopPacket(1, new protocol());		
		}
	

	public static String byteToBit(byte b[]) {
		String str = "";
		for (int i = 0; i < b.length; i++) {
			str = str + "" + (byte) ((b[i] >> 7) & 0x1) + (byte) ((b[i] >> 6) & 0x1) + (byte) ((b[i] >> 5) & 0x1)
					+ (byte) ((b[i] >> 4) & 0x1) + (byte) ((b[i] >> 3) & 0x1) + (byte) ((b[i] >> 2) & 0x1)
					+ (byte) ((b[i] >> 1) & 0x1) + (byte) ((b[i] >> 0) & 0x1) + " ";
		}
		return str;
	}

//得到mac地址的字符串表示
	public String getMacadress(byte b[]) {
		String str = " ";
		int a = 0;
		for (int j = 0; j < b.length; j++) {
			// byte变成int时，根据最高位进行填充，如1100 1100变成1111...1100 1100,即cc变成-52
			a = b[j];
			a = a << 24;
			a = a >>> 24;
			if (j != b.length - 1) {
				str += Integer.toHexString(a) + "-";
			} else {
				str += Integer.toHexString(a);
			}
		}
		return str;
	}
	 public static String bytesToHexString(byte[] bArr) {
	        StringBuffer sb = new StringBuffer(bArr.length);
	       
	        for (int i = 0; i < bArr.length; i++)
	        {
	            sTmp = Integer.toHexString(0xFF & bArr[i]);
	            if (sTmp.length() < 2)
	                sb.append(0);
	            sb.append(sTmp.toUpperCase()+" ");
	        }
	        return sb.toString();
	    }
}










