package de.xehpuk.disassembler.attribute.variable;

public class NullVariable implements VerificationType {
	public static final int TAG = 5;

	@Override
	public int getTag() {
		return TAG;
	}
}