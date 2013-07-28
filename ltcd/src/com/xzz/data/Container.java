package com.xzz.data;

import java.util.HashSet;
import java.util.Set;

public class Container {
	private Set<Operation> ops = new HashSet<Operation>();

	public Set<Operation> getOps() {
		return ops;
	}

	public void setOps(Set<Operation> ops) {
		this.ops = ops;
	}
}
