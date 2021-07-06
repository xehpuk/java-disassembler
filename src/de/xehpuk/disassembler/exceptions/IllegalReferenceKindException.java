package de.xehpuk.disassembler.exceptions;

/**
 *
 * @author xehpuk
 */
public class IllegalReferenceKindException extends ConstantPoolReadException {
	private final int referenceKind;

	public IllegalReferenceKindException(final int referenceKind) {
		super(String.valueOf(referenceKind));
		this.referenceKind = referenceKind;
	}

	public int getReferenceKind() {
		return referenceKind;
	}
}