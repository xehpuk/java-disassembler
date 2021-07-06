package de.xehpuk.disassembler.exceptions;

/**
 *
 * @author xehpuk
 */
public class ConstantPooReadException extends ClassFileReadException {
	public ConstantPooReadException() {
		super();
	}

	public ConstantPooReadException(final String message) {
		super(message);
	}

	public ConstantPooReadException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ConstantPooReadException(final Throwable cause) {
		super(cause);
	}
}