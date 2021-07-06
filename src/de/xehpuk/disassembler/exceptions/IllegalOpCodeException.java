package de.xehpuk.disassembler.exceptions;

/**
 *
 * @author xehpuk
 */
public class IllegalOpCodeException extends AttributesReadException {
	private final byte code;

	public IllegalOpCodeException(final byte code) {
		super(String.valueOf(code));
		this.code = code;
	}

	public byte getCode() {
		return code;
	}
}