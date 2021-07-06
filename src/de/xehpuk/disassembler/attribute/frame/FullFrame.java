package de.xehpuk.disassembler.attribute.frame;

import de.xehpuk.disassembler.attribute.variable.VerificationType;

public class FullFrame extends StackMapFrame {
	public static final int MIN_TYPE = 255;
	public static final int MAX_TYPE = MIN_TYPE;
	private final VerificationType[] locals;
	private final VerificationType[] stackItems;

	public FullFrame(final int frameType, final int offsetDelta, final VerificationType[] locals, final VerificationType[] stackItems) {
		super(frameType, offsetDelta);
		this.locals = locals;
		this.stackItems = stackItems;
	}

	public int getNumberOfLocals() {
		return locals.length;
	}

	public VerificationType[] getLocals() {
		return locals;
	}

	public int getNumberOfStackItems() {
		return stackItems.length;
	}

	public VerificationType[] getStackItems() {
		return stackItems;
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
