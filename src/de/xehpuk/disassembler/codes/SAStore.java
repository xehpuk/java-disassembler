package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class SAStore implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.SASTORE;
	}
}