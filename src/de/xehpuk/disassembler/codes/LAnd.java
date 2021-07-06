package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LAnd implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.LAND;
	}
}