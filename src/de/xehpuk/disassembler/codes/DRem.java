package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class DRem implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.DREM;
	}
}