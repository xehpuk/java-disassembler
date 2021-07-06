package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IOr implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.IOR;
	}
}