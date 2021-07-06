package de.xehpuk.disassembler.attribute.variable;

public class UninitializedThisVariable implements VerificationType {
	public static final int TAG = 6;

	@Override
	public int getTag() {
		return TAG;
	}
}