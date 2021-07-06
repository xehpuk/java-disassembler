package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IAnd implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.IAND;
	}
}