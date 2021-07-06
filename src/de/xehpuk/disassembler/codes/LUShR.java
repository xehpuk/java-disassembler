package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LUShR implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.LUSHR;
	}
}