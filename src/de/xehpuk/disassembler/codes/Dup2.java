package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class Dup2 implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.DUP2;
	}
}