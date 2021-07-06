package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class CheckCast extends IndexedInstruction {
	public CheckCast(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.CHECKCAST;
	}
}