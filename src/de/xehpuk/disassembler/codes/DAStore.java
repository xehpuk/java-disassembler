package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class DAStore implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.DASTORE;
	}
}