package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class INeg implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.INEG;
	}
}