package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IfLT extends BranchInstruction {
	public IfLT(final short offset) {
		super(offset);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.IFLT;
	}
}