package de.xehpuk.disassembler.exceptions;

/**
 *
 * @author xehpuk
 */
public class ConstantPoolReadException extends ClassFileReadException {
	public ConstantPoolReadException() {
		super();
	}

	public ConstantPoolReadException(final String message) {
		super(message);
	}

	public ConstantPoolReadException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ConstantPoolReadException(final Throwable cause) {
		super(cause);
	}
}