package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class FNeg implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.FNEG;
	}
}