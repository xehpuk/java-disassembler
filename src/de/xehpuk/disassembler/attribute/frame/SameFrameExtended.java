package de.xehpuk.disassembler.attribute.frame;

public class SameFrameExtended extends StackMapFrame {
	public static final int MIN_TYPE = 251;
	public static final int MAX_TYPE = MIN_TYPE;

	public SameFrameExtended(final int frameType, final int offsetDelta) {
		super(frameType, offsetDelta);
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