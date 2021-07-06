package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LdCW extends IndexedInstruction {
	public LdCW(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.LDC_W;
	}
}