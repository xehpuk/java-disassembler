package de.xehpuk.disassembler.attribute.frame;

public class ChopFrame extends StackMapFrame {
	public static final int MIN_TYPE = 248;
	public static final int MAX_TYPE = MIN_TYPE + 2;
	private final int absentLocals;

	public ChopFrame(final int frameType, final int offsetDelta) {
		super(frameType, offsetDelta);
		this.absentLocals = 251 - frameType;
	}

	public int getAbsentLocals() {
		return absentLocals;
	}

	@Override
	public int getMinType() {
		return MIN_TYPE;
	}

	@Override
	public int getMaxType() {
		return MAX_TYPE;
	}
}