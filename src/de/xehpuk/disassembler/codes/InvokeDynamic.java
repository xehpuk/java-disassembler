package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class InvokeDynamic extends IndexedInstruction {
	public InvokeDynamic(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.INVOKEDYNAMIC;
	}
}