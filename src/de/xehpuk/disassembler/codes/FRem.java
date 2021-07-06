package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class FRem implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.FREM;
	}
}