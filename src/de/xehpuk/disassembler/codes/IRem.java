package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IRem implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.IREM;
	}
}