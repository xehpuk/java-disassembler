package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class PutStatic extends IndexedInstruction {
	public PutStatic(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.PUTSTATIC;
	}
}