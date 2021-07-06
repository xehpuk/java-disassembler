package de.xehpuk.disassembler.attribute.frame;

public abstract class StackMapFrame {
	private final int frameType;
	private final int offsetDelta;

	protected StackMapFrame(final int frameType, final int offsetDelta) {
		this.offsetDelta = offsetDelta;
		this.frameType = frameType;
	}

	public int getFrameType() {
		return frameType;
	}

	public int getOffsetDelta() {
		return offsetDelta;
	}

	public abstract int getMinType();

	public abstract int getMaxType();

	@Override
	public String toString() {
		return "StackMapFrame{" + frameType + ", " + offsetDelta + ", " + getMinType() + ", " + getMaxType() + '}';
	}
}