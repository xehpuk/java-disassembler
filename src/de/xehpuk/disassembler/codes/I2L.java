package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class I2L implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.I2L;
	}
}