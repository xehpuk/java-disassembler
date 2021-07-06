package de.xehpuk.disassembler.attribute.frame;

public class SameFrame extends StackMapFrame {
	public static final int MIN_TYPE = 0;
	public static final int MAX_TYPE = MIN_TYPE + 63;

	public SameFrame(final int frameType) {
		super(frameType, frameType);
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