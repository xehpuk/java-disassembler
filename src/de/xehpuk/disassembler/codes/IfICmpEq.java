package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IfICmpEq extends BranchInstruction {
	public IfICmpEq(final short offset) {
		super(offset);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.IF_ICMPEQ;
	}
}