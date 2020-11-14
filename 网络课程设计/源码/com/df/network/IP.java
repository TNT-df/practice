package com.df.network;

public class IP {
	public String version;
	public String header_length;
	public String Priprity;
	public String packet_len;
	public String Identification;
	public String DF;
	public String MF;
	public String offset;
	public String time_to_live;
	public String protoclo;
	public String scr_add;
	public String dest_add;

	@Override
	public String toString() {
		return "IP [version=" + version + ", Priprity=" + Priprity + ", packet_len=" + packet_len + ", Identification="
				+ Identification + ", DF=" + DF + ", MF=" + MF + ", offset=" + offset + ", time_to_live=" + time_to_live
				+ ", protoclo=" + protoclo + ", scr_add=" + scr_add + ", dest_add=" + dest_add + ", options=" + options
				+ "]";
	}

	public String options;

	public IP(String version, String priprity, String packet_len, String identification, String dF, String mF,
			String offset, String time_to_live, String protoclo, String scr_add, String dest_add, String options,
			String header_length) {
		this.version = version;
		Priprity = priprity;
		this.packet_len = packet_len;
		Identification = identification;
		DF = dF;
		MF = mF;
		this.offset = offset;
		this.time_to_live = time_to_live;
		this.protoclo = protoclo;
		this.scr_add = scr_add;
		this.dest_add = dest_add;
		this.options = options;
		this.header_length =header_length;
	}

	public IP() {
	}

}