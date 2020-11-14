package com.df.network;

public class TCP {
	public String src_port;
	public String dst_port;
	public String Sequebce_Nubmer;
	public String Acknowledge_Number;
	public String URG;
	public String ACK;
	public String PSH;
	public String RST;
	public String SYN;
	public String FIN;
	public String window;
	public String Urgent_Pointer;
	public String Option;

	public TCP(String src_port, String dst_port, String sequebce_Nubmer, String acknowledge_Number, String uRG,
			String aCK, String pSH, String rST, String sYN, String fIN, String window, String urgent_Pointer,
			String option) {
		this.src_port = src_port;
		this.dst_port = dst_port;
		Sequebce_Nubmer = sequebce_Nubmer;
		Acknowledge_Number = acknowledge_Number;
		URG = uRG;
		ACK = aCK;
		PSH = pSH;
		RST = rST;
		SYN = sYN;
		FIN = fIN;
		this.window = window;
		Urgent_Pointer = urgent_Pointer;
		Option = option;
	}

	@Override
	public String toString() {
		return "TCP [src_port=" + src_port + ", dst_port=" + dst_port + ", Sequebce_Nubmer=" + Sequebce_Nubmer
				+ ", Acknowledge_Number=" + Acknowledge_Number + ", URG=" + URG + ", ACK=" + ACK + ", PSH=" + PSH
				+ ", RST=" + RST + ", SYN=" + SYN + ", FIN=" + FIN + ", window=" + window + ", Urgent_Pointer="
				+ Urgent_Pointer + ", Option=" + Option + "]";
	}

	public TCP() {
	}
}