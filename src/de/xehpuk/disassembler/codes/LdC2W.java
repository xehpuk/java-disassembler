package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LdC2W extends IndexedInstruction {
	public LdC2W(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.LDC2_W;
	}
}