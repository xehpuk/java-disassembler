package de.xehpuk.disassembler.exceptions;

public class IllegalArrayTypeCodeException extends AttributesReadException {
	private final byte code;

	public IllegalArrayTypeCodeException(final byte code) {
		super(String.valueOf(code));
		this.code = code;
	}

	public byte getCode() {
		return code;
	}
}