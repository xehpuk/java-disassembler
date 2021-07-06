package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IfACmpEq extends BranchInstruction {
	public IfACmpEq(final short offset) {
		super(offset);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.IF_ACMPEQ;
	}
}