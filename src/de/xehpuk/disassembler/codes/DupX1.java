package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class DupX1 implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.DUP_X1;
	}
}