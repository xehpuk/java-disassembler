package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class SALoad implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.SALOAD;
	}
}