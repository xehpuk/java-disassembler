package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class GetStatic extends IndexedInstruction {
	public GetStatic(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.GETSTATIC;
	}
}