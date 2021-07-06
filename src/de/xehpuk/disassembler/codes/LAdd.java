package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LAdd implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.LADD;
	}
}