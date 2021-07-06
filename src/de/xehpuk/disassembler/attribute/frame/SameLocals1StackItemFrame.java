package de.xehpuk.disassembler.attribute.frame;

import de.xehpuk.disassembler.attribute.variable.VerificationType;

public class SameLocals1StackItemFrame extends StackMapFrame {
	public static final int MIN_TYPE = 64;
	public static final int MAX_TYPE = MIN_TYPE + 63;
	private final VerificationType stackItem;

	public SameLocals1StackItemFrame(final int frameType, final VerificationType stackItem) {
		super(frameType, frameType - MIN_TYPE);
		this.stackItem = stackItem;
	}

	public VerificationType getStackItem() {
		return stackItem;
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