package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IDiv implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.IDIV;
	}
}