package com.df.network;

public class UDP {
	public String scr_port;
	public String dest_port;
	public String length;

	public UDP(String scr_port, String dest_port, String length) {
		this.scr_port = scr_port;
		this.dest_port = dest_port;
		this.length = length;
	}

	@Override
	public String toString() {
		return "UDP [scr_port=" + scr_port + ", dest_port=" + dest_port + ", length=" + length + "]";
	}

	public UDP() {
	}
}
