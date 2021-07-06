package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class Dup2X1 implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.DUP2_X1;
	}
}