/*
 * 文 件 名:  Looper.java
 * 版    权:  Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 创 建 人:  杨卫兵 yangweibing@itany.com
 * 创建时间:  2016年9月19日
 */
package com.itany.bbs.test;

/**
 * <一句话功能简述>
 *  
 * @author  杨卫兵
 * @version  [V1.00, 2016年9月19日]
 * @see  [相关类/方法]
 * @since V1.00
 */
public class Looper {
	public static void main(String[] args) {
		Looper loo = new Looper();
		loo.functionA();
	}
	
	public int[] global = new int[]{1,2,3,4,5,6,7};
	int pos = 0;
	public void functionA(){
		int temp = pos;
		System.out.println(pos++);
		if(pos== global.length){
			return;
		}
		functionA();
		System.out.println("---"+temp);
		
		
	}
}
