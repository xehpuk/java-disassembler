package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class AAStore implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.AASTORE;
	}
}