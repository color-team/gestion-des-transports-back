package dev.exception;

import dev.controller.dto.MessageErreurDto;

public abstract class MetierException extends RuntimeException {

	private static final long serialVersionUID = -1730616489131923653L;
	
	protected MessageErreurDto messageErreurDto;

	/** Constructeur
	 * @param messageErreurDto
	 */
	public MetierException(MessageErreurDto messageErreurDto) {
		super(messageErreurDto.getMessage());
		this.messageErreurDto = messageErreurDto;
	}

	public MessageErreurDto getMessageErreurDto() {
		return messageErreurDto;
	}
}
