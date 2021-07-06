package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public enum NOp implements Instruction {
	INSTANCE;

	@Override
	public OpCode getOpCode() {
		return OpCode.NOP;
	}
}