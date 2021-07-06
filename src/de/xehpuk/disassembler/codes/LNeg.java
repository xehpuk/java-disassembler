package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LNeg implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.LNEG;
	}
}