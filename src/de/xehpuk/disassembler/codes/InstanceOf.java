package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class InstanceOf extends IndexedInstruction {
	public InstanceOf(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.INSTANCEOF;
	}
}