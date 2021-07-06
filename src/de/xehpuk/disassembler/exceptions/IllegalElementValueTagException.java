package de.xehpuk.disassembler.exceptions;

public class IllegalElementValueTagException extends AttributesReadException {
	private final int tag;

	public IllegalElementValueTagException(final int tag) {
		super(tag + " (" + (char) tag + ")");
		this.tag = tag;
	}

	public int getTag() {
		return tag;
	}
}