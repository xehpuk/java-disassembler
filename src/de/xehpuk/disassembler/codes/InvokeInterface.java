package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class InvokeInterface extends IndexedInstruction {
	private final int count;

	public InvokeInterface(final int index, final int count) {
		super(index);
		this.count = count;
	}

	public final int getCount() {
		return count;
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.INVOKEINTERFACE;
	}
}