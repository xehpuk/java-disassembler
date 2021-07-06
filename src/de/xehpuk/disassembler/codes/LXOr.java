package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LXOr implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.LXOR;
	}
}