package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class InvokeSpecial extends IndexedInstruction {
	public InvokeSpecial(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.INVOKESPECIAL;
	}
}