package dev.exception;

import dev.controller.dto.MessageErreurDto;

public class ReservationCovoiturageInvalideException extends MetierException {

	private static final long serialVersionUID = -8006567278188430983L;

	public ReservationCovoiturageInvalideException(MessageErreurDto messageErreurDto) {
		super(messageErreurDto);
	}
}
