package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IfGE extends BranchInstruction {
	public IfGE(final short offset) {
		super(offset);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.IFGE;
	}
}