package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IfEq extends BranchInstruction {
	public IfEq(final short offset) {
		super(offset);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.IFEQ;
	}
}