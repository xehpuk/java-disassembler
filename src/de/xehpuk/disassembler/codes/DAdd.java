package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class DAdd implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.DADD;
	}
}