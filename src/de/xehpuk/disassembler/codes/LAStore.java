package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LAStore implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.LASTORE;
	}
}