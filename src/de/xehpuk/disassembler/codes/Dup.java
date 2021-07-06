package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class Dup implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.DUP;
	}
}