package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class InvokeVirtual extends IndexedInstruction {
	public InvokeVirtual(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.INVOKEVIRTUAL;
	}
}