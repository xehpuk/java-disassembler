package de.xehpuk.disassembler.attribute.frame;

import de.xehpuk.disassembler.attribute.variable.VerificationType;

public class AppendFrame extends StackMapFrame {
	public static final int MIN_TYPE = 252;
	public static final int MAX_TYPE = MIN_TYPE + 2;
	private final VerificationType[] locals;

	public AppendFrame(final int frameType, final int offsetDelta, final VerificationType[] locals) {
		super(frameType, offsetDelta);
		this.locals = locals;
	}

	public int getNumberOfLocals() {
		return locals.length;
	}

	public VerificationType[] getLocals() {
		return locals;
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