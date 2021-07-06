package de.xehpuk.disassembler.attribute.variable;

public class DoubleVariable implements VerificationType {
	public static final int TAG = 3;

	@Override
	public int getTag() {
		return TAG;
	}
}