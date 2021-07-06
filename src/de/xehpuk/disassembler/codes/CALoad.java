package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class CALoad implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.CALOAD;
	}
}