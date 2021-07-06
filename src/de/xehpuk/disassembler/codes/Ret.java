package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class Ret extends IndexedInstruction {
	public Ret(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.RET;
	}
}