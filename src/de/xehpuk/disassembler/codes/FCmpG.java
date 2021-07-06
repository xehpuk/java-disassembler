package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class FCmpG implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.FCMPG;
	}
}