package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class FAStore implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.FASTORE;
	}
}