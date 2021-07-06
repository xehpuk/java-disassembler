package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IfICmpGT extends BranchInstruction {
	public IfICmpGT(final short offset) {
		super(offset);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.IF_ICMPGT;
	}
}