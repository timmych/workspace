package com.xzz.data;

public class Dummy {
	private String name;
	public Dummy(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		if(arg0 == null)
			return false;
		if(arg0 == this)
			return true;
		if(arg0.getClass() != this.getClass()){
			return false;
		}
		return this.name.equals(((Dummy)arg0).name);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return name.hashCode();
	}
	
}
