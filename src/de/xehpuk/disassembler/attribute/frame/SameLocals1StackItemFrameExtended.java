package de.xehpuk.disassembler.attribute.frame;

import de.xehpuk.disassembler.attribute.variable.VerificationType;

public class SameLocals1StackItemFrameExtended extends StackMapFrame {
	public static final int MIN_TYPE = 247;
	public static final int MAX_TYPE = MIN_TYPE;
	private final VerificationType stackItem;

	public SameLocals1StackItemFrameExtended(final int frameType, final int offsetDelta, final VerificationType stackItem) {
		super(frameType, offsetDelta);
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