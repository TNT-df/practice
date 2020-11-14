package com.df.network;

public class pkt {
	public String caplen;
	public String len;
	public String header;
	public String head_length;
	public String data;
	public String data_length;

	public pkt(String caplen, String len, String header, String head_length, String data, String data_length) {
		this.caplen = caplen;
		this.len = len;
		this.header = header;
		this.head_length = head_length;
		this.data = data;
		this.data_length = data_length;
	}

	@Override
	public String toString() {
		return "pkt [caplen=" + caplen + ", len=" + len + ", header=" + header + ", head_length=" + head_length
				+ ", data=" + data + ", data_length=" + data_length + "]";
	}

	public pkt() {
	}
}