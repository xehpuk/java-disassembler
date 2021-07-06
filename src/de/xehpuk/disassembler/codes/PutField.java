package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class PutField extends IndexedInstruction {
	public PutField(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.PUTFIELD;
	}
}