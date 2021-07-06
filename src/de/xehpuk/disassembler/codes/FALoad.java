package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class FALoad implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.FALOAD;
	}
}