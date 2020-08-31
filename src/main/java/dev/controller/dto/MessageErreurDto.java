package dev.controller.dto;

public class MessageErreurDto {

	protected CodeErreur code;
	
	protected String message;

	public MessageErreurDto(CodeErreur code, String message) {
		this.code = code;
		this.message = message;
	}

	public CodeErreur getCode() {
		return code;
	}

	public void setCode(CodeErreur code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
