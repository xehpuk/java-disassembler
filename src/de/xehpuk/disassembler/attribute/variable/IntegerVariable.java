package de.xehpuk.disassembler.attribute.variable;

public class IntegerVariable implements VerificationType {
	public static final int TAG = 1;

	@Override
	public int getTag() {
		return TAG;
	}
}