package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IAStore implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.IASTORE;
	}
}