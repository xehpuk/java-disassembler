package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class CAStore implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.CASTORE;
	}
}