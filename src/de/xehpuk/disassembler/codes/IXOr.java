package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IXOr implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.IXOR;
	}
}