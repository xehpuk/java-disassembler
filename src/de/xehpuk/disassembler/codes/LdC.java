package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LdC extends IndexedInstruction {
	public LdC(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.LDC;
	}
}