package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class BALoad implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.BALOAD;
	}
}