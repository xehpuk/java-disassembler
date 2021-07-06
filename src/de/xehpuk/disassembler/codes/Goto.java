package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class Goto extends BranchInstruction {
	public Goto(final short offset) {
		super(offset);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.GOTO;
	}
}