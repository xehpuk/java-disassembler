package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class GotoW extends WideBranchInstruction {
	public GotoW(final int offset) {
		super(offset);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.GOTO_W;
	}
}