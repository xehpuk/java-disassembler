package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IfNE extends BranchInstruction {
	public IfNE(final short offset) {
		super(offset);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.IFNE;
	}
}