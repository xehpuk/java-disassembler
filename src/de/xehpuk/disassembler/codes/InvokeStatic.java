package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class InvokeStatic extends IndexedInstruction {
	public InvokeStatic(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.INVOKESTATIC;
	}
}