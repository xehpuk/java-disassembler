package de.xehpuk.disassembler.attribute.variable;

public class FloatVariable implements VerificationType {
	public static final int TAG = 2;

	@Override
	public int getTag() {
		return TAG;
	}
}