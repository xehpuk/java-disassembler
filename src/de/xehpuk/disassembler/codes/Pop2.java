package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class Pop2 implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.POP2;
	}
}