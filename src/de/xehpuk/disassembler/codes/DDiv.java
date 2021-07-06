package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class DDiv implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.DDIV;
	}
}