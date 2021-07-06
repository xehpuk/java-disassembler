package de.xehpuk.disassembler.attribute.variable;

public class UninitializedVariable implements VerificationType {
	public static final int TAG = 8;
	private final int offset;

	protected UninitializedVariable(final int offset) {
		this.offset = offset;
	}

	public int getOffset() {
		return offset;
	}

	@Override
	public int getTag() {
		return TAG;
	}
}