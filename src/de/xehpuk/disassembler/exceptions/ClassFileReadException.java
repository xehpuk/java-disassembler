package de.xehpuk.disassembler.exceptions;

/**
 *
 * @author xehpuk
 */
public class ClassFileReadException extends RuntimeException {
	public ClassFileReadException() {
		super();
	}

	public ClassFileReadException(final String message) {
		super(message);
	}

	public ClassFileReadException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ClassFileReadException(final Throwable cause) {
		super(cause);
	}
}