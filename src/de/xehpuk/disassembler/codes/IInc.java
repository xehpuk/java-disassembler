package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IInc extends IndexedInstruction {
	private final byte constant;

	public IInc(final int index, final byte constant) {
		super(index);
		this.constant = constant;
	}

	public final byte getConstant() {
		return constant;
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.IINC;
	}
}