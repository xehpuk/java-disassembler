package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class MultiANewArray extends IndexedInstruction {
	private final int dimensions;

	public MultiANewArray(final int index, final int dimensions) {
		super(index);
		this.dimensions = dimensions;
	}

	public final int getDimensions() {
		return dimensions;
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.MULTIANEWARRAY;
	}
}