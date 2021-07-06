package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class New extends IndexedInstruction {
	public New(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.NEW;
	}
}