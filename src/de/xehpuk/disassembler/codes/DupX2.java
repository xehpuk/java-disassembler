package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class DupX2 implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.DUP_X2;
	}
}