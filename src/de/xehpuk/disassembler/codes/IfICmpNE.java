package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IfICmpNE extends BranchInstruction {
	public IfICmpNE(final short offset) {
		super(offset);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.IF_ICMPNE;
	}
}