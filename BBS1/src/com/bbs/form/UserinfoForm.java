package com.bbs.form;

import org.apache.struts.action.ActionForm;

import com.bbs.entity.Userinfo;

public class UserinfoForm extends ActionForm {
	
	private Userinfo ui;

	public Userinfo getUi() {
		return ui;
	}

	public void setUi(Userinfo ui) {
		this.ui = ui;
	}
}
