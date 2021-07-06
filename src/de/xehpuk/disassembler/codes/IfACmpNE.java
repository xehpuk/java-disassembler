package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IfACmpNE extends BranchInstruction {
	public IfACmpNE(final short offset) {
		super(offset);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.IF_ACMPNE;
	}
}