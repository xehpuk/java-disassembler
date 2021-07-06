package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class Pop implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.POP;
	}
}