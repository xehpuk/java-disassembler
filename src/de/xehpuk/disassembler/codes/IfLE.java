package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IfLE extends BranchInstruction {
	public IfLE(final short offset) {
		super(offset);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.IFLE;
	}
}