package com.zz.b2cshop.common;

import com.zz.b2cshop.common.util.JsonBinder;

/**
 * @author xiangqh
 * 
 */
public class AjaxResult extends JsonResult {

	private static final long serialVersionUID = 404913078338861272L;

	public Object message;
	public String error;
	public String redirect;
	public int status = 200;
	public String success;

	public AjaxResult() {
		this.status = 200;
	}

	public AjaxResult(int status) {
		this.status = status;
	}

	public AjaxResult(int status, Object message) {
		this.status = status;
		this.message = message;
	}

	public AjaxResult(int status, String successOrError, String redirect) {
		this.status = status;
		this.redirect = redirect;
		if (status == 200)
			this.setSuccess(successOrError);
		else
			this.setError(successOrError);
	}

	public AjaxResult(int status, String redirect) {
		this.status = status;
		this.redirect = redirect;
	}

	public String getError() {
		return error;
	}

	public String getRedirect() {
		return redirect;
	}

	public int getStatus() {
		return status;
	}

	public String getSuccess() {
		return success;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return JsonBinder.buildNonNullBinder().toJson(this);
	}
}
