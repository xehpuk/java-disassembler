package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LCmp implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.LCMP;
	}
}