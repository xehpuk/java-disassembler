package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class GetField extends IndexedInstruction {
	public GetField(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.GETFIELD;
	}
}