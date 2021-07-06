package de.xehpuk.disassembler.attribute.variable;

public class LongVariable implements VerificationType {
	public static final int TAG = 4;

	@Override
	public int getTag() {
		return TAG;
	}
}