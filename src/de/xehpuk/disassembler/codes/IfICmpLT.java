package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IfICmpLT extends BranchInstruction {
	public IfICmpLT(final short offset) {
		super(offset);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.IF_ICMPLT;
	}
}