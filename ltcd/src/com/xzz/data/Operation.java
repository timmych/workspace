package com.xzz.data;

import java.util.HashSet;
import java.util.Set;

public class Operation {

	private String op;
	private Set<String> t = new HashSet<String>();
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public Set<String> getT() {
		return t;
	}
	public void setT(Set<String> t) {
		this.t = t;
	}
}
