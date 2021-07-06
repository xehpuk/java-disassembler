package de.xehpuk.disassembler.exceptions;

/**
 *
 * @author xehpuk
 */
public class AttributesReadException extends ClassFileReadException {
	public AttributesReadException() {
		super();
	}

	public AttributesReadException(final String message) {
		super(message);
	}

	public AttributesReadException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public AttributesReadException(final Throwable cause) {
		super(cause);
	}
}