package de.xehpuk.disassembler.exceptions;

/**
 *
 * @author xehpuk
 */
public class IllegalConstantPoolEntryType extends AttributesReadException {
	private final int index;

	public IllegalConstantPoolEntryType(final int index, final ClassCastException e) {
		super("at " + index + ": " + e.getMessage(), e);
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
}