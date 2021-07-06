package de.xehpuk.disassembler.exceptions;

/**
 *
 * @author xehpuk
 */
public class IllegalConstantInfoTagException extends ConstantPoolReadException {
	private final int constantInfoTag;

	public IllegalConstantInfoTagException(final int constantInfoTag) {
		super(String.valueOf(constantInfoTag));
		this.constantInfoTag = constantInfoTag;
	}

	public int getConstantInfoTag() {
		return constantInfoTag;
	}
}