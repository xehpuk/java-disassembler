package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class ANewArray extends IndexedInstruction {
	protected ANewArray(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.ANEWARRAY;
	}
}