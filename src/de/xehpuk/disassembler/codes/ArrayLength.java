package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class ArrayLength implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.ARRAYLENGTH;
	}
}