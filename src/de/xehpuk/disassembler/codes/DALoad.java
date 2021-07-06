package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class DALoad implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.DALOAD;
	}
}