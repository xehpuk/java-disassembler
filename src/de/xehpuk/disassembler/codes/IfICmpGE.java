package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IfICmpGE extends BranchInstruction {
	public IfICmpGE(final short offset) {
		super(offset);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.IF_ICMPGE;
	}
}