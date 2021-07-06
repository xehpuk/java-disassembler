package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class ISub implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.ISUB;
	}
}