package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IALoad implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.IALOAD;
	}
}