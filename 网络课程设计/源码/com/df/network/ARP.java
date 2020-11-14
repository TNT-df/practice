package com.df.network;

public class ARP {
	public String hardtype;
	public String prototype;
	public String hlen;
	public String plen;
	public String operatipn;
	public String sender_hardaddr;
	public String sender_protoaddr;
	public String target_hardaddr;
	public String target_protoaddr;

	public ARP(String hardtype, String prototype, String hlen, String plen, String operatipn, String sender_hardaddr,
			String sender_protoaddr, String target_hardaddr, String target_protoaddr) {
		this.hardtype = hardtype;
		this.prototype = prototype;
		this.hlen = hlen;
		this.plen = plen;
		this.operatipn = operatipn;
		this.sender_hardaddr = sender_hardaddr;
		this.sender_protoaddr = sender_protoaddr;
		this.target_hardaddr = target_hardaddr;
		this.target_protoaddr = target_protoaddr;
	}

	@Override
	public String toString() {
		return "ARP [hardtype=" + hardtype + ", prototype=" + prototype + ", hlen=" + hlen + ", plen=" + plen
				+ ", operatipn=" + operatipn + ", sender_hardaddr=" + sender_hardaddr + ", sender_protoaddr="
				+ sender_protoaddr + ", target_hardaddr=" + target_hardaddr + ", target_protoaddr=" + target_protoaddr
				+ "]";
	}

	public ARP() {
	}
}