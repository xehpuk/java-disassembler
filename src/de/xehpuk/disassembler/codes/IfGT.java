package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IfGT extends BranchInstruction {
	public IfGT(final short offset) {
		super(offset);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.IFGT;
	}
}