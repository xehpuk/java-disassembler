package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class BAStore implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.BASTORE;
	}
}