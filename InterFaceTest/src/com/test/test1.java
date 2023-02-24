package com.test;

interface Inter1{
	int getA();
}

interface Inter2{
	int getA();
}

interface Inter3 extends Inter1, Inter2{
	int getData();
}

public class test1 {

	public static void main(String[] args) {
	
	}

}
