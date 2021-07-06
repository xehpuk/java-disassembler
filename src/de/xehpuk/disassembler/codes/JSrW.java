package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class JSrW extends WideBranchInstruction {
	public JSrW(final int offset) {
		super(offset);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.JSR_W;
	}
}