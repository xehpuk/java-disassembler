package de.xehpuk.disassembler.exceptions;

/**
 *
 * @author xehpuk
 */
public class IllegalAttributeLengthException extends AttributesReadException {
	private final long attributeLength;

	public IllegalAttributeLengthException(final long attributeLength) {
		super(String.valueOf(attributeLength));
		this.attributeLength = attributeLength;
	}

	public long getAttributeLength() {
		return attributeLength;
	}
}