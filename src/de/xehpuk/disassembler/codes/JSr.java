package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class JSr extends BranchInstruction {
	public JSr(final short offset) {
		super(offset);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.JSR;
	}
}